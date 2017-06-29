package Page;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by 79333 on 2017/6/29.
 */
public class RelationPage {
    private String id;
    private String courseid;
    private String frontcourseid;

    public String getFrontcourseid() {
        return frontcourseid;
    }

    public void setFrontcourseid(String frontcourseid) {
        this.frontcourseid = frontcourseid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {this.courseid = courseid;}

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}
}
