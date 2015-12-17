package com.pomverte.autoconfigure;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "ldap")
public class LdapProperties {

    @NotNull
    private String url;

    @NotNull
    private String baseDN;
    
    @NotNull
    private String userDN;
    
    @NotNull
    private String password;

    public String getProviderUrl() {
        StringBuilder providerUrl = new StringBuilder();
        providerUrl.append(this.url).append((StringUtils.endsWithIgnoreCase(this.url, "/")) ? "" : '/')
                .append(this.baseDN);
        return providerUrl.toString();
    }

}
