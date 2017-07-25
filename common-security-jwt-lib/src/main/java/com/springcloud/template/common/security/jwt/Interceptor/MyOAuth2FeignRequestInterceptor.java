/**
 *  author chen roger
 */
package com.springcloud.template.common.security.jwt.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.implicit.ImplicitAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class MyOAuth2FeignRequestInterceptor extends OAuth2FeignRequestInterceptor {



    private final OAuth2ClientContext oAuth2ClientContext;


    private final AccessTokenProvider accessTokenProvider;

    public MyOAuth2FeignRequestInterceptor(OAuth2ClientContext oAuth2ClientContext) {
        super(oAuth2ClientContext, null);
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        this.oAuth2ClientContext=oAuth2ClientContext;
        List<AccessTokenProvider> chain = new ArrayList<>();

        AuthorizationCodeAccessTokenProvider authorizationCodeAccessTokenProvider= new AuthorizationCodeAccessTokenProvider();
        authorizationCodeAccessTokenProvider.setRequestFactory(httpComponentsClientHttpRequestFactory);
        chain.add(authorizationCodeAccessTokenProvider);

        ImplicitAccessTokenProvider implicitAccessTokenProvider = new ImplicitAccessTokenProvider();
        implicitAccessTokenProvider.setRequestFactory(httpComponentsClientHttpRequestFactory);
        chain.add(implicitAccessTokenProvider);

        ResourceOwnerPasswordAccessTokenProvider resourceOwnerPasswordAccessTokenProvider = new ResourceOwnerPasswordAccessTokenProvider();
        resourceOwnerPasswordAccessTokenProvider.setRequestFactory(httpComponentsClientHttpRequestFactory);
        chain.add(resourceOwnerPasswordAccessTokenProvider);

        ClientCredentialsAccessTokenProvider clientCredentialsAccessTokenProvider = new ClientCredentialsAccessTokenProvider();
        clientCredentialsAccessTokenProvider.setRequestFactory(httpComponentsClientHttpRequestFactory);
        chain.add(clientCredentialsAccessTokenProvider);
        List<AccessTokenProvider> providers=Collections.unmodifiableList(chain);
        accessTokenProvider=new AccessTokenProviderChain(providers);



    }


}
