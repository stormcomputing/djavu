package djavu

import javax.inject.*
import javax.ws.rs.core.*
import javax.servlet.http.*
import javax.enterprise.inject.*
import javax.enterprise.context.*

@Named
class EventsResourcesImpl implements EventsResources {

    @Inject
    EventRepository repo

    Event[] get() {
        repo.findAll()
    }
}
