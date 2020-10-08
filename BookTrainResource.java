
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class BookTrainResource {

    @POST // Méthode HTTP utilisée pour déclencher cette méthode
    public Response createBookTrain(String numTrain, int numberPlaces) {
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
        newBookTrain.setNumBook(Long.toString(System.currentTimeMillis()));
        BookTrainBD.getBookTrains().add(newBookTrain);

        return Response
          .status(Status.OK)
          .entity(newBookTrain.getNumBook())
          .build();
    }

    @GET // Méthode HTTP utilisée pour déclencher cette méthode
    public Response getBookTrains() {
        System.out.println("getBookTrains");

        return Response
          .status(Status.OK)
          .entity(BookTrainBD.getBookTrains())
          .build();
    }

    @GET // Méthode HTTP utilisée pour déclencher cette méthode
    @Path("{id}") // Chemin de façon à intégrer un template parameter (id)
    public Response getBookTrain(@PathParam("id") String bookNumber) {
        List<BookTrain> bookTrains = BookTrainBD.getBookTrains();

        for (BookTrain current : bookTrains) {
            if (current.getNumBook().equals(bookNumber)) {
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
            if (current.getNumBook().equals(bookNumber)) {
                currentBookTrain = current;
            }
        }
        return Response.status(Status.ACCEPTED).build();
    }
}