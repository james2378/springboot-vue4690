package com.project.demo.controller;

import com.project.demo.entity.PurchasingManagement;
import com.project.demo.service.PurchasingManagementService;
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
 * 采购管理：(PurchasingManagement)表控制层
 *
 */
@RestController
@RequestMapping("/purchasing_management")
public class PurchasingManagementController extends BaseController<PurchasingManagement, PurchasingManagementService> {

    /**
     * 采购管理对象
     */
    @Autowired
    public PurchasingManagementController(PurchasingManagementService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapproduct_name = new HashMap<>();
        mapproduct_name.put("product_name",String.valueOf(paramMap.get("product_name")));
        List listproduct_name = service.select(mapproduct_name, new HashMap<>()).getResultList();
        if (listproduct_name.size()>0){
            return error(30000, "字段商品名称内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
