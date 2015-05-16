package br.com.wpattern.frameworks.spring.data.entities;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.wpattern.frameworks.spring.data.utils.BaseEntities;

@Entity
@Table(name = "TB_USER")
@AttributeOverride(name = "id", column = @Column(name = "PK_ID"))
public class UserEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 201210190327L;

	@Column(name="LOGIN", length=30, nullable=false, unique=true)
	private String login;

	@Column(name="PASSWORD", length=127, nullable=false, unique=false)
	private String password;

	@Column(name="REGISTER_DATE", nullable=true, unique=false)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date registerDate;

	@Column(name="AGE", nullable=false, unique=false)
	private Integer age;

	public UserEntity() {
	}

	public UserEntity(String login, String passwd, Date registerDate, Integer age) {
		super();
		this.login = login;
		this.password = passwd;
		this.registerDate = registerDate;
		this.age = age;
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}

