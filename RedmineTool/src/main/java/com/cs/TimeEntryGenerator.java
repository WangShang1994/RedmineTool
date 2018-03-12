package com.cs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.taskadapter.redmineapi.bean.TimeEntry;
import com.taskadapter.redmineapi.bean.TimeEntryFactory;

public class TimeEntryGenerator {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	protected static List<TimeEntry> timeEntrys = new ArrayList<>();

	public TimeEntryGenerator(String csvFilePath) throws Exception {
		List<TimeEntryInfo> timeEntryInfos = readFile(csvFilePath);
		for (TimeEntryInfo tei : timeEntryInfos) {
			TimeEntry te = TimeEntryFactory.create();
			te.setActivityId(tei.getActivityId());
			te.setHours(tei.getHours());
			te.setProjectId(tei.getProjectId());
			te.setSpentOn(tei.getSpentOn());
			te.setUserId(tei.getUserId());
			te.setIssueId(tei.getIssueId());
			System.out.println("LogTime:" + tei.toString());
			timeEntrys.add(te);
		}
	}

	@SuppressWarnings("resource")
	private List<TimeEntryInfo> readFile(String path) throws Exception {
		File csv = new File(path);
		BufferedReader br;
		List<TimeEntryInfo> rsList = new ArrayList<>();
		br = new BufferedReader(new FileReader(csv));
		String line;
		String everyLine;
		while ((line = br.readLine()) != null) {
			everyLine = line;
			String[] infos = everyLine.split(",");
			TimeEntryInfo tei = new TimeEntryInfo();
			tei.setActivityId(Integer.valueOf(infos[4]));
			Float hours = Float.valueOf(infos[2]);
			BigDecimal b = new BigDecimal(hours);
			float f1 = b.setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
			tei.setHours(f1);
			tei.setIssueId(Integer.valueOf(infos[3]));
			tei.setProjectId(3);
			tei.setSpentOn(sdf.parse(infos[1]));
			tei.setUserId(Integer.valueOf(infos[0]));
			rsList.add(tei);
		}
		return rsList;
	}

}
