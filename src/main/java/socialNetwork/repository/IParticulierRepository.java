package socialNetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import socialNetwork.model.Particulier;

public interface IParticulierRepository extends JpaRepository<Particulier, Long> {

}
