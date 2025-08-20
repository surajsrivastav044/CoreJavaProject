import entity.Customer;
import entity.Vehicle;
import service.BillingService;
import service.CustomerService;
import service.VehicleService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {

        Scanner scanner=new Scanner(System.in);
        BillingService billingService=new BillingService();

        while(true){
            System.out.println("1. Add Customer with Vehicle\n2. create Invoice\n3. Show All Invoice\n4. Exit");
            int choice=scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Customer Name: ");
                    String name=scanner.next();
                    System.out.print("Phone: ");
                    String phone=scanner.next();
                    service.CustomerService.addCustomer(new Customer(0,name,phone));
                    System.out.println("----------------------------------------------");
                    System.out.print("Enter Vehicle Number: ");
                    String vehicleNumber=scanner.next();
                    System.out.print("Enter Vehicle Model: ");
                    String model=scanner.next();
                    Customer customer=CustomerService.getCustomerBasedOnNumber(phone);
                    assert customer != null;
                    int customerI=customer.getId();
                    VehicleService.addVehicle(new Vehicle(0,customerI,vehicleNumber,model));
                    break;

                case 2:
                    new App().showAllCustomer();
                    System.out.print("Enter Customer Id: ");
                    int customerId=scanner.nextInt();
                    System.out.print("Enter Vehicle Id: ");
                    int vehicleId=scanner.nextInt();
                    System.out.print("Enter Number of Services: ");
                    int numberOfServices=scanner.nextInt();
                    List<Integer> sIds=new ArrayList<>();
                    for(int i=0;i<numberOfServices;i++){
                        System.out.print("Enter the Service Id: ");
                        sIds.add(scanner.nextInt());
                    }
                    billingService.createInvoice(customerId,vehicleId,sIds);
                    break;

                case 3:
                    billingService.showAllInvoices();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Not a Valid Choice");
                    break;

            }
        }
    }

    private void showAllCustomer() throws SQLException {
        List<Customer> customers=new CustomerService().getAllCustomer();
        for(Customer customer:customers){
            System.out.println(customer);
        }
    }
}
