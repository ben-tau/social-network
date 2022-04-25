package socialNetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import socialNetwork.model.EntrepriseSecteurActivite;

public interface IEntrepriseSecteurActiviteRepository extends JpaRepository<EntrepriseSecteurActivite, Long> {
	@Query("select esa from EntrepriseSecteurActivite esa where esa.entreprise.id = :id")
	List<EntrepriseSecteurActivite> findAllByEntreprise(@Param("id") Long idEntreprise);
}
