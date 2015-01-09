/**
 * 
 */
package fr.imie.jdbc.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fr.imie.jdbc.DTO.PersonneDTO;
import fr.imie.jdbc.DTO.PromotionDTO;
import fr.imie.jdbc.ipresentation.IPresentation;
import fr.imie.jdbc.iservice.IService;
import fr.imie.jdbc.itransverse.IFactory;


/**
 * @author imie
 *
 */
public class Presentation implements IPresentation {

	IFactory factory = null;
	Scanner scanner;

	/**
	 * 
	 */
	public Presentation() {
		super();
		scanner = new Scanner(System.in);
	}
	
	public Presentation(IFactory factory)
	{
		super();
		scanner = new Scanner(System.in);
		this.factory = factory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpjdbc.presentation.IPresentation#start()
	 */
	@Override
	public void start() {

		// instantiation du service
		//IService service = Service.getInstance();
		

		// TP1
		Boolean endAppli = false;
		List<PersonneDTO> personneDTOs = null;
		Integer input = null;

		while (!endAppli) {

			System.out.println("-------------------------");
			System.out.println("1 : lister tous les users");
			System.out.println("2 : detail d'un user     ");
			System.out.println("3 : insérer un user      ");
			System.out.println("4 : supprimer un user    ");
			System.out.println("5 : modifier un user     ");
			System.out.println("6 : supprimer une promo  ");
			System.out.println("-------------------------");

			Integer menuNumber = inputInteger();
			PersonneDTO selectedPersonne = null;
			if (menuNumber == 0) {
				endAppli = true;
				break;
			}

			switch (menuNumber) {
			case 1:
				personneDTOs = viewPersonne(factory.createService() /*service*/);

				break;

			case 2:
				// TP 2
				selectedPersonne = viewAndSelectPersonne(factory.createService() /*service*/);
				System.out.format("nom : %s \nprenom :  %s\ndateNaiss : %s\ntel %s\npromotion : %s\n\n",
								selectedPersonne.getNom(), selectedPersonne
										.getPrenom(), selectedPersonne
										.getDateNaiss(), selectedPersonne
										.getTel(), selectedPersonne
										.getPromotionDTO().getLibelle());
				break;
			case 3:
				PersonneDTO personneDTO = new PersonneDTO();
				System.out.print("nom :  ");
				String nom = scanner.nextLine();
				personneDTO.setNom(nom);
				System.out.print("prenom :  ");
				String prenom = scanner.nextLine();
				personneDTO.setPrenom(prenom);
				System.out.print("tel :  ");
				String tel = scanner.nextLine();
				personneDTO.setTel(tel);
				System.out.print("date de naissance :  ");
				Date date = inputDate();
				personneDTO.setDateNaiss(date);
				//personneDTO = personneDAO.insert(personneDTO);
				
				personneDTO = factory.createService().insertPersonneDTO(personneDTO);// service.insertPersonneDTO(personneDTO);
				System.out.format("nouvel id inséré : %s\n",personneDTO.getId());
				break;

			case 4:

				selectedPersonne = viewAndSelectPersonne(factory.createService()/*service*/);
				//personneDAO.delete(selectedPersonne);
				factory.createService().deletePersonneDTO(selectedPersonne); //	service.deletePersonneDTO(selectedPersonne);
				break;

			case 5:

				selectedPersonne = viewAndSelectPersonne(factory.createService()/*service*/);
				//selectedPersonne = personneDAO.findById(selectedPersonne);
				selectedPersonne = factory.createService().findPersonneDTO(selectedPersonne); // service.findPersonneDTO(selectedPersonne);
				System.out.format("nom :  %s", selectedPersonne.getNom());
				if (questionModif()) {
					selectedPersonne.setNom(scanner.nextLine());
				}

				System.out.format("prenom :  %s", selectedPersonne.getPrenom());
				if (questionModif()) {
					selectedPersonne.setPrenom(scanner.nextLine());
				}

				System.out.format("date de naisance :  %s",
						selectedPersonne.getDateNaiss());
				if (questionModif()) {
					selectedPersonne.setDateNaiss(inputDate());
				}

				System.out.format("tel :  %s", selectedPersonne.getTel());
				if (questionModif()) {
					selectedPersonne.setTel(scanner.nextLine());
				}

				//personneDAO.update(selectedPersonne);
				factory.createService().updatePersonneDTO(selectedPersonne); //service.updatePersonneDTO(selectedPersonne);
				
				break;
			case 6:
				//List<PromotionDTO> promotionDTOs = promotionDAO.findAll();
				List<PromotionDTO> promotionDTOs = factory.createService().findAllPromotionDTO();// service.findAllPromotionDTO();
				
				Integer numLigne = 1;

				for (PromotionDTO promotionDTO : promotionDTOs) {
					System.out.format("%d : %s \n", numLigne++,
							promotionDTO.getLibelle());
				}

				input = null;
				input = inputInteger();
				PromotionDTO selectedPromotion =  promotionDTOs.get(input - 1);
				factory.createService().deletePersonneDTO(selectedPersonne);// service.deletePromotionDTO(selectedPromotion);
				
				break;
			default:
				break;
			}
		}

		System.out.println("End");

	}

	private Boolean questionModif() {
		Boolean retour = false;
		System.out.print(" || modifier le champ o/n : ");
		String input = scanner.nextLine();
		if (input.compareTo("o") == 0) {
			retour = true;
		}
		System.out.println();
		return retour;
	}

	private List<PersonneDTO> viewPersonne(IService service/*IPersonneDAO personneDAO*/) {
		List<PersonneDTO> personneDTOs;
		//personneDTOs = personneDAO.findAll();
		personneDTOs = service.getAllPersonneDTO();
		
		Integer numLigne = 1;

		for (PersonneDTO personneDTO : personneDTOs) {
			System.out.format("%d : %s | %s | %s\n", numLigne++, personneDTO
					.getNom(), personneDTO.getPrenom(), personneDTO
					.getPromotionDTO() != null ? personneDTO.getPromotionDTO()
					.getLibelle() : "");
		}
		return personneDTOs;

	}

	private PersonneDTO viewAndSelectPersonne(IService service/*IPersonneDAO personneDAO*/) {

		List<PersonneDTO> personneDTOs = viewPersonne(service/*personneDAO*/);

		Integer input = null;
		input = inputInteger();
		PersonneDTO selectedPersonne = personneDTOs.get(input - 1);
		return selectedPersonne;
	}

	private Integer inputInteger() {
		Boolean goodInput = false;
		Integer input = null;
		while (!goodInput) {
			try {
				System.out.println("saisir un numero");
				String rawInput = scanner.nextLine();
				input = Integer.valueOf(rawInput);
				goodInput = true;
			} catch (NumberFormatException e) {
				System.out.println("mauvais format");
			}
		}
		return input;
	}

	private Date inputDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Boolean goodInput = false;
		Date input = null;
		while (!goodInput) {
			try {
				String rawInput = scanner.nextLine();
				input = simpleDateFormat.parse(rawInput);
				goodInput = true;
			} catch (ParseException e) {
				System.out.println("mauvais format");
			}
		}
		return input;

	}

}
