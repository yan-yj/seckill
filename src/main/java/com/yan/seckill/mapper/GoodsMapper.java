package com.yan.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yan.seckill.pojo.Goods;
import com.yan.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yan
 * @since 2022-04-10
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 获取商品列表
     * @return
     */
    List<GoodsVo> findGoodsVo();

    /**
     * 获取商品详情
     * @return
     * @param goodsId
     */
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
