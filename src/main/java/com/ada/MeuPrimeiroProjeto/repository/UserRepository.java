package com.ada.MeuPrimeiroProjeto.repository;


import com.ada.MeuPrimeiroProjeto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    List<User> findAllByName(String name);

}
