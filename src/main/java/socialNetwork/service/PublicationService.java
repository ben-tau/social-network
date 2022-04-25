package socialNetwork.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import socialNetwork.model.Publication;
import socialNetwork.repository.IPublicationRepository;

@Service(value = "publicationService")
public class PublicationService implements IService<Publication> {

	@Autowired
	IPublicationRepository publicationRepository;

	@Override
	public List<Publication> findAll() {
		return publicationRepository.findAll();
	}

	@Override
	public Publication saveOrUpdate(Publication emp) {
		return publicationRepository.save(emp);
	}

	@Override
	public Optional<Publication> getOne(Long id) {
		return publicationRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		publicationRepository.deleteById(id);
	}

}
