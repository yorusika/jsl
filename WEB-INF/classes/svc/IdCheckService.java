package svc;

import dao.HongDAO;

public class IdCheckService {

	public int IdCheck(String id) {
		
		HongDAO hdao=HongDAO.getInstance();
		return hdao.registerCheck(id);
		
	}

	
	

}
