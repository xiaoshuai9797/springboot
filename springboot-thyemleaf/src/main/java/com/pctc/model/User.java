package com.pctc.model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity(name="user")
public class User {
	//public class User implements Serializable {//ehchace缓存得实现Serializable

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="name")//引号里面对应字段名
	//@NotEmpty(message="姓名不能为空")
	@NotBlank(message="姓名不能为空")
	@Length(min=2,max=6,message = "最小长度是2，最大长度是6")
	private String name;

	@Column(name="age")
	@NotNull(message="年龄不能为空")
	@Min(value=10,message = "年龄最小值为10")
	@Max(value=100,message = "年龄最大值为100")
	private Integer age;


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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("User{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append(", age=").append(age);
		sb.append('}');
		return sb.toString();
	}
}
