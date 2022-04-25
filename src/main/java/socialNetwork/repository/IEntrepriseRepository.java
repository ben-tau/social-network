package socialNetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import socialNetwork.model.Entreprise;

public interface IEntrepriseRepository extends JpaRepository<Entreprise, Long> {
	
}
