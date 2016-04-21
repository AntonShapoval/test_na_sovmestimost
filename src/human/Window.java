package human;

import java.awt.Font;
import javax.swing.*;

public class Window extends JFrame  {
	
	JPanel panel;
	JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb13, lb14, lb15, lb16, lb17, lb18,
	lb19, lb20, lb21, lb22, lb23, lb24, lb25; 
	JRadioButton rb1, rb2;
	JTextField tf1, tf2, tf3, tf4;
	JButton b1, b2, b3;
	JComboBox<?> combox;
	Primary handler=new Primary();
	Primary handlerRB=new Primary();
	ButtonGroup groupRB =  new ButtonGroup();
	String [] mas1=new String[4],mas2=new String[4];
	
	Window(String title){
		super(title);

		setSize(500, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		panel=new JPanel();
		panel.setLayout(null);
		setContentPane(panel);
		Font font1 = new Font("Verdana", Font.BOLD, 18);
		Font font2 = new Font("Arial", Font.PLAIN, 16);
		Font font3 = new Font("Arial", Font.BOLD, 16);
		Font font4 = new Font("Arial", Font.PLAIN, 14);
		
		combox=new JComboBox(Primary.vector);
		combox.setMaximumRowCount(5);
		combox.addItemListener(new Primary());
		combox.setBounds(10, 130, 205, 30);
		
		lb1= new JLabel("Введите данные человека: ");
		lb1.setFont(font1);
		lb1.setBounds(60, 2, 300, 30);
		
		lb2=new JLabel("имя");
		lb2.setFont(font2);
		lb2.setBounds(165, 50, 30, 30);
		
		lb3=new JLabel("фамилия");
		lb3.setFont(font2);
		lb3.setBounds(385, 50, 80, 30);
		
		lb4=new JLabel("рост(см)");
		lb4.setFont(font2);
		lb4.setBounds(45, 85, 70, 30);
		
		lb5=new JLabel("вес(кг)");
		lb5.setFont(font2);
		lb5.setBounds(165, 85, 60, 30);
		
		
		
		
		lb7=new JLabel("выбрать человека");
		lb7.setFont(font2);
		lb7.setBounds(220, 130, 150, 30);
		
		lb8=new JLabel("Человек 1.");
		lb8.setFont(font3);
		lb8.setBounds(40, 170, 90, 30);
		
		lb9=new JLabel("Человек 2.");
		lb9.setFont(font3);
		lb9.setBounds(265, 170, 90, 30);
		
		for(int i=0;i<mas1.length;i++){
			mas1[i]="..............................................";
			mas2[i]="..............................................";
		}
		
		lb10=new JLabel(mas1[0]);
		lb10.setFont(font2);
		lb10.setBounds(10, 200, 150, 30);
		
		lb11=new JLabel(mas1[1]);
		lb11.setFont(font2);
		lb11.setBounds(10, 235, 150, 30);
		
		lb12=new JLabel(mas1[2]);
		lb12.setFont(font2);
		lb12.setBounds(10, 270, 150, 30);
		
		lb13=new JLabel(mas1[3]);
		lb13.setFont(font2);
		lb13.setBounds(10, 305, 150, 30);
		
		lb14=new JLabel(mas2[0]);
		lb14.setFont(font2);
		lb14.setBounds(230, 200, 150, 30);
		
		lb15=new JLabel(mas2[1]);
		lb15.setFont(font2);
		lb15.setBounds(230, 235, 150, 30);
		
		lb16=new JLabel(mas2[2]);
		lb16.setFont(font2);
		lb16.setBounds(230, 270, 150, 30);
		
		lb17=new JLabel(mas2[3]);
		lb17.setFont(font2);
		lb17.setBounds(230, 305, 150, 30);
		
		lb18=new JLabel("Результат:");
		lb18.setFont(font3);
		lb18.setBounds(40, 375, 90, 30);
		
		lb19=new JLabel("..............................................");
		lb19.setFont(font4);
		lb19.setBounds(10, 410, 250, 30);
		
		lb20=new JLabel("..............................................");
		lb20.setFont(font4);
		lb20.setBounds(10, 445, 200, 30);
		
		lb21=new JLabel("Новый человек:");
		lb21.setFont(font3);
		lb21.setBounds(245, 375, 150, 30);
		
		lb22=new JLabel("..............................................");
		lb22.setFont(font2);
		lb22.setBounds(230, 410, 150, 30);
		
		lb23=new JLabel("..............................................");
		lb23.setFont(font2);
		lb23.setBounds(230, 445, 150, 30);
		
		lb24=new JLabel("..............................................");
		lb24.setFont(font2);
		lb24.setBounds(230, 480, 150, 30);
		
		lb25=new JLabel("..............................................");
		lb25.setFont(font2);
		lb25.setBounds(230, 515, 150, 30);
		
				
		tf1=new JTextField(30);
		tf1.setBounds(10, 50, 150, 25);
		
		tf2=new JTextField(30);
		tf2.setBounds(230, 50, 150, 25);
		
		tf3=new JTextField(3);
		tf3.setBounds(10, 85, 30, 25);
		
		tf4=new JTextField(3);
		tf4.setBounds(130, 85, 30, 25);
		
		rb1= new JRadioButton("м",false);
		rb1.setBounds(230, 85, 40, 30);
		rb1.addItemListener(handlerRB);
		
		rb2= new JRadioButton("ж",false);
		rb2.setBounds(275, 85, 40, 30);
		rb2.addItemListener(handlerRB);
		groupRB.add(rb1);
		groupRB.add(rb2);
		
		b1=new JButton("Ввод данных");
		b1.setBounds(335, 85, 120, 30);
		b1.addActionListener(handler);
		
		b2= new JButton("Сравнить");
		b2.setBounds(335, 340, 120, 30);
		b2.addActionListener(handler);
		
		b3= new JButton("Сравнить со всеми");
		b3.setBounds(10, 340, 150, 30);
		b3.addActionListener(handler);
		
		panel.add(lb1);
		panel.add(tf1);
		panel.add(lb2);
		panel.add(tf2);
		panel.add(lb3);
		panel.add(tf3);
		panel.add(lb4);
		panel.add(tf4);
		panel.add(lb5);
		panel.add(rb1);
		panel.add(rb2);
		panel.add(b1);
		panel.add(combox);
		panel.add(lb7);
		panel.add(lb8);
		panel.add(lb9);
		panel.add(lb10);
		panel.add(lb11);
		panel.add(lb12);
		panel.add(lb13);
		panel.add(lb14);
		panel.add(lb15);
		panel.add(lb16);
		panel.add(lb17);
		panel.add(b2);
		panel.add(b3);
		panel.add(lb18);
		panel.add(lb19);
		panel.add(lb20);
		panel.add(lb21);
		panel.add(lb22);
		panel.add(lb23);
		panel.add(lb24);
		panel.add(lb25);
	}
	
	void otobragenieChelovec1 (String a,String b,String c,String d){
		lb10.setText(a);
		lb11.setText(b);
		lb12.setText(c);
		lb13.setText(d);
	}
	void otobragenieChelovec2 (String a,String b,String c,String d){
		lb14.setText(a);
		lb15.setText(b);
		lb16.setText(c);
		lb17.setText(d);
	}
	void otobragenieRezultat (String a){
		lb19.setText(a);
	}
	void vvediteImyReb (String a){
		lb20.setText(a);
	}
	void otobragenieRebenka (String a,String b,String c,String d){
		lb22.setText(a);
		lb23.setText(b);
		lb24.setText(c);
		lb25.setText(d);
	}
	void refreshCombobox(){
		panel.remove(combox);
		combox=new JComboBox(Primary.vector);
		combox.setMaximumRowCount(5);
		combox.addItemListener(new Primary());
		combox.setBounds(10, 130, 205, 30);
		panel.add(combox);
	}
}
