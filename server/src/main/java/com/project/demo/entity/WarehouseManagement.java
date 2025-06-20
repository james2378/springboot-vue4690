package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 仓储管理：(WarehouseManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "WarehouseManagement")
public class WarehouseManagement implements Serializable {

    // WarehouseManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_management_id")
    private Integer warehouse_management_id;

    // 商品图
    @Basic
    private String product_map;
    // 货物分类
    @Basic
    private String classification_of_goods;
    // 商品名称
    @Basic
    private String product_name;
    // 商品类型
    @Basic
    private String product_type;
    // 品牌
    @Basic
    private String brand;
    // 商品规格
    @Basic
    private String commodity_specifications;
    // 供应商编号
    @Basic
    private Integer supplier_number;
    // 供应商名称
    @Basic
    private String supplier_name;
    // 库存数量
    @Basic
    private Integer inventory_quantity;
    // 销售价
    @Basic
    private Integer sales_price;
    // 仓库号
    @Basic
    private String warehouse_number;
    // 存储位置图
    @Basic
    private String storage_location_map;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
