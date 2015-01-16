/**
 * 
 */
package fr.imie.jdbc.DTO;

import java.util.Date;

/**
 * @author imie
 *
 */
public class PersonneDTO {

	private String nom;
	private String prenom;
	private Date dateNaiss;
	private String tel;
	private Integer Id;
	private String password;
	private String login;
	
	private PromotionDTO promotionDTO;
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the dateNaiss
	 */
	public Date getDateNaiss() {
		return dateNaiss;
	}
	/**
	 * @param dateNaiss the dateNaiss to set
	 */
	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}
	/**
	 * @return the promotionDTO
	 */
	public PromotionDTO getPromotionDTO() {
		return promotionDTO;
	}
	/**
	 * @param promotionDTO the promotionDTO to set
	 */
	public void setPromotionDTO(PromotionDTO promotionDTO) {
		this.promotionDTO = promotionDTO;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return nom;
	}
	public void setLogin(String login) {
		this.nom = login;
	}

	


}
