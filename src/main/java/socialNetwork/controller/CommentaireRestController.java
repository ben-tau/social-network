package socialNetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import socialNetwork.dto.CommentaireDto;
import socialNetwork.model.Commentaire;
import socialNetwork.service.CommentaireService;
import socialNetwork.service.PublicationService;

@RestController
@CrossOrigin(origins ="*")
public class CommentaireRestController {
	
	@Autowired
	private PublicationService publicationService;

	@Autowired
	private CommentaireService commentaireService;
	
	@GetMapping("/publications/{publicationId}/commentaires")
	public ResponseEntity<List<Commentaire>> getCommentariesByPost(@PathVariable("publicationId") Long publicationId){
		
		publicationService.getOne(publicationId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publication non trouvée avec l'id: " + publicationId));
		
		return new ResponseEntity<>(commentaireService.getCommentariesByPost(publicationId), HttpStatus.OK);
	}
	
	@GetMapping("/publications/{publicationId}/commentaires/{commentaireId}")
	public ResponseEntity<Commentaire> getOneCommentaryByPost(@PathVariable("publicationId") Long publicationId,
			@PathVariable("commentaireId") Long commentaireId){
		
		publicationService.getOne(publicationId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publication non trouvée avec l'id: " + publicationId));
		
		Commentaire commentaire = commentaireService.getOneCommentaryByPost(commentaireId, publicationId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Commentaire non trouvée avec l'id: " + commentaireId));
		
		return new ResponseEntity<>(commentaire, HttpStatus.OK);
	}
	
	@PostMapping("/publications/{publicationId}/commentaires")
	public ResponseEntity<Commentaire> save(@PathVariable("publicationId") Long publicationId, @RequestBody CommentaireDto commentaire) {
		Commentaire commentaireToSave = new Commentaire();
		
		commentaireToSave.setContenu(commentaire.getContenu());
		
		commentaireService.saveCommentaryByPost(publicationId, commentaireToSave).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publication non trouvée :" + publicationId));
		return new ResponseEntity<>(commentaireToSave, HttpStatus.OK);
	}
	
	@PutMapping("/publications/{publicationId}/commentaires/{commentaireId}")
	public ResponseEntity<Commentaire> editOneCommentaryByPost(@PathVariable("publicationId") Long publicationId,
			@PathVariable("commentaireId") Long commentaireId, @RequestBody Commentaire commentaire){
		
		publicationService.getOne(publicationId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publication non trouvée avec l'id: " + publicationId));
		
		commentaireService.editOneCommentaryByPost(commentaireId, publicationId, commentaire).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Commentaire non trouvée avec l'id: " + commentaireId));
		
		return new ResponseEntity<>(commentaire, HttpStatus.OK);
	}
	
	@DeleteMapping("/publications/{publicationId}/commentaires/{commentaireId}")
	public ResponseEntity<?> deleteOneCommentaryByPost(@PathVariable("publicationId") Long publicationId,
			@PathVariable("commentaireId") Long commentaireId){
		
		publicationService.getOne(publicationId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publication non trouvée avec l'id: " + publicationId));
		
		commentaireService.deleteOneCommentaryByPost(commentaireId, publicationId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Commentaire non trouvée avec l'id: " + commentaireId));
		
		return new ResponseEntity<>("DELETED successfully !", HttpStatus.OK);
	}
}