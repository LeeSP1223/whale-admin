package com.lsp.system.mapper;

import com.lsp.system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Lee.
 * @since 2023-06-04
 */
public interface UserMapper extends BaseMapper<User> {

    public List<String> getRoleNameByUserId(Integer userId);

}
