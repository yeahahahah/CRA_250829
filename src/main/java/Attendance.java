import java.io.*;
import java.util.*;




public class Attendance {

    public static Map<Integer, Player> playerList ;

    public static final int[] WeekDayPoint = {1, 1, 3, 1, 1, 2, 2};
    public static final int grade1_point=50;
    public static final int grade2_point=30;
    public static final String[] gradeTitle={"NORMAL","GOLD","SILVER"};

    static Map<String, Integer> playerIDList = new HashMap<>();
    static int idCnt = 0;

    static int[][] playerAttendanceCount = new int[100][100];
    static int[] points = new int[100];
    static int[] grade = new int[100];
    static String[] playerName = new String[100];

    static int[] wed = new int[100];
    static int[] weeken = new int[100];


    public static Integer getPlayerID(String playerName) {
        if (!playerIDList.containsKey(playerName)) {
            playerIDList.put(playerName, ++idCnt);
            Attendance.playerName[idCnt] = playerName;
            playerList.put(idCnt,new Player(playerName));
        }
        return playerIDList.get(playerName);
    }



    public Integer getPlayerPoint(int id){
        return  points[id];
    }

    public Integer getPlayerPoint(String playerName){

        int id=getPlayerID(playerName);
       return playerList.get(id).getPoints();

    }




    public static void addAttendancePoint(String playerName, String attendWeekDay) {
        int addPoint = 0;
        int index = 0;
        int playerID=getPlayerID(playerName);
        index = getWeekNum(attendWeekDay);
        playerList.get(playerID).addDat(index);
        playerList.get(playerID).setPoints(WeekDayPoint[index]);


    }

    public static void addAttendancePoint(int playerID, String attendWeekDay) {
        int addPoint = 0;
        int index = 0;

        index = getWeekNum(attendWeekDay);
        playerAttendanceCount[playerID][index]++;
        points[playerID] += WeekDayPoint[index];

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
                // addAttendancePoint(getPlayerID(parts[0]), parts[1]);
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void firePlayer() {

        ArrayList<String> firedPlayer = new ArrayList<>();

        System.out.println();
        System.out.println("Removed player");
        System.out.println("==============");

        for (int i = 1; i <=playerList.size(); i++) {
            if(playerList.get(i).isFire()) System.out.println(playerList.get(i).getPlayerName());

        }


    }

    private static void firePlayerold() {

        ArrayList<String> firedPlayer = new ArrayList<>();

        System.out.println();
        System.out.println("Removed player");
        System.out.println("==============");



        for (int i = 1; i <= idCnt; i++) {
            if (grade[i] != 1 && grade[i] != 2 && playerAttendanceCount[i][2] == 0 && playerAttendanceCount[i][5] == 0 && playerAttendanceCount[i][6] == 0) {
                firedPlayer.add(playerName[i]);
            }
        }


        for(int i=0;i<firedPlayer.size();i++){
            System.out.println(firedPlayer.get(i));
        }
    }


    private static void ratingPlayer() {

        for (int i = 1; i <=playerList.size(); i++) {
            System.out.print("NAME : " + playerList.get(i).getPlayerName() + ", ");
            System.out.print("POINT : " + playerList.get(i).getPoints() + ", ");
            System.out.println("GRADE : " +  playerList.get(i).ratingPlayer());

        }

    }




    public static void addBonusPoint() {

        for (int i = 1; i <=playerList.size(); i++) {
            playerList.get(i).getBonus();
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