package practice_Serialization_Deserialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Run2_Deserialization {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./NfsData.txt");
		ObjectInputStream objInput = new ObjectInputStream(fis);
		
		NfsMostWanted user2obj = (NfsMostWanted) objInput.readObject();
		System.out.println(user2obj.name);
		System.out.println(user2obj.level);
		System.out.println(user2obj.score);
		System.out.println(user2obj.life);
		
	}

}
