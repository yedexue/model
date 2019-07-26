package sqldemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import sqldemo.model.InvocationChannel;
@Mapper
@Component
public interface InvocationChannelMapper {
    int deleteByPrimaryKey(Integer invocationchannelid);

    int insert(InvocationChannel record);

    int insertSelective(InvocationChannel record);

    InvocationChannel selectByPrimaryKey(Integer invocationchannelid);

    int updateByPrimaryKeySelective(InvocationChannel record);

    int updateByPrimaryKey(InvocationChannel record);
}