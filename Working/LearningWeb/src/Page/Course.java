package Page;

/**
 * Created by Administrator on 2017/6/26.
 */
public class Course {
    CoursePage cp;
    private String tusername;
    private String tname;
    private String result;
    private String addcouid;
    private String precourse1;
    private String precourse2;

    public String getPrecourse1() {
        return precourse1;
    }

    public void setPrecourse1(String precourse1) {
        this.precourse1 = precourse1;
    }

    public String getPrecourse2() {
        return precourse2;
    }

    public void setPrecourse2(String precourse2) {
        this.precourse2 = precourse2;
    }

    public String getPrecourse3() {
        return precourse3;
    }

    public void setPrecourse3(String precourse3) {
        this.precourse3 = precourse3;
    }

    private String precourse3;
    private String precourse4;

    public String getPrecourse4() {
        return precourse4;
    }

    public void setPrecourse4(String precourse4) {
        this.precourse4 = precourse4;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    private String teacherid;
    private String kind;
    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getAddcouid() {
        return addcouid;
    }

    public void setAddcouid(String addcouid) {
        this.addcouid = addcouid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

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