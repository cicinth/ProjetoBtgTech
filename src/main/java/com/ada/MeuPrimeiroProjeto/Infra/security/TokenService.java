package com.ada.MeuPrimeiroProjeto.Infra.security;

import com.ada.MeuPrimeiroProjeto.model.User;
import com.auth0.jwt.JWT;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${config.token.secret}")
    private String secretKey;
    public String tokenGenerate(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            return JWT.create()
                    .withSubject(user.getEmail())
                    .withClaim("id", user.getId())
                    .withClaim("name", user.getName())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 3600000))
                    .withIssuer("Ada Tech")
                    .sign(algorithm);
        }catch (JWTCreationException exception) {
            throw new RuntimeException("erro to generate token", exception);
        }
    }

    public String getSubject(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC512(secretKey);

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("Ada Tech")
                    .build();

            return verifier.verify(token).getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("invalid token");
        }
    }
}
