package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 仓库号：(WarehouseNumber)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "WarehouseNumber")
public class WarehouseNumber implements Serializable {

    // WarehouseNumber编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_number_id")
    private Integer warehouse_number_id;

    // 仓库号
    @Basic
    private String warehouse_number;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
