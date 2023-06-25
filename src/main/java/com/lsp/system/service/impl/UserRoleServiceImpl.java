package com.lsp.system.service.impl;

import com.lsp.system.entity.UserRole;
import com.lsp.system.mapper.UserRoleMapper;
import com.lsp.system.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色映射表 服务实现类
 * </p>
 *
 * @author Lee.
 * @since 2023-06-04
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
