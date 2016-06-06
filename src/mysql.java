
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.logging.Level; 
import java.util.logging.Logger;

import org.testng.collections.CollectionUtils;



public class mysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbURL = "jdbc:mysql://localhost:3306/hotel"; 
		String username ="root"; 
		String password = "9700"; 
		
		
		Connection dbCon = null; 
		Statement stmt = null; 
		ResultSet rs= null;
		
		
		String city=null;
		String collection=null;
		String url=null;
		
		city="Delhi";
		collection="Near Railway Station";
		url="http://www.oyorooms.com";
		
		
		String query ="select * from data"; 
		String query2="INSERT INTO data (city, collection, link) VALUES (" + "\""+ city + "\",\"" + collection + "\",\"" + url + "\")";
		
		System.out.println(query2);
		
		try { 
			//getting database connection to MySQL server 
			dbCon = DriverManager.getConnection(dbURL, username, password); 
			
			//getting PreparedStatment to execute query 
			stmt = dbCon.prepareStatement(query); 
			
			//Resultset returned by query 
			 
			
			rs=stmt.executeQuery(query);
			
			while(rs.next()){
				/*System.out.print(rs.getString("collection"));
				System.out.print("\t"+rs.getString("hotel_name")+ "\n");
				*/
				String collname=rs.getString("collection");
				switch(collname){
					
				case "Stays Near Railway Station": 
					System.out.println("db.hotels.findAndModify({query: {\"name\": \""+rs.getString("hotel_name")+"\"}, update: { $set: {\"collection.nearRailwayStation\": true}}})");
					break;
					
				case "Best for Business travellers":
					System.out.println("db.hotels.findAndModify({query: {\"name\": \""+rs.getString("hotel_name")+"\"}, update: { $set: {\"collection.businessHotels\": true}}})");
					break;
				
				case "Best For Solo Travellers": 
					System.out.println("db.hotels.findAndModify({query: {\"name\": \""+rs.getString("hotel_name")+"\"}, update: { $set: {\"collection.forSoloTravellers\": true}}})");
					break;
					
				case "Best For Couples": 
					System.out.println("db.hotels.findAndModify({query: {\"name\": \""+rs.getString("hotel_name")+"\"}, update: { $set: {\"collection.forCouples\": true}}})");
					break;
					
				case "Best For International Guests": 
					System.out.println("db.hotels.findAndModify({query: {\"name\": \""+rs.getString("hotel_name")+"\"}, update: { $set: {\"collection.forInternationalGuests\": true}}})");
					break;
					
				case "Local ID Checkins": 
					System.out.println("db.hotels.findAndModify({query: {\"name\": \""+rs.getString("hotel_name")+"\"}, update: { $set: {\"collection.localIDCheckins\": true}}})");
					break;
					
				case "Local Check-Ins Allowed": 
					System.out.println("db.hotels.findAndModify({query: {\"name\": \""+rs.getString("hotel_name")+"\"}, update: { $set: {\"collection.localIDCheckins\": true}}})");
					break;
					
				case "Most Popular OYOs": 
					System.out.println("db.hotels.findAndModify({query: {\"name\": \""+rs.getString("hotel_name")+"\"}, update: { $set: {\"collection.popularOYOs\": true}}})");
					break;
					
				case "Stays near Airport": 
					System.out.println("db.hotels.findAndModify({query: {\"name\": \""+rs.getString("hotel_name")+"\"}, update: { $set: {\"collection.nearAirport\": true}}})");
					break;
					
				case "Stays near Metro": 
					System.out.println("db.hotels.findAndModify({query: {\"name\": \""+rs.getString("hotel_name")+"\"}, update: { $set: {\"collection.nearMetro\": true}}})");
					break;
					
				case "OYOs for beach lovers": 
					System.out.println("db.hotels.findAndModify({query: {\"name\": \""+rs.getString("hotel_name")+"\"}, update: { $set: {\"collection.beachHotels\": true}}})");
					break;
					
				default:
						break;
				};
				
				
				
				
				
				
				
				
				
				
			}
			
		}
			
		catch (SQLException ex) { 
			Logger.getLogger(CollectionUtils.class.getName()).log(Level.SEVERE, null, ex); 
			} 
		finally{ 
			//close connection ,stmt and resultset here 
			}
		}

			

		
	

}
