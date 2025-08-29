import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

class AttendanceTest {




    @org.junit.jupiter.api.Test
    void chechkingAttendance_Mon() {
        Attendance a = new Attendance();
        int expected=a.getPlayerPoint(1)+1;

        Attendance.addAttendancePoint(1,"monday");

        Assertions.assertEquals(expected,a.getPlayerPoint(1));
    }
    @org.junit.jupiter.api.Test
    void chechkingAttendance_Tue() {
        Attendance a = new Attendance();

        int expected=a.getPlayerPoint(1)+1;
        Attendance.addAttendancePoint(1,"tuesday");
        Assertions.assertEquals(expected,a.getPlayerPoint(1));
    }
    @org.junit.jupiter.api.Test
    void chechkingAttendance_Wed() {
        Attendance a = new Attendance();
        int expected=a.getPlayerPoint(1)+3;
        Attendance.addAttendancePoint(1,"wednesday");
           Assertions.assertEquals(expected,a.getPlayerPoint(1));
    }
    @org.junit.jupiter.api.Test
    void chechkingAttendance_Thu() {
        Attendance a = new Attendance();
        int expected=a.getPlayerPoint(1)+1;
        Attendance.addAttendancePoint(1,"thursday");
        Assertions.assertEquals(expected,a.getPlayerPoint(1));
    }
    @org.junit.jupiter.api.Test
    void chechkingAttendance_Fri() {
        Attendance a = new Attendance();
        int expected=a.getPlayerPoint(1)+1;
        Attendance.addAttendancePoint(1,"friday");

        Assertions.assertEquals(expected,a.getPlayerPoint(1));
    }
    @org.junit.jupiter.api.Test
    void chechkingAttendance_Sat() {
        Attendance a = new Attendance();
        int expected=a.getPlayerPoint(1)+2;
        Attendance.addAttendancePoint(1,"saturday");

        Assertions.assertEquals(expected,a.getPlayerPoint(1));
    }
    @org.junit.jupiter.api.Test
    void chechkingAttendance_Monday() {
        Attendance a = new Attendance();
        int expected=a.getPlayerPoint(1)+2;
        Attendance.addAttendancePoint(1,"sunday");

        Assertions.assertEquals(expected,a.getPlayerPoint(1));
    }
//
//    @org.junit.jupiter.api.Test
//    void chechkingAttendance2_mon() {
//        Attendance a = new Attendance();
//        a.players=new Players();
//        int expected=1;
//        Attendance.addAttendancePoint("John","monday");
//
//        Assertions.assertEquals(expected,a.getPlayerPoint("John"));
//    }
//
//
//    @org.junit.jupiter.api.Test
//    void chechkingAttendance2_Wed() {
//        Attendance a = new Attendance();
//        a.players=new Players();
//        int expected=3;
//        Attendance.addAttendancePoint("John","wednesday");
//
//        Assertions.assertEquals(expected,a.getPlayerPoint("John"));
//    }
//
//
//    @org.junit.jupiter.api.Test
//    void chechkingAttendance2_sat() {
//        Attendance a = new Attendance();
//        a.players=new Players();
//        int expected=2;
//        Attendance.addAttendancePoint("John","saturday");
//
//        Assertions.assertEquals(expected,a.getPlayerPoint("John"));
//    }
//
//
//    @org.junit.jupiter.api.Test
//    void chechkingAttendance2_sun() {
//        Attendance a = new Attendance();
//        a.players=new Players();
//        int expected=2;
//        Attendance.addAttendancePoint("John","sunday");
//
//        Assertions.assertEquals(expected,a.getPlayerPoint("John"));
//    }
//
    @org.junit.jupiter.api.Test
    void chechkingAttendance2andBonus_sun() {
        Attendance a = new Attendance();
        a.playerList=new HashMap<>();
         int expected=20;
        for(int i=0;i<10;i++){
            Attendance.addAttendancePoint("John","sunday");
        }

        Assertions.assertEquals(expected,a.getPlayerPoint("John"));

        Attendance.addBonusPoint();

        Assertions.assertEquals(expected+10,a.getPlayerPoint("John"));


    }


}