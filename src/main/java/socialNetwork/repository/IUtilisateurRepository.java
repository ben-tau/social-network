package socialNetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import socialNetwork.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
