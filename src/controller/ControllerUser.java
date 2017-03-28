/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.FunctionDAO;
import dao.UserDAO;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import model.AccessBackoffice;

import model.Function;
import model.User;
import view.UseurView;


public class ControllerUser {

    
    private UserDAO userDAO ;

    public ControllerUser(UserDAO userDao) {
        this.userDAO=userDao;
    }
    
   

    public JTable addRowTable(JTable jt_listUser) {
        
        DefaultTableModel model = (DefaultTableModel) jt_listUser.getModel();
        ArrayList<User> list_User = userDAO.getAllDetails();
        Object rowData[] = new Object[13];

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
            rowData[9] = user.getNickname_back();
            rowData[10] = user.isIsBlocked();
            rowData[11] = user.isIsAdmin();           
            rowData[12] = user.getNickname_site();
     

            model.addRow(rowData);
        }
        return jt_listUser;
    }
     public void UserInfo(UseurView userView, Long id) {
        User user = this.userDAO.find(id);
    
        ArrayList<String> values = new ArrayList<>();
        ArrayList<Boolean> valuesBollean = new ArrayList<>();
       
        
        // Add all values in ArraList
        
        values.add(String.valueOf(user.getFirstname()));
        values.add(String.valueOf(user.getLastname()));
        values.add(String.valueOf(user.getAddress()));
        values.add(String.valueOf(user.getCity()));
        values.add(String.valueOf(user.getCountry()));
        values.add(String.valueOf(user.getTel()));
        values.add(String.valueOf(user.getMail()));
        values.add(String.valueOf(user.getFunction()));
        values.add(String.valueOf(user.getNickname_back()));
        
        values.add(String.valueOf(user.getNickname_site()));
        valuesBollean.add(user.isIsBlocked());
        valuesBollean.add(user.isIsAdmin());
        
        userView.updateUserInfo(values,valuesBollean);
         
        
    }
    
   public void delete(Long id){
        User user = this.userDAO.find(id);
        userDAO.delete(user.getId());
    }
   public void addCombobox(JComboBox cb_Metier) {

        // ************************ ADD Function
        FunctionDAO functionDAO = new FunctionDAO();
        ArrayList<Function> metier = new ArrayList<>();

        metier = functionDAO.getAll();

        cb_Metier.addItem("");

        for (int i = 0; i < metier.size(); i++) {
            cb_Metier.addItem(metier.get(i).getDefinition());

        }

    }
}
