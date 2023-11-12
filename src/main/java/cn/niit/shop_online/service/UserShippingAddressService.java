package cn.niit.shop_online.service;

import cn.niit.shop_online.entity.UserShippingAddress;
import cn.niit.shop_online.vo.AddressVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 200613
 * @since 2023-11-07
 */
public interface UserShippingAddressService extends IService<UserShippingAddress> {
    //添加收货地址
    Integer saveshippingAddress(AddressVO addressVO) ;
    //修改收货地址
    Integer editShippingAddress(AddressVO addressVO) ;
    //收货地址列表
    List<AddressVO> putShippingList(Integer userId);
    //收货地址详情
    AddressVO getShippingAddress(Integer id);
    //删除收获地址
    void deleteShippingAddress(Integer id);



}
