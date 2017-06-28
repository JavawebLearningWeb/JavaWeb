package Page;

/**
 * Created by 79333 on 2017/6/26.
 */
public class AddcoursePage {
    private String id;
    private String teacherid;
    private String result;
    private String course;

    public String getCourse(){ return course; }

    public void setCourse(String course){this.course = course;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
