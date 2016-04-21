package human;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Primary implements ActionListener, ItemListener {
	static Window w;
	static String name, lastname, sexString;
	static float height, weight;
	static boolean sex;
	Human human = null;
	static Human tempMan = null;
	static HashMap<String, ValuesHuman> hashmap = new HashMap<String, ValuesHuman>();
	static Vector<String> vector = new Vector<String>();
	static Human child = null;
	static DataBase db;
	static int i = 0;

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Отсутствует драйвер подключения к базе данных!");
		}
		db = new DataBase();
		db.selectAllHuman();
		try {
			while (db.rs.next()) {
				name = db.rs.getString("name");
				lastname = db.rs.getString("lname");
				height = db.rs.getFloat("height");
				weight = db.rs.getFloat("weight");
				sexString = db.rs.getString("sex");
				if (sexString.equals("м")) {
					hashmap.put((lastname + " " + name), new ValuesHuman(height, weight, true));
					vector.add((lastname + " " + name));
				} else {
					hashmap.put((lastname + " " + name), new ValuesHuman(height, weight, false));
					vector.add((lastname + " " + name));
				}
			}
			db.closeDB();
			Collections.sort(vector);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				w = new Window("Тест на совместимость");
			}
		});

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == w.rb1)
			sex = w.rb1.isSelected();
		// System.out.println(sex);

		if (e.getSource() == w.combox) {
			String temp = (String) w.combox.getSelectedItem();
			ValuesHuman vh = hashmap.get(temp);
			String smas[] = temp.split(" ");
			if (vh.sex)
				tempMan = new Man(vh.sex, smas[1], smas[0], vh.height, vh.weight);
			else
				tempMan = new Woman(vh.sex, smas[1], smas[0], vh.height, vh.weight);
			otobragenie_2(tempMan);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == w.b1) {

			if (child == null) {

				boolean flag = true;
				name = w.tf1.getText();
				lastname = w.tf2.getText();
				try {
					height = Float.parseFloat(w.tf3.getText());
					weight = Float.parseFloat(w.tf4.getText());
				} catch (NumberFormatException nfE) {
					flag = false;
				}
				if (name.matches("^\\D*$") && lastname.matches("^\\D*$") && !name.isEmpty() && !lastname.isEmpty()
						&& flag && (height > 50 & height < 260) && (weight > 20 & weight < 400)) {

					if (sex) {
						human = new Man(sex, name, lastname, height, weight);
						otobragenie_1(human);
						db.addHuman(human);
						vector.addElement(lastname + " " + name);
						Collections.sort(vector);
						hashmap.put((lastname + " " + name), new ValuesHuman(height, weight, true));
						w.refreshCombobox();
					}

					else {
						human = new Woman(sex, name, lastname, height, weight);
						otobragenie_1(human);
						db.addHuman(human);
						vector.addElement(lastname + " " + name);
						Collections.sort(vector);
						hashmap.put((lastname + " " + name), new ValuesHuman(height, weight, false));
						w.refreshCombobox();
					}
				} else
					JOptionPane.showMessageDialog(null, "Неверный ввод!");
			} else {
				child.name = w.tf1.getText();
				if (child.name.matches("^\\D*$") && !child.name.isEmpty())
					otobragenieRebenka(child);
				else
					JOptionPane.showMessageDialog(null, "Неверный ввод!");
			}

		}

		if (e.getSource() == w.b2) {
			if (child == null) {
				if (human == null)
					JOptionPane.showMessageDialog(null, "Введите данные для 'Человек 1'!");
				if (tempMan == null)
					JOptionPane.showMessageDialog(null, "Выберите человека из списка!");
				else if (human != null && tempMan != null)
					child = Human.test(human, tempMan);
			} else
				JOptionPane.showMessageDialog(null, "Пара совпала!\nТест окончен.");
		}

		if (e.getSource() == w.b3) {
			if (child == null) {
				if (human == null)
					JOptionPane.showMessageDialog(null, "Введите данные для 'Человек 1'!");
				else {
					String[] smas;
					ValuesHuman valueshuman;
					Human tempMan1;
					stop: for (Map.Entry<String, ValuesHuman> item : hashmap.entrySet()) {
						smas = item.getKey().split(" ");
						valueshuman = item.getValue();
						if (valueshuman.sex)
							tempMan1 = new Man(true, smas[1], smas[0], valueshuman.height, valueshuman.weight);
						else
							tempMan1 = new Woman(false, smas[1], smas[0], valueshuman.height, valueshuman.weight);
						child = Human.test(human, tempMan1);
						if (child != null) {
							otobragenie_2(tempMan1);
							break stop;
						}
					}
					if (child == null)
						JOptionPane.showMessageDialog(null, "Подходящей пары не найдено!");
				}
			} else
				JOptionPane.showMessageDialog(null, "Пара совпала!\nТест окончен.");
		}
	}

	public void otobragenie_1(Human h) {
		if (h.gender)
			w.otobragenieChelovec1(h.name, h.lastname, "рост: " + ((int) h.height) + ", вес: " + ((int) h.weight),
					"мужчина.");
		else
			w.otobragenieChelovec1(h.name, h.lastname, "рост: " + ((int) h.height) + ", вес: " + ((int) h.weight),
					"женщина.");
	}

	public void otobragenie_2(Human h) {
		if (i == 0) {
			if (h.gender)
				w.otobragenieChelovec2(h.name, h.lastname, "рост: " + ((int) h.height) + ", вес: " + ((int) h.weight),
						"мужчина.");
			else
				w.otobragenieChelovec2(h.name, h.lastname, "рост: " + ((int) h.height) + ", вес: " + ((int) h.weight),
						"женщина.");
		} else
			JOptionPane.showMessageDialog(null, "Пара совпала!\nТест окончен.");
	}

	public void otobragenieRebenka(Human h) {
		i++;
		if (i == 1) {
			if (h.gender)
				w.otobragenieRebenka(h.name, h.lastname, "рост: " + ((int) h.height) + ", вес: " + ((int) h.weight),
						"мужчина.");
			else
				w.otobragenieRebenka(h.name, h.lastname, "рост: " + ((int) h.height) + ", вес: " + ((int) h.weight),
						"женщина.");
		} else
			JOptionPane.showMessageDialog(null, "Пара совпала!\nТест окончен.");
	}

}
