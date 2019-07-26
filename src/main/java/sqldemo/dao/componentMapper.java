package sqldemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import sqldemo.model.component;
@Mapper
@Component
public interface componentMapper {
	
	List<component> getAll();
	
	int deleteByPrimaryKey(Integer componentid);
	
	int deleteforignkey();

	int insert(component record);

	int insertSelective(component record);

	component selectByPrimaryKey(Integer componentid);

	int updateByPrimaryKeySelective(component record);

	int updateByPrimaryKey(component record);

	Integer getPortIDByComponentName(String cmpname, String portname);

	component getIDbyName(String name);
	component getByType(String Type);
	
	List<component> selectAll_aadl();
	List<component> selectAll_sysml();
	List<component> selectAll_slk();
}