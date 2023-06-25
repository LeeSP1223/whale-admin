package com.lsp.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lsp.system.entity.Role;
import com.lsp.system.entity.RoleMenu;
import com.lsp.system.mapper.RoleMapper;
import com.lsp.system.mapper.RoleMenuMapper;
import com.lsp.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Lee.
 * @since 2023-06-04
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Override
    @Transactional
    public void addRole(Role role) {
        // 写入角色表
        this.baseMapper.insert(role);
        // 写入角色菜单的关系表
        if (null != role.getMenuIdList()) {
            for (Integer menuId : role.getMenuIdList()) {
                roleMenuMapper.insert(new RoleMenu(null,role.getRoleId(),menuId));
            }
        }
    }

    @Override
    public Role getRoleById(Integer roleId) {
        Role role = this.baseMapper.selectById(roleId);
        List<Integer> menuIdList = roleMenuMapper.getMenuIdListByRoleId(roleId);
        role.setMenuIdList(menuIdList);
        return role;
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        // 修改角色表
        this.baseMapper.updateById(role);
        // 删除原有权限
        LambdaQueryWrapper<RoleMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RoleMenu::getRoleId,role.getRoleId());
        roleMenuMapper.delete(wrapper);
        // 新增权限
        if (null != role.getMenuIdList()) {
            for (Integer menuId : role.getMenuIdList()) {
                roleMenuMapper.insert(new RoleMenu(null,role.getRoleId(),menuId));
            }
        }
    }

    @Override
    @Transactional
    public void deleteRoleById(Integer roleId) {
        this.baseMapper.deleteById(roleId);
        // 删除角色菜单权限
        LambdaQueryWrapper<RoleMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RoleMenu::getRoleId,roleId);
        roleMenuMapper.delete(wrapper);
    }
}
