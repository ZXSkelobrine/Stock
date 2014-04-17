package com.github.ZXSkelobrine.barcode;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Runthrough {
	private static List<LoggedProduct> logggedProducts = new ArrayList<LoggedProduct>();
	private static List<Product> normalProducts = new ArrayList<Product>();
	private static List<Product> needed = new ArrayList<Product>();

	public static void runThrough(List<Product> stocked) throws SQLException {
		needed.clear();
		logggedProducts.clear();
		normalProducts.clear();
		ResultSet rs = Main.runQuery(Main.statement, "SELECT * FROM PRODNAMES");
		while (rs.next()) {
			Product p = new Product(rs.getInt("ID"), rs.getString("CODE"), rs.getString("NAME"), "", 0, 0, 0, 0);
			logggedProducts.add(new LoggedProduct(p, true));
			normalProducts.add(p);
		}
		setNeeded(stocked);
	}

	private static void setNeeded(List<Product> stocked) {
		for (Product product : stocked) {
			for (Product pro : normalProducts) {
				if (pro.getBarcode().equals(product.getBarcode())) {
					int index = normalProducts.indexOf(pro);
					LoggedProduct p = logggedProducts.get(index);
					p.setNeeded(false);
					logggedProducts.set(index, p);
				}
			}
		}
		logNeeded();
	}

	private static void logNeeded() {
		for (LoggedProduct p : logggedProducts) {
			if (p.isNeeded()) {
				needed.add(p.getProduct());
			}
		}
	}

	public static List<Product> getNeeded() {
		return needed;
	}
}
