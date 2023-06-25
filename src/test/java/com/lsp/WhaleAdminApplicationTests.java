package com.lsp;

import com.lsp.system.entity.User;
import com.lsp.system.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class WhaleAdminApplicationTests {

	@Resource
	private UserMapper userMapper;


	@Test
	void testMapper() {
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}

}
