package human;

import java.util.Random;

public abstract class Human {
	Random rnd=new Random();
	boolean gender;
	String name, lastname;
	float height, weight;
	float chance=rnd.nextFloat();
	
	Human (boolean gender,String name,String lastname,float height,float weight){
	this.gender=gender;
	this.name=name;
	this.lastname=lastname;
	this.height=height;
	this.weight=weight;
}
	Human (boolean gender,String lastname,float height,float weight){
		this.gender=gender;
		this.lastname=lastname;
		this.height=height;
		this.weight=weight;
	}

abstract boolean speak(Human h);
abstract boolean tolerante(Human h);

boolean spendTimeTogether (Human h){
	float razn=Math.abs(height-h.height);
	float percent10=height/10;
	if ((percent10<razn)&(chance>0.85)) return false;
	if ((percent10>razn)&(chance>0.95)) return false;
	else return true;
}
abstract Human haveRelations(Human h);

abstract Human newHuman(boolean gend, String lstName, float rst, float vs);

static Human test(Human a, Human b){
	if (!a.gender&!b.gender)return a.haveRelations(b);
	else if (!a.gender&b.gender)return a.haveRelations(b);
	else if (a.gender&!b.gender)return a.haveRelations(b);
	else return a.haveRelations(b);
	
}

}
