package Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 79333 on 2017/6/24.
 */
@Entity
@Table(name = "progress", schema = "learningweb", catalog = "")
public class ProgressEntity {
    private String id;
    private String examscore;
    private String studentid;
    private String courseid;
    private String chapterid;

    private ChapterEntity chapterEntity;
    private StudentEntity studentEntity;
    private CourseEntity courseEntity;

    @ManyToOne
    @JoinColumn(name = "studentid", insertable=false, updatable=false)
    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    @ManyToOne
    @JoinColumn(name = "chapterid", insertable=false, updatable=false)
    public ChapterEntity getChapterEntity() {
        return chapterEntity;
    }

    public void setChapterEntity(ChapterEntity chapterEntity) {
        this.chapterEntity = chapterEntity;
    }

    @ManyToOne
    @JoinColumn(name = "courseid", insertable=false, updatable=false)
    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
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
    @Column(name = "examscore")
    public String getExamscore() {
        return examscore;
    }

    public void setExamscore(String examscore) {
        this.examscore = examscore;
    }

    @Basic
    @Column(name = "studentid")
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "courseid" )
    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    @Basic
    @Column(name = "chapterid" )
    public String getChapterid() {
        return chapterid;
    }

    public void setChapterid(String chapterid) {
        this.chapterid = chapterid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgressEntity that = (ProgressEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (examscore != null ? !examscore.equals(that.examscore) : that.examscore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (examscore != null ? examscore.hashCode() : 0);
        return result;
    }
}
