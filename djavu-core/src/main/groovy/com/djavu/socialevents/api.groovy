package com.djavu.socialevents

import javax.ws.rs.*
import javax.ws.rs.core.*

@Path('/api/socialevent')
interface SocialEventResources {

	@GET
	@Produces('application/json')
	SocialEvent[] get()
}
