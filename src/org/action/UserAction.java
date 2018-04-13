package org.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.dao.IUserTableDAO;
import org.dao.UserTableDAO;
import org.easybooks.test.model.vo.Userinfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport {
	Userinfo user;
	Userinfo user1;
	String newPaw;

	public Userinfo getUser() {
		return user;
	}

	public void setUser(Userinfo user) {
		this.user = user;
	}

	public void setNewPaw(String newPaw) {
		this.newPaw = newPaw;
	}

	//登入验证
	public String login() throws Exception {
		String num = user.getNumb();
		String paw = user.getPaw();
		boolean validated = false;
		user = null;
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		user1 = null;
		user1 = (Userinfo) session.get("user");
		if (user1 == null) {
			user1 = new UserTableDAO().validateUser(num, paw);
			if (user1 != null) {
				session.put("user", user1);
				session.put("paw", paw);
				validated = true;
			}
		} else {
			validated = true;
		}
		if (validated) {
			return "success";
		} else {
			return "error";
		}		
	}
	
	//修改密码
	public String changePaw() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		user = (Userinfo) session.get("user");
		session.put("paw", newPaw);
		String state = new UserTableDAO().changePaw(user, newPaw);
		return state;
	}
	// �û�ע��
//	public String registerUser() {
		// DBOperations db = new DBOperations();
		// if (db.saveUser(user)) {
		// db.closePstmt();
		// db.closeConn();
		// return SUCCESS;
		// } else {
		// db.closePstmt();
		// db.closeConn();
		// return ERROR;
		// }
		// Session session = MyHibernateSessionFactory.getSession();
		// Transaction ts = session.beginTransaction();
		// session.save(user);
		// ts.commit();
		// MyHibernateSessionFactory.closeSession();
//		Configuration configuration = new Configuration().configure();
//		SessionFactory sf = configuration.buildSessionFactory();
//		Session session = sf.openSession();
//		Transaction ts = session.beginTransaction();
//		session.save(user);
//		ActionContext context = ActionContext.getContext();
//		Map s = context.getSession();
//		s.put("user", user);
//		ts.commit();
//		session.close();
//		return SUCCESS;
//	}
}
