package com.cs;

import java.util.List;

import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.bean.TimeEntry;

public class ToolLaunch {

	protected ToolLaunch(String url, String userName, String password, String csvFilePatjh) throws Exception {
		LoginInfo loginInfo = new LoginInfo(url, userName, password);
		loginInfo.login();
		RedmineManager rm = loginInfo.getRedmineManager();
		List<TimeEntry> timeEntrys = new TimeEntryGenerator(csvFilePatjh).timeEntrys;
		for (TimeEntry te : timeEntrys) {
			rm.getTimeEntryManager().createTimeEntry(te);
		}
	}

}
