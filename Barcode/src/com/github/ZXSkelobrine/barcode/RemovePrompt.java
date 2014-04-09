package com.github.ZXSkelobrine.barcode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RemovePrompt extends JFrame {

	private static final long serialVersionUID = -4932700449253245600L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public RemovePrompt(final Product product) {
		setTitle("Project Flame - Stock Keeper - Remove Stock");
		try {
			BufferedImage bi = ImageIO.read(Window.class.getResource(Window.icon));
			setIconImage(bi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(10, 14, 46, 14);
		contentPane.add(lblAmount);

		textField = new JTextField();
		textField.setBounds(66, 11, 103, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "1");
			}
		});
		button.setBounds(239, 11, 60, 60);
		contentPane.add(button);

		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "2");
			}
		});
		button_1.setBounds(300, 11, 60, 60);
		contentPane.add(button_1);

		JButton button_2 = new JButton("5");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "5");
			}
		});
		button_2.setBounds(300, 72, 60, 60);
		contentPane.add(button_2);

		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "4");
			}
		});
		button_3.setBounds(239, 72, 60, 60);
		contentPane.add(button_3);

		JButton button_4 = new JButton("7");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "7");
			}
		});
		button_4.setBounds(239, 133, 60, 60);
		contentPane.add(button_4);

		JButton button_5 = new JButton("8");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "8");
			}
		});
		button_5.setBounds(300, 133, 60, 60);
		contentPane.add(button_5);

		JButton button_6 = new JButton("0");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "0");
			}
		});
		button_6.setBounds(300, 194, 60, 60);
		contentPane.add(button_6);

		JButton button_7 = new JButton("9");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "9");
			}
		});
		button_7.setBounds(361, 133, 60, 60);
		contentPane.add(button_7);

		JButton button_8 = new JButton("6");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "6");
			}
		});
		button_8.setBounds(361, 72, 60, 60);
		contentPane.add(button_8);

		JButton button_9 = new JButton("3");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "3");
			}
		});
		button_9.setBounds(361, 11, 60, 60);
		contentPane.add(button_9);

		JButton button_10 = new JButton("<");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
			}
		});
		button_10.setBounds(425, 11, 106, 60);
		contentPane.add(button_10);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Main.removeData(Main.statement, product.getBarcode(), Main.getProductName(product.getBarcode()), Integer.parseInt(textField.getText()));
					dispose();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnDone.setBounds(425, 72, 106, 60);
		contentPane.add(btnDone);

		textField_1 = new JTextField("/" + product.getAmount());
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBounds(169, 11, 60, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		initCompleted();
	}

	private void initCompleted() {
		setVisible(true);
	}

}
