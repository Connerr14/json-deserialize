package com.example.jsonproject;

import com.google.gson.stream.JsonReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // launch();

        // Read a json object and deserialize it
        try
        (
                // Create the file reader object
                FileReader fileReader = new FileReader("src/main/resources/com/example/jsonproject/employees.json");
                // Create the jsonReader object
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            // Make a gson object from the Gson class
            Gson gson = new Gson();

            // Read employees from json response
            EmployeesResponse employeesResponse = gson.fromJson(jsonReader, EmployeesResponse.class);

            // Print all the employee names
            for (int i = 0; i < employeesResponse.Employees.size(); i++) {
                Employee employee = employeesResponse.Employees.get(i);
                System.out.println(employee.preferredFullName);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}