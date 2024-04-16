package Controller;

import Model.NuneDamaDAO;
import Model.NuneDamaDTO;

public class Controller2 {
	
	public void select(NuneDamaDTO dto) {
		NuneDamaDAO dao = new NuneDamaDAO();
		dto = dao.Select(dto);
		System.out.print("ID: " + dto.getId() + "\t");
		System.out.print("경험치: " + dto.getExp() + "\t");
		System.out.print("체력: " + dto.getHp() + "\t");
		System.out.println("레벨: " + dto.getLv() + "\t");
	
	}
}
