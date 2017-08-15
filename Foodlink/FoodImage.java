/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodimage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author fiabci
 */
public class FoodImage {

   private final String USER_AGENT = "Mozilla/5.0";

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws org.json.JSONException
     */
    public static void main(String[] args) throws IOException, JSONException {
        FoodImage http = new FoodImage();
        http.sendGet();

    }

    private void sendGet() throws IOException, JSONException {

        String file = "/Users/fiabci/Desktop/foodlist.txt";
        BufferedReader br = null;
        FileReader fr = null;
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        String foodname;
        
        BufferedReader inFile = new BufferedReader(new FileReader(file));
        ArrayList<String> ar = new ArrayList<String>();

        String Arraylist; 
        while ((Arraylist = br.readLine()) != null) 
        {
            ar.add(Arraylist);
        }
        for (int i=0; i < ar.size(); i++){
        
            String url = "https://www.googleapis.com/customsearch/v1?q=" + ar.get(i) + "&key=AIzaSyASb6H1BXb0fVLTmm0HQdE50CmPswE30LI&cx=007049906580970037433%3A1ikvw7pmkdy&num=1&searchType=image";

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            System.out.println(ar.get(i) + ":\n" + url);

            StringBuffer response;
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

            System.out.println(response.toString());

            String filename = "food.txt";
            try (PrintWriter outputStream = new PrintWriter(filename)) {
                outputStream.println(response.toString());
            }catch(IOException e){
                
            }

            String jsonData = " ";

            String line;
            br = new BufferedReader(new FileReader("food.txt"));
            while ((line = br.readLine()) != null) {
                jsonData += line + "\n";
            }
            JSONObject ki = new JSONObject(jsonData);
            JSONArray bro = ki.getJSONArray("items");
            JSONObject items = bro.getJSONObject(0);
            System.out.println("link : " + items.getString("link"));

        }
    }
}