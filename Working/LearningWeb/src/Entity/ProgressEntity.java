package Entity;

import javax.persistence.*;

/**
 * Created by ycbhci on 2017/6/26.
 */
@Entity
@Table(name = "progress", schema = "learningweb", catalog = "")
public class ProgressEntity {
    private String id;
    private String examscore;

    @Id
    @Column(name = "id", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "examscore", nullable = false, length = 50)
    public String getExamscore() {
        return examscore;
    }

    public void setExamscore(String examscore) {
        this.examscore = examscore;
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
