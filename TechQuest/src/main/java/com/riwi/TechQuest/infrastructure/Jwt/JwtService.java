package com.riwi.TechQuest.infrastructure.Jwt;

import com.riwi.TechQuest.application.services.Impl.CustomUserDetailsService;
import com.riwi.TechQuest.domain.model.enums.Roles;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private static final String SECRET_KEY = "BjeraabZDmZ2H0IHOB53oGQqe79X4XlLfoGJV+qLoe0=";

    @Autowired
    private CustomUserDetailsService userDetailsService;

    // Generación del token
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }

    private String getToken(Map<String, Object> extraClaims, UserDetails user) {
        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        System.out.println("Authorities: " + user.getAuthorities());

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .claim("roles", roles)// Asegúrate de que esto sea el email
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24 minutos
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Obtención de la clave de firma
    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Obtener el email desde el token
    public String getEmailFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    // Validación del token
    public boolean isTokenValid(String token, UserDetails existingUserDetails) {
        final String email = getEmailFromToken(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email); // Aquí cargamos el UserDetails

        boolean isValid = email.equals(userDetails.getUsername()) && !isTokenExpired(token);
        return isValid;
    }

    // Obtener todas las reclamaciones del token
    private Claims getAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Obtener una reclamación específica
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Verificar la fecha de expiración
    private Date expiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return expiration(token).before(new Date());
    }
}
