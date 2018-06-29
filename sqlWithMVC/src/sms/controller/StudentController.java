package sms.controller;

import java.util.Scanner;

import sms.action.Action;

public class StudentController {
	public void requestProcess(Action action, Scanner sc) {
		try {
			action.excute(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
