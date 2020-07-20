
package acme.features.anonymous.patonbulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patonbulletins.Patonbulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousPatonbulletinCreateService implements AbstractCreateService<Anonymous, Patonbulletin> {

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

		request.unbind(entity, model, "author", "description", "text");

	}

	@Override
	public void bind(final Request<Patonbulletin> request, final Patonbulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public Patonbulletin instantiate(final Request<Patonbulletin> request) {
		assert request != null;

		Patonbulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result = new Patonbulletin();
		result.setAuthor("Galan");
		result.setDescription("Description");
		result.setText("GalanBulletin");
		result.setMoment(moment);

		return result;
	}

	@Override
	public void validate(final Request<Patonbulletin> request, final Patonbulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Patonbulletin> request, final Patonbulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);

		this.repository.save(entity);
	}

}
