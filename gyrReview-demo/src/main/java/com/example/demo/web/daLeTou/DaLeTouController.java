/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: DaLeTouController
 * Author:   gyr
 * Date:     2020/8/22 21:53
 * Description:
 */
package com.example.demo.web.daLeTou;

import com.example.demo.service.daLeTou.DaLeTouServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dlt")
public class DaLeTouController {


    @Autowired
    private DaLeTouServie daLeTouServie;


    @RequestMapping("/getData")
    public String getData(){
        return daLeTouServie.getData();
    }

}