package com.yan.seckill.vo;

import com.yan.seckill.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DetailVo
 * 详情返回对象
 * @description:
 * @author: yan-yj
 * @time: 2022/4/23 11:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailVo {

    private User user;

    private GoodsVo goodsVo;

    private int secKillStatus;

    private int remainSeconds;
}
