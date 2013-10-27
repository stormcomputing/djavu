package djavu

import org.springframework.data.repository.RepositoryDefinition
import org.springframework.transaction.annotation.Transactional

@RepositoryDefinition(domainClass = Event.class, idClass = Long.class)
interface EventRepository {

	List<Event> findAll()
}
