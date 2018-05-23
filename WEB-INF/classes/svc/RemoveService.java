package svc;

import dao.HongDAO;

public class RemoveService {

	public boolean removeMember(String id) {
		//DAO의 removeMember(id) 메소드를 호출해서 결과값을 int형으로 받아온다.
		//int가 0이면 false를 1이상이면 true를 리턴해 준다.
		HongDAO dao = new HongDAO();
		int result = dao.removeMember(id);
		
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	
		
	}

}
