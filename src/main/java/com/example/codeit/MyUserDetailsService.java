package com.example.codeit;

import com.example.codeit.models.MyUserDetails;
import com.example.codeit.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();

//        User user=userRepository.findByUserName(userName);

//        if(user != null && user.isActive()) {//here you can check that
//            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
//            return buildUserForAuthentication(user, authorities);
//        }
//
//        else {
//            throw new UsernameNotFoundException("username not found");
//        }
    }
}
