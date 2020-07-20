
package acme.features.anonymous.patonbulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patonbulletins.Patonbulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousPatonbulletinRepository extends AbstractRepository {

	@Query("select p from Patonbulletin p")
	Collection<Patonbulletin> findMany();
}
