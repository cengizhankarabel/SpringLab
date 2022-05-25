package com.karabel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="accounts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
	@Id
	private String number;
	private double balance;
}
