/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Bohan Feng
 */
public class CardLayoutNavigator {
    
    public static void goBack(JPanel container, JPanel currPanel){
        container.remove(currPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }
    
    public static void goNext(JPanel container, JPanel nextPanel, String nextName){
        container.add(nextName + " Panel", nextPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }
}
