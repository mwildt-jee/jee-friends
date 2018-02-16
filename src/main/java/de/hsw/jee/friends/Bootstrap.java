package de.hsw.jee.friends;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.services.ProfileService;
import de.hsw.jee.friends.services.UserService;

@ApplicationScoped
public class Bootstrap {

	Logger LOG = LoggerFactory.getLogger(Bootstrap.class);
	
	@Inject private UserService userService;
	@Inject private ProfileService profileService;

    public void postConstruct(@Observes @Initialized(ApplicationScoped.class) Object o) {
    	LOG.info("bootstrap application");
		if(userService.noUserExists()) {
			final User admin = userService.createUser("admin", "admin");
			profileService.createProfile(admin, "Adam", "admin");

			final User user1 = userService.createUser("bert", "bert");
			profileService.createProfile(user1, "Bertholt", "Benutzer");
		}
    }
}