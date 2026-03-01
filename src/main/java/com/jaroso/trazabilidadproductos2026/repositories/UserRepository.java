package com.jaroso.trazabilidadproductos2026.repositories;


import com.jaroso.trazabilidadproductos2026.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUserName(String username);

}
