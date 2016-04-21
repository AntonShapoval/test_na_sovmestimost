package human;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DataBase {
private Connection con;
private String url="jdbc:sqlite:people.db";
//private String name="root";
//private String password=null;
private String select="SELECT name, lname, height, weight, sex FROM people";
private String delete="DELETE FROM people";
private Statement st;
ResultSet rs;
	
	private void connect (){
		try{
			con=DriverManager.getConnection(url);
			System.out.println("Connected.");
			st=con.createStatement();
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Нет подключения к базе данных!");
		}
}
	void addHuman (Human h){
		connect ();
		String zapros;
		if (h.gender) 
			zapros="INSERT INTO people VALUES(null, '"+h.name+"', '"+h.lastname+"', "+h.height+", "+h.weight+", 'м')";
		else zapros="INSERT INTO people VALUES(null, '"+h.name+"', '"+h.lastname+"', "+h.height+", "+h.weight+", 'ж')";
		try {
			st.executeUpdate(zapros);
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Не удалось добавить в базу данных!");
		}
	}
	void selectAllHuman (){
		connect ();
		try {
			rs=st.executeQuery(select);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Не удалось прочитать из базы данных!");
		}
	}
	void closeDB(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void deleteAllHuman(){
		connect ();
		try {
			st.executeUpdate(delete);
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Не удалось удалить данные из БД!");
		}
	}
}
