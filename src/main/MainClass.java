package main;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        OwapiConnection conn = new OwapiConnection();
        conn.getData();
    }
}
