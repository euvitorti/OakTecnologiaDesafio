package com.oak.tecnologia.OakTecnologia.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oak.tecnologia.OakTecnologia.models.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findByUsername(String userName);
}
