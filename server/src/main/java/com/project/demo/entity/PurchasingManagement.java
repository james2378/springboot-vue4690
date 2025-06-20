package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 采购管理：(PurchasingManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PurchasingManagement")
public class PurchasingManagement implements Serializable {

    // PurchasingManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchasing_management_id")
    private Integer purchasing_management_id;

    // 商品图
    @Basic
    private String product_map;
    // 采购单号
    @Basic
    private String purchase_order_number;
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
    // 采购数量
    @Basic
    private Integer purchase_quantity;
    // 采购人员
    @Basic
    private Integer procurement_personnel;
    // 采购日期
    @Basic
    private Timestamp purchase_date;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
