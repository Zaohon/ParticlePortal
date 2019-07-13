package cn.blockmc.Zao_hon.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import org.bukkit.Location;

import cn.blockmc.Zao_hon.ParticlePortal;
import cn.blockmc.Zao_hon.listener.Portal;

public class Sqlite {
	private final String path;
	private ParticlePortal plugin;

	public Sqlite(ParticlePortal plugin) {
		this.plugin = plugin;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			plugin.PR("加载JDBC数据库失败");
			plugin.onDisable();
		}
		path = "jdbc:sqlite:" + plugin.getDataFolder() + "/" + "portals.db";
		this.setupTable();
	}

	public Connection setupConnection() {
		try {
			return DriverManager.getConnection(path);
		} catch (SQLException e) {
			plugin.PR("连接数据库失败");
			plugin.onDisable();
			return null;
		}
	}

	public void setupTable() {
		Connection connection = setupConnection();
		try {
			Statement stat = connection.createStatement();
			stat.execute(
					"CREATE TABLE IF NOT EXISTS portals(NAME TEXT , WORLD1 TEXT ,X1 DOUBLE  , Y1 DOUBLE , Z1 DOUBLE , PITCH1 FLOAT , YAW1 FLOAT ,WORLD2 TEXT, X2 DOUBLE ,Y2 DOUBLE , Z2 DOUBLE, PITCH2 FLOAT ,YAW2 FLOAT)");
			stat.close();
			connection.close();
		} catch (SQLException e) {
			plugin.PR("创建初始表失败");
			e.printStackTrace();
		}

	}

	public PreparedStatement setupPreparedStatement(Connection conn, PreparedStatementType type) {
		try {
			return conn.prepareStatement(type.getStatement());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insertPortal(Portal portal) {
		Connection conn = setupConnection();
		String portalname = portal.getName();
		Location[] locs = portal.getLocations();
		Location loc1 = locs[0];
		Location loc2 = locs[1];
		PreparedStatement ps = setupPreparedStatement(conn, PreparedStatementType.INSECT_PORTAL);
		try {
			ps.setString(1, portalname);
			ps.setString(2, loc1.getWorld().getName());
			ps.setDouble(3, loc1.getX());
			ps.setDouble(4, loc1.getY());
			ps.setDouble(5, loc1.getZ());
			ps.setFloat(6, loc1.getYaw());
			ps.setFloat(7, loc1.getPitch());
			ps.setString(8, loc2.getWorld().getName());
			ps.setDouble(9, loc2.getX());
			ps.setDouble(10, loc2.getY());
			ps.setDouble(11, loc2.getZ());
			ps.setFloat(12, loc2.getYaw());
			ps.setFloat(13, loc2.getPitch());
			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void removePortal(String name){
		Connection conn = setupConnection();
		PreparedStatement ps = setupPreparedStatement(conn, PreparedStatementType.DELETE_PORTAL);
		try {
			ps.setString(1, name);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public HashMap<String,Portal> selectPortals() {
		HashMap<String,Portal> portals = new HashMap<String,Portal>();
		Connection conn = setupConnection();
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM portals");
			while (rs.next()) {
				String name = rs.getString(1);
				Location loc1 = new Location(plugin.getServer().getWorld(rs.getString(2)), rs.getDouble(3),
						rs.getDouble(4), rs.getDouble(5), rs.getFloat(6), rs.getFloat(7));
				Location loc2 = new Location(plugin.getServer().getWorld(rs.getString(8)), rs.getDouble(9),
						rs.getDouble(10), rs.getDouble(11), rs.getFloat(12), rs.getFloat(13));
				Portal portal = new Portal(plugin.getPortalManager(),name, new Location[] { loc1, loc2 });
				portals.put(name,portal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return portals;
	}

}
