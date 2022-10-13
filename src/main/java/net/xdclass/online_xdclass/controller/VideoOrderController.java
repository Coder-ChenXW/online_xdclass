package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.entity.VideoOrder;
import net.xdclass.online_xdclass.model.request.VideoOrderRequest;
import net.xdclass.online_xdclass.service.VideoOrderService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {


    @Autowired
    private VideoOrderService videoOrderService;


    /**
     * 下单接口
     * @return
     */
    @Transactional
    @RequestMapping("save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){

        Integer userId = (Integer) request.getAttribute("user_id");


        int rows = videoOrderService.save(userId, videoOrderRequest.getVideoId());

        return rows == 0 ? JsonData.buildError("下单失败"):JsonData.buildSuccess();
    }

    
    /** 
     * @Function: 功能描述 订单列表
     * @Author: ChenXW
     * @Date: 20:18 2022/10/11
     */
    @GetMapping("list")
    public JsonData listOrder(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");

        List<VideoOrder> videoOrderList = videoOrderService.listOrderByUserId(userId);

        return JsonData.buildSuccess(videoOrderList);
    }

}
