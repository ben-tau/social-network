package socialNetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import socialNetwork.model.Notification;

public interface INotificationRepository extends JpaRepository<Notification, Long>{

}
