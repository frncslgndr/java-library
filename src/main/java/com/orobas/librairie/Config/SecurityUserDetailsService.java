package com.orobas.librairie.Config;


import com.orobas.librairie.Entity.User;
import com.orobas.librairie.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Re définition du [UserDetailsService] pour le mécanisme d'authentification
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> account = userRepository.findByMail(username);
        if (account.isPresent()) {
            return account.get();
        }
        throw new UsernameNotFoundException("the username $username doesn't exist");
    }
}