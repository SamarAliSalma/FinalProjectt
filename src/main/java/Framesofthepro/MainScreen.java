package Framesofthepro;

import domain.*;
import java.util.Scanner;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PrinterException;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JMenuBar;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Label;
import java.awt.Color;

public class MainScreen {

	private JFrame frmSas;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField Username1;
	private JTextField Name1;
	private JTextField City1;
	private JTextField HouseNum1;
	private JTextField Age1;
	private JTextField StreetName1;
	private JTextField Name3;
	private JTextField Salary3;
	private JTextField StreetName3;
	private JTextField Age3;
	private JTextField City3;
	private JTextField HouseNum3;
	private JTextField Name2;
	private JTextField Grade;
	private JTextField StreetName2;
	private JTextField Age2;
	private JTextField City2;

	private JTextField HouseNum2;
	private JTextArea salaryArea;

	private JTextArea gradeArea;
	private JLabel nameLabel;
	private JCheckBox chckbxEmployee;
	private JCheckBox chckbxStudent;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_10;
	private int i = 1;
	private int age = 0;
	private static ArrayList<Employee> arraylargerSalary = new ArrayList<Employee>();
	private static ArrayList<Student> arraylargerGrade = new ArrayList<Student>();
	private static ArrayList<Administrator> arrayAdmins = new ArrayList<Administrator>();
	private static ArrayList<Object> search = new ArrayList<Object>();
	private static ArrayList<Integer> index = new ArrayList<Integer>();

	private static ArrayList<Student> arrayStudents = new ArrayList<Student>();
	private static ArrayList<Employee> arrayEmployees = new ArrayList<Employee>();
	private JPasswordField Password1;
	private JTextField name1Search;
	private JTextField name1;
	private JTextField age1;
	private JTextField grade1;
	private JTextField city1;
	private JTextField stName1;
	private JTextField houseNo1;
	private JTextField name2Search;
	private JTextField name2;
	private JTextField salary2;
	private JTextField age2;
	private JTextField city2;
	private JTextField stName2;
	private JTextField houseNo2;
	private JTextField salarySearch;
	private JTextField gradeSearch;
	private static ObjectMapper om = new ObjectMapper();
	private static File fileStudent;
	protected static File fileAdmin;
	private static File fileEmployee;
	private JLabel lblNewLabel_9;

