package com.github.ZXSkelobrine.barcode;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.mail.MessagingException;

public class Main {
	public static Connection connection;
	public static Statement statement;
	public static final double CURRENT_VERSION = 1.4;

	public static void main(String[] args) throws MalformedURLException, IOException {
		Update.updateCheck(CURRENT_VERSION);
		try {
			{
				boolean create = new File("C:/StockKeeper/products.db").exists();
				setupConnections("C:/StockKeeper/products.db");
				connection.setAutoCommit(false);
				if (!create) runCommand(statement, "CREATE TABLE PRODUCTS (ID INT PRIMARY KEY NOT NULL, CODE TEXT NOT NULL, NAME TEXT NOT NULL, EXPIRY TEXT NOT NULL, BUY_COST REAL NOT NULL, SELL_COST REAL NOT NULL, PROFIT_COST REAL NOT NULL, AMOUNT INT NOT NULL)");
				if (!create) runCommand(statement, "CREATE TABLE PRODNAMES (ID INT PRIMARY KEY NOT NULL, CODE TEXT NOT NULL, NAME TEXT NOT NULL)");
				runChecks();
			}
			// "CREATE TABLE PRODUCTS (ID INT PRIMARY KEY NOT NULL, CODE TEXT NOT NULL, NAME TEXT NOT NULL, EXPIRY TEXT NOT NULL, BUY_COST REAL NOT NULL, SELL_COST REAL NOT NULL, PROFIT_COST REAL NOT NULL, AMOUNT INT NOT NULL)";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void runCommand(Statement statement, String command) throws SQLException {
		statement.executeUpdate(command);
	}

	public static Connection connectToDatabase(String databaseName) throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
	}

