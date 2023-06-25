package com.lsp.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 角色菜单映射表
 * </p>
 *
 * @author Lee.
 * @since 2023-06-04
 */
@Data
@TableName("whale_role_menu")
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer roleId;
    private Integer menuId;


}
