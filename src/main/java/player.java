public class player
{

    private String playerName;
    private Integer points;
    private Integer grade;
    public int[] dat=new int[7];

    public player(String Name) {
        playerName=Name;
        points=0;
        grade=0;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int[] getDat() {
        return dat;
    }

    public void setDat(int dayIndex) {
        this.dat[dayIndex]++;
    }



    public Integer getPoints() {
        return points;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
