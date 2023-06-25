package com.lsp.system.mapper;

import com.lsp.system.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author Lee.
 * @since 2023-06-04
 */
public interface MenuMapper extends BaseMapper<Menu> {
    public List<Menu> getMenuListByUserId(@Param("userId") Integer userId, @Param("pid") Integer pid);
}
