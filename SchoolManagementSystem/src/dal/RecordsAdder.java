/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dto.EmployeeDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;

/**
 *
 * @author Mukhtiar-HPC
 */
public class RecordsAdder {

    void saveEmployee(EmployeeDTO objEmp, Response objResponse, Connection dbConnection) {
        try{
            PreparedStatement p = dbConnection.prepareStatement("INSERT INTO Employees (LastName,FirstName,Title , TitleOfCourtesy , BirthDate , HireDate , Address , City , Region , PostalCode , Country , HomePhone , PhotoPath) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);");
            p.setString(1, objEmp.LastName);
            p.setString(2, objEmp.FirstName);
            p.setString(3, objEmp.Title);
            p.setString(4, objEmp.TitleOfCourtesy);
            p.setString(5, objEmp.BirthDate);
            p.setString(6, objEmp.HireDate);
            p.setString(7, objEmp.Address);
            p.setString(8, objEmp.City);
            p.setString(9, objEmp.Region);
            p.setString(10, objEmp.PostalCode);
            p.setString(11, objEmp.Countryl);
            p.setString(12, objEmp.PhotoPath);
             p.setString(13, objEmp.Note);
                     
            
            
            int rowsInserted = p.executeUpdate();
            if(rowsInserted > 0){
                objResponse.messagesList.add(new Message("Employee added successfully.", MessageType.Information));
            }
        }catch(SQLException e){
            System.out.println("Done");
            objResponse.messagesList.add(new Message("Ooops! Failed to create employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
            objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }

}
