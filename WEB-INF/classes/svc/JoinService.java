package svc;


import dao.HongDAO;
import vo.Member;

public class JoinService {

	public boolean insertMember(Member member) {
		//1. DAO의 insertMember(member) 메소드를 호출해서 결과값을 int로 받아온다.
		//2. 결과값이 0이면 false, 1이상이면 true를 반환한다.
		HongDAO dao = new HongDAO();
		int newMember = dao.insertMember(member);

		if(newMember >= 1) {
			return true;
		}else {
			return false;
		}
		
	}

}
