package Page;

/**
 * Created by Administrator on 2017/6/26.
 */
public class Course {
    CoursePage cp;
    private String tusername;
    private String tname;
    private int cnum;

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public CoursePage getCp() {
        return cp;
    }

    public void setCp(CoursePage cp) {
        this.cp = cp;
    }

    public String getTusername() {
        return tusername;
    }

    public void setTusername(String tusername) {
        this.tusername = tusername;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}