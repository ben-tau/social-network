package socialNetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import socialNetwork.model.Publication;

public interface IPublicationRepository extends JpaRepository<Publication, Long> {

}
