package socialNetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import socialNetwork.model.Message;

public interface IMessageRepository extends JpaRepository<Message, Long>{

}
