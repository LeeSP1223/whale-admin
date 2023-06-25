package com.lsp.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsp.common.vo.Result;
import com.lsp.system.entity.Role;
import com.lsp.system.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author Lee.
 * @since 2023-06-04
 */
@Api(tags = {"角色接口列表"})
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @ApiOperation("角色查询")
    @GetMapping("/list")
    public Result<Map<String,Object>> getRoleList(@RequestParam(value = "roleName",required = false) String roleName,
                                                  @RequestParam(value = "pageNo") Long pageNo,
                                                  @RequestParam(value = "pageSize") Long pageSize){

        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(roleName),Role::getRoleName,roleName);
        wrapper.orderByDesc(Role::getRoleId);

        Page<Role> page = new Page<>(pageNo,pageSize);
        roleService.page(page,wrapper);

        Map<String,Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("rows",page.getRecords());

        return Result.success(data);
    }

    @ApiOperation("添加角色")
    @PostMapping
    public Result<?> addRole(@RequestBody Role role) {
        roleService.addRole(role);
        return Result.success("新增角色成功");
    }

    @ApiOperation("根据id获取用户信息")
    @GetMapping("/{roleId}")
    public Result<Role> getRoleById(@PathVariable("roleId") Integer roleId) {
        Role role = roleService.getRoleById(roleId);
        return Result.success(role);
    }

    @ApiOperation("修改角色")
    @PutMapping
    public Result<?> updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
        return Result.success("修改角色成功");
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{roleId}")
    public Result<Role> deleteRoleById(@PathVariable("roleId") Integer roleId) {
        roleService.deleteRoleById(roleId);
        return Result.success("删除角色成功");
    }

    @ApiOperation("查询所有角色")
    @GetMapping("/all")
    public Result<List<Role>> getAllRole(){
        List<Role> roleList = roleService.list();
        return Result.success(roleList);
    }

}
