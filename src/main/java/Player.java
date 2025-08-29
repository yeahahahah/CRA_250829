import java.util.ArrayList;

public class Player {

// 정책
    public static final int[] WeekDayPoint = {1, 1, 3, 1, 1, 2, 2};
    public static final int grade1_point=50;
    public static final int grade2_point=30;
    public static final String[] gradeTitle={"NORMAL","GOLD","SILVER"};
       public static final Boolean[] fireGrade={true,false,false};

    private String playerName;
    private Integer points;
    private Integer grade;
    public int[] dat=new int[7];
    public boolean fireflag;

    public Player(String Name) {
        playerName=Name;
        points=0;
        grade=0;
        fireflag=false;
    }

    public void setPoints(Integer points) {
        this.points += points;
    }

    public String getPlayerName() {
        return playerName;
    }




    public void addDat(int dayIndex) {
        this.dat[dayIndex]++;
        this.setPoints(WeekDayPoint[dayIndex]);
    }


    public Integer getPoints() {
        return points;
    }


    public Integer getBonus() {

        if(this.dat[2] >9){
            this.points += 10;
        }

        if(this.dat[5] + this.dat[6] >9){
            this.points += 10;
        }

        return points;
    }

    public String ratingPlayer() {


        if (points >= grade1_point) {
            grade = 1;
        } else if (points >= grade2_point) {
            grade = 2;
        } else {
            grade = 0;
        }

        return gradeTitle[grade];

    }






    public Boolean isFireGrade(){
        return fireGrade[grade];
    }

    public Boolean isFireAttandance(){

        if ( dat[2] == 0 && dat[5] == 0 && dat[6] == 0)  return true;
        return false;
    }

    public Boolean isFire() {


        if (isFireGrade() && isFireAttandance()) {
            fireflag=true;
        }
//
        return fireflag;
    }




}
