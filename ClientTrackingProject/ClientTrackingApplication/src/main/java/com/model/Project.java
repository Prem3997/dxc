package com.model;

//import javax.persistence.JoinColumn;
//import javax.persistence.Entity;
//import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//@Entity
@Document
public class Project {
	@Id
	private String projectId;
	private String projectName;
	private String chapterToWhichBelongs;
	private String projectManger;
	private String projectVersion;
	private String projectStatus;
	@ManyToOne
	private Client client;
	public Project() {
		// TODO Auto-generated constructor stub
	}
	public Project(String projectId, String projectName, String chapterToWhichBelongs, String projectManger,
			String projectVersion, String projectStatus, Client client) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.chapterToWhichBelongs = chapterToWhichBelongs;
		this.projectManger = projectManger;
		this.projectVersion = projectVersion;
		this.projectStatus = projectStatus;
		this.client = client;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getChapterToWhichBelongs() {
		return chapterToWhichBelongs;
	}
	public void setChapterToWhichBelongs(String chapterToWhichBelongs) {
		this.chapterToWhichBelongs = chapterToWhichBelongs;
	}
	public String getProjectManger() {
		return projectManger;
	}
	public void setProjectManger(String projectManger) {
		this.projectManger = projectManger;
	}
	public String getProjectVersion() {
		return projectVersion;
	}
	public void setProjectVersion(String projectVersion) {
		this.projectVersion = projectVersion;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chapterToWhichBelongs == null) ? 0 : chapterToWhichBelongs.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + ((projectManger == null) ? 0 : projectManger.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((projectStatus == null) ? 0 : projectStatus.hashCode());
		result = prime * result + ((projectVersion == null) ? 0 : projectVersion.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (chapterToWhichBelongs == null) {
			if (other.chapterToWhichBelongs != null)
				return false;
		} else if (!chapterToWhichBelongs.equals(other.chapterToWhichBelongs))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		if (projectManger == null) {
			if (other.projectManger != null)
				return false;
		} else if (!projectManger.equals(other.projectManger))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (projectStatus == null) {
			if (other.projectStatus != null)
				return false;
		} else if (!projectStatus.equals(other.projectStatus))
			return false;
		if (projectVersion == null) {
			if (other.projectVersion != null)
				return false;
		} else if (!projectVersion.equals(other.projectVersion))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", chapterToWhichBelongs="
				+ chapterToWhichBelongs + ", projectManger=" + projectManger + ", projectVersion=" + projectVersion
				+ ", projectStatus=" + projectStatus + ", client=" + client + "]";
	}
	

}