	public static void main(String[] args) throws FileNotFoundException {

		fileStudent = new File("Students.txt");
		fileAdmin = new File("Admins.txt");
		fileEmployee = new File("Employees.txt");

		if (fileAdmin.exists()) {
			if (new Scanner(fileAdmin).hasNextLine()) {
				try {
					arrayAdmins = om.readValue(new Scanner(fileAdmin).nextLine(),
							new TypeReference<ArrayList<Administrator>>() {
							});
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (fileStudent.exists()) {
			if (new Scanner(fileStudent).hasNextLine()) {
				try {
					arrayStudents = om.readValue(new Scanner(fileStudent).nextLine(),
							new TypeReference<ArrayList<Student>>() {
							});
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (fileEmployee.exists()) {
			if (new Scanner(fileEmployee).hasNextLine()) {
				try {
					arrayEmployees = om.readValue(new Scanner(fileEmployee).nextLine(),
							new TypeReference<ArrayList<Employee>>() {
							});
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frmSas.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	public MainScreen() {
		initialize();
	}

	private void initialize() {
		frmSas = new JFrame();
		frmSas.setTitle("SAS");

		frmSas.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/owl-login.png")));

		frmSas.setBounds(100, 100, 645, 457);
		frmSas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSas.addWindowListener(new WindowListener() {
			public void windowClosed(WindowEvent arg0) {
				try {
					om.writeValue(fileStudent, arrayStudents);
					om.writeValue(fileAdmin, arrayAdmins);
					om.writeValue(fileEmployee, arrayEmployees);

				} catch (JsonGenerationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}

			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowClosing(WindowEvent e) {
				try {
					om.writeValue(fileStudent, arrayStudents);
					om.writeValue(fileAdmin, arrayAdmins);
					om.writeValue(fileEmployee, arrayEmployees);

				} catch (JsonGenerationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);

			}

			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

		frmSas.getContentPane().setLayout(null);
		tabbedPane.setBounds(0, 0, 808, 521);
		frmSas.getContentPane().add(tabbedPane);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add Student", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNameS = new JLabel("Name");
		lblNameS.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameS.setFont(new Font("Arial", Font.BOLD, 13));
		lblNameS.setBounds(28, 23, 96, 29);
		panel_2.add(lblNameS);

		JLabel lblAgeS = new JLabel("Age");
		lblAgeS.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeS.setFont(new Font("Arial", Font.BOLD, 13));
		lblAgeS.setBounds(170, 23, 96, 29);
		panel_2.add(lblAgeS);

		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("Arial", Font.BOLD, 13));
		lblGrade.setBounds(280, 23, 96, 29);
		panel_2.add(lblGrade);

		JLabel lblStreetNameS = new JLabel("Street name");
		lblStreetNameS.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreetNameS.setFont(new Font("Arial", Font.PLAIN, 13));
		lblStreetNameS.setBounds(58, 170, 83, 29);
		panel_2.add(lblStreetNameS);

		JLabel lblCityS = new JLabel("City");
		lblCityS.setHorizontalAlignment(SwingConstants.CENTER);
		lblCityS.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCityS.setBounds(48, 137, 96, 29);
		panel_2.add(lblCityS);

		JLabel lblHouseNumberS = new JLabel("House Number");
		lblHouseNumberS.setHorizontalAlignment(SwingConstants.CENTER);
		lblHouseNumberS.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHouseNumberS.setBounds(58, 202, 96, 29);
		panel_2.add(lblHouseNumberS);
		Image img = new ImageIcon(this.getClass().getResource("/readmeio_register-1-700x376.png")).getImage();

		Name2 = new JTextField();
		Name2.setColumns(10);
		Name2.setBounds(28, 62, 116, 22);
		panel_2.add(Name2);

		Grade = new JTextField();
		Grade.setColumns(10);
		Grade.setBounds(288, 62, 76, 22);
		panel_2.add(Grade);

		StreetName2 = new JTextField();
		StreetName2.setColumns(10);
		StreetName2.setBounds(159, 174, 128, 22);
		panel_2.add(StreetName2);

		Age2 = new JTextField();
		Age2.setColumns(10);
		Age2.setBounds(187, 62, 54, 22);
		panel_2.add(Age2);

		City2 = new JTextField();
		City2.setColumns(10);
		City2.setBounds(159, 141, 128, 22);
		panel_2.add(City2);

		HouseNum2 = new JTextField();
		HouseNum2.setColumns(10);
		HouseNum2.setBounds(159, 206, 128, 22);
		panel_2.add(HouseNum2);

		JButton Studentbtn = new JButton("Add");
		Studentbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		Studentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student student = new Student(Name2.getText(), Integer.parseInt(Age2.getText()),
							Integer.parseInt(Grade.getText()));
					student.setAddress(new Address(StreetName2.getText(), HouseNum2.getText(), City2.getText()));
					arrayStudents.add(student);
					Name2.setText(null);
					Age2.setText(null);
					Grade.setText(null);
					StreetName2.setText(null);
					HouseNum2.setText(null);
					City2.setText(null);

				} catch (Exception es) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");

				}
			}
		});
		Studentbtn.setBounds(159, 260, 89, 29);
		panel_2.add(Studentbtn);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Arial", Font.BOLD, 13));
		lblAddress.setBounds(74, 107, 70, 22);
		panel_2.add(lblAddress);

		JLabel lblNewLabel_11 = new JLabel("New label");

		lblNewLabel_11.setIcon(new ImageIcon(img));
		lblNewLabel_11.setBounds(-70, -54, 699, 471);
		panel_2.add(lblNewLabel_11);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Administrator", null, panel, null);
		panel.setLayout(null);

		JLabel lblStreetNameA = new JLabel("Street name");
		lblStreetNameA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStreetNameA.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreetNameA.setBounds(87, 182, 96, 29);
		panel.add(lblStreetNameA);

		JLabel lblHouseNumberA = new JLabel("House number");
		lblHouseNumberA.setHorizontalAlignment(SwingConstants.CENTER);
		lblHouseNumberA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHouseNumberA.setBounds(87, 215, 96, 29);
		panel.add(lblHouseNumberA);

		JLabel lblCityA = new JLabel("City");
		lblCityA.setHorizontalAlignment(SwingConstants.CENTER);
		lblCityA.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCityA.setBounds(87, 150, 96, 29);
		panel.add(lblCityA);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Arial", Font.BOLD, 13));
		lblUsername.setBounds(10, 24, 116, 47);
		panel.add(lblUsername);

		JLabel Passwordlbl = new JLabel("Password");
		Passwordlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Passwordlbl.setFont(new Font("Arial", Font.BOLD, 13));
		Passwordlbl.setBounds(235, 28, 116, 38);
		panel.add(Passwordlbl);

		JLabel lblNameA = new JLabel("Name");
		lblNameA.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameA.setFont(new Font("Arial", Font.BOLD, 13));
		lblNameA.setBounds(87, 71, 96, 29);
		panel.add(lblNameA);

		JLabel lblAgeA = new JLabel("Age");
		lblAgeA.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeA.setFont(new Font("Arial", Font.BOLD, 13));
		lblAgeA.setBounds(264, 71, 96, 29);
		panel.add(lblAgeA);

		Username1 = new JTextField();
		Username1.setBounds(109, 37, 116, 22);
		panel.add(Username1);
		Username1.setColumns(10);

		Name1 = new JTextField();
		Name1.setColumns(10);
		Name1.setBounds(161, 77, 116, 22);
		panel.add(Name1);

		City1 = new JTextField();
		City1.setColumns(10);
		City1.setBounds(189, 155, 116, 22);
		panel.add(City1);

		HouseNum1 = new JTextField();
		HouseNum1.setColumns(10);
		HouseNum1.setBounds(189, 220, 116, 22);
		panel.add(HouseNum1);

		Age1 = new JTextField();
		Age1.setColumns(10);
		Age1.setBounds(337, 78, 33, 22);
		panel.add(Age1);

		StreetName1 = new JTextField();
		StreetName1.setColumns(10);
		StreetName1.setBounds(189, 187, 116, 22);
		panel.add(StreetName1);

		JButton Adminsbtn = new JButton("Add");
		Adminsbtn.setFont(new Font("Arial", Font.BOLD, 13));
		Adminsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Administrator admin = new Administrator(Name1.getText(), Integer.parseInt(Age1.getText()),
							PassEnc.encrypt(Username1.getText()), PassEnc.encrypt(Password1.getText()));
					admin.setAddress(new Address(StreetName1.getText(), HouseNum1.getText(), City1.getText()));
					arrayAdmins.add(admin);
				} catch (Exception es) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");

				}
				Name1.setText(null);
				Age1.setText(null);
				Username1.setText(null);
				Password1.setText(null);
				StreetName1.setText(null);
				HouseNum1.setText(null);
				City1.setText(null);

			}
		});
		Adminsbtn.setBounds(168, 265, 76, 29);
		panel.add(Adminsbtn);

		Password1 = new JPasswordField();
		Password1.setBounds(337, 37, 116, 22);
		panel.add(Password1);

		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblAddress_1.setBounds(97, 111, 76, 28);
		panel.add(lblAddress_1);

		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setIcon(new ImageIcon(img));
		lblNewLabel_12.setBounds(-70, -54, 699, 471);
		panel.add(lblNewLabel_12);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add Employee", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNameE = new JLabel("Name");
		lblNameE.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameE.setFont(new Font("Arial", Font.BOLD, 13));
		lblNameE.setBounds(37, 22, 96, 29);
		panel_1.add(lblNameE);

		JLabel lblAgeE = new JLabel("Age");
		lblAgeE.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeE.setFont(new Font("Arial", Font.BOLD, 13));
		lblAgeE.setBounds(160, 22, 96, 29);
		panel_1.add(lblAgeE);

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalary.setFont(new Font("Arial", Font.BOLD, 13));
		lblSalary.setBounds(254, 22, 96, 29);
		panel_1.add(lblSalary);

		JLabel lblCityE = new JLabel("City");
		lblCityE.setHorizontalAlignment(SwingConstants.CENTER);
		lblCityE.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCityE.setBounds(59, 122, 96, 29);
		panel_1.add(lblCityE);

		JLabel lblStreetNameE = new JLabel("Street name");
		lblStreetNameE.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreetNameE.setFont(new Font("Arial", Font.PLAIN, 13));
		lblStreetNameE.setBounds(37, 154, 96, 29);
		panel_1.add(lblStreetNameE);

		JLabel lblHouseNumberE = new JLabel("House Number");
		lblHouseNumberE.setHorizontalAlignment(SwingConstants.CENTER);
		lblHouseNumberE.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHouseNumberE.setBounds(37, 194, 96, 29);
		panel_1.add(lblHouseNumberE);

		Name3 = new JTextField();
		Name3.setBounds(28, 57, 116, 22);
		panel_1.add(Name3);
		Name3.setColumns(10);

		Salary3 = new JTextField();
		Salary3.setColumns(10);
		Salary3.setBounds(264, 57, 79, 22);
		panel_1.add(Salary3);

		StreetName3 = new JTextField();
		StreetName3.setColumns(10);
		StreetName3.setBounds(143, 159, 116, 22);
		panel_1.add(StreetName3);

		Age3 = new JTextField();
		Age3.setColumns(10);
		Age3.setBounds(187, 57, 48, 22);
		panel_1.add(Age3);

		City3 = new JTextField();
		City3.setColumns(10);
		City3.setBounds(143, 126, 117, 22);
		panel_1.add(City3);

		HouseNum3 = new JTextField();
		HouseNum3.setColumns(10);
		HouseNum3.setBounds(143, 194, 116, 22);
		panel_1.add(HouseNum3);

		JButton Employeebtn = new JButton("Add");
		Employeebtn.setFont(new Font("Arial", Font.BOLD, 13));
		Employeebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Employee employee = new Employee(Name3.getText(), Integer.parseInt(Age3.getText()),
							Integer.parseInt(Salary3.getText()));
					employee.setAddress(new Address(StreetName3.getText(), HouseNum3.getText(), City3.getText()));
					arrayEmployees.add(employee);
				} catch (Exception es) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");

				}
				Name3.setText(null);
				Age3.setText(null);
				Salary3.setText(null);
				StreetName3.setText(null);
				HouseNum3.setText(null);
				City3.setText(null);
			}
		});
		Employeebtn.setBounds(160, 233, 64, 34);
		panel_1.add(Employeebtn);

		JLabel lblNewLabel_8 = new JLabel("Address");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_8.setBounds(107, 90, 64, 25);
		panel_1.add(lblNewLabel_8);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(-70, -54, 699, 471);
		panel_1.add(label_1);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Search", null, panel_4, null);
		panel_4.setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(20, 21, 46, 14);
		panel_4.add(lblName);

		JButton btnNewButton_1 = new JButton("next");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if (chckbxStudent.isSelected()) {
					try {
						name1.setText(((Student) search.get(i)).getName());
						age1.setText(Integer.toString(((Student) search.get(i)).getAge()));
						grade1.setText(Integer.toString(((Student) search.get(i)).getGrade()));
						city1.setText(((Student) search.get(i)).getAddress().getCity());
						houseNo1.setText(((Student) search.get(i)).getAddress().getHouseNumber());
						stName1.setText(((Student) search.get(i)).getAddress().getStreetName());
						i++;
					} catch (Exception c) {
						lblNewLabel_7.setText("No more Students!");


					}
				} else if (chckbxEmployee.isSelected()) {
					try {
						name1.setText(((Employee) search.get(i)).getName());
						age1.setText(Integer.toString(((Employee) search.get(i)).getAge()));
						grade1.setText(Integer.toString(((Employee) search.get(i)).getSalary()));
						city1.setText(((Employee) search.get(i)).getAddress().getCity());
						houseNo1.setText(((Employee) search.get(i)).getAddress().getHouseNumber());
						stName1.setText(((Employee) search.get(i)).getAddress().getStreetName());
						i++;
					} catch (Exception c) {
						lblNewLabel_7.setText("No more Employees");


					}

				}
			}
		});
		btnNewButton_1.setBounds(265, 17, 89, 23);
		panel_4.add(btnNewButton_1);

		name1Search = new JTextField();
		name1Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		name1Search.setBounds(61, 18, 86, 20);
		panel_4.add(name1Search);
		name1Search.setColumns(10);

		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name1.setText(null);
				age1.setText(null);
				grade1.setText(null);
				city1.setText(null);
				houseNo1.setText(null);
				stName1.setText(null);
				search.clear();
				index.clear();
				i = 1;
				lblNewLabel_7.setText(null);

				try {
					if (chckbxStudent.isSelected()) {

						for (int n = 0; n < arrayStudents.size(); n++) {
							if (arrayStudents.get(n) != null) {

								if (arrayStudents.get(n).getName().equalsIgnoreCase(name1Search.getText())) {
									search.add(arrayStudents.get(n));
									index.add(n);

								}
							}
						}
						name1.setText(((Student) search.get(0)).getName());
						age1.setText(Integer.toString(((Student) search.get(0)).getAge()));
						grade1.setText(Integer.toString(((Student) search.get(0)).getGrade()));
						city1.setText(((Student) search.get(0)).getAddress().getCity());
						houseNo1.setText(((Student) search.get(0)).getAddress().getHouseNumber());
						stName1.setText(((Student) search.get(0)).getAddress().getStreetName());

					} else if (chckbxEmployee.isSelected()) {

						for (int n = 0; n < arrayStudents.size(); n++) {
							if (arrayEmployees.get(n) != null) {

								if (arrayEmployees.get(n).getName().equalsIgnoreCase(name1Search.getText())) {
									search.add(arrayEmployees.get(n));
									index.add(n);

								} 
							}
						}
						name1.setText(((Employee) search.get(0)).getName());
						age1.setText(Integer.toString(((Employee) search.get(0)).getAge()));
						grade1.setText(Integer.toString(((Employee) search.get(0)).getSalary()));
						city1.setText(((Employee) search.get(0)).getAddress().getCity());
						houseNo1.setText(((Employee) search.get(0)).getAddress().getHouseNumber());
						stName1.setText(((Employee) search.get(0)).getAddress().getStreetName());
					}
				} catch (Exception a) {
					
					lblNewLabel_7.setText("Entered value is not acceptable please try again");
					name1Search.setText(null);

				}

			}

		});
		btnSearch.setBounds(172, 17, 89, 23);
		panel_4.add(btnSearch);

		name1 = new JTextField();

		name1.setBounds(50, 106, 86, 20);
		panel_4.add(name1);
		name1.setColumns(10);

		age1 = new JTextField();

		age1.setBounds(172, 106, 86, 20);
		panel_4.add(age1);
		age1.setColumns(10);

		grade1 = new JTextField();
		grade1.setBounds(342, 106, 86, 20);
		panel_4.add(grade1);
		grade1.setColumns(10);

		city1 = new JTextField();
		city1.setBounds(117, 180, 86, 20);
		panel_4.add(city1);
		city1.setColumns(10);

		stName1 = new JTextField();
		stName1.setBounds(117, 208, 86, 20);
		panel_4.add(stName1);
		stName1.setColumns(10);

		houseNo1 = new JTextField();
		houseNo1.setBounds(117, 239, 86, 20);
		panel_4.add(houseNo1);
		houseNo1.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(20, 109, 46, 14);
		panel_4.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Age:");
		lblNewLabel_1.setBounds(146, 109, 46, 14);
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Grade \\ Salary :");
		lblNewLabel_2.setBounds(265, 109, 97, 14);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("City:");
		lblNewLabel_3.setBounds(77, 183, 46, 14);
		panel_4.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Street Name:");
		lblNewLabel_4.setBounds(36, 214, 64, 14);
		panel_4.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("House Number:");
		lblNewLabel_5.setBounds(22, 239, 78, 14);
		panel_4.add(lblNewLabel_5);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxStudent.isSelected()) {

					arrayStudents.get(index.get(i - 1)).setName(name1.getText());
					arrayStudents.get(index.get(i - 1)).setAge(Integer.parseInt(age1.getText()));
					arrayStudents.get(index.get(i - 1)).setGrade(Integer.parseInt(grade1.getText()));
					Address address = new Address(stName1.getText(), houseNo1.getText(), city1.getText());
					arrayStudents.get(index.get(i - 1)).setAddress(address);

				} else if (chckbxEmployee.isSelected()) {
					arrayEmployees.get(index.get(i - 1)).setName(name1.getText());
					arrayEmployees.get(index.get(i - 1)).setAge(Integer.parseInt(age1.getText()));
					arrayEmployees.get(index.get(i - 1)).setSalary(Integer.parseInt(grade1.getText()));
					Address address = new Address(stName1.getText(), houseNo1.getText(), city1.getText());
					arrayEmployees.get(index.get(i - 1)).setAddress(address);
				}
			}
		});
		btnSave.setBounds(358, 17, 89, 23);
		panel_4.add(btnSave);

		chckbxStudent = new JCheckBox("Student");
		chckbxStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		chckbxStudent.setBounds(121, 63, 97, 23);
		panel_4.add(chckbxStudent);

		chckbxEmployee = new JCheckBox("Employee");
		chckbxEmployee.setBounds(20, 63, 97, 23);
		panel_4.add(chckbxEmployee);

		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(71, 46, 240, 14);
		panel_4.add(lblNewLabel_7);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(img));
		label.setBounds(-70, -54, 699, 471);
		panel_4.add(label);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Reports", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(169, 60, 200, 107);
		panel_3.add(scrollPane_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane);

		salaryArea = new JTextArea();
		scrollPane.setRowHeaderView(salaryArea);

		JLabel lblNewLabel_6 = new JLabel("Salary:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(100, 18, 61, 29);
		panel_3.add(lblNewLabel_6);

		salarySearch = new JTextField();
		salarySearch.setBounds(159, 23, 86, 20);
		panel_3.add(salarySearch);
		salarySearch.setColumns(10);

		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_9.setText(null);

				arraylargerSalary.clear();
				try {
					for (int i = 0; i < arrayEmployees.size(); i++)
						if (Integer.parseInt(salarySearch.getText()) < arrayEmployees.get(i).getSalary()) {
							arraylargerSalary.add(arrayEmployees.get(i));
						}
					for (int s1 = 0; s1 < arraylargerSalary.size(); s1++) {
						salaryArea.append(arraylargerSalary.get(s1).toString() + "\n");
					}
				} catch (Exception en) {
					if (arraylargerSalary.size() == 0) {
						lblNewLabel_9.setText("\"No Salaries larger than Entered Value\"");

					}
					lblNewLabel_9.setText("\"Entered value is not acceptable please try again\"");
				}
			}
		});
		btnNewButton_4.setBounds(255, 22, 89, 23);
		panel_3.add(btnNewButton_4);

		gradeSearch = new JTextField();
		gradeSearch.setBounds(159, 195, 86, 20);
		panel_3.add(gradeSearch);
		gradeSearch.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Grade:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_13.setBounds(100, 190, 61, 29);
		panel_3.add(lblNewLabel_13);

		JButton btnNewButton_5 = new JButton("Search");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_10.setText(null);

				try {
					for (int i = 0; i < arrayStudents.size(); i++) {
						arraylargerGrade.clear();
						if (Integer.parseInt(gradeSearch.getText()) < arrayStudents.get(i).getGrade()) {
							arraylargerGrade.add(arrayStudents.get(i));

						}

						for (int g1 = 0; g1 < arraylargerGrade.size(); g1++) {
							gradeArea.append(arraylargerGrade.get(g1).toString() + "\n");

						}

					}
				} catch (Exception c) {
					if (arraylargerGrade.size() == 0) {
						lblNewLabel_10.setText("\"No Grades larager than Entered Value\"");

					}
					lblNewLabel_10.setText("\"Entered value is not acceptable please try again\"");

				}
			}
		});
		btnNewButton_5.setBounds(255, 194, 89, 23);
		panel_3.add(btnNewButton_5);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(187, 221, 182, 129);
		panel_3.add(scrollPane_1);

		gradeArea = new JTextArea();
		scrollPane_1.setViewportView(gradeArea);

		JButton btnNewButton_7 = new JButton("Print");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean ppt;
				try {
					ppt = salaryArea.print();
					if (ppt) {
						JOptionPane.showMessageDialog(null, "Done");
					} else {
						JOptionPane.showMessageDialog(null, "Printing");

					}
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_7.setBounds(27, 76, 89, 23);
		panel_3.add(btnNewButton_7);

		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(349, 0, 269, 64);
		panel_3.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setBounds(349, 195, 269, 118);
		panel_3.add(lblNewLabel_10);

		JButton btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean ppt;
				try {
					ppt = gradeArea.print();
					if (ppt) {
						JOptionPane.showMessageDialog(null, "Done");
					} else {
						JOptionPane.showMessageDialog(null, "Printing");

					}
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(27, 327, 89, 23);
		panel_3.add(btnNewButton);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(img));
		label_2.setBounds(-70, -54, 699, 471);
		panel_3.add(label_2);

		JMenuBar menuBar = new JMenuBar();
		frmSas.setJMenuBar(menuBar);

		JButton btnExit = new JButton("Exit");
		menuBar.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					om.writeValue(fileStudent, arrayStudents);
					om.writeValue(fileAdmin, arrayAdmins);
					om.writeValue(fileEmployee, arrayEmployees);

				} catch (JsonGenerationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});

	}
}
