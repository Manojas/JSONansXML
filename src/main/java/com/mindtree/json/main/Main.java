package com.mindtree.json.main;

import java.util.Scanner;

import com.mindtree.json.services.JsonToDatabase;
import com.mindtree.json.services.XmlToDatabase;

public class Main {
	static Scanner in=new Scanner(System.in);
public static void main(String[] args)
{
	JsonToDatabase jtd=new JsonToDatabase();
	XmlToDatabase xtd=new XmlToDatabase();
	boolean flag=true;
	do {
		System.out.println("Enter your choices");
		System.out.println("1.Json to Database");
		System.out.println("2.Xml to database");
		System.out.println("3.Database to XMl");
	
	//	String str3=QuarantineServiceInterface.getName();
		short choice=in.nextShort();
		switch(choice)
		{
		case 1:String str=jtd.jsonToDatabase();
		System.out.println(str);
		break;
		case 2:String str2=xtd.xmlToDatabase();
		System.out.println(str2);
//		break;
//		case 3:updateQuarantineDetailsBasedOnId();
//		break;
//		case 4:deleteQuarantineDetailsBasedOnId();
//		break;
		case 4:System.out.println("You are exited");
		flag=false;
		break;
		default:System.out.println("You are entered wrong choice");
		break;
		
		}
	}while(flag);
}
}
