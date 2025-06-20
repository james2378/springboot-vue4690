package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 销售出库：(SalesOutbound)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "SalesOutbound")
public class SalesOutbound implements Serializable {

    // SalesOutbound编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_outbound_id")
    private Integer sales_outbound_id;

    // 商品图
    @Basic
    private String product_map;
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
    // 销售价
    @Basic
    private String sales_price;
    // 订单号
    @Basic
    private String order_number;
    // 销售数量
    @Basic
    private Integer sales_volumes;
    // 销售金额
    @Basic
    private String sales_amount;
    // 销售月份
    @Basic
    private String sales_month;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
