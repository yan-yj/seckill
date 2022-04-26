package com.yan.seckill.vo;

import com.yan.seckill.pojo.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OrderDetailVo
 * 订单详情返回对象
 * @description:
 * @author: yan-yj
 * @time: 2022/4/26 22:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailVo {
    private Order order;
    private GoodsVo goodsVo;
}
