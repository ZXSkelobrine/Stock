package com.github.ZXSkelobrine.barcode;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Details extends JFrame {

	private static final long serialVersionUID = 4975498380016552291L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtBarcode;
	private JTextField txtBuy;
	private JTextField txtSell;
	private JTextField txtProfit;
	private JLabel lblAmount;
	private JTextField txtAmount;
	private JButton btnOkay;

	/**
	 * Create the frame.
	 */
	public Details(Product product) {
		int iD = product.getId();
		String name = product.getName();
		String barcode = product.getBarcode();
		float buy = product.getBuyCost();
		float sell = product.getSell();
		float profit = product.getProfit();
		int amount = product.getAmount();
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 261, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 21, 46, 14);
		contentPane.add(lblId);

		txtID = new JTextField(String.valueOf(iD));
		txtID.setEditable(false);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtID.setBounds(88, 11, 155, 34);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtName = new JTextField(name);
		txtName.setEditable(false);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtName.setColumns(10);
		txtName.setBounds(88, 46, 155, 34);
		contentPane.add(txtName);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 56, 46, 14);
		contentPane.add(lblName);

		JLabel lblBarcode = new JLabel("Barcode:");
		lblBarcode.setBounds(10, 91, 46, 14);
		contentPane.add(lblBarcode);

		txtBarcode = new JTextField(barcode);
		txtBarcode.setEditable(false);
		txtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBarcode.setColumns(10);
		txtBarcode.setBounds(88, 81, 155, 34);
		contentPane.add(txtBarcode);

		JLabel lblBuyCost = new JLabel("Buy Cost:");
		lblBuyCost.setBounds(10, 126, 68, 14);
		contentPane.add(lblBuyCost);

		txtBuy = new JTextField(String.valueOf(buy));
		txtBuy.setEditable(false);
		txtBuy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBuy.setColumns(10);
		txtBuy.setBounds(88, 116, 155, 34);
		contentPane.add(txtBuy);

		JLabel lblSellCost = new JLabel("Sell Cost:");
		lblSellCost.setBounds(10, 161, 46, 14);
		contentPane.add(lblSellCost);

		txtSell = new JTextField(String.valueOf(sell));
		txtSell.setEditable(false);
		txtSell.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSell.setColumns(10);
		txtSell.setBounds(88, 151, 155, 34);
		contentPane.add(txtSell);

		JLabel lblProfit = new JLabel("Profit:");
		lblProfit.setBounds(10, 196, 46, 14);
		contentPane.add(lblProfit);

		txtProfit = new JTextField(String.valueOf(profit));
		txtProfit.setEditable(false);
		txtProfit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtProfit.setColumns(10);
		txtProfit.setBounds(88, 186, 155, 34);
		contentPane.add(txtProfit);

		lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(10, 231, 46, 14);
		contentPane.add(lblAmount);

		txtAmount = new JTextField(String.valueOf(amount));
		txtAmount.setEditable(false);
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAmount.setColumns(10);
		txtAmount.setBounds(88, 221, 155, 34);
		contentPane.add(txtAmount);

		btnOkay = new JButton("Okay");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOkay.setBounds(83, 266, 89, 23);
		contentPane.add(btnOkay);
		setVisible(true);
	}

}
