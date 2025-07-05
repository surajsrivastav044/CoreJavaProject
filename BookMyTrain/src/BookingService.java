import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {

    private final List<Train> trainList=new ArrayList<>();

    private final List<Ticket> ticketList= new ArrayList<>();

    public BookingService(){

        trainList.add(new Train(101,"Kanpur Express", "Kanpur", "Agra", 150));
        trainList.add(new Train(102,"Goa Express", "Delhi", "Lucknow", 250));
        trainList.add(new Train(103,"Gorakhpur express", "Lucknow", "Pune", 100));
        trainList.add(new Train(104,"Punjab Mail", "Pune", "Delhi", 80));

    }

    public List<Train> searchTrain(String source, String destination){
        List<Train> res=new ArrayList<>();
        for(Train train:trainList){
            if(train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination)){
                res.add(train);
            }
        }
        return res;
    }

    public Ticket bookTicket(User user, int trainId, int seatCount){
        for(Train train:trainList){
            if(train.getTrainId()==trainId){
                if(train.BookSeats(seatCount)){
                    Ticket ticket=new Ticket(user, train, seatCount);
                    ticketList.add(ticket);
                    return ticket;
                }
                else{
                    System.out.println("Not enough Seats Available");
                    return null;
                }
            }
        }
        System.out.println("Train ID not found");
        return null;
    }

    public List<Ticket> getTicketByUser(User user){
        List<Ticket> res=new ArrayList<>();
        for(Ticket ticket:ticketList){
            if(ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName())){
                res.add(ticket);
            }
        }
        return res;
    }

    public void cancelTicket(int ticketId, User user){
        Iterator<Ticket> itr= ticketList.iterator();
        while(itr.hasNext()){
            Ticket ticket=itr.next();
            if(ticket.getTicketId()==ticketId && ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName())){
                Train train=ticket.getTrain();
                train.cancelTicket(ticket.getSeatBooked());
                itr.remove();
                System.out.println("Ticket "+ticketId+" cancelled successfully");
                return;
            }
        }
        System.out.println("ticket not found");
    }

    public void listAllTrains(){
        System.out.println("List of all trains");
        for(Train train: trainList){
            System.out.println(train);
        }
    }
}
