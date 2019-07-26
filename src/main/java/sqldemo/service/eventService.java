package sqldemo.service;

import sqldemo.dao._eventMapper;
import sqldemo.model._event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("eventService")
public class eventService {
	@Autowired
	_eventMapper _eventmapper;
	public List<_event> getAll(){
        return _eventmapper.getAll();
//       
		
    }
	public void insert(_event record) {
		_eventmapper.insert(record);
		
	}
	
	public int deleteByPrimaryKey(Integer eventid) {
		return _eventmapper.deleteByPrimaryKey(eventid);
		
	}
	
	

}
