package sqldemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import sqldemo.model.ASyncMessaging;
@Mapper
@Component
public interface ASyncMessagingMapper {
    int deleteByPrimaryKey(Integer asyncmessagingid);

    int insert(ASyncMessaging record);

    int insertSelective(ASyncMessaging record);

    ASyncMessaging selectByPrimaryKey(Integer asyncmessagingid);

    int updateByPrimaryKeySelective(ASyncMessaging record);

    int updateByPrimaryKey(ASyncMessaging record);
}