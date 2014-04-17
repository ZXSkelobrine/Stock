package com.github.ZXSkelobrine.barcode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class ProductReview extends JFrame {

	private static final long serialVersionUID = -1618389240678484323L;
	private JPanel contentPane;
	static JList<String> list;
	static List<Product> products = new ArrayList<Product>();

	/**
	 * Create the frame.
	 */
	public ProductReview() {
		setTitle("Project Flame - Stock Keeper - Review Stock");
		try {
			BufferedImage bi = ImageIO.read(Window.class.getResource(Window.icon));
			setIconImage(bi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(0, 0, 304, 416);
		contentPane.add(list);

		JButton btnDetails = new JButton("Details");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedValue() != null) {
					for (Product product : products) {
						if (product.getName().equals(list.getSelectedValue())) new Details(product);
					}
				}
			}
		});
		btnDetails.setBounds(314, 11, 89, 23);
		contentPane.add(btnDetails);

		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Window.setVisible();
			}
		});
		btnReturn.setBounds(314, 84, 89, 23);
		contentPane.add(btnReturn);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedValue() != null) {
					for (Product product : products) {
						if (product.getName().equals(list.getSelectedValue())) new RemovePrompt(product);

					}
				}
			}
		});
		btnRemove.setBounds(314, 45, 89, 23);
		contentPane.add(btnRemove);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Runthrough.runThrough(products);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				Printing.doublePrint(products, Runthrough.getNeeded());
			}
		});
		btnPrint.setBounds(314, 116, 89, 23);
		contentPane.add(btnPrint);
	}

	public static void run() {
		ProductReview frame = new ProductReview();
		populateList();
		frame.setVisible(true);
	}

	public static void populateList() {
		products.clear();
		ResultSet set;
		try {
			set = Main.runQuery(Main.statement, "SELECT * FROM PRODUCTS");
			while (set.next()) {
				int id = set.getInt("ID");
				String barcode = set.getString("CODE");
				String name = set.getString("NAME");
				String expiry = set.getString("EXPIRY");
				int amount = set.getInt("AMOUNT");
				float buy_cost = set.getFloat("BUY_COST");
				float sell_cost = set.getFloat("SELL_COST");
				float profit = set.getFloat("PROFIT_COST");
				products.add(new Product(id, barcode, name, expiry, amount, buy_cost, sell_cost, profit));
			}
			String[] names = new String[products.size()];
			for (Product product : products) {
				names[products.indexOf(product)] = product.getName();
			}
			list.setListData(names);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
