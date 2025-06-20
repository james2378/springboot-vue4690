package com.project.demo.controller;

import com.project.demo.entity.WarehouseNumber;
import com.project.demo.service.WarehouseNumberService;
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
 * 仓库号：(WarehouseNumber)表控制层
 *
 */
@RestController
@RequestMapping("/warehouse_number")
public class WarehouseNumberController extends BaseController<WarehouseNumber, WarehouseNumberService> {

    /**
     * 仓库号对象
     */
    @Autowired
    public WarehouseNumberController(WarehouseNumberService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
