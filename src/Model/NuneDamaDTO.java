package Model;

public class NuneDamaDTO {
	
	private String id;
	private int exp;
	private int hp;
	private int lv;
	
	public NuneDamaDTO(String id, int exp, int hp, int lv) {
		this.id = id;
		this.exp = exp;
		this.hp = hp;
		this.lv = lv;
	}

	public NuneDamaDTO(int exp, int hp) {
		this.exp = exp;
		this.hp = hp;
	}

	public NuneDamaDTO(String id) {
		this.id = id;
	}
	

	public String getId() {
		return id;
	}

	public int getExp() {
		return exp;
	}

	public int getHp() {
		return hp;
	}

	public int getLv() {
		return lv;
	}
	
	
	
	
}
