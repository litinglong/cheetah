package com.silva.gateway.tmp;
//package com.silva.gateway.config;
//
////import cn.hutool.core.util.ArrayUtil;
////import cn.hutool.json.JSONUtil;
////import com.youlai.common.core.constant.AuthConstants;
////import com.youlai.common.core.result.Result;
////import com.youlai.common.core.result.ResultCode;
////import com.youlai.gateway.security.AuthorizationManager;
////import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.core.io.buffer.DataBufferUtils;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
//import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
//import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
//import reactor.core.publisher.Mono;
//
//import java.nio.charset.Charset;
//
////import reactor.core.publisher.Mono;
//
////@AllArgsConstructor
//@Configuration
//@EnableWebFluxSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)https://www.cnblogs.com/haoxianrui/p/13719356.html
//public class ResourceServerConfig2{
//
//    private AuthorizationManager2 authorizationManager2;
////    private CustomServerAccessDeniedHandler customServerAccessDeniedHandler;
////    private CustomServerAuthenticationEntryPoint customServerAuthenticationEntryPoint;
////    private WhiteListConfig whiteListConfig;
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//		http.oauth2ResourceServer().authenticationEntryPoint(authenticationEntryPoint());
//		http.authorizeExchange()
//		        .pathMatchers("/chetax-security/oauth/token","/chetax-security/rsa/publicKey").permitAll()
//		        .anyExchange().access(authorizationManager2)
//		        .and()
//		        .exceptionHandling()
//		        .accessDeniedHandler(accessDeniedHandler()) // 处理未授权
//		        .authenticationEntryPoint(authenticationEntryPoint()) //处理未认证
//		        .and().csrf().disable();
//		
//		return http.build();
//    }
//
//
//    /**
//     * 未授权
//     *
//     * @return
//     */
//    @Bean
//    ServerAccessDeniedHandler accessDeniedHandler() {
//        return (exchange, denied) -> {
//            Mono<Void> mono = Mono.defer(() -> Mono.just(exchange.getResponse()))
//                    .flatMap(response -> {
//                        response.setStatusCode(HttpStatus.OK);
//                        response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//                        response.getHeaders().set("Access-Control-Allow-Origin", "*");
//                        response.getHeaders().set("Cache-Control", "no-cache");
////                        String body = JSONUtil.toJsonStr(Result.failed(ResultCode.USER_ACCESS_UNAUTHORIZED));
//                        String body = "USER_ACCESS_UNAUTHORIZED";
//                        DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
//                        return response.writeWith(Mono.just(buffer))
//                                .doOnError(error -> DataBufferUtils.release(buffer));
//                    });
//
//            return mono;
//        };
//    }
//
//    /**
//     * token无效或者已过期自定义响应
//     */
//    @Bean
//    ServerAuthenticationEntryPoint authenticationEntryPoint() {
//        return (exchange, e) -> {
//            Mono<Void> mono = Mono.defer(() -> Mono.just(exchange.getResponse()))
//                    .flatMap(response -> {
//                        response.setStatusCode(HttpStatus.OK);
//                        response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//                        response.getHeaders().set("Access-Control-Allow-Origin", "*");
//                        response.getHeaders().set("Cache-Control", "no-cache");
////                        String body = JSONUtil.toJsonStr(Result.failed(ResultCode.TOKEN_INVALID_OR_EXPIRED));
//                        String body = "TOKEN_INVALID_OR_EXPIRED";
//                        DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
//                        return response.writeWith(Mono.just(buffer))
//                                .doOnError(error -> DataBufferUtils.release(buffer));
//                    });
//            return mono;
//        };
//    }
//    
//    /**
//     * @linkhttps://blog.csdn.net/qq_24230139/article/details/105091273
//     * ServerHttpSecurity没有将jwt中authorities的负载部分当做Authentication
//     * 需要把jwt的Claim中的authorities加入
//     * 方案：重新定义ReactiveAuthenticationManager权限管理器，默认转换器JwtGrantedAuthoritiesConverter
//     */
//    @Bean
//    public Converter<Jwt, ? extends Mono<? extends AbstractAuthenticationToken>> jwtAuthenticationConverter() {
//        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
//        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("prefix");
//        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("ClaimName");
//
//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
//        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
//    }
//}
