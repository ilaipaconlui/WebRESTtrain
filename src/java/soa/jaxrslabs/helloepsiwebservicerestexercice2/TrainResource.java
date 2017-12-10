package soa.jaxrslabs.helloepsiwebservicerestexercice2;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/trains")
@Produces("application/xml")
public class TrainResource {

    public TrainResource() {
    }
    
    @Path("/booktrains") // Chemin suivant /trains/booktrains pour invoquer cette méthode
    public BookTrainResource getBookTrainResource() {
        return new BookTrainResource();
    }

   
    @GET // Méthode HTTP utilisée pour déclencher cette méthode
    public Response getTrains() {
        System.out.println("getTrains");
        
        return Response
                .status(Status.OK)
                .entity(new GenericEntity<List<Train>>(BookTrainBD.getTrains()){})
                .build();
    }
    
    @GET // Méthode HTTP utilisée pour déclencher cette méthode
    @Path("numTrain-{id}") // Chemin suivant ce template numTrain-TR123 où TR123 est une chaine variable
    public Response getTrain(@PathParam("id") String numTrain) {
        System.out.println("getTrain");
        for (Train current : BookTrainBD.getTrains()) {
            if (numTrain.equals(current.getNumTrain())) {
                return Response
                        .status(Status.OK)
                        .entity(current)
                        .build();
            }
        }
        return Response
                .status(Status.NO_CONTENT)
                .build();
    }

    @GET // Méthode HTTP utilisée pour déclencher cette méthode
    @Path("/search") // Chemin suivant /trains/search pour invoquer cette méthode
    public Response searchTrainsByCriteria(@QueryParam("departure") String departure,
            @QueryParam("arrival") String arrival, @QueryParam("arrivalhour") String arrivalHour) {
        System.out.println("searchTrainsByCriteria");
        return Response
                .status(Status.OK)
                .entity(BookTrainBD.getTrains().subList(0, 2))
                .build();
    }
}
