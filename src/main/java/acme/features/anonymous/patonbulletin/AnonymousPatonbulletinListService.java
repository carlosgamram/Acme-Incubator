
package acme.features.anonymous.patonbulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patonbulletins.Patonbulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousPatonbulletinListService implements AbstractListService<Anonymous, Patonbulletin> {

	@Autowired
	AnonymousPatonbulletinRepository repository;


	@Override
	public boolean authorise(final Request<Patonbulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Patonbulletin> request, final Patonbulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "description", "text", "moment");
	}

	@Override
	public Collection<Patonbulletin> findMany(final Request<Patonbulletin> request) {
		assert request != null;

		Collection<Patonbulletin> result;
		result = this.repository.findMany();

		return result;
	}

}
