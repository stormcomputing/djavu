package com.djavu.socialevents

import org.springframework.data.repository.RepositoryDefinition
import org.springframework.transaction.annotation.Transactional

@RepositoryDefinition(domainClass = SocialEvent.class, idClass = Long.class)
interface SocialEventRepository {

	List<SocialEvent> findAll()
}
