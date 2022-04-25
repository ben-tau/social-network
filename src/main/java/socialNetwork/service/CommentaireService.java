package socialNetwork.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import socialNetwork.model.Commentaire;
import socialNetwork.repository.ICommentaireRepository;
import socialNetwork.repository.IPublicationRepository;

@Service(value = "commentaireService")
public class CommentaireService {

	@Autowired
	private ICommentaireRepository commentaireRepository;
	
	@Autowired
	private IPublicationRepository publicationRepository;
	
	
	public List<Commentaire> getCommentariesByPost(Long publicationId) {
		return commentaireRepository.findByPublicationId(publicationId);
	}

	public Commentaire getCommentaryById(Long CommentaireId) {
		return commentaireRepository.findById(CommentaireId).get();
	}
	
	
	public Optional<Commentaire> getOneCommentaryByPost(Long CommentaireId, Long publicationId) {
		return commentaireRepository.findByIdAndPublicationId(CommentaireId, publicationId);
	}

	
	public Optional<Commentaire> saveCommentaryByPost(Long publicationId, Commentaire commentaire) {
		return publicationRepository.findById(publicationId).map(publication -> {
			commentaire.setPublication(publication);
			return commentaireRepository.save(commentaire);
		});
	}
	
	public Optional<Commentaire> editOneCommentaryByPost(Long commentaireId, Long publicationId, Commentaire commentaire) {
		return commentaireRepository.findByIdAndPublicationId(commentaireId, publicationId).map(commentaireToUpdate -> {
			commentaireToUpdate.setContenu(commentaire.getContenu());
			return commentaireRepository.save(commentaireToUpdate);
		});
	}

	public Optional<?> deleteOneCommentaryByPost(Long commentaireId, Long publicationId) {
		return commentaireRepository.findByIdAndPublicationId(commentaireId, publicationId).map(commentaireToDelete -> {
			commentaireRepository.delete(commentaireToDelete);
			return "DELETED";
		});
	}
	
}
