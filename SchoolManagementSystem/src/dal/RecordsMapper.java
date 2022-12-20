/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.dto.EmployeeDTO;

/**
 *
 * @author Mukhtiar
 */
public class RecordsMapper {

    ArrayList<EmployeeDTO> getEmployees(ResultSet rs) {
        ArrayList<EmployeeDTO> emplist = new ArrayList<>();
        try{
        while (rs.next())
            {
                EmployeeDTO objEmp=new EmployeeDTO();                
                objEmp.Id=rs.getString(1);
                objEmp.FirstName= rs.getString(3);
                objEmp.LastName =rs.getString(2);
                objEmp.Address=rs.getString(8); 
                objEmp.BirthDate=rs.getString(6);
                objEmp.City=rs.getString(9);
                objEmp.Countryl=rs.getString(12);
                objEmp.HireDate=rs.getString(7);
                objEmp.Note=rs.getString(16);
                objEmp.PostalCode=rs.getString(11);
                objEmp.Title=rs.getString(4);
                objEmp.PhotoPath=rs.getString(18);
                objEmp.TitleOfCourtesy=rs.getString(5);
                objEmp.Phone=rs.getString(13);
                
                
                
                emplist.add(objEmp);
            }
        }catch (Exception e){
        }
        return emplist;
    }
    
}
