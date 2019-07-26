package sqldemo.controller;

import sqldemo.model.component;
import sqldemo.model.part;
import sqldemo.service.ComponentService;
import sqldemo.service.eventService;

import org.apache.catalina.User;
import org.apache.ibatis.javassist.expr.NewArray;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.sql.visitor.functions.Insert;
import com.alibaba.druid.stat.TableStat.Name;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller


public class LoginController {
	@Autowired
	ComponentService componentservice;

    
    @RequestMapping(value="/login")
    public ModelAndView hello(){
    	 // 顾名思义 实体和数据 同时返回页面模板和数据
        ModelAndView mav = new ModelAndView("starter");
        List<component> list =componentservice.getAll();
        mav.addObject("list",list);
        
        

        
        
        return mav;
    }
    
    @RequestMapping(value = "/add",method = RequestMethod.POST) 
    public ModelAndView add(component record){
    	ModelAndView mav = new ModelAndView("starter");
    	componentservice.insert(record); 
    	return mav;
    	}
    
    @RequestMapping(value = "/delete",method = RequestMethod.POST) 
    public ModelAndView delete(int componentid){
    	ModelAndView mav = new ModelAndView("starter");
    	
		componentservice.delete(componentid);
    	return mav;
    	}
    
    @RequestMapping(value = "/DeleteServlet")
    public ModelAndView delete1(HttpServletRequest request, HttpServletResponse response)
    {
    	
    	String id=request.getParameter("name");
    	Integer id1 =new Integer(id);  //类型转换
    	componentservice.deleteforignkey();
    	componentservice.delete(id1);
    	ModelAndView mav =new ModelAndView("starter");
    	return mav;
    	
    }
    
	@RequestMapping(value = "/cs")
	public ModelAndView cs() {
		ModelAndView mav =new ModelAndView("index_iframe");
		return mav;
	}
   

}
