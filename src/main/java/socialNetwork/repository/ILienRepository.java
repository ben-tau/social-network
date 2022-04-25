package socialNetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import socialNetwork.model.Lien;


public interface ILienRepository extends JpaRepository<Lien, Long>{

}
