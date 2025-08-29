import org.junit.jupiter.api.Assertions;

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
}