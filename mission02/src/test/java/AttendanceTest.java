import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AttendanceTest {



    @BeforeEach
    void setUp() {
               Attendance.playerList = new HashMap<>();
        Attendance.playerIDList = new HashMap<>();
        Attendance.idCnt = 0;
        Attendance.playerName = new String[100];
    }



    @org.junit.jupiter.api.Test
    void chechkingAttendanceandBonus_sun() {


        int expected=20;
        for(int i=0;i<10;i++){
            Attendance.addAttendancePoint("John","sunday");
        }
        Attendance.getPlayerID("John");
        assertEquals(expected,Attendance.getPlayerPoint("John"));

        Attendance.addBonusPoint();

        assertEquals(expected+10,Attendance.getPlayerPoint("John"));


    }





    @org.junit.jupiter.api.Test
    void chechkingAttendanceandBonus_sat() {

        int expected=20;
        for(int i=0;i<5;i++){
            Attendance.addAttendancePoint("Key","saturday");
            Attendance.addAttendancePoint("Key","sunday");
        }

        assertEquals(expected,Attendance.getPlayerPoint("Key"));

        Attendance.addBonusPoint();

        assertEquals(expected+10,Attendance.getPlayerPoint("Key"));


    }


    @Test
    void chechkingAttendanceandBonus_mon() {

        int expected=10;
        for(int i=0;i<10;i++){
            Attendance.addAttendancePoint("Key","monday");

        }

        assertEquals(expected,Attendance.getPlayerPoint("Key"));

        Attendance.addBonusPoint();

        assertEquals(expected,Attendance.getPlayerPoint("Key"));


    }

    @Test
    void chechkingAttendanceandBonus_daily() {

        int expected=6;

        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","tuesday");

        Attendance.addAttendancePoint("Key","thursday");
        Attendance.addAttendancePoint("Key","friday");

        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","monday");


        assertEquals(expected,Attendance.getPlayerPoint("Key"));

        Attendance.addBonusPoint();

        assertEquals(expected,Attendance.getPlayerPoint("Key"));
        Attendance.firePlayer();

        int pid=Attendance.getPlayerID("Key");
        assertTrue(  Attendance.playerList.get(pid).isFire());
    }

    @Test
    void chechkingAttendanceandBonus_daily2() {

        int expected=11;

        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","tuesday");

        Attendance.addAttendancePoint("Key","thursday");
        Attendance.addAttendancePoint("Key","friday");
        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","monday");


        for(int i=0;i<10;i++){
            Attendance.addAttendancePoint("John","sunday");
        }

        assertEquals(expected,Attendance.getPlayerPoint("Key"));

        Attendance.addBonusPoint();

        assertEquals(expected,Attendance.getPlayerPoint("Key"));
        Attendance.firePlayer();

        int pid=Attendance.getPlayerID("Key");
        assertTrue(  Attendance.playerList.get(pid).isFire());
    }




    @Test
    void chechkingAttendanceandBonus_sun2() {

        int expected=12;

        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","tuesday");

        Attendance.addAttendancePoint("Key","thursday");
        Attendance.addAttendancePoint("Key","friday");
        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","monday");
        Attendance.addAttendancePoint("Key","sunday");


        assertEquals(expected,Attendance.getPlayerPoint("Key"));

        Attendance.addBonusPoint();

        assertEquals(expected,Attendance.getPlayerPoint("Key"));
        Attendance.firePlayer();

        int pid=Attendance.getPlayerID("Key");
        assertFalse(  Attendance.playerList.get(pid).isFire());
    }


    @Test
    void rating1() {


        int expected=55;
        for(int i=0;i<11;i++){
            Attendance.addAttendancePoint("John","wednesday");
            Attendance.addAttendancePoint("John","sunday");
        }
        Attendance.getPlayerID("John");
        assertEquals(expected,Attendance.getPlayerPoint("John"));

        Attendance.addBonusPoint();

        assertEquals(expected+20,Attendance.getPlayerPoint("John"));

        Attendance.ratingPlayer();;

        int pid=Attendance.getPlayerID("John");
        assertEquals("GOLD", Attendance.playerList.get(pid).ratingPlayer());

    }

    @Test
    void rating2() {


        int expected=30;
        for(int i=0;i<10;i++){
            Attendance.addAttendancePoint("John","sunday");
            Attendance.addAttendancePoint("John","monday");
        }
        Attendance.getPlayerID("John");
        assertEquals(expected,Attendance.getPlayerPoint("John"));

        Attendance.addBonusPoint();

        assertEquals(expected+10,Attendance.getPlayerPoint("John"));

        Attendance.ratingPlayer();;

        int pid=Attendance.getPlayerID("John");
        assertEquals("SILVER", Attendance.playerList.get(pid).ratingPlayer());

    }


    @Test
    void rating3() {


        int expected=18;
        for(int i=0;i<9;i++){
            Attendance.addAttendancePoint("John","tuesday");
            Attendance.addAttendancePoint("John","monday");
        }
        Attendance.getPlayerID("John");
        assertEquals(expected,Attendance.getPlayerPoint("John"));

        Attendance.addBonusPoint();

        assertEquals(expected,Attendance.getPlayerPoint("John"));

        Attendance.ratingPlayer();;

        int pid=Attendance.getPlayerID("John");
        assertEquals("NORMAL", Attendance.playerList.get(pid).ratingPlayer());

    }

}