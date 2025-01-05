package com.company.groomingzone.member;

import java.util.Collection;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity memberEntity = memberRepository.findByEmail(username).orElseThrow(() ->
            new UsernameNotFoundException("User not found with username: " + username));
        return new MemberDetails(memberEntity);
    }

    public static class MemberDetails extends MemberEntity implements UserDetails {

        MemberDetails(MemberEntity memberEntity) {
            setId(memberEntity.getId());
            setName(memberEntity.getName());
            setEmail(memberEntity.getEmail());
            setPassword(memberEntity.getPassword());
            setRoles(memberEntity.getRoles());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
        }

        @Override
        public String getPassword() {
            return super.getPassword();
        }

        @Override
        public String getUsername() {
            return super.getEmail();
        }

    }
}
