package com.github.ZXSkelobrine.barcode;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.alee.laf.WebLookAndFeel;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField productCode;
	private JTextField date;
	private JTextField buy;
	private JTextField sell;
	private JTextField profit;
	private String selected = "productCode";
	private JTextField amount;
	private static Window frame;
	public static String icon = "/images/project_flame.png";
	private JComboBox<String> cbxName;
	private List<String> names = new ArrayList<String>();
	private List<String> codes = new ArrayList<String>();

	/**
	 * Launch the application.
	 * 
	 * @throws Exception
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, Exception {
		Main.main(args);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("Commiting");
					Main.connection.commit();
					Main.statement.close();
					Main.connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void setVisible() {
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public Window() throws IOException {
		try {
			ResultSet rs = Main.runQuery(Main.statement, "SELECT * FROM PRODNAMES");
			while (rs.next()) {
				names.add(rs.getString("NAME"));
				codes.add(rs.getString("CODE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		WebLookAndFeel.install();
		setTitle("Project Flame - Stock Keeper - Add Stock");
		try {
			BufferedImage bi = ImageIO.read(Window.class.getResource(Window.icon));
			setIconImage(bi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblVersion = new JLabel("Version: " + Main.CURRENT_VERSION);
		lblVersion.setBounds(0, 296, 81, 14);
		contentPane.add(lblVersion);

		JButton b1 = new JButton("1");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					productCode.setText(productCode.getText() + "1");
					break;
				case "date":
					date.setText(date.getText() + "1");
					break;
				case "buy":
					buy.setText(buy.getText() + "1");
					break;
				case "sell":
					sell.setText(sell.getText() + "1");
					break;
				case "amount":
					amount.setText(amount.getText() + "1");
					profit.setText(String.valueOf(((Float.parseFloat(sell.getText()) - Float.parseFloat(buy.getText())) * Integer.parseInt(amount.getText()))));
					break;
				}
			}
		});
		b1.setBounds(512, 11, 60, 60);
		contentPane.add(b1);

		JButton b2 = new JButton("2");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					productCode.setText(productCode.getText() + "2");
					break;
				case "date":
					date.setText(date.getText() + "2");
					break;
				case "buy":
					buy.setText(buy.getText() + "2");
					break;
				case "sell":
					sell.setText(sell.getText() + "2");
					break;
				case "amount":
					amount.setText(amount.getText() + "2");
					profit.setText(String.valueOf(((Float.parseFloat(sell.getText()) - Float.parseFloat(buy.getText())) * Integer.parseInt(amount.getText()))));
					break;
				}
			}
		});
		b2.setBounds(573, 11, 60, 60);
		contentPane.add(b2);

		JButton b3 = new JButton("3");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					productCode.setText(productCode.getText() + "3");
					break;
				case "date":
					date.setText(date.getText() + "3");
					break;
				case "buy":
					buy.setText(buy.getText() + "3");
					break;
				case "sell":
					sell.setText(sell.getText() + "3");
					break;
				case "amount":
					amount.setText(amount.getText() + "3");
					profit.setText(String.valueOf(((Float.parseFloat(sell.getText()) - Float.parseFloat(buy.getText())) * Integer.parseInt(amount.getText()))));
					break;
				}
			}
		});
		b3.setBounds(634, 11, 60, 60);
		contentPane.add(b3);

		JButton b4 = new JButton("4");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					productCode.setText(productCode.getText() + "4");
					break;
				case "date":
					date.setText(date.getText() + "4");
					break;
				case "buy":
					buy.setText(buy.getText() + "4");
					break;
				case "sell":
					sell.setText(sell.getText() + "4");
					break;
				case "amount":
					amount.setText(amount.getText() + "4");
					profit.setText(String.valueOf(((Float.parseFloat(sell.getText()) - Float.parseFloat(buy.getText())) * Integer.parseInt(amount.getText()))));
					break;
				}
			}
		});
		b4.setBounds(512, 72, 60, 60);
		contentPane.add(b4);

		JButton b5 = new JButton("5");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					productCode.setText(productCode.getText() + "5");
					break;
				case "date":
					date.setText(date.getText() + "5");
					break;
				case "buy":
					buy.setText(buy.getText() + "5");
					break;
				case "sell":
					sell.setText(sell.getText() + "5");
					break;
				case "amount":
					amount.setText(amount.getText() + "5");
					profit.setText(String.valueOf(((Float.parseFloat(sell.getText()) - Float.parseFloat(buy.getText())) * Integer.parseInt(amount.getText()))));
					break;
				}
			}
		});
		b5.setBounds(573, 72, 60, 60);
		contentPane.add(b5);

		JButton b6 = new JButton("6");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					productCode.setText(productCode.getText() + "6");
					break;
				case "date":
					date.setText(date.getText() + "6");
					break;
				case "buy":
					buy.setText(buy.getText() + "6");
					break;
				case "sell":
					sell.setText(sell.getText() + "6");
					break;
				case "amount":
					amount.setText(amount.getText() + "6");
					profit.setText(String.valueOf(((Float.parseFloat(sell.getText()) - Float.parseFloat(buy.getText())) * Integer.parseInt(amount.getText()))));
					break;
				}
			}
		});
		b6.setBounds(634, 72, 60, 60);
		contentPane.add(b6);

		JButton b7 = new JButton("7");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					productCode.setText(productCode.getText() + "7");
					break;
				case "date":
					date.setText(date.getText() + "7");
					break;
				case "buy":
					buy.setText(buy.getText() + "7");
					break;
				case "sell":
					sell.setText(sell.getText() + "7");
					break;
				case "amount":
					amount.setText(amount.getText() + "7");
					profit.setText(String.valueOf(((Float.parseFloat(sell.getText()) - Float.parseFloat(buy.getText())) * Integer.parseInt(amount.getText()))));
					break;
				}
			}
		});
		b7.setBounds(512, 133, 60, 60);
		contentPane.add(b7);

		JButton b8 = new JButton("8");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					productCode.setText(productCode.getText() + "8");
					break;
				case "date":
					date.setText(date.getText() + "8");
					break;
				case "buy":
					buy.setText(buy.getText() + "8");
					break;
				case "sell":
					sell.setText(sell.getText() + "8");
					break;
				case "amount":
					amount.setText(amount.getText() + "8");
					profit.setText(String.valueOf(((Float.parseFloat(sell.getText()) - Float.parseFloat(buy.getText())) * Integer.parseInt(amount.getText()))));
					break;
				}
			}
		});
		b8.setBounds(573, 133, 60, 60);
		contentPane.add(b8);

		JButton b9 = new JButton("9");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					productCode.setText(productCode.getText() + "9");
					break;
				case "date":
					date.setText(date.getText() + "9");
					break;
				case "buy":
					buy.setText(buy.getText() + "9");
					break;
				case "sell":
					sell.setText(sell.getText() + "9");
					break;
				case "amount":
					amount.setText(amount.getText() + "9");
					profit.setText(String.valueOf(((Float.parseFloat(sell.getText()) - Float.parseFloat(buy.getText())) * Integer.parseInt(amount.getText()))));
					break;
				}
			}
		});
		b9.setBounds(634, 133, 60, 60);
		contentPane.add(b9);

		JButton b0 = new JButton("0");
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					productCode.setText(productCode.getText() + "0");
					// name.setText(Main.getProductName(productCode.getText()));
					break;
				case "date":
					date.setText(date.getText() + "0");
					break;
				case "buy":
					buy.setText(buy.getText() + "0");
					break;
				case "sell":
					sell.setText(sell.getText() + "0");
					break;
				case "amount":
					amount.setText(amount.getText() + "0");
					profit.setText(String.valueOf(((Float.parseFloat(sell.getText()) - Float.parseFloat(buy.getText())) * Integer.parseInt(amount.getText()))));
					break;
				}
			}
		});
		b0.setBounds(573, 194, 60, 60);
		contentPane.add(b0);

		productCode = new JTextField();
		productCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selected = "productCode";
			}
		});
		productCode.setBounds(81, 25, 285, 30);
		contentPane.add(productCode);
		productCode.setColumns(10);

		date = new JTextField();
		date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		date.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selected = "date";
			}
		});
		date.setBounds(81, 97, 285, 30);
		contentPane.add(date);
		date.setColumns(10);

		buy = new JTextField();
		buy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selected = "buy";
			}
		});
		buy.setBounds(81, 132, 285, 30);
		contentPane.add(buy);
		buy.setColumns(10);

		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(10, 34, 71, 14);
		contentPane.add(lblBarcode);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 72, 71, 14);
		contentPane.add(lblName);

		JLabel lblExpir = new JLabel("Expiry Date");
		lblExpir.setBounds(10, 107, 71, 14);
		contentPane.add(lblExpir);

		JLabel lblBuyCost = new JLabel("Buy Cost");
		lblBuyCost.setBounds(10, 142, 71, 14);
		contentPane.add(lblBuyCost);

		sell = new JTextField();
		sell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selected = "sell";
			}
		});
		sell.setBounds(81, 167, 285, 30);
		contentPane.add(sell);
		sell.setColumns(10);

		JLabel lblSellCost = new JLabel("Sell Cost");
		lblSellCost.setBounds(10, 179, 71, 14);
		contentPane.add(lblSellCost);

		profit = new JTextField();
		profit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selected = "profit";
			}
		});
		profit.setEditable(false);
		profit.setEnabled(false);
		profit.setBounds(81, 239, 285, 30);
		contentPane.add(profit);
		profit.setColumns(10);

		JLabel lblProfit = new JLabel("Profit");
		lblProfit.setBounds(10, 249, 71, 14);
		contentPane.add(lblProfit);

		JButton bDot = new JButton(".");
		bDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					break;
				case "date":
					date.setText(date.getText() + ".");
					break;
				case "buy":
					buy.setText(buy.getText() + ".");
					break;
				case "sell":
					sell.setText(sell.getText() + ".");
					break;
				}
			}
		});
		bDot.setBounds(634, 194, 60, 60);
		contentPane.add(bDot);

		JButton bSlash = new JButton("/");
		bSlash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					break;
				case "date":
					date.setText(date.getText() + "/");
					break;
				case "buy":
					break;
				case "sell":
					break;
				}
			}
		});
		bSlash.setBounds(512, 194, 60, 60);
		contentPane.add(bSlash);

		JButton bBack = new JButton("<");
		bBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selected) {
				case "productCode":
					productCode.setText(productCode.getText().substring(0, productCode.getText().length() - 1));
					break;
				case "date":
					date.setText(date.getText().substring(0, date.getText().length() - 1));
					break;
				case "buy":
					buy.setText(buy.getText().substring(0, buy.getText().length() - 1));
					break;
				case "sell":
					sell.setText(sell.getText().substring(0, sell.getText().length() - 1));
					break;
				case "amount":
					amount.setText(amount.getText().substring(0, amount.getText().length() - 1));
					break;
				}
			}
		});
		bBack.setBounds(698, 11, 106, 60);
		contentPane.add(bBack);

		amount = new JTextField();
		amount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		amount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selected = "amount";
			}
		});
		amount.setBounds(81, 202, 285, 30);
		contentPane.add(amount);
		amount.setColumns(10);

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(10, 217, 71, 14);
		contentPane.add(lblAmount);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.insertData(Main.statement, productCode.getText(), (String) cbxName.getSelectedItem(), date.getText(), Float.parseFloat(buy.getText()), Float.parseFloat(sell.getText()), Integer.parseInt(amount.getText()));
				} catch (NumberFormatException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(698, 72, 106, 60);
		contentPane.add(btnAdd);

		JButton btnOverride = new JButton("Override");
		btnOverride.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new NameOverride();
			}
		});
		btnOverride.setBounds(376, 48, 81, 23);
		contentPane.add(btnOverride);

		JButton btnRemoveStock = new JButton("Remove Stock");
		btnRemoveStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Remove.run();
			}
		});
		btnRemoveStock.setBounds(698, 270, 116, 40);
		contentPane.add(btnRemoveStock);

		JButton btnReviewStock = new JButton("Review Stock");
		btnReviewStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ProductReview.run();
			}
		});
		btnReviewStock.setBounds(578, 270, 116, 40);
		contentPane.add(btnReviewStock);

		String[] name = new String[names.size()];
		names.toArray(name);
		cbxName = new JComboBox<String>();
		cbxName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbxName.setModel(new DefaultComboBoxModel<String>(name));
		cbxName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() instanceof JComboBox) {
					String code = codes.get(((JComboBox<?>) arg0.getSource()).getSelectedIndex());
					productCode.setText(code);
				}
			}
		});
		cbxName.setBounds(81, 61, 285, 30);
		contentPane.add(cbxName);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				names.clear();
				codes.clear();
				try {
					ResultSet rs = Main.runQuery(Main.statement, "SELECT * FROM PRODNAMES");
					while (rs.next()) {
						names.add(rs.getString("NAME"));
						codes.add(rs.getString("CODE"));
					}
					String[] name = new String[names.size()];
					names.toArray(name);
					cbxName.setModel(new DefaultComboBoxModel<String>(name));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(376, 72, 81, 23);
		contentPane.add(btnUpdate);

	}
}
