import javax.swing.*;

import java.awt.*;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import java.io.*;
import java.util.*;


public class Advisor {

static JFrame frame;
static JPanel panel;
static JButton students, records, Graduation, Edit,View,Delete,Add;
static boolean isClicked = false;
static String temp="test";
static File user_cred;
static Scanner scan;
static BufferedReader reader;
static FileWriter file_writer;
static JLabel selected = new JLabel("None Selected");
private static JButton reset;
static File file = new File("items.txt");
static String[] items;
private static JTextArea textArea;
public static void main(String[] args) throws FileNotFoundException{
	Advisor();
	
}


public static void Advisor() throws FileNotFoundException{	
	frame = new JFrame();
	frame.setSize(800,600);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	
	
	createListItems();
	
	 students = new JButton("Students");
	 
	students.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//rame.setTitle("Test");
			isClicked = true;
			if(isClicked ==true){
				records.setVisible(false);
				Graduation.setVisible(false);
				Edit.setVisible(true);
				View.setVisible(true);
				Delete.setVisible(true);
				Add.setVisible(true);
			}
			selected.setText("students selected");
			
		}
	});
	
	 records = new JButton("Records");
	records.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		selected.setText("records selected");
		}
	});
	
	 Graduation = new JButton("Graduation");
	Graduation.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selected.setText("graduation selected");
		}
	});
	
	
	JButton Logout = new JButton("Logout");
	Logout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			try {
		
				frame.setVisible(false);Login.Login();// close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	});
	
	Edit = new JButton("Edit");
	Edit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selected.setText("Edit Selected");
		}
	});
	
	 View = new JButton("View");
	 View.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		selected.setText("View Selected");
	 	}
	 });
	
	 Delete = new JButton("Delete");
	 Delete.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		selected.setText("Delete Selected");
	 	}
	 });
	 
	Add = new JButton("Add");
	Add.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selected.setText("Add Selected");
		}
	});
		Edit.setVisible(false);
		View.setVisible(false);
		Delete.setVisible(false);
		Add.setVisible(false);
	
	reset = new JButton("Reset");
	reset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			records.setVisible(true);
			Graduation.setVisible(true);
			Edit.setVisible(false);
			View.setVisible(false);
			Delete.setVisible(false);
			Add.setVisible(false);
		}
	});
	
	textArea = new JTextArea();
	
	
	
	
	GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(55)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(Logout)
						.addGap(18)
						.addComponent(reset))
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(records, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(students, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(Graduation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(26)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(Edit, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
							.addComponent(Add, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
							.addComponent(View, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
							.addComponent(Delete, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
						.addComponent(selected)
						.addGap(326))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(18)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())))
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.TRAILING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(94)
				.addComponent(selected)
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(records)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(students)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(Graduation))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(Add)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(View)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(Edit)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(Delete)
						.addPreferredGap(ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(Logout)
							.addComponent(reset))
						.addGap(80))
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())))
	);
	frame.getContentPane().setLayout(groupLayout);
	frame.setVisible(true);
	
	
}public static void close(){
	System.exit(0);
}
public static void createListItems()throws FileNotFoundException{
	int item_counter=0;
	Scanner scan = new Scanner(file);
	while(scan.hasNextLine()){
		scan.nextLine();
		item_counter++;
	}
	scan = new Scanner(file);
	items = new String[item_counter];
	for(int i=0;i<items.length;i++){
		
		items[i]=scan.nextLine();
	}
	
	
}
}
