package Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 79333 on 2017/6/29.
 */
@Entity
@Table(name = "association", schema = "learningweb", catalog = "")
public class AssociationEntity {
    private String id;
    private String chapterid;
    private String prochapterid;

    private ChapterEntity chapterEntity;
    private ChapterEntity prochapterEntity;

    @ManyToOne
    @JoinColumn(name = "prochapterid",insertable=false,updatable=false)
    public ChapterEntity getChapterEntity() {
        return chapterEntity;
    }

    public void setChapterEntity(ChapterEntity chapterEntity) {
        this.chapterEntity = chapterEntity;
    }

    @ManyToOne
    @JoinColumn(name = "chapterid",insertable=false,updatable=false)
    public ChapterEntity getProchapterEntity() {
        return prochapterEntity;
    }

    public void setProchapterEntity(ChapterEntity prochapterEntity) {
        this.prochapterEntity = prochapterEntity;
    }

    @Basic
    @Column(name = "chapterid")
    public String getChapterid() {
        return chapterid;
    }

    public void setChapterid(String chapterid) {
        this.chapterid = chapterid;
    }

    @Basic
    @Column(name = "prochapterid")
    public String getProchapterid() {
        return prochapterid;
    }

    public void setProchapterid(String prochapterid) {
        this.prochapterid = prochapterid;
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

        AssociationEntity that = (AssociationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
