package service;

import entity.Invoice;

import java.sql.SQLException;
import java.util.List;

public class BillingService {

    public CustomerService customerService=new CustomerService();
    public InvoiceService invoiceService=new InvoiceService();

    public void createInvoice(int customerId,int vehicleId, List<Integer> serviceIds) throws SQLException{
        String serviceId="";
        for(int serviceI:serviceIds ){
            serviceId+=serviceI;
        }
       new InvoiceService().addInvoice(new Invoice(0,customerId, vehicleId, Integer.parseInt(serviceId)));
    }

    public void showAllInvoices() throws SQLException {
        List<Invoice> invoices=invoiceService.getAllInvoices();
        for(Invoice invoice:invoices){
            System.out.println(invoice);
        }
    }
}
