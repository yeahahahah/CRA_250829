import java.io.*;
import java.util.*;

public class Attendance {

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
        }
        return playerIDList.get(playerName);
    }

    private static void addAttendancePoint(int playerID, String attendWeekDay) {
        int addPoint = 0;
        int index = 0;

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


        if (index == 2) wed[playerID]++;
        if (index > 4) weeken[playerID]++;
        playerAttendanceCount[playerID][index]++;
        points[playerID] += WeekDayPoint[index];
    }

    public static void chechkingAttendance() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/attendance_weekday_500.txt"))) {
            for (int i = 0; i < 500; i++) {
                String line = br.readLine();
                if (line == null) break;
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    addAttendancePoint(getPlayerID(parts[0]), parts[1]);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void firePlayer() {
        System.out.println();
        System.out.println("Removed player");
        System.out.println("==============");
        for (int i = 1; i <= idCnt; i++) {
            if (grade[i] != 1 && grade[i] != 2 && wed[i] == 0 && weeken[i] == 0) {
                System.out.println(playerName[i]);
            }
        }
    }

    private static void ratingPlayer() {
        for (int i = 1; i <= idCnt; i++) {

            if (points[i] >= grade1_point) {
                grade[i] = 1;
            } else if (points[i] >= grade2_point) {
                grade[i] = 2;
            } else {
                grade[i] = 0;
            }

            System.out.print("NAME : " + playerName[i] + ", ");
            System.out.print("POINT : " + points[i] + ", ");
            System.out.print("GRADE : ");

            System.out.println(gradeTitle[grade[i]]);

        }
    }

    private static void addBonusPoint() {
        for (int i = 1; i <= idCnt; i++) {
            if (playerAttendanceCount[i][2] > 9) {
                points[i] += 10;
            }
            if (playerAttendanceCount[i][5] + playerAttendanceCount[i][6] > 9) {
                points[i] += 10;
            }
        }
    }

    public static void main(String[] args) {
        chechkingAttendance();
        addBonusPoint();
        ratingPlayer();
        firePlayer();
    }

    static class Node {
        String w;
        String wk;
    }
}