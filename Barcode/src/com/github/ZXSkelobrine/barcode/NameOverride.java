package com.github.ZXSkelobrine.barcode;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NameOverride extends JFrame {

	private static final long serialVersionUID = 364901168032518829L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtCode;

	/**
	 * Create the frame.
	 */
	public NameOverride() {
		setTitle("Project Flame - Stock Keeper - Name Override");
		try {
			BufferedImage bi = ImageIO.read(Window.class.getResource(Window.icon));
			setIconImage(bi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 33, 46, 14);
		contentPane.add(lblName);

		JLabel lblCode = new JLabel("Code:");
		lblCode.setBounds(10, 68, 46, 14);
		contentPane.add(lblCode);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setBounds(52, 30, 146, 30);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtCode = new JTextField();
		txtCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCode.setBounds(52, 65, 146, 30);
		contentPane.add(txtCode);
		txtCode.setColumns(10);

		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCode.setText(txtCode.getText() + "1");
			}
		});
		button.setBounds(207, 11, 60, 60);
		contentPane.add(button);

		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCode.setText(txtCode.getText() + "2");
			}
		});
		button_1.setBounds(268, 11, 60, 60);
		contentPane.add(button_1);

		JButton button_2 = new JButton("5");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCode.setText(txtCode.getText() + "5");
			}
		});
		button_2.setBounds(268, 72, 60, 60);
		contentPane.add(button_2);

		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCode.setText(txtCode.getText() + "4");
			}
		});
		button_3.setBounds(207, 72, 60, 60);
		contentPane.add(button_3);

		JButton button_4 = new JButton("7");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCode.setText(txtCode.getText() + "7");
			}
		});
		button_4.setBounds(207, 133, 60, 60);
		contentPane.add(button_4);

		JButton button_5 = new JButton("8");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCode.setText(txtCode.getText() + "8");
			}
		});
		button_5.setBounds(268, 133, 60, 60);
		contentPane.add(button_5);

		JButton button_6 = new JButton("0");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCode.setText(txtCode.getText() + "0");
			}
		});
		button_6.setBounds(268, 194, 60, 60);
		contentPane.add(button_6);

		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCode.setText(txtCode.getText() + "9");
			}
		});
		button_9.setBounds(329, 133, 60, 60);
		contentPane.add(button_9);

		JButton button_10 = new JButton("6");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCode.setText(txtCode.getText() + "6");
			}
		});
		button_10.setBounds(329, 72, 60, 60);
		contentPane.add(button_10);

		JButton button_11 = new JButton("3");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCode.setText(txtCode.getText() + "3");
			}
		});
		button_11.setBounds(329, 11, 60, 60);
		contentPane.add(button_11);

		JButton button_12 = new JButton("<");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCode.setText(txtCode.getText().substring(0, txtCode.getName().length() - 1));
			}
		});
		button_12.setBounds(393, 11, 106, 60);
		contentPane.add(button_12);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDone.setBounds(393, 72, 106, 60);
		contentPane.add(btnDone);
		initCompleted();
	}

	private void initCompleted() {
		setVisible(true);
	}
}