	public static Connection connectToDatabaseFP(String path) throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:" + path);
	}

	public static void createTable(Statement statement, String... strings) throws SQLException {
		StringBuilder sb = new StringBuilder();
		for (String s : strings) {
			sb.append(s + " ");
		}
		statement.executeUpdate(sb.toString());
	}

	public static void insertData(Statement statement, String productCode, String name, String date, float buyCost, float sellCost, int amount) throws SQLException {
		float profit = sellCost - buyCost;
		ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM PRODUCTS");
		int id = rs.getInt(1) + 1;
		String sql = "INSERT INTO PRODUCTS (ID,CODE,NAME,EXPIRY,BUY_COST,SELL_COST,PROFIT_COST,AMOUNT) VALUES (" + id + ",\"" + productCode + "\",\"" + name + "\",\"" + date + "\"," + buyCost + "," + sellCost + "," + profit + "," + amount + ");";// ID,CODE,NAME,EXPIRY,REAL_COST,SELL_COST,PROFIT_COST
		statement.executeUpdate(sql);
	}

	public static void removeData(Statement statement, String productCode, String name, int amount) throws SQLException {
		int left = statement.executeQuery("SELECT AMOUNT FROM PRODUCTS WHERE CODE=\"" + productCode + "\"").getInt(1) - amount;

		boolean createNewRecord = left > 0;
		int id = statement.executeQuery("SELECT ID FROM PRODUCTS WHERE CODE=\"" + productCode + "\"").getInt(1);
		float buyCost = statement.executeQuery("SELECT BUY_COST FROM PRODUCTS WHERE CODE=\"" + productCode + "\"").getFloat(1);
		float sellCost = statement.executeQuery("SELECT SELL_COST FROM PRODUCTS WHERE CODE=\"" + productCode + "\"").getFloat(1);
		float profit = statement.executeQuery("SELECT PROFIT_COST FROM PRODUCTS WHERE CODE=\"" + productCode + "\"").getFloat(1);
		String date = statement.executeQuery("SELECT EXPIRY FROM PRODUCTS WHERE CODE=\"" + productCode + "\"").getString(1);

		String sqlII = "DELETE from PRODUCTS where CODE=\"" + productCode + "\"";
		statement.executeUpdate(sqlII);
		if (createNewRecord) {
			String sql = "INSERT INTO PRODUCTS (ID,CODE,NAME,EXPIRY,BUY_COST,SELL_COST,PROFIT_COST,AMOUNT) VALUES (" + id + ",\"" + productCode + "\",\"" + name + "\",\"" + date + "\"," + buyCost + "," + sellCost + "," + profit + "," + left + ");";// ID,CODE,NAME,EXPIRY,REAL_COST,SELL_COST,PROFIT_COST
			statement.executeUpdate(sql);
		}
	}

	public static void setupConnections(String path) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		connection = connectToDatabaseFP(path);
		System.out.println("Opened");
		statement = connection.createStatement();
	}

	public static void closeAll() throws SQLException {
		statement.close();
		connection.close();
	}

	public static String getProductName(String barcode) {
		switch (barcode) {
		case "991765":
			return "Nic";
		case "5034660522629":
			return "Boost 4 Pack";
		case "7613033495113":
			return "Rolo 4 Pack";
		case "5000159470704":
			return "Snickers 4 Pack";
		case "05000314900992":
			return "Poppets Mint 36 Pack";
		case "05000314900909":
			return "Poppets Toffee 36 Pack";
		case "7613033507724":
			return "KitKat 4 Pack";
		case "7613033496462":
			return "KitKat Chunky 4 Pack";
		case "5023274065600":
			return "Refresher Single";
		case "5034660508557":
			return "Turkish Delight 4 Pack";
		case "5034660520085":
			return "Wispa 4 Pack";
		case "07622210105585":
			return "Double Decker 8 4 Pack Box";
		case "7622210105578":
			return "Double Decker 4 Pack";
		case "05034660035664":
			return "Picnic 10 4 Pack Box";
		case "5000159470315":
			return "Galaxy 4 Pack";
		case "7613033563683":
			return "KitKat 2x4 Pack";
		case "5000159394499":
			return "Ripple 4 Pack";
		case "5010975075168":
			return "Caramel Wafer Biscuit 6 Pack";
		case "5010975075083":
			return "Caramel Log 6 Pack";
		case "8013399110689":
			return "Chewits 6 Pack";
		case "5000136059298":
			return "Daim 4 Pack";
		case "5000168122359":
			return "Gold 9 Pack";
		case "07613033538469":
			return "Smarties 12 4 Pack Box";
		case "7613033538452":
			return "Smarties 4 Pack";
		case "5010975040012":
			return "Snowball 6 Pack";
		case "5010975030020":
			return "Tea Cake 6 Pack";
		case "05000201010247":
			return "Creme Egg 48 Pack";
		case "50201600":
			return "Creme Egg Single";
		case "5000237107041":
			return "Mini Cheddars 7 Pack Assorted";
		case "5010029216752":
			return "Weetabix On The Go Fruit And Fibre 5 Pack";
		case "5010029216769":
			return "Weetabix On The Go Apple 5 Pack";
		case "5000108467434":
			return "Oat So Simple Oats And Fruit 6 Pack";
		case "5010026513281":
			return "Oats 2 Go";
		case "5000159454452":
			return "Bounty 4 by 2 Pack";
		case "5000159300766":
			return "Topic 4 Pack";
		default:
			return "UNKNOWN";
		}
	}

	public static ResultSet runQuery(Statement statement, String query) throws SQLException {
		return statement.executeQuery(query);
	}

	public static void addName(Statement statement, String name, String barcode) throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM PRODUCTS");
		int id = rs.getInt(1) + 1;
		statement.executeUpdate("INSERT INTO PRODNAMES (ID,CODE,NAME) VALUES (" + id + ",\"" + barcode + "\",\"" + name + "\");");
	}

	public static void runChecks() throws SQLException {
		Thread t = new Thread() {
			@Override
			public void run() {
				ResultSet resultSet;
				try {
					resultSet = statement.executeQuery("SELECT * FROM PRODUCTS");
					while (resultSet.next()) {
						String date = resultSet.getString("EXPIRY");
						int prod_day = Integer.parseInt(date.split("/")[0]);
						int prod_month = Integer.parseInt(date.split("/")[1]);
						int prod_year = Integer.parseInt(date.split("/")[2]);
						String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
						int curr_day = Integer.parseInt(currentDate.split("/")[0]);
						int curr_month = Integer.parseInt(currentDate.split("/")[1]);
						int curr_year = Integer.parseInt(currentDate.split("/")[2]);
						if (prod_year == curr_year) {
							if (curr_month == prod_month) {
								if (curr_day == prod_day) {
									Mail.sendMail("The product: " + resultSet.getString("NAME") + " is going out of date today. You currently own: " + resultSet.getInt("AMOUNT") + " of this product.", "Product Expiry");
								}
								if (curr_day + 1 == prod_day) {
									Mail.sendMail("The product: " + resultSet.getString("NAME") + " is going out of date tomorrow. You currently own: " + resultSet.getInt("AMOUNT") + " of this product.", "Product Expiry");
								}
							}
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();

	}
}
