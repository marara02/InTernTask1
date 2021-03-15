package com.coffeetarget.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "mark")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "markName")
    private String markName;

    @Column(name = "sizeID")
    private int sizeID;

    @Column(name = "sortID")
    private int sortID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public void setSortID(int sortID) {
        this.sortID = sortID;
    }

    public int getSortID() {
        return sortID;
    }

    public int getSizeID() {
        return sizeID;
    }

    public void setSizeID(int sizeID) {
        this.sizeID = sizeID;
    }
}
