/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluations5;

import controller.ControllerUser;
import dao.UserDAO;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import view.UseurView;

/**
 *
 * @author Formation
 */
public class Evaluations5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          JFrame frame = new JFrame();
        UserDAO userdao = new UserDAO();
        ControllerUser userController = new ControllerUser(userdao);
      UseurView useurView =  new UseurView(userController);
      
      frame.setTitle("Vols");
        frame.setSize(1000, 691);
//        this.setMinimumSize(new Dimension(340, 480));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLocation(450, 110);
        
        frame.add(useurView);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println("zelda");
    }
    
}
