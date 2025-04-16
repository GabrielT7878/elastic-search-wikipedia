package com.javainuse.boot_elasticsearch_crud.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.javainuse.boot_elasticsearch_crud.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenService {
    @Value("${elastic.security.secret}")
    private String secret;

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256("UGIHASDYGA%4132");

        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("id", user.getId())
                .withClaim("name", user.getUsername())
                .withExpiresAt(Instant.now().plusSeconds(84600))
                .withIssuedAt(Instant.now())
                .withIssuer("Api - Elasticsearch")
                .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return Optional.of(
                    JWTUserData.builder()
                            .userId(decodedJWT.getClaim("id").asLong())
                            .email(decodedJWT.getSubject())
                            .build()
            );
        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }
    }

}

