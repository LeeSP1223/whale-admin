package com.lsp.system.service;

import com.lsp.system.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author Lee.
 * @since 2023-06-04
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> getAllMenu();

    List<Menu> getMenuListByUserId(Integer userId);
}
