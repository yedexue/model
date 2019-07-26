package sqldemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import sqldemo.model.bus;
@Mapper
@Component
public interface busMapper {
    int deleteByPrimaryKey(Integer busid);

    int insert(bus record);

    int insertSelective(bus record);

    bus selectByPrimaryKey(Integer busid);

    int updateByPrimaryKeySelective(bus record);

    int updateByPrimaryKey(bus record);
}