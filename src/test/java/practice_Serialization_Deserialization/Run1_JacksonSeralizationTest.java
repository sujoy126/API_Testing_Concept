package practice_Serialization_Deserialization;

import java.io.File;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(
		value = {
				  "createdBy",
				  "projecctName",
				  "teamSize",
				  "status"
		}
		)
@JsonIgnoreProperties(
		value= {
				"teamSize"
		},allowSetters = true // allowsetters is optional
		)



class Project1 {
	 @JsonProperty(value="project Name")
	 private String projectName;
	 @JsonProperty(value="created By")
	 private String createdBy;
	 private int teamSize;
	 private String status;
	public Project1(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}
	public Project1() {}  //For Creating instance of the class
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 	 
 }


public class Run1_JacksonSeralizationTest {
	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		Project1 pobj =new Project1("TeamWork", "Sujoy", 20, "Created");
		ObjectMapper objM = new ObjectMapper();
		File fl = new File("./Jacksonproject3.json");
		objM.writeValue(fl, pobj);
		System.out.println("========end===========");
	}

}
