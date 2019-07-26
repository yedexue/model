package sqldemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import sqldemo.model._provide;
@Mapper
@Component
public interface _provideMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(_provide record);

    int insertSelective(_provide record);

    _provide selectByPrimaryKey(Integer id);
    _provide selectByportid(Integer id);

    int updateByPrimaryKeySelective(_provide record);

    int updateByPrimaryKey(_provide record);
}