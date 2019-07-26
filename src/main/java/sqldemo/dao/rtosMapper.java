package sqldemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import sqldemo.model.rtos;
@Mapper
@Component
public interface rtosMapper {
    int deleteByPrimaryKey(Integer rtosid);

    int insert(rtos record);

    int insertSelective(rtos record);

    rtos selectByPrimaryKey(Integer rtosid);

    int updateByPrimaryKeySelective(rtos record);

    int updateByPrimaryKey(rtos record);
}