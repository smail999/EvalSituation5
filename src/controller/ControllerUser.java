/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccessBackofficeDAO;
import dao.UserDAO;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.AccessBackoffice;
import model.User;

/**
 *
 * @author Formation
 */
public class ControllerUser {
  
    private UserDAO UserDAO = new UserDAO();

    public JTable addRowTable(JTable jt_listUser) {
        DefaultTableModel model = (DefaultTableModel) jt_listUser.getModel();
        ArrayList<User> list_User = UserDAO.getAll();

        Object rowData[] = new Object[9];

        for (User user : list_User) {

            rowData[0] = user.getId();
            rowData[1] = user.getFirstname();
            rowData[2] = user.getLastname();
            rowData[3] = user.getAddress();
            rowData[4] = user.getCity();
            rowData[5] = user.getCountry();
            rowData[6] = user.getTel();
            rowData[7] = user.getMail();
            rowData[8] = user.getFunction();
           
            model.addRow(rowData);
        }
        return jt_listUser;
    }

    public void updateInfo(JTextField tf_firstname,
                           JTextField tf_lastname,
                           JTextField tf_address,
                           JTextField tf_city,
                           JTextField tf_country,
                           JTextField tf_tel ,
                           JTextField tf_mail , 
                           JTextField tf_function) 
    {
        
       User uservide = new User();
      
       uservide.setFirstname(tf_firstname.getText());
       uservide.setFirstname(tf_lastname.getText());
       uservide.setFirstname(tf_address.getText());
       uservide.setFirstname(tf_city.getText());
       uservide.setFirstname(tf_country.getText());
       uservide.setFirstname(tf_tel.getText());
       uservide.setFirstname(tf_mail.getText());
       uservide.setFirstname(tf_function.getText());
      
       UserDAO userdao = new UserDAO();
       userdao.update(uservide);
       

    } 

    public void addInfoPlanned(JTextField tf_Prénom,
                           JTextField tf_nom,
                           JTextField tf_address,
                           JTextField tf_city,
                           JTextField tf_country,
                           JTextField tf_tel ,
                           JTextField tf_mail , 
                           JTextField tf_function) {
        
      Object numObject = jt_listUser.getValueAt(jt_listUser.getSelectedRow(), 0);
        Long id = Long.parseLong(numObject.toString().substring(2));
        
        Flight flight = this.flightDAO.find(id);
//        System.out.println(flight);
        
        num.setText("DF" + flight.getId());
//        num.setText("");
        countryStart.setText(flight.getDeparting_country());
        iataStart.setText(flight.getDeparting_aita());
//        num.setText("");
        countryArrived.setText(flight.getArrival_country());
        iataArrived.setText(flight.getArrival_aita());
        dateStart.setText(flight.getDeparting_hour().substring(0, 10));
        hoursStart.setText(flight.getDeparting_hour().substring(11, 16));
        dateArrived.setText(arrivedDate(flight).substring(0, 10));
        hoursArrived.setText(arrivedDate(flight).substring(11, 16));
        time.setText("" + flight.getDuration());
        price.setText("" + flight.getPrice());
        idPilote.setSelectedIndex(1);   
    }
     
    
    
    
    
    
}
