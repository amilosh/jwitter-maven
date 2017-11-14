package by.it.milosh.pojo;

import org.hibernate.annotations.Type;
import java.sql.Blob;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "avatar")
public class Avatar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "avatarId")
    private Long avatarId;

    @Column(name = "image")
    private java.sql.Blob image;

//    @Type(type = "java.sql.Blob")
//    private byte[] image;

    public Avatar() {
    }

    public Avatar(Long avatarId) {
        this.avatarId = avatarId;
    }

    public Avatar(Blob image) {
        this.image = image;
    }

    public Avatar(Long avatarId, Blob image) {
        this.avatarId = avatarId;
        this.image = image;
    }

    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
