import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class ColorWorld extends JFrame implements ActionListener{
	static JLabel name = new JLabel("Please enter your name");
	static JTextField namefield = new JTextField(100);
	static JButton start =new JButton("Start");


	public ColorWorld(){

		this.setLayout(null);
		this.name.setBounds(60,20,350,50);
		this.namefield.setBounds(60,80,300,50);
		this.start.setBounds(170,160,150,50);
		start.addActionListener(this);
		this.add(name);
		this.add(namefield);
		this.add(start);
	}
	
	public void actionPerformed(ActionEvent e){
		try{
			String name = namefield.getText();
			new game(name);
		}
		catch(NumberFormatException q){
			JOptionPane.showMessageDialog(null,"invalid","Note",JOptionPane.WARNING_MESSAGE);
			q.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ColorWorld frame = new ColorWorld();
		frame.setTitle("ColorWorld");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,300);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class ColorWorld extends JFrame implements ActionListener{
	static JLabel name = new JLabel("Please enter your name");
	static JTextField namefield = new JTextField(100);
	static JButton start =new JButton("Start");


	public ColorWorld(){

		this.setLayout(null);
		this.name.setBounds(60,20,350,50);
		this.namefield.setBounds(60,80,300,50);
		this.start.setBounds(170,160,150,50);
		start.addActionListener(this);
		this.add(name);
		this.add(namefield);
		this.add(start);
	}
	
	public void actionPerformed(ActionEvent e){
		try{
			String name = namefield.getText();
			new game(name);
		}
		catch(NumberFormatException q){
			JOptionPane.showMessageDialog(null,"invalid","Note",JOptionPane.WARNING_MESSAGE);
			q.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ColorWorld frame = new ColorWorld();
		frame.setTitle("ColorWorld");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,300);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
