package Page;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by 79333 on 2017/6/29.
 */
public class LearnPage {
    private String id;
    private String studentid;
    private String courseid;

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}
}
