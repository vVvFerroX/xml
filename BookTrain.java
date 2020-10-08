
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "booktrain")
public class BookTrain {

    private String bookNumber;

    private Train currentTrain;

    private int numberPlaces;

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Train getCurrentTrain() {
        return currentTrain;
    }
    
     public int getNumberPlaces() {
        return numberPlaces;
    }

    public void setNumberPlaces(int numberPlaces) {
        this.numberPlaces = numberPlaces;
    }

    void setNumBook(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setCurrentTrain(Train currentTrain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object getNumBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}