package cn.blockmc.Zao_hon.storage;

public enum PreparedStatementType {
	INSECT_PORTAL("INSERT INTO portals VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)"),
	DELETE_PORTAL("DELETE FROM portals WHERE name = ?");
	private String statement;
	PreparedStatementType(String statement) {
		this.statement = statement;
	}
	public String getStatement(){
		return statement;
	}
}
