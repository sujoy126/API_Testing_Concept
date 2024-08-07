package practice_Serialization_Deserialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NfsMostWanted implements Serializable {
	 String name;
	 int level;
	 long score;
	 int life;
	 
	 public NfsMostWanted() {}
	 
	 public NfsMostWanted(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}	
}


public class Run1_Serialization {
	public static void main(String[] args) throws Throwable{
		NfsMostWanted user1obj = new NfsMostWanted("Sujoy", 10, 80000 , 1);
		FileOutputStream fos= new FileOutputStream("./NfsData.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fos);
		objout.writeObject(user1obj);
		System.out.println("===========end=========");
	}

}
