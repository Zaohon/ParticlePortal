package cn.blockmc.Zao_hon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sqlite {
	private final String path;
	private ParticlePortal plugin;

	public Sqlite() {
		this.plugin = ParticlePortal.getInstance();
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			plugin.PR("加载JDBC数据库失败");
			plugin.onDisable();
		}
		path ="jdbc:sqlite:" + plugin.getDataFolder()+"/"+"portals.db";
		this.setupTable();
	}
	public Connection setupConnection(){
		try {
			return DriverManager.getConnection(path);
		} catch (SQLException e) {
			plugin.PR("连接数据库失败");
			plugin.onDisable();
			return null;
		}
	}
	public void setupTable(){
		Connection connection = setupConnection();
		try {
			Statement stat = connection.createStatement();
			stat.execute("CREATE TABLE IF NOT EXISTS portals(NAME TEXT , X1 DOUBLE  , Y1 DOUBLE , Z1 DOUBLE , PITCH1 FLOAT , YAW1 FLOAT , X2 DOUBLE ,Y2 DOUBLE , Z2 DOUBLE, PITCH2 FLOAT YAW2 FLOAT)");
			stat.close();
			connection.close();
		} catch (SQLException e) {
			plugin.PR("创建初始表失败");
			e.printStackTrace();
		}
		
	}
}
