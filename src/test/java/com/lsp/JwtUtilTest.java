package com.lsp;

import com.lsp.common.utils.JwtUtil;
import com.lsp.system.entity.User;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Lee.
 * @Description: TODO
 * @DateTime: 2023/6/12 15:14
 **/

@SpringBootTest
public class JwtUtilTest {

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    public void testCreateJwt() {
        User user = new User();
        user.setUsername("admin");
        user.setPhone("18888888888");
        String token = jwtUtil.createToken(user);
        System.out.println(token);
    }

    @Test
    public void testParseJwt() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzMzJhZDkwYS03ZmU0LTRmMDgtYTRjMy1iYTczZTA4OWE0OGEiLCJzdWIiOiJ7XCJwaG9uZVwiOlwiMTg4ODg4ODg4ODhcIixcInVzZXJuYW1lXCI6XCJhZG1pblwifSIsImlzcyI6InN5c3RlbSIsImlhdCI6MTY4NjU1NDQ1OCwiZXhwIjoxNjg2NTU2MjU4fQ.z2eg60dv9w6i-6nM7q_O36-qQIdZWAyeW8la7MEffxs";
        Claims claims = jwtUtil.parseToken(token);
        System.out.println(claims);
    }

    @Test
    public void testParseJwt2() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzMzJhZDkwYS03ZmU0LTRmMDgtYTRjMy1iYTczZTA4OWE0OGEiLCJzdWIiOiJ7XCJwaG9uZVwiOlwiMTg4ODg4ODg4ODhcIixcInVzZXJuYW1lXCI6XCJhZG1pblwifSIsImlzcyI6InN5c3RlbSIsImlhdCI6MTY4NjU1NDQ1OCwiZXhwIjoxNjg2NTU2MjU4fQ.z2eg60dv9w6i-6nM7q_O36-qQIdZWAyeW8la7MEffxs";
        User user = jwtUtil.parseToken(token,User.class);
        System.out.println(user);
    }

}
