package com.thunder.springcloud.controller;

import com.thunder.springcloud.dto.CommonResult;
import com.thunder.springcloud.entities.Payment;
import com.thunder.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//该注解使得每一个方法都传递回一个json数据
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/payment/create")
    //当用户服务访问该接口时，一定要记得加@RequesstBody标签，不然数据无法传递，此处为巨坑啊
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.insert(payment);
        log.info("插入结果为:"+result+"，插入数据为："+payment.getSerial());
        if (result > 0){
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(400,"插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.selectByPrimaryKey(id);
        log.info("查询结果:"+result);
        if (result != null){
            return new CommonResult(200,"查询数据库成功",result);
        }else {
            return new CommonResult(400,"没有对应记录，查询Id："+id,null);
        }
    }


}
