package com.project.demo.controller;

import com.project.demo.entity.SalesOutbound;
import com.project.demo.service.SalesOutboundService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;


/**
 * 销售出库：(SalesOutbound)表控制层
 *
 */
@RestController
@RequestMapping("/sales_outbound")
public class SalesOutboundController extends BaseController<SalesOutbound, SalesOutboundService> {

    /**
     * 销售出库对象
     */
    @Autowired
    public SalesOutboundController(SalesOutboundService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(sales_outbound_id) AS max FROM "+"`sales_outbound`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = "UPDATE `warehouse_management` INNER JOIN `sales_outbound` ON warehouse_management.product_name=sales_outbound.product_name SET warehouse_management.inventory_quantity= warehouse_management.inventory_quantity - sales_outbound.sales_volumes WHERE sales_outbound.sales_outbound_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
