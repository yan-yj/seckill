package com.yan.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yan.seckill.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yan
 * @since 2022-03-12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
