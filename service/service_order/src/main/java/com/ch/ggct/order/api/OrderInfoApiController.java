package com.ch.ggct.order.api;

import com.ch.ggct.order.service.OrderInfoService;
import com.ch.ggct.vo.order.OrderFormVo;
import com.ch.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月29日 21:15
 */
@RestController
@RequestMapping("api/order/oderInfo")
public class OrderInfoApiController {
    @Autowired
    OrderInfoService orderInfoServicel;

    //生成订单方法
    @PostMapping("submitOrder")
    public Result  submitOrder(@RequestBody OrderFormVo orderFormVo){
        Long orderId = orderInfoServicel.submitOrder(orderFormVo);
        return Result.ok(orderId);
    }

}
