package com.lsp.system.service;

import com.lsp.system.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Lee.
 * @since 2023-06-04
 */
public interface IRoleService extends IService<Role> {

    void addRole(Role role);

    Role getRoleById(Integer roleId);

    void updateRole(Role role);

    void deleteRoleById(Integer roleId);
}
