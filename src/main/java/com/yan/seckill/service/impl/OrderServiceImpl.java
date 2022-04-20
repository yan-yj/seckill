package com.yan.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yan.seckill.mapper.OrderMapper;
import com.yan.seckill.pojo.Order;
import com.yan.seckill.pojo.SeckillGoods;
import com.yan.seckill.pojo.SeckillOrder;
import com.yan.seckill.pojo.User;
import com.yan.seckill.service.IOrderService;
import com.yan.seckill.service.ISeckillGoodsService;
import com.yan.seckill.service.ISeckillOrderService;
import com.yan.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yan
 * @since 2022-04-10
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private ISeckillGoodsService seckillGoodsService;
    @Autowired(required = false)
    private OrderMapper orderMapper;
    @Autowired
    private ISeckillOrderService seckillOrderService;

    /**
     * 秒杀
     * @param user
     * @param goodsVo
     * @return
     */
    @Override
    public Order seckill(User user, GoodsVo goodsVo) {
        // 秒杀商品表减库存
        SeckillGoods seckillGoods = seckillGoodsService.getOne(
                new QueryWrapper<SeckillGoods>().eq("goods_id", goodsVo.getId()));
        seckillGoods.setStockCount(seckillGoods.getStockCount()-1);
        seckillGoodsService.updateById(seckillGoods);

        // 生成订单
        Order order = new Order();
        order.setUserId(user.getId());
        order.setGoodsId(goodsVo.getId());
        order.setDeliveryAddrId(0L);
        order.setGoodsName(goodsVo.getGoodsName());
        order.setGoodsCount(1);
        order.setGoodsPrice(seckillGoods.getSeckillPrice());
        order.setOrderChannel(1);
        order.setStatus(0);
        order.setCreateDate(new Date());
        orderMapper.insert(order);

        // 生成秒杀订单
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setUserId(user.getId());
        seckillOrder.setOrderId(order.getId());
        seckillOrder.setGoodsId(goodsVo.getId());
        seckillOrderService.save(seckillOrder);
        return order;
    }
}
