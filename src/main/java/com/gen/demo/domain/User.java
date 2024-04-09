/*
 * the below code generated by Tabnine
 */
/*
 * package com.gen.demo.domain;
 * 
 * import javax.persistence.*; import java.util.Date;
 * 
 * @Entity
 * 
 * @Table(name = "User") public class User {
 * 
 * @Id
 * 
 * @Column(name = "id", length = 36) private String id;
 * 
 * @Column(name = "name", length = 255, nullable = false) private String name;
 * 
 * @Column(name = "userName", length = 255, nullable = false, unique = true)
 * private String userName;
 * 
 * @Column(name = "email", length = 255, nullable = false, unique = true)
 * private String email;
 * 
 * @Column(name = "password", length = 255, nullable = false) private String
 * password;
 * 
 * @Column(name = "isActive", nullable = false) private boolean isActive;
 * 
 * @Column(name = "createdDate", nullable = false)
 * 
 * @Temporal(TemporalType.TIMESTAMP) private Date createdDate;
 * 
 * @Column(name = "createdBy", length = 255, nullable = false) private String
 * createdBy;
 * 
 * // Getters and setters
 * 
 * public String getId() { return id; }
 * 
 * public void setId(String id) { this.id = id; }
 * 
 * public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public String getUserName() { return userName; }
 * 
 * public void setUserName(String userName) { this.userName = userName; }
 * 
 * public String getEmail() { return email; }
 * 
 * public void setEmail(String email) { this.email = email; }
 * 
 * public String getPassword() { return password; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * public boolean isActive() { return isActive; }
 * 
 * public void setActive(boolean active) { isActive = active; }
 * 
 * public Date getCreatedDate() { return createdDate; }
 * 
 * public void setCreatedDate(Date createdDate) { this.createdDate =
 * createdDate; }
 * 
 * public String getCreatedBy() { return createdBy; }
 * 
 * public void setCreatedBy(String createdBy) { this.createdBy = createdBy; } }
 */

package com.gen.demo.domain;//entity instead domain was the package given by GPT

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "userName", unique = true, nullable = false, length = 255)
    private String userName;

    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    @Column(name = "createdDate", nullable = false)
    private Date createdDate;

    @Column(name = "createdBy", nullable = false, length = 255)
    private String createdBy;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}