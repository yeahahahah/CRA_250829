import java.io.*;
import java.util.*;




public class Attendance {

    public static Map<Integer, Player> playerList ;

      static Map<String, Integer> playerIDList = new HashMap<>();
    static int idCnt = 0;


    static String[] playerName = new String[100];



    public static Integer getPlayerID(String playerName) {
        if (!playerIDList.containsKey(playerName)) {
            playerIDList.put(playerName, ++idCnt);
            Attendance.playerName[idCnt] = playerName;
            playerList.put(idCnt,new Player(playerName));
        }
        return playerIDList.get(playerName);
    }




    public static Integer getPlayerPoint(String playerName){

        int id=getPlayerID(playerName);
       return playerList.get(id).getPoints();

    }


    public static void addAttendancePoint(String playerName, String attendWeekDay) {

        int dayIdx = 0;
        int playerID=getPlayerID(playerName);
        dayIdx = getWeekNum(attendWeekDay);
        playerList.get(playerID).addDat(dayIdx);



    }



    private static int getWeekNum(String attendWeekDay) {
        int index=0;
        switch (attendWeekDay) {
            case "monday":
                index = 0;
                break;
            case "tuesday":
                index = 1;
                break;
            case "wednesday":
                index = 2;
                break;
            case "thursday":
                index = 3;
                break;
            case "friday":
                index = 4;
                break;
            case "saturday":
                index = 5;
                break;
            case "sunday":
                index = 6;
                break;
        }
        return index;
    }

    public static void chechkingAttendance() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/attendance_weekday_500.txt"))) {
            for (int i = 0; i < 500; i++) {
                String line = br.readLine();
                if (line == null) break;
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    addAttendancePoint(parts[0], parts[1]);

                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void firePlayer() {

        System.out.println();
        System.out.println("Removed player");
        System.out.println("==============");

        for (Player player : playerList.values()) {
            if(player.isFire()) System.out.println(player.getPlayerName());
        }
    }


    public static void ratingPlayer() {

        for (Player player : playerList.values()) {
            System.out.print("NAME : " + player.getPlayerName() + ", ");
            System.out.print("POINT : " + player.getPoints() + ", ");
            System.out.println("GRADE : " +  player.ratingPlayer());
        }


    }




    public static void addBonusPoint() {
        for (Player player : playerList.values()) {
            player.getBonus();
        }

    }

    public static void main(String[] args) {
        playerList =  new HashMap<>();

        chechkingAttendance();
        addBonusPoint();
        ratingPlayer();
        firePlayer();
    }


}