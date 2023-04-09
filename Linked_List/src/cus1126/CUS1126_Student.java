package cus1126;

public class CUS1126_Student {
    //info part
    String name;
    String Xnumber;
    double exam1score;

    //link part
    CUS1126_Student link;

    public CUS1126_Student(String nm, String xnum, double pts) {
        this.name = nm;
        this.Xnumber = xnum;
        this.exam1score = pts;
        this.link = null; //initially this points to null
    }


}
