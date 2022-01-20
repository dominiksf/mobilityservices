package tum.seba.mobilityservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;
import tum.seba.mobilityservices.repository.CustomerRepository;
import tum.seba.mobilityservices.repository.EmployeeRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    Argon2PasswordEncoder argon2PasswordEncoder;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeRepository.findByEmail(username)
                .orElse(customerRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException(username + "doesn't seem to exist.")));
    }


}
