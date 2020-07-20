
package acme.features.anonymous.patonbulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.patonbulletins.Patonbulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/patonbulletin/")
public class AnonymousPatonbulletinController extends AbstractController<Anonymous, Patonbulletin> {

	@Autowired
	private AnonymousPatonbulletinListService	listService;

	@Autowired
	private AnonymousPatonbulletinCreateService	createService;


	@PostConstruct
	private void initialize() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.CREATE, createService);
	}

}
