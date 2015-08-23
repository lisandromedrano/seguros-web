package com.lix.multitenancy;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lix.domain.master.productores.model.Productores;

@Component("webSessionCurrentTenantIdentifierResolver")
public class WebSessionCurrentTenantIdentifierResolver implements
		CurrentTenantIdentifierResolver {

	private static final Logger LOG = LoggerFactory
			.getLogger(WebSessionCurrentTenantIdentifierResolver.class);

	@Autowired
	private HttpServletRequest request;

	@Override
	public String resolveCurrentTenantIdentifier() {

		String loggedUserName = "unlogged";
		try {
			Productores currentProductor = (Productores) request.getSession()
					.getAttribute("currentProductor");
			LOG.info("currentProductor {},{}", currentProductor.getApellido(),
					currentProductor.getNombre());
			Integer productorId = currentProductor.getId();
			return "productor" + productorId;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			LOG.info("no currentProductor");
			// e1.printStackTrace();
		}
		return "";

		// try {
		// UserDetails ud = (UserDetails) request.getSession().getAttribute(
		// "loggedInUser");
		// LOG.info("loggedInUser {}", ud.getUsername());
		// loggedUserName = ud.getUsername();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// LOG.info("no user in seesion");
		// // e.printStackTrace();
		// }
		// LOG.info("current tenant: {}", loggedUserName);
		// return "productor1";
		// return null;
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return false;
	}
}