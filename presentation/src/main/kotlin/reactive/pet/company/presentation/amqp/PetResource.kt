package reactive.pet.company.presentation.amqp

import io.smallrye.reactive.messaging.annotations.Channel
import org.jboss.resteasy.annotations.SseElementType
import javax.inject.Inject
import javax.ws.rs.Path
import org.reactivestreams.Publisher
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/pet")
class PetResource {

    @Inject
    @Channel("my-data-stream")
    val message = Publisher<String>{}

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType("text/plain")
    fun stream() : Publisher<String> {
        return message
    }
}