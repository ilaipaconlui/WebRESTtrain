package soa.jaxrslabs.helloepsiwebservicerestexercice2;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author M34LMAR
 */
@Produces("application/xml")
public class BookTrainResource {

    @POST // Méthode HTTP utilisée pour déclencher cette méthode
    public Response createBookTrain(@FormParam("num") String numTrain,@FormParam("nb") int numberPlaces) {
        Train currentTrain = null;
        for (Train current : BookTrainBD.getTrains()) {
            if (current.getNumTrain().equals(numTrain)) {
                currentTrain = current;
            }
        }
        if (currentTrain == null) {
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        }
        BookTrain newBookTrain = new BookTrain();
        newBookTrain.setNumberPlaces(numberPlaces);
        newBookTrain.setCurrentTrain(currentTrain);
        newBookTrain.setBookNumber(Long.toString(System.currentTimeMillis()));
        BookTrainBD.getBookTrains().add(newBookTrain);
        return Response
                .status(Status.OK)
                .entity(newBookTrain.getBookNumber())
                .build();
    }

    @GET // Méthode HTTP utilisée pour déclencher cette méthode
    public Response getBookTrains() {
        System.out.println("getBookTrains");
        return Response
                .status(Status.OK)
                .entity(new GenericEntity<List<BookTrain>>(BookTrainBD.getBookTrains()){})
                .build();
    }

    @GET // Méthode HTTP utilisée pour déclencher cette méthode
    @Path("{id}") // Chemin de façon à intégrer un template parameter (id)
    public Response getBookTrain(@PathParam("id") String bookNumber) {
        List<BookTrain> bookTrains = BookTrainBD.getBookTrains();
        for (BookTrain current : bookTrains) {
            if (current.getBookNumber().equals(bookNumber)) {
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

    @DELETE // Méthode HTTP utilisée pour déclencher cette méthode
    @Path("{id}") // Chemin de façon à intégrer un template parameter (id)
    public Response removeBookTrain(@PathParam("id") String bookNumber) {
        BookTrain currentBookTrain = null;
        for (BookTrain current : BookTrainBD.getBookTrains()) {
            if (current.getBookNumber().equals(bookNumber)) {
                currentBookTrain = current;
            }
        }
        BookTrainBD.getBookTrains().remove(currentBookTrain);
        return Response.status(Status.ACCEPTED).build();
    }
}
