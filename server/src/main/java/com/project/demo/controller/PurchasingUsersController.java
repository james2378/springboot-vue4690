package com.project.demo.controller;

import com.project.demo.entity.PurchasingUsers;
import com.project.demo.service.PurchasingUsersService;
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
 * 采购用户：(PurchasingUsers)表控制层
 *
 */
@RestController
@RequestMapping("/purchasing_users")
public class PurchasingUsersController extends BaseController<PurchasingUsers, PurchasingUsersService> {

    /**
     * 采购用户对象
     */
    @Autowired
    public PurchasingUsersController(PurchasingUsersService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapprocurement_personnel = new HashMap<>();
        mapprocurement_personnel.put("procurement_personnel",String.valueOf(paramMap.get("procurement_personnel")));
        List listprocurement_personnel = service.select(mapprocurement_personnel, new HashMap<>()).getResultList();
        if (listprocurement_personnel.size()>0){
            return error(30000, "字段采购人员内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
