package socialNetwork.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import socialNetwork.model.Entreprise;
import socialNetwork.model.EntrepriseSecteurActivite;
import socialNetwork.model.SecteurActivite;
import socialNetwork.repository.IEntrepriseRepository;
import socialNetwork.repository.IEntrepriseSecteurActiviteRepository;
import socialNetwork.repository.IOffreEmploiRepository;
import socialNetwork.repository.ISecteurActiviteRepository;

@SpringBootTest
class SocialNetworkV1ApplicationTests {
	
		@Autowired
		private IEntrepriseRepository entrepriseRepo;
		@Autowired
		private ISecteurActiviteRepository secteurActiviteRepo;
		@Autowired
		private IEntrepriseSecteurActiviteRepository entrepriseSecteurActiviteRepo;
		@Autowired
		private IOffreEmploiRepository offreEmploiRepo;


		@Test
		void testEntreprise() throws ParseException {
			
//			Entreprise entreprise1 = new Entreprise();
//			entreprise1 = entrepriseRepo.findById(1L).get();
//			entrepriseRepo.delete(entreprise1);
			
			int start = entrepriseRepo.findAll().size();
			
			String str = "05/07/1985";
		    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(str);

			Entreprise entreprise1 = new Entreprise();
			entreprise1.setNom("Entreprise 1");
			entreprise1.setNombreEmployes(5000L);
			entreprise1.setPresentation("Présentation bidon");
			entreprise1.setSiteWeb("entreprise-bidon.fr");
			entreprise1.setDateCreation(date);
			

			entreprise1 = entrepriseRepo.save(entreprise1);

			entreprise1 = entrepriseRepo.findById(entreprise1.getId()).get();

			assertEquals("Entreprise 1", entreprise1.getNom());
			assertEquals(5000L, entreprise1.getNombreEmployes());
			assertEquals("Présentation bidon", entreprise1.getPresentation());
			assertEquals("entreprise-bidon.fr", entreprise1.getSiteWeb());
			assertEquals(date, entreprise1.getDateCreation());

			str = "11/08/1988";
		    date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
			
			entreprise1.setNom("Entreprise 2");
			entreprise1.setNombreEmployes(55000L);
			entreprise1.setPresentation("Présentation encore plus bidon");
			entreprise1.setSiteWeb("entreprise-vraiment-bidon.fr");
			entreprise1.setDateCreation(date);
			
			entreprise1 = entrepriseRepo.save(entreprise1);
			
			entreprise1 = entrepriseRepo.findById(entreprise1.getId()).get();
			
			assertEquals("Entreprise 2", entreprise1.getNom());
			assertEquals(55000L, entreprise1.getNombreEmployes());
			assertEquals("Présentation encore plus bidon", entreprise1.getPresentation());
			assertEquals("entreprise-vraiment-bidon.fr", entreprise1.getSiteWeb());
			assertEquals(date, entreprise1.getDateCreation());


			int end = entrepriseRepo.findAll().size();

			assertEquals(1, end - start);

			entrepriseRepo.delete(entreprise1);

			Optional<Entreprise> optEntreprise = entrepriseRepo.findById(entreprise1.getId());

			if (optEntreprise.isPresent()) {
				fail("Suppression lieu en erreur");
			}
	}
		
		@Test
		public void testEntrepriseSecteurActivite() throws ParseException {
			String str = "05/07/1985";
		    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
			
			// Arrange
			Entreprise entreprise1 = new Entreprise();
			entreprise1.setNom("Entreprise 1");
			entreprise1.setNombreEmployes(5000L);
			entreprise1.setPresentation("Présentation bidon");
			entreprise1.setSiteWeb("entreprise-bidon.fr");
			entreprise1.setDateCreation(date);
			
			entreprise1 = entrepriseRepo.save(entreprise1);

			SecteurActivite secteurActivite = new SecteurActivite();
			secteurActivite.setNom("Hôtellerie");
			
			secteurActivite = secteurActiviteRepo.save(secteurActivite);

			// Act
			EntrepriseSecteurActivite entrepriseSecteurActivite = new EntrepriseSecteurActivite(entreprise1,secteurActivite);
			entrepriseSecteurActivite = entrepriseSecteurActiviteRepo.save(entrepriseSecteurActivite);

			// Assert
			int size = entrepriseSecteurActiviteRepo.findAllByEntreprise(entreprise1.getId()).size();

			assertEquals(1, size);
		}
	
}
