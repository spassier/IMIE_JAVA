package fr.imie.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "personne" database table.
 * 
 */
@Entity
@Table(name="personne")
@NamedQueries({
@NamedQuery(name="Personne.findAll", query="SELECT p FROM Personne p"),
@NamedQuery(name="Personne.findByPromotion", query="SELECT p FROM Personne p, Promotion pr WHERE pr.id = :promoId")
//@NamedQuery(name="PersonnefindPromotionById", query="SELECT pr from Personne p WHERE p.id = :promoId")

})
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="datenaiss")
	private Date datenaiss;

	@Column(name="nom")
	private String nom;

	@Column(name="password")
	private String password;

	@Column(name="prenom")
	private String prenom;

	//@Column(name="promotion_id")
	//private int promotionId;
	
	@ManyToOne
	@JoinColumn(name="promotion_id")
	private Promotion promotion;
	
	@Column(name="tel")
	private String tel;

	public Personne() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatenaiss() {
		return this.datenaiss;
	}

	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/*
 	public int getPromotionId() {
		return this.promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}
	*/
	
	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	 
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}