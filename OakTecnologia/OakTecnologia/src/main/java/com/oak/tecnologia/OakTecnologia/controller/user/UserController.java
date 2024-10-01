package com.oak.tecnologia.OakTecnologia.controller.user;

import com.oak.tecnologia.OakTecnologia.controller.auth.AuthenticationController;
import com.oak.tecnologia.OakTecnologia.dto.auth.AuthenticationDTO;
import com.oak.tecnologia.OakTecnologia.models.user.User;
import com.oak.tecnologia.OakTecnologia.repository.user.IUserRepository;
import com.oak.tecnologia.OakTecnologia.service.user.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationController authenticationController;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid AuthenticationDTO authenticationDTO, UriComponentsBuilder uriComponentsBuilder){
        String hashedPassword = userService.hashPassword(authenticationDTO.password());
        var user = new User(authenticationDTO, hashedPassword);
        iUserRepository.save(user);

        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new AuthenticationDTO(authenticationDTO.userName(), authenticationDTO.password()));
    }

}
