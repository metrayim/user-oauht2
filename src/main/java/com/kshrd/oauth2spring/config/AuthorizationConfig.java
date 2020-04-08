package com.kshrd.oauth2spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
// import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            
                    clients.inMemory()
                        .withClient("auth-user")
                        .secret("{noop}secretadmin")
                        .scopes("read","write")
                        .authorizedGrantTypes("password","refresh_token")
                        .authorities("USER")
                        .accessTokenValiditySeconds(1000)
                        .refreshTokenValiditySeconds(1500);
                    
                    }

                    @Override
                    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
                        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
                    }
    // @Override
    // public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    //     security.checkTokenAccess("permitAll");
    // }

    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }
}