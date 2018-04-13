package org.dao;

import org.easybooks.test.model.vo.Userinfo;

public interface IUserTableDAO {
	Userinfo validateUser(String name, String psw);
	public String changePaw(Userinfo user, String newPaw);
}
