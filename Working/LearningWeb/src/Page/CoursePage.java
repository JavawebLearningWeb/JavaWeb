package Page;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * Created by 79333 on 2017/6/24.
 */
public class CoursePage {
    private String id;
    private String name;
    private String teacherid;
    private String introduction;
    private String picture;
    private String kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {this.kind = kind;}

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {this.picture = picture;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }
}
