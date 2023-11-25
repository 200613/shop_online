package cn.niit.shop_online.service;

import cn.niit.shop_online.common.result.PageResult;
import cn.niit.shop_online.entity.UserOrder;
import cn.niit.shop_online.query.CancelGoodsQuery;
import cn.niit.shop_online.query.OrderPreQuery;
import cn.niit.shop_online.query.OrderQuery;
import cn.niit.shop_online.vo.OrderDetailVO;
import cn.niit.shop_online.vo.OrderLogisticVO;
import cn.niit.shop_online.vo.SubmitOrderVO;
import cn.niit.shop_online.vo.UserOrderVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 1103386023
 * @since 2023-11-07
 */
public interface UserOrderService extends IService<UserOrder> {
Integer addGoodsOrder(UserOrderVO orderVO);
    /**
     * 订单详情
     *
     * @param id
     * @return
     */
    OrderDetailVO getOrderDetail(Integer id);
    /**
     * 填写订单 - 获取预付订单
     *
     * @param userId
     * @return
     */
    SubmitOrderVO getPreOrderDetail(Integer userId);
    /**
     * 填写订单 - 获取立即购买订单
     *
     * @param query
     * @return
     */
    SubmitOrderVO getPreNowOrderDetail(OrderPreQuery query);
    /**
     * 填写订单 - 获取再次购买订单
     *
     * @param id
     * @return
     */
    SubmitOrderVO getRepurchaseOrderDetail(Integer id);
    /**
     * 订单列表
     *
     * @param query
     * @return
     */
    PageResult<OrderDetailVO> getOrderList(OrderQuery query);
    /**
     * 取消订单
     *
     * @param query
     * @return
     */
    OrderDetailVO cancelOrder(CancelGoodsQuery query);
    /**
     * 删除订单
     *
     * @param ids
     */
    void deleteOrder(List<Integer> ids, Integer userId);
    /**
     * 订单支付
     *
     * @param id
     */
    void payOrder(Integer id);
    /**
     * 模拟发货
     *
     * @param id
     * @return
     */
    void consignOrder(Integer id);
    /**
     * 确认收货
     *
     * @param id
     * @return
     */
    OrderDetailVO receiptOrder(Integer id);
    /**
     * 物流订单信息
     *
     * @param id
     * @return
     */
    OrderLogisticVO getOrderLogistics(Integer id);
}

