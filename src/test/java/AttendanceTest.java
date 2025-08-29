import org.junit.jupiter.api.Assertions;

class AttendanceTest {

    @org.junit.jupiter.api.Test
    void chechkingAttendance() {
        Attendance a = new Attendance();
        Attendance.addAttendancePoint(1,"Friday");
        int expected=1;
        Assertions.assertEquals(expected,a.getPlayerPoint(1));
    }
}