package com.cs;

import java.util.Date;

public class TimeEntryInfo {

	Integer activityId;
	Float hours;
	Integer projectId;
	Integer issueId;
	Integer userId;
	Date spentOn;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Float getHours() {
		return hours;
	}

	public void setHours(Float hours) {
		this.hours = hours;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getSpentOn() {
		return spentOn;
	}

	public void setSpentOn(Date spentOn) {
		this.spentOn = spentOn;
	}

	@Override
	public String toString() {
		return "ActiviltyId:" + activityId + " Hours:" + hours + " ProjectId:" + projectId + " IssueId:" + issueId
				+ " UserId:" + userId + " SpentOn:" + spentOn;
	}

}
