package com.yan.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yan.seckill.pojo.Order;
import com.yan.seckill.pojo.User;
import com.yan.seckill.vo.GoodsVo;
import com.yan.seckill.vo.OrderDetailVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yan
 * @since 2022-04-10
 */
public interface IOrderService extends IService<Order> {

    /**
     * 秒杀
     * @param user
     * @param goodsVo
     * @return
     */
    Order seckill(User user, GoodsVo goodsVo);

    /**
     * 订单详情
     * @param orderId
     * @return
     */
    OrderDetailVo detail(Long orderId);
}
