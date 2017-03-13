package com.babar.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author babar
 * @since 2/26/17.
 */
@Entity
public class Client{

    @Id
    @GeneratedValue
    private int id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(unique = true)
    private String phone;

    private Date entryDate;

    @ManyToMany
    @JoinTable(
            name = "client_question_paper",
            joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "question_paper_id")}
    )
    private List<QuestionPaper> questionPapers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public List<QuestionPaper> getQuestionPapers() {
        return questionPapers;
    }

    public void setQuestionPapers(List<QuestionPaper> questionPapers) {
        this.questionPapers = questionPapers;
    }
}

