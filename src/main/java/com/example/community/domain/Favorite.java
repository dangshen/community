package com.example.community.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Table(name = "favorite")
public class Favorite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fId;

    private List<User> users;
    private List<Moments> moments;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Moments> getMoments() {
        return moments;
    }

    public void setMoments(List<Moments> moments) {
        this.moments = moments;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "fId=" + fId +
                ", users=" + users +
                ", moments=" + moments +
                '}';
    }
}
