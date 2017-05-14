package com.sdcuike.practice.config.security;

import com.sdcuike.practice.domain.Authority;
import com.sdcuike.practice.domain.User;
import com.sdcuike.practice.domain.UserAuthority;
import com.sdcuike.practice.mapper.UserAuthorityMapper;
import com.sdcuike.practice.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Authenticate a user from the database.
 */
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private UserAuthorityMapper userAuthorityMapper;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);
        
        Optional<User> userFromDatabase = findOneWithAuthoritiesByLogin(login);
        return userFromDatabase.map(user -> {
            if (!user.getActivated()) {
                throw new UserNotActivatedException("User " + login + " was not activated");
            }
            List<GrantedAuthority> grantedAuthorities =
                    user.getAuthorities()
                        .stream()
                        .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                        .collect(Collectors.toList());
            return new org.springframework.security.core.userdetails.User(login,
                    user.getPasswordHash(),
                    grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException("User " + login + " was not found in the " +
                "database"));
    }
    
    private Optional<User> findOneWithAuthoritiesByLogin(String login) {
        Optional<User> user = Optional.ofNullable(userMapper.findByLoginName(login));
        if (!user.isPresent()) {
            return user;
        }
        
        User userDb = user.get();
        List<UserAuthority> userAuthorities = userAuthorityMapper.findByUserId(userDb.getId());
        
        Set<Authority> collect = userAuthorities.stream()
                                                .map(UserAuthority::getAuthorityName)
                                                .map(Authority::new)
                                                .collect(Collectors.<Authority>toSet());
        userDb.setAuthorities(collect);
        return user;
    }
}
