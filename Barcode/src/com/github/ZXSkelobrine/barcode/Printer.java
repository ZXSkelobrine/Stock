package com.github.ZXSkelobrine.barcode;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Printer implements Printable {
	private static Product[] productsArray;
	private static List<Product> productsList;
	private static String title;

	public static void setProducts(Product[] products) {
		Printer.productsArray = products;
	}

	public static void setProducts(List<Product> products) {
		Printer.productsList = products;
	}

	public static void setTitle(String title) {
		Printer.title = title;
	}

	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
		if (page > 0) {
			return NO_SUCH_PAGE;
		}
		currentRecord = 65;
		name = 60;
		barcode = 160;
		expiry = 240;
		buy = 330;
		sell = 380;
		profit = 430;
		amount = 480;
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());
		Rectangle b = g.getClipBounds();
		{
			g.setFont(new Font(Font.DIALOG, Font.TRUETYPE_FONT, 6));
			titleDate(g);
			drawRectangle(b, g);
			drawTable(b, g);
			if (productsArray != null) {
				drawRecords(productsArray, g);
			} else {
				drawRecords(productsList, g2d);
			}
		}
		return PAGE_EXISTS;
	}

	int name = 60;
	int barcode = 160;
	int expiry = 240;
	int buy = 330;
	int sell = 380;
	int profit = 430;
	int amount = 480;

	private void drawTable(Rectangle b, Graphics g) {
		int bottom = b.height - 50;
		g.drawLine(barcode - 10, 50, barcode - 10, bottom);
		g.drawLine(expiry - 10, 50, expiry - 10, bottom);
		g.drawLine(buy - 10, 50, buy - 10, bottom);
		g.drawLine(sell - 10, 50, sell - 10, bottom);
		g.drawLine(profit - 10, 50, profit - 10, bottom);
		g.drawLine(amount - 10, 50, amount - 10, bottom);
	}

	private void drawRectangle(Rectangle b, Graphics g) {
		g.drawLine(50, 50, b.width - 50, 50);
		g.drawLine(50, 50, 50, b.height - 50);
		g.drawLine(b.width - 50, 50, b.width - 50, b.height - 50);
		g.drawLine(50, b.height - 50, b.width - 50, b.height - 50);
	}

	private void titleDate(Graphics g) {
		g.drawString(new SimpleDateFormat().format(Calendar.getInstance().getTime()) + " - " + title, 50, 40);
	}

	static int currentRecord = 65;

	private void drawRecord(Product product, Graphics g) {
		g.drawString(product.getName(), name, currentRecord);
		g.drawString(product.getBarcode(), barcode, currentRecord);
		g.drawString(product.getExpiry(), expiry, currentRecord);
		g.drawString(product.getBuyCost() + "", buy, currentRecord);
		g.drawString(product.getSell() + "", sell, currentRecord);
		g.drawString(new DecimalFormat("#.##").format(product.getProfit()), profit, currentRecord);
		g.drawString(product.getAmount() + "", amount, currentRecord);
		currentRecord += 20;
	}

	private void drawRecords(Product[] products, Graphics g) {
		for (Product p : products) {
			if (p.getName() != null && !p.getName().equals("")) {
				drawRecord(p, g);
			}
		}
	}

	private void drawRecords(List<Product> products, Graphics g) {
		for (Product p : products) {
			if (p.getName() != null && !p.getName().equals("")) {
				drawRecord(p, g);
			}
		}
	}

	public static void reset() {
		currentRecord = 65;
		productsArray = null;
		productsList = null;
	}
}
