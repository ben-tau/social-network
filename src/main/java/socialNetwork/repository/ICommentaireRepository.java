package socialNetwork.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import socialNetwork.model.Commentaire;

//@Repository
public interface ICommentaireRepository extends JpaRepository<Commentaire, Long> {
	//méthodes persos
		List<Commentaire> findByPublicationId(Long publicationId);
		
		Optional<Commentaire> findByIdAndPublicationId(Long commentaireId, Long publicationId);
}
