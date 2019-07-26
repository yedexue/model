package sqldemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sqldemo.dao.componentMapper;
import sqldemo.model.component;

@Service("ComponentService")
public class ComponentService {
	
	@Autowired
	componentMapper componentMapper;
	public List<component> getAll() {
		return componentMapper.getAll();
		
	}
	public void insert(component record) {
		componentMapper.insert(record);
		
	}
	public int delete (Integer componentid){
		return componentMapper.deleteByPrimaryKey(componentid);
		
	}
	public int deleteforignkey() {
		return componentMapper.deleteforignkey();
	}

}
