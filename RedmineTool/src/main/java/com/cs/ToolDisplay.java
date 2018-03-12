package com.cs;

import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ToolDisplay {
	private  final String note = "UserID,Date,Hours,IssueID";
	
	JLabel jLabelUrl = new JLabel("URL:");
	JLabel jLabelUserName = new JLabel("UserName:");
	JLabel jLabelPwd = new JLabel("Password:");
	JLabel jLabelPath = new JLabel("CsvFilePath:");
	JLabel jlableNode = new JLabel(note);
	JButton jBtnRun = new JButton("Run");
	TextField urlTextField = new TextField(10);
	TextField userNameTextField = new TextField(20);
	TextField passwordTextField = new TextField(20);
	TextField csvFilePathField = new TextField(20);
	JFrame jFrame = new JFrame("RedmineTool");

	public static void main(String[] args) {
		ToolDisplay a = new ToolDisplay();
		a.display();
	}

	private void display() {
		jFrame.setLayout(new FlowLayout());
		jFrame.add(jLabelUrl);
		jFrame.add(urlTextField);
		urlTextField.setText("http://10.39.107.79/redmine/");
		jFrame.add(jLabelUserName);
		jFrame.add(userNameTextField);
		jFrame.add(jLabelPwd);
		jFrame.add(passwordTextField);
		jFrame.add(jLabelPath);
		jFrame.add(csvFilePathField);
		jFrame.add(jlableNode);
		jFrame.add(jBtnRun);
		jBtnRun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ToolLaunch tool = new ToolLaunch(urlTextField.getText(), userNameTextField.getText(),
							passwordTextField.getText(), csvFilePathField.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
		jFrame.setLocation(500, 500);
		this.jFrame.setSize(1030, 100);
		this.jFrame.setResizable(false);
		jFrame.setVisible(true);

	}

}
