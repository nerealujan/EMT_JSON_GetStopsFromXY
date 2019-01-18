package emt2;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsearJSON {

	public void getDatos(String json) {
		// TODO Auto-generated method stub
		
		double latitud = (double) 0;
		double longitud = (double) 0;
		String stopId = "";
		String postalAddress = "";
		String lineId = "";
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject objeto_json = (JSONObject)parser.parse(json); 
			
			JSONArray lista_paradas = (JSONArray) objeto_json.get("stop");
			
			for (int i = 0; i < lista_paradas.size(); i++) 
			{
				ArrayList<String> lista_lineId=new ArrayList<>();
				
				JSONObject objeto_parada =(JSONObject)lista_paradas.get(i);
				stopId = (String)objeto_parada.get("stopId");
				postalAddress = (String)objeto_parada.get("postalAddress");
				latitud = (Double)objeto_parada.get("latitude"); 
				longitud = (Double)objeto_parada.get("longitude");
				
				Object objeto_varios=objeto_parada.get("line");
				
				if (objeto_varios instanceof JSONArray)
                {
                        JSONArray lista_lineas=(JSONArray)objeto_parada.get("line");
                        for(int j=0;j<lista_lineas.size(); j++)
                        {
                            JSONObject objeto_linea=(JSONObject) lista_lineas.get(j);
                             lineId=(String)objeto_linea.get("line");
                            lista_lineId.add(lineId);
                        }

                }
                else
                {
                    JSONObject  objeto_linea=(JSONObject) objeto_parada.get("line");
                    lineId=(String)objeto_linea.get("line");
                    lista_lineId.add(lineId);

                 }
				
				System.out.println("Numero de parada: "+stopId+"\nDirección de la parada: "+postalAddress+"\nLatitud: "+latitud+"\nLongitud: "+longitud+"\nLineas: "+lista_lineId);
				
			}
			
			
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

}
