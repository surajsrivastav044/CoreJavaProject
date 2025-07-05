import java.util.List;
import java.util.Scanner;

public class IRCTCAPP {

    private final Scanner sc=new Scanner(System.in);

    private final UserService userService=new UserService();

    private final BookingService bookingService=new BookingService();

    public static void main(String[] args) {
        new IRCTCAPP().start();
    }

    public void start(){
        while(true){
            System.out.println("\n------------------Welcome to IRCTC APP----------------------");
            if(!userService.isLoggedIn()){
                System.out.println("1. register");
                System.out.println("2. login");
                System.out.println("3. exit");
                System.out.print("Enter your Choice: ");

                int choice=sc.nextInt();
                switch(choice){
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exitApp();
                    default -> System.out.println("Invalid choice");
                }
            }
            else{
                showUserMenu();
            }
        }
    }

    public void register(){
        System.out.print("Enter Username: ");
        String username=sc.next();

        System.out.print("Enter Password: ");
        String password=sc.next();

        System.out.print("Enter Contact: ");
        String contact=sc.next();

        System.out.print("Enter Full Name: ");
        String fullName=sc.nextLine();
        sc.nextLine();

        userService.registerUser(username,password,fullName,contact);
    }

    public void login(){
        System.out.print("Enter Username: ");
        String username=sc.next();

        System.out.print("Enter Password: ");
        String password=sc.next();

        userService.loginUser(username,password);
    }

    public void showUserMenu(){
        while(userService.isLoggedIn()){
            System.out.println("\n-------------------User Menu----------------------");
            System.out.println("1. Search Train");
            System.out.println("2. Book Train");
            System.out.println("3. View My Tickets");
            System.out.print("4. Cancel Tickets");
            System.out.println("5. View All Tickets");
            System.out.println("6. Logout:");
            System.out.print("Enter Choice: ");

            int choice=sc.nextInt();
            switch(choice){
                case 1 -> searchTrain();
                case 2 -> bookTicket();
                case 3 -> viewMyTicket();
                case 4 -> cancelTicket();
                case 5 -> bookingService.listAllTrains();
                case 6 -> userService.logoutUser();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void searchTrain(){
        System.out.print("Enter Source: ");
        String source=sc.next();

        System.out.print("Enter Destination: ");
        String destination=sc.next();

        List<Train> trains=bookingService.searchTrain(source,destination);
        if(trains.isEmpty()){
            System.out.println("No Trains founds between "+source+" -> "+destination);
            return;
        }
        System.out.println("Train Found");
        for(Train train:trains){
            System.out.println(trains);
        }

        System.out.print("Do you want to book ticket? (yes/no):");
        String choice=sc.next();
        if(choice.equalsIgnoreCase("yes")){
            System.out.print("Enter trainID to book: ");
            int trainId=sc.nextInt();

            System.out.print("Enter Total Seat you want to book: ");
            int seats=sc.nextInt();

            Ticket ticket=bookingService.bookTicket(userService.getCurrentUser(),trainId,seats);

            if(ticket!=null){
                System.out.println("Booking successful");
                System.out.println(ticket);
            }

        }else{
            System.out.println("Returning to user menu....?");
        }
    }

    private void bookTicket(){

        System.out.print("Enter Source: ");
        String source=sc.next();

        System.out.print("Enter Destination: ");
        String destination=sc.next();

        List<Train> trains=bookingService.searchTrain(source,destination);
        if(trains.isEmpty()){
            System.out.println("No Trains Available for booking between "+source+" -> "+destination);
            return;
        }
        System.out.println("Train Available");
        for(Train train:trains){
            System.out.println(trains);
        }

        System.out.print("Enter trainID to book: ");
        int trainId=sc.nextInt();

        System.out.print("Enter Total Seat you want to book: ");
        int seats=sc.nextInt();

        Ticket ticket=bookingService.bookTicket(userService.getCurrentUser(),trainId,seats);

        if(ticket!=null){
            System.out.println("Booking successful");
            System.out.println(ticket);
        }
    }

    private void viewMyTicket(){
        List<Ticket> tickets=bookingService.getTicketByUser(userService.getCurrentUser());
        if(tickets.isEmpty()){
            System.out.println("Sorry No tickets found");
            return;
        }
        System.out.print("Your Tickets: ");
        for(Ticket ticket:tickets){
            System.out.println(ticket);
        }
    }

    private void cancelTicket(){
        System.out.print("Enter Ticket ID to Cancel: ");
        int ticketId=sc.nextInt();
        bookingService.cancelTicket(ticketId,userService.getCurrentUser());
    }

    private void exitApp(){
        System.out.println("Thanks for using IRCTC APP");
        System.exit(0);
    }
}
