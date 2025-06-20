package com.project.demo.controller;

import com.project.demo.entity.WarehousingAudit;
import com.project.demo.service.WarehousingAuditService;
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
 * 入库审核：(WarehousingAudit)表控制层
 *
 */
@RestController
@RequestMapping("/warehousing_audit")
public class WarehousingAuditController extends BaseController<WarehousingAudit, WarehousingAuditService> {

    /**
     * 入库审核对象
     */
    @Autowired
    public WarehousingAuditController(WarehousingAuditService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mappurchase_order_number = new HashMap<>();
        mappurchase_order_number.put("purchase_order_number",String.valueOf(paramMap.get("purchase_order_number")));
        List listpurchase_order_number = service.select(mappurchase_order_number, new HashMap<>()).getResultList();
        if (listpurchase_order_number.size()>0){
            return error(30000, "字段采购单号内容不能重复");
        }
        this.addMap(paramMap);
        String sql = "SELECT MAX(warehousing_audit_id) AS max FROM "+"`warehousing_audit`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = "UPDATE `warehouse_management` INNER JOIN `warehousing_audit` ON warehouse_management.product_name=warehousing_audit.product_name SET warehouse_management.inventory_quantity= warehouse_management.inventory_quantity + warehousing_audit.receipt_quantity WHERE warehousing_audit.warehousing_audit_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
