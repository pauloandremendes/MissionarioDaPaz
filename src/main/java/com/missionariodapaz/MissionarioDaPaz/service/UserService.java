package com.missionariodapaz.MissionarioDaPaz.service;

import com.missionariodapaz.MissionarioDaPaz.model.domain.UserModel;
import com.missionariodapaz.MissionarioDaPaz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    public User execute(User user) {
//
//        User existsUser = userRepository.findByUsername(user.getUsername());
//
//        if (existsUser != null) {
//            throw new Error("User already exists!");
//        }
//
//        user.setPassword(passwordEncoder().encode(user.getPassword()));
//        User createdUser = userRepository.save(user);
//        return createdUser;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com username: " + username));
        return new User(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
    }
}
