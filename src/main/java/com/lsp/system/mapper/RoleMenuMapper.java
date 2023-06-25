package com.lsp.system.mapper;

import com.lsp.system.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色菜单映射表 Mapper 接口
 * </p>
 *
 * @author Lee.
 * @since 2023-06-04
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    public List<Integer> getMenuIdListByRoleId(Integer roleId);
}
