import java.io.*;
import java.util.*;

public class Attendance {

    static class Node {
        String w;
        String wk;
    }

    static Map<String, Integer> playerIDList = new HashMap<>();
    static int idCnt = 0;

    static int[][] dat = new int[100][100];
    static int[] points = new int[100];
    static int[] grade = new int[100];
    static String[] playerName = new String[100];

    static int[] wed = new int[100];
    static int[] weeken = new int[100];

    public static void checkingAttendance(String playerName, String attendWeekDay) {
        if (!playerIDList.containsKey(playerName)) {
            playerIDList.put(playerName, ++idCnt);
            Attendance.playerName[idCnt] = playerName;
        }
        int playerID = playerIDList.get(playerName);
        
        addAttendancePoint(attendWeekDay, playerID);
    }

    private static void addAttendancePoint(String attendWeekDay, int playerID) {
        int addPoint = 0;
        int index = 0;

        switch (attendWeekDay) {
            case "monday":
                index = 0;
                addPoint++;
                break;
            case "tuesday":
                index = 1;
                addPoint++;
                break;
            case "wednesday":
                index = 2;
                addPoint += 3;
                wed[playerID]++;
                break;
            case "thursday":
                index = 3;
                addPoint++;
                break;
            case "friday":
                index = 4;
                addPoint++;
                break;
            case "saturday":
                index = 5;
                addPoint += 2;
                weeken[playerID]++;
                break;
            case "sunday":
                index = 6;
                addPoint += 2;
                weeken[playerID]++;
                break;
        }

        dat[playerID][index]++;
        points[playerID] += addPoint;
    }

    public static void input() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/attendance_weekday_500.txt"))) {
            for (int i = 0; i < 500; i++) {
                String line = br.readLine();
                if (line == null) break;
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    checkingAttendance(parts[0], parts[1]);
                }
            }


            addBonusPoint();
            ratingPlayer();
            firePlayer();

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

            if (points[i] >= 50) {
                grade[i] = 1;
            } else if (points[i] >= 30) {
                grade[i] = 2;
            } else {
                grade[i] = 0;
            }

            System.out.print("NAME : " + playerName[i] + ", ");
            System.out.print("POINT : " + points[i] + ", ");
            System.out.print("GRADE : ");

            if (grade[i] == 1) {
                System.out.println("GOLD");
            } else if (grade[i] == 2) {
                System.out.println("SILVER");
            } else {
                System.out.println("NORMAL");
            }
        }
    }

    private static void addBonusPoint() {
        for (int i = 1; i <= idCnt; i++) {
            if (dat[i][2] > 9) {
                points[i] += 10;
            }

            if (dat[i][5] + dat[i][6] > 9) {
                points[i] += 10;
            }
        }
    }

    public static void main(String[] args) {
        input();
    }
}