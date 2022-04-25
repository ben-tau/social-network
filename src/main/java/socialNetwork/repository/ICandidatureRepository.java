package socialNetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import socialNetwork.model.Candidature;

public interface ICandidatureRepository extends JpaRepository<Candidature, Long> {

}
