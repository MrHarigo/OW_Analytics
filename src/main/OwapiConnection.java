package main;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

import java.net.URL;
import java.net.URLConnection;

public class OwapiConnection {

    final private String BASE_ADDRESS = "https://owapi.net/api/v3/u/";
    final private String JSON_FILENAME = "jsonData.json";
    private JsonParser jsonParser;
    private URLConnection connection;

    private void initialize() throws IOException {
        establishConnection();
        jsonParser = new JsonParser();
    }

    public File getData() throws IOException {
        if (fileIsAvailable(JSON_FILENAME)) return new File(JSON_FILENAME);
        return writeJsonToFile(JSON_FILENAME,getJsonData());
    }

    public JsonObject getJsonData() throws IOException {
        initialize();
        connection.connect();
        JsonElement root = jsonParser.parse(new InputStreamReader((InputStream) connection.getContent()));
        return root.getAsJsonObject();
    }

    public void establishConnection() throws IOException {
        URL url = new URL(BASE_ADDRESS + "Harigo-21704/stats");
        connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 " +
                "(KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

    }

    public boolean fileIsAvailable(String filename){
        return new File(filename).isFile();
    }

    public File writeJsonToFile(String filename, JsonObject jsonObject) throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File(filename);
        PrintWriter writer = new PrintWriter(file.getName(), "UTF-8");
        writer.write(jsonObject.toString());
        writer.close();
        return file;
    }
}
