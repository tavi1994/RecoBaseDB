package com.qa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Record {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	Long id;
	String label;
	String title;
	String artist;
	int year;
	int value;

	public Record() {
		super();
	}

	public Record(String label, String title, String artist, int year, int value) {
		super();
		this.label = label;
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.value = value;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setRecord(Record record) {
		this.label = record.label;
		this.title = record.title;
		this.artist = record.artist;
		this.year = record.year;
		this.value = record.value;
	}
}
