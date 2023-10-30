package com.proconsul.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

public class Tutorial implements Serializable{

	
	private static final long serialVersionUID = 8891765904214925896L;
	
	@EmbeddedId
	private TutorialId tutorialId;

	@Column(name = "language_version")
	private int languageVersion;

	@Column(name = "publishing_date")
	private Date publishingDate;

	public TutorialId getTutorialId() {
		return tutorialId;
	}

	public void setTutorialId(TutorialId tutorialId) {
		this.tutorialId = tutorialId;
	}

	public int getLanguageVersion() {
		return languageVersion;
	}

	public void setLanguageVersion(int languageVersion) {
		this.languageVersion = languageVersion;
	}

	public Date getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}

	protected Tutorial() {

	}

	public Tutorial(TutorialId tutorialId, int languageVersion, Date publishingDate) {

		this.tutorialId = tutorialId;
		this.languageVersion = languageVersion;
		this.publishingDate = publishingDate;
	}


}
