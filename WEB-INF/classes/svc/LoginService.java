package svc;

import dao.HongDAO;
import vo.Member;

public class LoginService {

	public Member getLoginMember(String id, String pass) {
		// DAO의  dao.getLoginMmeber(id, pass)메소드를 호출해서
		// member 객체를 받아와서 반환한다.
		HongDAO dao = new HongDAO();
		Member newMember = dao.getLoginMember(id, pass);
		
		return newMember;
	}


}
