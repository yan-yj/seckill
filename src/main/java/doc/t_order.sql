use seckill;
create table t_order
(
    id                  bigint(20) not null auto_increment comment '订单ID',
    user_id             bigint(20) default null comment '用户ID',
    goods_id            bigint(20) default null comment '商品ID',
    delivery_addr_id    bigint(20) default null comment '收获地址ID',
    goods_name          varchar(16) default null comment '商品名称，冗余用于查询',
    goods_count         int(11) default '0' comment '商品数量',
    goods_price         decimal(10,2) default '0.00' comment '商品单价',
    order_channel       tinyint(4) default '0' comment '订单来源：1 pc, 2 android, 3 ios',
    status              tinyint(4) default '0' comment '订单状态：0 新建未支付， 1 已支付， 2 已发货， 3 已收货， 4 已退款， 5 已完成',
    create_date         datetime default null comment '订单创建时间',
    pay_date            datetime default null comment '支付时间',
    primary key(id)
)engine = innodb auto_increment = 12 default charset = utf8mb4;