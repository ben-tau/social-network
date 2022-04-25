package socialNetwork.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
	List<T> findAll();

	T saveOrUpdate(T o);

//	Optional<T> permet d'encapsuler un objet dont valeur peut etre NULL
	Optional<T> getOne(Long id);

	void delete(Long id);
}
