package org.xupt.action;

import org.xupt.bean.User;
import org.xupt.dao.UserDao;

import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport {

	private String name;
	private String pass;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	private static final long serialVersionUID = 1L;
    
	@Override
	public String execute() throws Exception {
		 User user = new User(name, pass);
//		    String password=new UserDao().findpass(user);
//		    if(password==null) {
		    	new UserDao().add(user);
		        return SUCCESS;	
//		    }else {
//		    	return ERROR;
//		    }
	   
	}
}
