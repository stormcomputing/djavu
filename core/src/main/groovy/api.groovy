package djavu

import javax.ws.rs.*
import javax.ws.rs.core.*

@Path('/api/events')
interface EventsResources {

	@GET
	@Produces('application/json')
	Event[] get()
}
