package sqldemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import sqldemo.model.shareddataaccess;
@Mapper
@Component
public interface shareddataaccessMapper {
    int deleteByPrimaryKey(Integer shareddataaccessid);

    int insert(shareddataaccess record);

    int insertSelective(shareddataaccess record);

    shareddataaccess selectByPrimaryKey(Integer shareddataaccessid);

    int updateByPrimaryKeySelective(shareddataaccess record);

    int updateByPrimaryKey(shareddataaccess record);
}