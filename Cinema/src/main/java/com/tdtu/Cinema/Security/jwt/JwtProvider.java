package com.tdtu.Cinema.Security.jwt;


import com.tdtu.Cinema.Security.userprincal.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private String jwtsecret = "111111111";
    private  int jwtExpiration = 86400;

    public String createToken(Authentication authentication){
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpiration * 1000);
        return Jwts.builder()
                .setSubject(userPrinciple.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)

                .signWith(SignatureAlgorithm.HS512, jwtsecret)
                .compact();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtsecret).parseClaimsJwt(token);
            return  true;
        }catch (SignatureException e){
            logger.error("invalid jwt " + e);
        }catch (MalformedJwtException e){
            logger.error("invalid format " + e);
        }catch (ExpiredJwtException e){
            logger.error("invalid expired " + e);
        }catch (UnsupportedJwtException e){
            logger.error("invalid unsupport " + e);
        }catch (IllegalArgumentException e){
            logger.error("invalid claims " + e);
        }
        return false;
    }

    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtsecret)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUserNameFromtoken(String token){
        String username = Jwts.parser().setSigningKey(jwtsecret).parseClaimsJwt(token).getBody().getSubject();
        return username;
    }


}
