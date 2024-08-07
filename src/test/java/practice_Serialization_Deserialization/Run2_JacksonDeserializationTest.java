package practice_Serialization_Deserialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run2_JacksonDeserializationTest {
	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		ObjectMapper objM = new ObjectMapper();
		File fil = new File("./Jacksonproject3.json");
		Project1 pobj1 = objM.readValue(fil,Project1.class);
		System.out.println(pobj1.getProjectName());
		System.out.println(pobj1.getCreatedBy());
		System.out.println(pobj1.getTeamSize());
		System.out.println(pobj1.getStatus());
	}

}
