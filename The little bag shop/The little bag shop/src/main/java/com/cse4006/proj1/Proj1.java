/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cse4006.proj1;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.formdev.flatlaf.*;
import com.cse4006.views.*;

/**
 *
 * @author D3MON
 */
public class Proj1 {
    private static JFrame frame = new JFrame("ShipShape"); 
    
    public static void main(String[] args) {
        FlatLightLaf.setup();
        openLayout("LoginView", "Login View");


    }
    
    public static void openLayout(String layoutName, String title) {
        JPanel layout = null;
        Integer sizeX = 860;
        Integer sizeY = 500;


        frame.getContentPane().removeAll();

        switch (layoutName) {
            case "LoginView":
                layout = new LoginView();
                break;
                
            case "MainMenu":
                layout = new MainMenu();
                break;
                
            case "BagList":
                layout = new BagList();
                break;
                
            case "AddBag":
                layout = new AddBag();
                break;
                
            case "SearchBags":
                layout = new SearchBags();
                break;
                
            case "ManagerMainMenu":
                layout = new ManagerMainMenu();
                break;
                
            case "AddCashier":
                layout = new AddCashier();
                break;
                
            default:
                System.err.println("Layout not found: " + layoutName);
                return;
        }

        frame.setTitle(title);
        frame.setResizable(false);
        frame.setExtendedState(JFrame.NORMAL);
        frame.add(layout);
        frame.setSize(sizeX, sizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
