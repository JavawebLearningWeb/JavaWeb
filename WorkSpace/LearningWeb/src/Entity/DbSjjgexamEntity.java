package Entity;

import javax.persistence.*;

/**
 * Created by ycbhci on 2017/6/24.
 */
@Entity
@Table(name = "db_sjjgexam", schema = "database_rjxt", catalog = "")
public class DbSjjgexamEntity {
    private String id;
    private String answer;
    private String address;

    @Id
    @Column(name = "id", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "answer", nullable = false, length = 50)
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DbSjjgexamEntity that = (DbSjjgexamEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
