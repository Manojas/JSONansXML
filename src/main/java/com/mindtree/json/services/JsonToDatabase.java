package com.mindtree.json.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.mindtree.json.utility.GetConnection;

public class JsonToDatabase {

	public String jsonToDatabase()
	{
		String Str = null;
		JSONParser jsonParser = new JSONParser();
		try {
			// Parsing the contents of the JSON file
			JSONObject jsonObject = (JSONObject) jsonParser
					.parse(new FileReader("D:/PlayerDetails2.json"));
			// Retrieving the array
			System.out.println(jsonObject);
			JSONArray jsonArray = (JSONArray) jsonObject.get("PlayerDetails");
			System.out.println(jsonArray);
			Connection con = GetConnection.getConnection();
			// Insert a row into the MyPlayers table
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO player2 values (?, ?, ?)");
			for (Object object : jsonArray) {
				JSONObject record = (JSONObject) object;
				
				//int id = Integer.parseInt((String) record.get("ID"));
				
				int id = Integer.parseInt((String) record.get("PlayerID"));
				int age = Integer.parseInt((String) record.get("PlayerAge"));
				String name = (String) record.get("PlayerName");
			
				pstmt.setInt(1, id);
				pstmt.setInt(2, age);
				pstmt.setString(3, name);
		
				pstmt.executeUpdate();
			}
			System.out.println("Records inserted.....");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {   
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Str;
		
	}
}
