package cn.blockmc.Zao_hon.storage;

public enum PreparedStatementType {
	INSECT_PORTAL("INSERT INTO portals VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
	private String statement;
	PreparedStatementType(String statement) {
		this.statement = statement;
	}
	public String getStatement(){
		return statement;
	}
}
