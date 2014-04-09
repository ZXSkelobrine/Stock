package com.github.ZXSkelobrine.barcode;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class Remove extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBarcode;
	private JTextField txtAmount;
	private String selectedItem = "barcode";
	private static Remove frame;
	private JComboBox<String> cbxName;
	private List<String> names = new ArrayList<String>();
	private List<String> codes = new ArrayList<String>();

	public static void run() {
		frame = new Remove();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Remove() {
		try {
			ResultSet rs = Main.runQuery(Main.statement, "SELECT * FROM PRODNAMES");
			while (rs.next()) {
				names.add(rs.getString("NAME"));
				codes.add(rs.getString("CODE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setTitle("Project Flame - Stock Keeper - Remove Stock");
		try {
			BufferedImage bi = ImageIO.read(Window.class.getResource(Window.icon));
			setIconImage(bi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Barcode");
		label.setBounds(10, 23, 71, 14);
		contentPane.add(label);

		txtBarcode = new JTextField();
		txtBarcode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedItem = "barcode";
			}
		});
		txtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBarcode.setColumns(10);
		txtBarcode.setBounds(81, 14, 285, 30);
		contentPane.add(txtBarcode);

		JLabel label_1 = new JLabel("Amount");
		label_1.setBounds(10, 92, 71, 14);
		contentPane.add(label_1);

		txtAmount = new JTextField();
		txtAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedItem = "amount";
			}
		});
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAmount.setColumns(10);
		txtAmount.setBounds(81, 82, 285, 30);
		contentPane.add(txtAmount);

		JButton button = new JButton("/");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText() + "/");
					break;
				}
			}
		});
		button.setBounds(512, 183, 60, 60);
		contentPane.add(button);

		JButton button_1 = new JButton(".");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText() + ".");
					break;
				}
			}
		});
		button_1.setBounds(634, 183, 60, 60);
		contentPane.add(button_1);

		JButton button_2 = new JButton("0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText() + "0");
					break;
				case "amount":
					txtAmount.setText(txtAmount.getText() + "0");
					break;
				}
			}
		});
		button_2.setBounds(573, 183, 60, 60);
		contentPane.add(button_2);

		JButton button_3 = new JButton("7");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText() + "7");
					break;
				case "amount":
					txtAmount.setText(txtAmount.getText() + "7");
					break;
				}
			}
		});
		button_3.setBounds(512, 122, 60, 60);
		contentPane.add(button_3);

		JButton button_4 = new JButton("8");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText() + "8");
					break;
				case "amount":
					txtAmount.setText(txtAmount.getText() + "8");
					break;
				}
			}
		});
		button_4.setBounds(573, 122, 60, 60);
		contentPane.add(button_4);

		JButton button_5 = new JButton("9");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText() + "9");
					break;
				case "amount":
					txtAmount.setText(txtAmount.getText() + "9");
					break;
				}
			}
		});
		button_5.setBounds(634, 122, 60, 60);
		contentPane.add(button_5);

		JButton button_6 = new JButton("4");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText() + "4");
					break;
				case "amount":
					txtAmount.setText(txtAmount.getText() + "4");
					break;
				}
			}
		});
		button_6.setBounds(512, 61, 60, 60);
		contentPane.add(button_6);

		JButton button_7 = new JButton("5");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText() + "5");
					break;
				case "amount":
					txtAmount.setText(txtAmount.getText() + "5");
					break;
				}
			}
		});
		button_7.setBounds(573, 61, 60, 60);
		contentPane.add(button_7);

		JButton button_8 = new JButton("6");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText() + "6");
					break;
				case "amount":
					txtAmount.setText(txtAmount.getText() + "6");
					break;
				}
			}
		});
		button_8.setBounds(634, 61, 60, 60);
		contentPane.add(button_8);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Main.removeData(Main.statement, txtBarcode.getText(), Main.getProductName(txtBarcode.getText()), Integer.parseInt(txtAmount.getText()));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRemove.setBounds(698, 61, 106, 60);
		contentPane.add(btnRemove);

		JButton button_10 = new JButton("1");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText() + "1");
					break;
				case "amount":
					txtAmount.setText(txtAmount.getText() + "1");
					break;
				}
			}
		});
		button_10.setBounds(512, 0, 60, 60);
		contentPane.add(button_10);

		JButton button_11 = new JButton("2");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText() + "2");
					break;
				case "amount":
					txtAmount.setText(txtAmount.getText() + "2");
					break;
				}
			}
		});
		button_11.setBounds(573, 0, 60, 60);
		contentPane.add(button_11);

		JButton button_12 = new JButton("3");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText() + "3");
					break;
				case "amount":
					txtAmount.setText(txtAmount.getText() + "3");
					break;
				}
			}
		});
		button_12.setBounds(634, 0, 60, 60);
		contentPane.add(button_12);

		JButton button_13 = new JButton("<");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (selectedItem) {
				case "barcode":
					txtBarcode.setText(txtBarcode.getText().substring(0, txtBarcode.getText().length() - 1));
					break;
				case "amount":
					txtAmount.setText(txtAmount.getText().substring(0, txtAmount.getText().length() - 1));
					break;
				}
			}
		});
		button_13.setBounds(698, 0, 106, 60);
		contentPane.add(button_13);

		JButton btnAddStock = new JButton("Add Stock");
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Window.setVisible();
			}
		});
		btnAddStock.setBounds(0, 222, 116, 40);
		contentPane.add(btnAddStock);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 57, 71, 14);
		contentPane.add(lblName);

		JButton btnReviewStock = new JButton("Review Stock");
		btnReviewStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ProductReview.run();
			}
		});
		btnReviewStock.setBounds(120, 222, 116, 40);
		contentPane.add(btnReviewStock);

		String[] name = new String[names.size()];
		names.toArray(name);
		cbxName = new JComboBox<String>();
		cbxName.setModel(new DefaultComboBoxModel<String>(name));
		cbxName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() instanceof JComboBox) {
					String code = codes.get(((JComboBox<?>) arg0.getSource()).getSelectedIndex());
					txtBarcode.setText(code);
				}
			}
		});
		cbxName.setBounds(81, 48, 285, 30);
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
		btnUpdate.setBounds(367, 53, 89, 23);
		contentPane.add(btnUpdate);
	}

	public static void setVisible() {
		frame.setVisible(true);
	}
}
