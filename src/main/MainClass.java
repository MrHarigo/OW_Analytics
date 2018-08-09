package main;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        OwapiConnection conn = new OwapiConnection();
        conn.getDatafile("Harigo-21704/stats");//общая статистика
        conn.getDatafile("Harigo-21704/heroes");//статистика по героем из ранкеда
        //conn.getJsonDataByLink("Harigo-21704/stats");
    }
}
