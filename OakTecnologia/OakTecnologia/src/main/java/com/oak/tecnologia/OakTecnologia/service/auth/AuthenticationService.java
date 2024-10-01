package com.oak.tecnologia.OakTecnologia.service.auth;

import com.oak.tecnologia.OakTecnologia.models.user.User;
import com.oak.tecnologia.OakTecnologia.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return iUserRepository.findByUsername(username);
    }

}
