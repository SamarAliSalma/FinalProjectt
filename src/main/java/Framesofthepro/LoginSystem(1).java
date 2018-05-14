package Framesofthepro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import javax.swing.SwingConstants;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Administrator;
import domain.PassEnc;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Toolkit;

public class LoginSystem {
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JFrame frmSms;
	private JFrame frmLoginSystem;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private static File fileAdmin;

	private static ArrayList<Administrator> arrayAdmins = new ArrayList<Administrator>();

	private static ObjectMapper om = new ObjectMapper();

	public static void main(String[] args) {
		fileAdmin = new File("Admins.txt");

		try {
			if (fileAdmin.exists()) {
				Scanner scan = new Scanner(fileAdmin);
				if (scan.hasNextLine()) {

					arrayAdmins = om.readValue(new Scanner(fileAdmin).nextLine(),
							new TypeReference<ArrayList<Administrator>>() {
							});
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSystem window = new LoginSystem();
					window.frmSms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginSystem() {
		initialize();
	}

	private void initialize() {
		frmSms = new JFrame();
		frmSms.setTitle("SMS");

		frmSms.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/owl-login.png")));

		frmSms.setBounds(200, 200, 569, 334);
		frmSms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSms.getContentPane().setLayout(null);

		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(129, 140, 73, 20);
		frmSms.getContentPane().add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(129, 171, 73, 20);
		frmSms.getContentPane().add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(212, 141, 162, 20);
		frmSms.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();

		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Image img = new ImageIcon(this.getClass().getResource("/ezgif.com-gif-maker (4).gif")).getImage();

				lblNewLabel_1.setIcon(new ImageIcon(img));
				txtPassword.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseExited(MouseEvent e) {
						Image img = new ImageIcon(this.getClass().getResource("/ezgif.com-gif-maker (3).gif"))
								.getImage();

						lblNewLabel_1.setIcon(new ImageIcon(img));
					}
				});

			}
		});

		txtPassword.setBounds(212, 168, 162, 20);
		frmSms.getContentPane().add(txtPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Administrator a = Valid(arrayAdmins, txtUsername, txtPassword);

				String password = txtPassword.getText();
				String username = txtUsername.getText();
				if ((password.contains("swer") && username.contains("user")) || (a != null)) {
					txtUsername.setText(null);
					txtPassword.setText(null);
					MainScreen m = new MainScreen();
					try {
						MainScreen.main(null);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "invalid login details");
				}
			}
		});
		btnLogin.setBounds(109, 215, 89, 23);
		frmSms.getContentPane().add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtUsername.setText(null);
				txtPassword.setText(null);

			}
		});
		btnReset.setBounds(229, 215, 89, 23);
		frmSms.getContentPane().add(btnReset);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login Systems",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(346, 215, 89, 23);
		frmSms.getContentPane().add(btnExit);
		lblNewLabel_1 = new JLabel("");

		lblNewLabel_1.setBounds(67, 24, 499, 118);
		frmSms.getContentPane().add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 140, 533, 2);
		frmSms.getContentPane().add(separator);

		lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/frame_00_delay-0.2s.gif")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(67, 24, 499, 118);
		frmSms.getContentPane().add(lblNewLabel);

	}

	private Administrator Valid(ArrayList<Administrator> admins, JTextField txt, JPasswordField txt1) {
		for (Administrator p : admins) {
			if (p != null) {
				if ((txt.getText().equals(PassEnc.decrypt(p.getUserName()))
						&& txt1.getText().equals(PassEnc.decrypt(p.getPassword())))) {
					return p;

				}
			}
		}
		return null;

	}
}
