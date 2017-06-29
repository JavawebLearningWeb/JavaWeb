package Page;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * Created by 79333 on 2017/6/26.
 */
public class AddcoursePage {
    private String id;
    private String teacherid;
    private String result;
    private String course;
    private String precourseid1;
    private String precourseid2;
    private String precourseid3;
    private String precourseid4;


    public String getPrecourseid1() {
        return precourseid1;
    }

    public void setPrecourseid1(String precourseid1) {
        this.precourseid1 = precourseid1;
    }


    public String getPrecourseid2() {
        return precourseid2;
    }

    public void setPrecourseid2(String precourseid2) {
        this.precourseid2 = precourseid2;
    }


    public String getPrecourseid3() {
        return precourseid3;
    }

    public void setPrecourseid3(String precourseid3) {
        this.precourseid3 = precourseid3;
    }


    public String getPrecourseid4() {
        return precourseid4;
    }

    public void setPrecourseid4(String precourseid4) {
        this.precourseid4 = precourseid4;
    }

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
