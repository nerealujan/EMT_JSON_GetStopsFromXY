package emt2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Scanner;



public class ClasePrincipal {

	private static String latitud, longitud, radio;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce la latitud");
		latitud = sc.nextLine();
		
		System.out.println("Introduce la longitud");
		longitud = sc.nextLine();
		
		System.out.println("Introduce el radio");
		radio = sc.nextLine();
		
		String json = "";
		
		PeticionPost peticion;
		
		try {
			peticion = new PeticionPost("https://openbus.emtmadrid.es:9443/emt-proxy-server/last/geo/GetStopsFromXY.php");
			
			peticion.add("idClient", "WEB.SERV.ataraxa@hotmail.com" );
			peticion.add("passKey","83D88CD0-8A9B-4CE6-B976-B922B61FAE6D");
			peticion.add("latitude", latitud);
			peticion.add("longitude", longitud);
			peticion.add("Radius", radio);
			
			json = peticion.getRespueta();
			
		//	System.out.println(json);
			
			ParsearJSON pj = new ParsearJSON();
			pj.getDatos(json);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
