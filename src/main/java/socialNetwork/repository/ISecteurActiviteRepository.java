package socialNetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import socialNetwork.model.SecteurActivite;

public interface ISecteurActiviteRepository extends JpaRepository<SecteurActivite, Long> {
	
}
