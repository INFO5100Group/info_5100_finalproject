/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author Bohan Feng
 */
public class CardLayoutNavigator {
    
    /**
     * go to previous page
     * @param container
     * @param currPanel current page
     */
    public static void goBack(JPanel container, JPanel currPanel){
        container.remove(currPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }
    
    /**
     * go to next page
     * @param container
     * @param nextPanel next page
     * @param nextName  next page name
     */
    public static void goNext(JPanel container, JPanel nextPanel, String nextName){
        container.add(nextName + " Panel", nextPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }
    
    public static void logout(JPanel container, JPanel currPanel){
        goBack(container, currPanel);
        Component [] componentArray = container.getComponents();
        Component c = componentArray[componentArray.length-1];
        MainPanel ms = (MainPanel) c;
        ms.cleanfield();
    }
}
