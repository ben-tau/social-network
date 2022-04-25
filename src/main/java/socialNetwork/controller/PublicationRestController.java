package socialNetwork.controller;

import java.util.List;

import javax.validation.Valid;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import socialNetwork.dto.PublicationDto;
import socialNetwork.model.Publication;
import socialNetwork.service.PublicationService;

@Api(value = "PublicationRestController", description = "REST APIs related to Publication Entity!!!!")
@RestController
//Autorise la communication entre application (BACK-END <-> FRONT-END)
@CrossOrigin(origins = "*")
public class PublicationRestController {
	@Autowired
	PublicationService publicationService;

	// http://localhost:8080/employees
	// Affiche une liste d'employes sur le chemin /employees
	@ApiOperation(value = "Get list of posts in the System ", response = Publication.class, tags = "getPosts")
	@GetMapping(value = "/publications")
	public ResponseEntity<List<Publication>> getPosts() {
		return new ResponseEntity<>(publicationService.findAll(), HttpStatus.OK);
	}

	// http://localhost:8080/publications/1
	// Affiche une publication selon son identifiant sur le chemin /publications/1
	@ApiOperation(value = "Save one post in the System ", response = Publication.class, tags = "createPost")
	@PostMapping(value = "/publications")
	public ResponseEntity<Publication> createPost(@Valid @RequestBody PublicationDto pubDto) {
		Publication pubToSave = new Publication();

		pubToSave.setContenu(pubDto.getContenu());

		return new ResponseEntity<>(publicationService.saveOrUpdate(pubToSave), HttpStatus.OK);

	}

	// http://localhost:8080/publications/1
	// Affiche une publication selon son identifiant sur le chemin /publications/1
	@ApiOperation(value = "Get one Post in the System ", response = Publication.class, tags = "getPost")
	@GetMapping(value = "/publications/{id}")
	public ResponseEntity<Publication> getPost(@PathVariable("id") Long id) {
		Publication pub = publicationService.getOne(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found with id: " + id));
		return new ResponseEntity<>(pub, HttpStatus.OK);

	}

	// http://localhost:8080/publications/1
	// Met a jour un publication selon son identifiant sur le chemin /publications/1
	@ApiOperation(value = "Edit one post in the System ", response = Publication.class, tags = "editPost")
	@PutMapping(value = "/publications/{id}")
	public ResponseEntity<Publication> updatePost(@PathVariable("id") Long id,
			@Valid @RequestBody PublicationDto pubDto) {
		Publication pubToUpdate = publicationService.getOne(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found with id: " + id));

		pubToUpdate.setContenu(pubDto.getContenu());

		pubToUpdate = publicationService.saveOrUpdate(pubToUpdate);

		return new ResponseEntity<>(pubToUpdate, HttpStatus.OK);
	}

	// http://localhost:8080/publications/1
	// Supprime un publication selon son identifiant sur le chemin /publications/1
	@ApiOperation(value = "Delete one post in the System ", response = Publication.class, tags = "deletePost")
	@DeleteMapping(value = "/publications/{id}")
	public ResponseEntity<?> deletePost(@PathVariable("id") Long id) {
		Publication pubToDelete = publicationService.getOne(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found with id: " + id));
		publicationService.delete(pubToDelete.getId());
		return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
	}

}
