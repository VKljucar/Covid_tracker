package hr.java.covid_tracker.security;

import hr.java.covid_tracker.login.Login;
import hr.java.covid_tracker.login.LoginJpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final LoginJpaRepository loginJpaRepository;

    public DomainUserDetailsService(LoginJpaRepository loginJpaRepository) {
        this.loginJpaRepository = loginJpaRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String korisnickoIme) {

        return loginJpaRepository
                .findByKorisnickoIme(korisnickoIme)
                .map(this::createSpringSecurityUser)
                .orElseThrow(() -> new UsernameNotFoundException("Korisnik " + korisnickoIme + " nije pronađen u bazi"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(Login user) {
        List<GrantedAuthority> grantedAuthorities = user
                .getAuthorities()
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getKorisnickoIme(), user.getLozinka(), grantedAuthorities);
    }

}
