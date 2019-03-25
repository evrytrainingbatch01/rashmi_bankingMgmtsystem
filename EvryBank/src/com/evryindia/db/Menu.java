//package com.evryindia.db;
//
//import java.util.Scanner;
//
//public class Menu {
//	private static void mainMenu() {
//	    while(true) {
//        	Scanner sc = new Scanner(System.in);
//
//	        int option = getOptionFromUser();
//	        switch(option) {
//	            case '1':
//	        		
//	        		System.out.println("1. Add a customer");
//	        		String password = sc.next();
//	        		System.out.println("2. Delete a customer ");
//	        		System.out.println("3. Add Money to any account ");
//	        		System.out.println("4. Approval transaction ");
//	        		System.out.println("5. Pride loan ");
//	        		System.out.println("6. View all customers");
//	                break;
//	            case '2':
//	                deleteRecord();
//	                break;
//	            case '3':
//	                updateRecord();
//	                break;
//	            case '4':
//	                return;
//	        }
//	    }
//	}
//
//	private static int getOptionFromUser() {
//		Scanner sc = new Scanner(System.in);
//		int option= sc.nextInt();
//		return option;
//	}
//
//}
