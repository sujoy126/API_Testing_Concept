package practice_Serialization_Deserialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * { "projectName" : "orange",
 *   "projectStatus" : "created", 
 *   "teamSize" : 10,
 *   "teamMember" : ["deba", "amit", "loga"], 
 *   "projectManager": { "name": "sagar",
 *                       "empID": "td01" 
 *                      }
 * }
 *
 */

class Emp {

	String projectName;
	String projectStatus;
	int teamSize;
	List<String> teamMember;
	ProjectManager projectManager;

	public Emp(String projectName, String projectStatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}

	public List<String> getTeamMember() {
		return teamMember;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

}

class ProjectManager {

	String name;
	String empID;

	public ProjectManager(String name, String empID) {
		super();
		this.name = name;
		this.empID = empID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpID() {
		return empID;
	}

}

public class Run3_POJO {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		List<String> li = new ArrayList<>();
		li.add("Deba");
		li.add("amit");
		li.add("loga");
		ProjectManager pm = new ProjectManager("sagar", "tp01");

		Emp ep = new Emp("Orange", "Created", 10, li, pm);

		ObjectMapper objM = new ObjectMapper();
		objM.writeValue(new File("./employee1.json"), ep);
		
		System.out.println("=======closed========");

	}

}
