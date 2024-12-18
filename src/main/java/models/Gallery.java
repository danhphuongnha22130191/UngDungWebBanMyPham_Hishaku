package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GALLERY")
public class Gallery implements Serializable{
	private static final long serialVersionUID = -7810072010082294351L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "TYPE", columnDefinition = "varchar(20)")
	private String type;
	@Column(name = "DATA")
	private byte[] data;
}