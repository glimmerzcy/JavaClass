package edu.tju.reflection.entity;

import edu.tju.reflection.annotation.*;
import edu.tju.reflection.sql.SQLable;

@Table("User")
public class User implements SQLable {
	
	@PrimaryKey
	@Column("id")
    private Integer id;
	
	@PrimaryKey
	@Column("username")
    private String username;
    
	@Column("age")
    private Integer age;

    @Column("email")
    private String email;

    @Column("telephone")
    private String telephone;
    
    public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
