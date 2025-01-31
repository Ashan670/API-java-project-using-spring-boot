package com.api.service;

import org.springframework.stereotype.Service;
import com.api.model.Endpoint;
import com.DatabaseConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class EndpointService {

    public List<Endpoint> getAllEndpoints() {
        List<Endpoint> endpoints = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM endpoint_table");
            while (resultSet.next()) {
                Endpoint endpoint = new Endpoint();
                endpoint.setId(resultSet.getInt("id"));
                endpoint.setEndpoint(resultSet.getString("endpoint"));
                endpoints.add(endpoint);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endpoints;
    }
}
