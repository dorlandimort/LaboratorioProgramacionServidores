import java.util.LinkedList;
import java.util.List;

import org.json.*;
public class Test {

	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		JSONObject cuenta = new JSONObject();
		List<String> lista = new LinkedList<>();
		lista.add("hola");
		lista.add("mundo");
		
		try {
			cuenta.put("nombre", "hola");
			json.put("cuenta", cuenta);
			System.out.println(json.toString());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
