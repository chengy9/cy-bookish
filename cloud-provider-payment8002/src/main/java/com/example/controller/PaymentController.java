package com.example.controller;

import com.example.beans.CommonResult;
import com.example.beans.Payment;
import com.example.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****新增结果:" + result);

        if (result > 0) {
            return new CommonResult(200, "插入成功,返回结果" + result + "服务端口：" + serverPort, payment);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:{}", payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功" + "服务端口：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID: " + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public CommonResult<Payment> lb() {

        return new CommonResult(200, "lb访问成功服务端口：" + serverPort);

    }
}



