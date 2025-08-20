package service;

import config.DbConfiguration;
import entity.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    public static void addVehicle(Vehicle vehicle) throws SQLException {

        Connection connection= DbConfiguration.getConnection();
        String query="INSERT INTO vehicles(customer_id,number_plate,model) VALUES(?,?,?)";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setInt(1, vehicle.getCustomerId());
        ps.setString(2, vehicle.getVehicleNumber());
        ps.setString(3, vehicle.getModelYear());

        int data=ps.executeUpdate();
        System.out.println(data+" Vehicle added successfully");
        connection.close();
        ps.close();
    }

    public List<Vehicle> getAllVehicle() throws SQLException{
        List<Vehicle> vehicles=new ArrayList<>();

        Connection connection=DbConfiguration.getConnection();
        Statement st=connection.createStatement();
        String query="SELECT * from vehicles";
        ResultSet rs=st.executeQuery(query);

        while(rs.next()){
            vehicles.add(new Vehicle(rs.getInt("id"),rs.getInt("customer_id"),rs.getString("number_plate"),rs.getString("model")));
        }
        connection.close();
        st.close();
        return vehicles;

    }
}
