package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //User 클래스가 MySQL에  테이블이 생성 
//@DynamicInsert //insert시에 null인 필드를 제외시켜준다. 
public class User {
    
	@Id //Primary key 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
    
	@Column(nullable = false, length = 30,unique = true)
	private String username; 
	
	@Column(nullable = false, length = 100)
	private String password; 
	
	@Column(nullable = false, length = 50)
	private String email; 
	//@ColumnDefault("user")
	//DB는 RoleType이라는게 없다. 
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋
	
	private String oauth; 
	
	@CreationTimestamp 
	private Timestamp createDate;
}
