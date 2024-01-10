package com.example.demo.bean;

import java.util.Date;

import lombok.Data;

@Data
public class PublicationBean {
	
	Long id ;
	Date date;
	String titre;
	String lien;
	String type;
	String sourcepdf;
	

}
