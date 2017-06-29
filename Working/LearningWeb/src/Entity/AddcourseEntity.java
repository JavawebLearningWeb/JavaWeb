package Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 79333 on 2017/6/26.
 */
@Entity
@Table(name = "addcourse", schema = "learningweb", catalog = "")
public class AddcourseEntity {
    private String id;
    private String result;
    private String teacherid;
    private TeacherEntity teacherEntity;
    private String course;
    private String precourseid1;
    private String precourseid2;
    private String precourseid3;
    private String precourseid4;

    @Basic
    @Column(name = "precourseid1")
    public String getPrecourseid1() {
        return precourseid1;
    }

    public void setPrecourseid1(String precourseid1) {
        this.precourseid1 = precourseid1;
    }

    @Basic
    @Column(name = "precourseid2")
    public String getPrecourseid2() {
        return precourseid2;
    }

    public void setPrecourseid2(String precourseid2) {
        this.precourseid2 = precourseid2;
    }

    @Basic
    @Column(name = "precourseid3")
    public String getPrecourseid3() {
        return precourseid3;
    }

    public void setPrecourseid3(String precourseid3) {
        this.precourseid3 = precourseid3;
    }

    @Basic
    @Column(name = "precourseid4")
    public String getPrecourseid4() {
        return precourseid4;
    }

    public void setPrecourseid4(String precourseid4) {
        this.precourseid4 = precourseid4;
    }

    @ManyToOne
    @JoinColumn(name = "teacherid", insertable=false, updatable=false)
    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }

    @Basic
    @Column(name = "teacherid")
    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "course")
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    @Basic
    @Column(name = "result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddcourseEntity that = (AddcourseEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }
}
