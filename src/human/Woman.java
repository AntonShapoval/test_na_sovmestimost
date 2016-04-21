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
		Primary.w.otobragenieRezultat("Лучшие подруги!");
		return null;}
		else {if(h.gender)
		Primary.w.otobragenieRezultat("Ничего не вышло, разбежались...");
		if (!h.gender)
		Primary.w.otobragenieRezultat("Где-то, когда-то виделись...");
		return null;}
		
	}

	Human newHuman(boolean gend, String lstName, float rst, float vs){
			float rost,ves;
		if (chance>0.5){
			Primary.w.otobragenieRezultat("Поздравляем, у Вас мальчик!");
			Primary.w.vvediteImyReb("Введите имя ребенка!");
			rost=(float) (rst+0.1*(height-rst));
			ves=(float)(vs+0.1*(weight-vs));
			
			return new Man(true,lstName,rost,ves);
		}
		else{ 
		Primary.w.otobragenieRezultat("Поздравляем, у Вас девочка!");
		Primary.w.vvediteImyReb("Введите имя ребенка!");
		rost=(float) (height+0.1*(rst-height));
		ves=(float)(weight+0.1*(vs-weight));
		if (lstName.endsWith("ой")) {lstName=lstName.replace("ой", "ая");return new Woman(false,lstName,rost,ves);}
		else if (lstName.endsWith("ин")){lstName=lstName+"а";return new Woman(false,lstName,rost,ves);}
		else if (lstName.endsWith("ий")){ lstName=lstName.replace("ий", "ая");return new Woman(false,lstName,rost,ves);}
		else if (lstName.endsWith("ый")){ lstName=lstName.replace("ый", "ая");return new Woman(false,lstName,rost,ves);}
		else if (lstName.endsWith("ов")){lstName=lstName+"а";return new Woman(false,lstName,rost,ves);}
		else return new Woman(false,lstName,rost,ves);
		}
		}
	

}
