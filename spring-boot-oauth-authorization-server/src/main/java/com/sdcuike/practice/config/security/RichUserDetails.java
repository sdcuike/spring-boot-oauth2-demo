package com.sdcuike.practice.config.security;

import com.sdcuike.practice.domain.User;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * Created by beaver on 2017/6/12.
 */
class RichUserDetails implements UserDetails, CredentialsContainer {
    private final Long id;
    private final String phone;
    private String password;
    private final String username;
    private final Set<GrantedAuthority> authoritie;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;
    
    public RichUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
        this(user, true, true, true, true, authorities);
    }
    
    public RichUserDetails(User user, boolean enabled,
                           boolean accountNonExpired, boolean credentialsNonExpired,
                           boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        
        this.id = user.getId();
        this.phone = user.getPhone();
        this.username = user.getLoginName();
        this.password = user.getPasswordHash();
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authoritie = Collections.unmodifiableSet(sortAuthorities(authorities));
    }
    
    public Collection<GrantedAuthority> getAuthorities() {
        return authoritie;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
    
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
    
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    
    public void eraseCredentials() {
        password = null;
    }
    
    private static SortedSet<GrantedAuthority> sortAuthorities(
            Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(
                new RichUserDetails.AuthorityComparator());
        
        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority,
                    "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }
        
        return sortedAuthorities;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getPhone() {
        return phone;
    }
    
    private static class AuthorityComparator implements Comparator<GrantedAuthority>,
                                                        Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
        
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before adding it to
            // the set.
            // If the authority is null, it is a custom authority and should precede
            // others.
            if (g2.getAuthority() == null) {
                return -1;
            }
            
            if (g1.getAuthority() == null) {
                return 1;
            }
            
            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }
    
    
}
