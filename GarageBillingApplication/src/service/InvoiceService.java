package service;

import config.DbConfiguration;
import entity.Customer;
import entity.Invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    public void addInvoice(Invoice invoice) throws SQLException {

        Connection connection= DbConfiguration.getConnection();
        String query="INSERT INTO invoices(customer_id,vehicle_id,service_id) VALUES(?,?,?)";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setInt(1,invoice.getCustomer_id());
        ps.setInt(2,invoice.getVehicle_id());
        ps.setInt(3,invoice.getService_id());
        ps.executeUpdate();
        System.out.println("Invoice Added Successfully");
        connection.close();
        ps.close();

    }

    public List<Invoice> getAllInvoices() throws SQLException{

        List<Invoice> invoices=new ArrayList<>();

        Connection connection=DbConfiguration.getConnection();
        Statement st=connection.createStatement();
        String query="SELECT * from invoices";
        ResultSet rs=st.executeQuery(query);

        while(rs.next()){
            invoices.add(new Invoice(rs.getInt("id"),rs.getInt("customer_id"),
                    rs.getInt("vehicle_id"),rs.getInt("service_id")));
        }
        connection.close();
        st.close();
        return invoices;

    }
}
