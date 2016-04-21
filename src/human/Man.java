package human;

public class Man extends Human {
		
	Man(boolean gender, String name, String lastname, float height, float weight) {
		super(gender, name, lastname, height, weight);
		
	}
	Man(boolean gender, String lastname, float height, float weight) {
		super(gender, lastname, height, weight);
		
	}

	@Override
	boolean speak(Human h) {
		if (h.gender&h.chance>0.5)return false;
		else return true;
	}

	@Override
	boolean tolerante(Human h) {
		if (!h.gender&(h.chance<=0.7))return true;
		else if (h.gender&(h.chance<=0.056)) return true;
		else return false;
	}

	@Override
	Human haveRelations(Human h) {
		if (!h.gender&&speak(h)&&tolerante(h)&&spendTimeTogether(h)){
			return h.newHuman(gender, lastname, height, weight);
		}
		else if(h.gender&&speak(h)&&tolerante(h)&&spendTimeTogether(h))
		{Primary.w.otobragenieRezultat("Лучшие друзья!");
		return null;}
		else {if(!h.gender)
		Primary.w.otobragenieRezultat("Ничего не вышло, разбежались...");
		if (h.gender)
		Primary.w.otobragenieRezultat("Где-то, когда-то виделись...");
		return null;}
	}

	@Override
	Human newHuman(boolean gend, String lstName, float rst, float vs) {
		
		return null;
	}

}
