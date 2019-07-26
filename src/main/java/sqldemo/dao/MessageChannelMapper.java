package sqldemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import sqldemo.model.MessageChannel;
@Mapper
@Component
public interface MessageChannelMapper {
    int deleteByPrimaryKey(Integer messagechannelid);

    int insert(MessageChannel record);

    int insertSelective(MessageChannel record);

    MessageChannel selectByPrimaryKey(Integer messagechannelid);

    int updateByPrimaryKeySelective(MessageChannel record);

    int updateByPrimaryKey(MessageChannel record);
}