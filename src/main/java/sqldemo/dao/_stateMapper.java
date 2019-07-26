package sqldemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import sqldemo.model._state;

@Mapper
@Component
public interface _stateMapper {

	int deleteByPrimaryKey(Integer stateid);

	int insert(_state record);

	int insertSelective(_state record);

	_state selectByPrimaryKey(Integer stateid);

	int updateByPrimaryKeySelective(_state record);

	int updateByPrimaryKey(_state record);

	public Integer getStateID(String statename);

	List<_state> getStateUnderCMP(Integer cmpid);
}