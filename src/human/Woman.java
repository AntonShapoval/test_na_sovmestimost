package human;

public class Woman extends Human {

	Woman(boolean gender, String name, String lastname, float height, float weight) {
		super(gender, name, lastname, height, weight);
		
	}
	Woman(boolean gender, String lastname, float height, float weight) {
		super(gender, lastname, height, weight);
		
	}

	@Override
	boolean speak(Human h) {
		
		return true;
	}

	@Override
	boolean tolerante(Human h) {
		if (!h.gender&(h.chance<=0.05))  return true;
		else if (h.gender&(h.chance<=0.7)) return true;
		else  return false;
	}

	@Override
	Human haveRelations(Human h) {
		if (h.gender&&speak(h)&&tolerante(h)&&spendTimeTogether(h)){
			return newHuman(h.gender,h.lastname,h.height,h.weight);
		}
		else if(!h.gender&&speak(h)&&tolerante(h)&&spendTimeTogether(h))
		{
		Primary.w.otobragenieRezultat("������ �������!");
		return null;}
		else {if(h.gender)
		Primary.w.otobragenieRezultat("������ �� �����, �����������...");
		if (!h.gender)
		Primary.w.otobragenieRezultat("���-��, �����-�� ��������...");
		return null;}
		
	}

	Human newHuman(boolean gend, String lstName, float rst, float vs){
			float rost,ves;
		if (chance>0.5){
			Primary.w.otobragenieRezultat("�����������, � ��� �������!");
			Primary.w.vvediteImyReb("������� ��� �������!");
			rost=(float) (rst+0.1*(height-rst));
			ves=(float)(vs+0.1*(weight-vs));
			
			return new Man(true,lstName,rost,ves);
		}
		else{ 
		Primary.w.otobragenieRezultat("�����������, � ��� �������!");
		Primary.w.vvediteImyReb("������� ��� �������!");
		rost=(float) (height+0.1*(rst-height));
		ves=(float)(weight+0.1*(vs-weight));
		if (lstName.endsWith("��")) {lstName=lstName.replace("��", "��");return new Woman(false,lstName,rost,ves);}
		else if (lstName.endsWith("��")){lstName=lstName+"�";return new Woman(false,lstName,rost,ves);}
		else if (lstName.endsWith("��")){ lstName=lstName.replace("��", "��");return new Woman(false,lstName,rost,ves);}
		else if (lstName.endsWith("��")){ lstName=lstName.replace("��", "��");return new Woman(false,lstName,rost,ves);}
		else if (lstName.endsWith("��")){lstName=lstName+"�";return new Woman(false,lstName,rost,ves);}
		else return new Woman(false,lstName,rost,ves);
		}
		}
	

}
