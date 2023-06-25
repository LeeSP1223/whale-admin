package com.lsp.system.controller;

import com.lsp.common.vo.Result;
import com.lsp.system.entity.Menu;
import com.lsp.system.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author Lee.
 * @since 2023-06-04
 */
@Api(tags = {"菜单接口列表"})
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @ApiOperation("查询所有菜单数据")
    @GetMapping
    public Result<List<Menu>> getAllMenu() {
        List<Menu> menuList = menuService.getAllMenu();
        return Result.success(menuList);
    }

}
