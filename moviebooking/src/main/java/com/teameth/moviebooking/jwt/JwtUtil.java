package com.teameth.moviebooking.jwt;

import com.teameth.moviebooking.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Service
public class JwtUtil {
    private String Secret_Key = "secret";
     public User acceptUser( User user ){
         return user;
     }
    public String extraUsername(String token){
        return extractClaim(token,Claims ::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

        public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
            final Claims claims = extractAllClaims(token);
            return claimsResolver.apply(claims);
        }
        private Claims extractAllClaims(String token){
            return Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(token).getBody();
        }
        private Boolean isTokenExpired(String token){
            return extractExpiration(token).before(new Date());
        }
        public String generateToken(UserDetails userDetails){
            Map<String, Object> claims = new HashMap<>();

            claims.put("roles",userDetails.getAuthorities());
            return createToken(claims,userDetails.getUsername());
        }
        public String createToken(Map<String,Object> claims,String subject){
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(subject)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                    .signWith(SignatureAlgorithm.HS256,Secret_Key).compact();
        }
        public boolean validationToken(String token,UserDetails userDetails){
        final String username =extraUsername(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
        }

    }

