package com.github.ZXSkelobrine.barcode;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Main {
	static Connection connection;
	static Statement statement;
	static String path = "C:/Users/Ryan.D/Desktop/Barcodes/barcode_image.JPG";

	public static void main(String[] args) {
		try {
			setupConnections();
			System.out.println("Connections are setup");
			connectToDatabase("test");
			System.out.println("Connected to database");
			// "CREATE TABLE PRODUCTS (ID INT PRIMARY KEY NOT NULL, CODE TEXT NOT NULL, NAME TEXT NOT NULL, EXPIRY TEXT NOT NULL, BUY_COST REAL NOT NULL, SELL_COST REAL NOT NULL, PROFIT_COST REAL NOT NULL, AMOUNT INT NOT NULL)";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void runCommand(Statement statement, String command) throws SQLException {
		statement.executeUpdate(command);
	}

	public static Connection connectToDatabase(String databaseName) throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
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

	public static void setupConnections() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:test.db");
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

	public static int getTimesAmount(String name) {
		switch (name) {
		case "Boost 4 Pack":
			return 4;
		case "Rolo 4 Pack":
			return 4;
		case "Snickers 4 Pack":
			return 4;
		case "Poppets Mint 36 Pack":
			return 36;
		case "Poppets Toffee 36 Pack":
			return 36;
		case "KitKat 4 Pack":
			return 4;
		case "KitKat Chunky 4 Pack":
			return 4;
		case "Refresher Single":
			return 1;
		case "Turkish Delight 4 Pack":
			return 4;
		case "Wispa 4 Pack":
			return 4;
		case "Double Decker 8 4 Pack Box":
			return 8 * 4;
		case "Double Decker 4 Pack":
			return 4;
		case "Picnic 10 4 Pack Box":
			return 4 * 10;
		case "Galaxy 4 Pack":
			return 4;
		case "KitKat 2x4 Pack":
			return 2 * 4;
		case "Ripple 4 Pack":
			return 4;
		case "Caramel Wafer Biscuit 6 Pack":
			return 6;
		case "Caramel Log 6 Pack":
			return 6;
		case "Chewits 6 Pack":
			return 6;
		case "Daim 4 Pack":
			return 4;
		case "Gold 9 Pack":
			return 9;
		case "Smarties 12 4 Pack Box":
			return 12 * 4;
		case "Smarties 4 Pack":
			return 4;
		case "Snowball 6 Pack":
			return 6;
		case "Tea Cake 6 Pack":
			return 6;
		case "Creme Egg 48 Pack":
			return 48;
		case "Creme Egg Single":
			return 1;
		case "Mini Cheddars 7 Pack Assorted":
			return 7;
		case "Weetabix On The Go Fruit And Fibre 5 Pack":
			return 5;
		case "Weetabix On The Go Apple 5 Pack":
			return 5;
		case "Oat So Simple Oats And Fruit 6 Pack":
			return 6;
		case "Oats 2 Go":
			return 1;
		case "Bounty 4 by 2 Pack":
			return 4;
		case "Topic 4 Pack":
			return 4;
		default:
			return 1;
		}
	}

	public static BufferedImage cutRectangle(BufferedImage image, Rectangle rec) {
		return image.getSubimage(rec.x, rec.y, rec.width, rec.height);
	}

	public static void test(BufferedImage filePath) throws Exception {

		Map<DecodeHintType, Object> tmpHintsMap = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);
		tmpHintsMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
		tmpHintsMap.put(DecodeHintType.POSSIBLE_FORMATS, EnumSet.allOf(BarcodeFormat.class));
		tmpHintsMap.put(DecodeHintType.PURE_BARCODE, Boolean.FALSE);

		String tmpRetString = BarCodeUtil.decode(filePath, tmpHintsMap);
		// String tmpRetString = BarCodeUtil.decode(tmpFile, null);
		System.out.println(tmpRetString);
	}
}

class BarCodeUtil {
	private static BarcodeFormat DEFAULT_BARCODE_FORMAT = BarcodeFormat.CODE_128;

	/**
	 * Decode method used to read image or barcode itself, and recognize the
	 * barcode,
	 * get the encoded contents and returns it.
	 * 
	 * @param whatFile
	 *            image that need to be read.
	 * @param config
	 *            configuration used when reading the barcode.
	 * @return decoded results from barcode.
	 */
	public static String decode(BufferedImage tmpBfrImage, Map<DecodeHintType, Object> whatHints) throws Exception {
		if (tmpBfrImage == null) throw new IllegalArgumentException("Could not decode image.");
		LuminanceSource tmpSource = new BufferedImageLuminanceSource(tmpBfrImage);
		BinaryBitmap tmpBitmap = new BinaryBitmap(new HybridBinarizer(tmpSource));
		MultiFormatReader tmpBarcodeReader = new MultiFormatReader();
		Result tmpResult;
		String tmpFinalResult;
		try {
			if (whatHints != null && !whatHints.isEmpty()) tmpResult = tmpBarcodeReader.decode(tmpBitmap, whatHints);
			else tmpResult = tmpBarcodeReader.decode(tmpBitmap);
			// setting results.
			tmpFinalResult = String.valueOf(tmpResult.getText());
		} catch (Exception tmpExcpt) {
			throw new Exception("BarCodeUtil.decode Excpt err - " + tmpExcpt.toString() + " - " + tmpExcpt.getMessage());
		}
		return tmpFinalResult;
	}
}
