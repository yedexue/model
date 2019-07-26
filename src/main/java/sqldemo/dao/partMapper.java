package sqldemo.dao;

import sqldemo.model.part;

public interface partMapper {
    int deleteByPrimaryKey(Integer partitionid);

    int insert(part record);

    int insertSelective(part record);

    part selectByPrimaryKey(Integer partitionid);

    int updateByPrimaryKeySelective(part record);

    int updateByPrimaryKey(part record);
}