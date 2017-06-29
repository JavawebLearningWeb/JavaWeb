package Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 79333 on 2017/6/29.
 */
@Entity
@Table(name = "relation", schema = "learningweb", catalog = "")
public class RelationEntity {
    private String id;
    private String courseid;
    private String frontcourseid;
    private CourseEntity courseEntity;
    private CourseEntity frontcourseEntity;

    @ManyToOne
    @JoinColumn(name = "courseid", insertable=false, updatable=false)
    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    @ManyToOne
    @JoinColumn(name = "courseid", insertable=false, updatable=false)
    public CourseEntity getFrontcourseEntity() {
        return frontcourseEntity;
    }

    public void setFrontcourseEntity(CourseEntity frontcourseEntity) {
        this.frontcourseEntity = frontcourseEntity;
    }


    @Basic
    @Column(name = "frontcourseid")
    public String getFrontcourseid() {
        return frontcourseid;
    }

    public void setFrontcourseid(String frontcourseid) {
        this.frontcourseid = frontcourseid;
    }

    @Basic
    @Column(name = "courseid")
    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelationEntity that = (RelationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
