package com.github.ZXSkelobrine.barcode;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import com.alee.laf.WebLookAndFeel;

import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class UpdateWindow extends JFrame {

	private static final long serialVersionUID = -2520106035665537988L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UpdateWindow(String version, final String address) {
		WebLookAndFeel.install();
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 363, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setText("There is a new version available: " + version + "\nYou can download it from: " + address.split("exe")[0] + "exe");
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 357, 93);
		contentPane.add(textArea);

		JButton btnGotIt = new JButton("Got It!");
		btnGotIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnGotIt.setBounds(27, 95, 101, 23);
		contentPane.add(btnGotIt);

		JButton btnTakeMeThere = new JButton("Take me there");
		btnTakeMeThere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					String[] split = address.split("exe");
					Desktop.getDesktop().browse(new URI(split[0] + "exe"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});
		btnTakeMeThere.setBounds(234, 95, 101, 23);
		contentPane.add(btnTakeMeThere);
		setVisible(true);
	}
}
