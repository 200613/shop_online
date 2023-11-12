package cn.niit.shop_online.service.impl;

import cn.niit.shop_online.common.exception.ServerException;
import cn.niit.shop_online.convert.AddressConvert;
import cn.niit.shop_online.entity.UserShippingAddress;
import cn.niit.shop_online.enums.AddressDefaultEnum;
import cn.niit.shop_online.enums.AddressDeleteFlagEnum;
import cn.niit.shop_online.mapper.UserShippingAddressMapper;
import cn.niit.shop_online.service.UserShippingAddressService;
import cn.niit.shop_online.vo.AddressVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 200613
 * @since 2023-11-07
 */
@Service
public class UserShippingAddressServiceImpl extends ServiceImpl<UserShippingAddressMapper, UserShippingAddress> implements UserShippingAddressService {

    @Override
    public Integer saveshippingAddress(AddressVO addressVO) {
       UserShippingAddress convert=AddressConvert.INSTANCE.convert(addressVO);
       if (addressVO.getIsDefault()==AddressDefaultEnum.DEFAULT_ADDRESS.getValue()){
           List<UserShippingAddress> list=baseMapper.selectList(new
                   LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getIsDefault,
                   AddressDefaultEnum.DEFAULT_ADDRESS.getValue()));
           if (list.size()>0){
               throw  new ServerException("已默认存在地址，请勿重复操作");
           }
       }
       save(convert);
       return convert.getId();
    }

    @Override
    public Integer editShippingAddress(AddressVO addressVO) {
      UserShippingAddress userShippingAddress=baseMapper.selectById(addressVO.getId());
      if (userShippingAddress==null){
          throw  new ServerException("地址不存在");

      }
      if (addressVO.getIsDefault()== AddressDefaultEnum.DEFAULT_ADDRESS.getValue()){
          UserShippingAddress address=baseMapper.selectOne(new
                  LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getUserId,addressVO.getUserId()).eq(UserShippingAddress::getIsDefault,
                  AddressDefaultEnum.DEFAULT_ADDRESS.getValue()));
          if(address!=null){
              address.setIsDefault(AddressDefaultEnum.NOT_DEFAULT_ADDRESS.getValue());
              updateById(address);
          }
      }
        UserShippingAddress address= AddressConvert.INSTANCE.convert(addressVO);
        updateById(address);
        return address.getId();
    }

    @Override
    public List<AddressVO> putShippingList(Integer userId) {
        List<UserShippingAddress> list = baseMapper.selectList(new LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getUserId, userId));
        return AddressConvert.INSTANCE.convertToAddressVOList(list);
    }

    @Override
    public AddressVO getShippingAddress(Integer id) {
        UserShippingAddress address = baseMapper.selectById(id);
        return AddressConvert.INSTANCE.convertToAddressVO(address);
    }

    @Override
    public void deleteShippingAddress(Integer id) {
        UserShippingAddress address = baseMapper.selectById(id);
        if (address == null){
            throw new ServerException("地址不存在");
        }
        if (address.getIsDefault() == AddressDefaultEnum.DEFAULT_ADDRESS.getValue()){
            throw new ServerException("默认地址不能删除");
        }else {
            UserShippingAddress updateAddress = new UserShippingAddress();
            updateAddress.setId(id);
            updateAddress.setDeleteFlag(AddressDeleteFlagEnum.DELETE_ADDRESS.getValue());
            baseMapper.update(updateAddress, new LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getId, id));
        }
    }


}
