package com.vti.ki4m.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Target")
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "TargetName", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "CompletionRate", length = 100, nullable = false, unique = true)
    private String completionRate;

    @Column(name = "Image", length = 200)
    private String image;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "AccountId", nullable = false)
//    private Account account;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "CategoryId", nullable = false)
//    private Category category;

    @Column(name = "TargetDateCompleted", length = 50, nullable = false, unique = true)
    private Date dateCompleted;

    public Target() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(String completionRate) {
        this.completionRate = completionRate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}
