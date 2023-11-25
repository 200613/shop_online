package cn.niit.shop_online.mapper;

import cn.niit.shop_online.entity.Goods;
import cn.niit.shop_online.vo.UserOrderGoodsVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 1103386023
 * @since 2023-11-07
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * 根据订单id 查询商品信息列表
     *
     * @param id
     * @return
     */
    List<UserOrderGoodsVO> getGoodsListByOrderId(@Param("id") Integer id);

}
