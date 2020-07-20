
package acme.features.anonymous.bulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.bulletins.Bulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/bulletin/")
public class AnonymousBulletinController extends AbstractController<Anonymous, Bulletin> {

	@Autowired
	private AnonymousBulletinListService	listService;

	@Autowired
	private AnonymousBulletinCreateService	createService;


	@PostConstruct
	private void initialize() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.CREATE, createService);
	}

}
