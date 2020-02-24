package com.model;

import org.springframework.data.annotation.Id;

public class Project {
	@Id
	private String projectId;
	private String projectName;
	private String chapterToWhichBelongs;
	private String projectManager;
	private String projectVersion;
	private String projectStatus;
	//private Client client;
	public Project() {
		// TODO Auto-generated constructor stub
	}
	public Project(String projectId, String projectName, String chapterToWhichBelongs, String projectManager,
			String projectVersion, String projectStatus) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.chapterToWhichBelongs = chapterToWhichBelongs;
		this.projectManager = projectManager;
		this.projectVersion = projectVersion;
		this.projectStatus = projectStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chapterToWhichBelongs == null) ? 0 : chapterToWhichBelongs.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + ((projectManager == null) ? 0 : projectManager.hashCode());
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
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		if (projectManager == null) {
			if (other.projectManager != null)
				return false;
		} else if (!projectManager.equals(other.projectManager))
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
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
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
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", chapterToWhichBelongs="
				+ chapterToWhichBelongs + ", projectManager=" + projectManager + ", projectVersion=" + projectVersion
				+ ", projectStatus=" + projectStatus + "]";
	}
	

	

}
