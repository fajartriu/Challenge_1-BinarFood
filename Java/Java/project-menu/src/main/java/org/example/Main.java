package org.example;

import org.example.menu.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // declare class Menu
        Menu menu = new Menu();
        // declare all menu
        HashMap<String, Integer> menus = new HashMap<String, Integer>();
        menus.put("Nasi Goreng", 15000);
        menus.put("Mie Goreng", 13000);
        menus.put("Nasi + Ayam", 18000);
        menus.put("Es Teh Manis", 3000);
        menus.put("Es Jeruk", 5000);
        //=============================================
        // declare status for condition while
        int stat = 1;
        // declare for temp arr (menu name, quantity, sub total)
        ArrayList<String> menuName = new ArrayList();
        ArrayList<Integer> quantity = new ArrayList();
        ArrayList<Integer> subT = new ArrayList();
        // start
        while (stat == 1){
            int statBack = 1;
            // show menu
            menu.screenMenu();
            // input menu what do you want
            Scanner inputUser = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Pilih menu:");
            int menuUser = inputUser.nextInt();  // Read user input
            System.out.println("Menu pilihan: " + menuUser);  // Output user input
            //=========================================
            // if input 0 to exit application
            if (menuUser == 0){
                stat = 0;
            }
            // then program still on proses
            else{
                // for menu = Nasigoreng
                if (menuUser == 1 && statBack == 1){
                    // show menu name and how many menu do you want
                    int qty = menu.screenConfirmOrder("Nasi Goreng", menus.get("Nasi Goreng"));
                    // if input 0 back to screen menu
                    if(qty == 0){
                        statBack = 0;
                    }
                    // if input not 0 proses calculate menu per order
                    else{
                        int subTotal = menu.calculatePerOrder(qty, menus.get("Nasi Goreng"));
                        // input value to temp variable
                        menuName.add("Nasi Goreng       ");
                        quantity.add(qty);
                        subT.add(subTotal);
                    }
                }
                // for menu = Mie Goreng
                else if(menuUser == 2 && statBack == 1){
                    // show menu name and how many menu do you want
                    int qty = menu.screenConfirmOrder("Mie Goreng", menus.get("Mie Goreng"));
                    // if input 0 back to screen menu
                    if(qty == 0){
                        statBack = 0;
                    }
                    // if input not 0 proses calculate menu per order
                    else {
                        int subTotal = menu.calculatePerOrder(qty, menus.get("Mie Goreng"));
                        // input value to temp variable
                        menuName.add("Mie Goreng        ");
                        quantity.add(qty);
                        subT.add(subTotal);
                    }
                }
                // for menu = Nasi + Ayam
                else if(menuUser == 3 && statBack == 1){
                    int qty = menu.screenConfirmOrder("Nasi + Ayam", menus.get("Nasi + Ayam"));
                    // if input 0 back to screen menu
                    if(qty == 0){
                        statBack = 0;
                    }
                    else {
                        int subTotal = menu.calculatePerOrder(qty, menus.get("Nasi + Ayam"));
                        // input value to temp variable
                        menuName.add("Nasi + Ayam       ");
                        quantity.add(qty);
                        subT.add(subTotal);
                    }
                }
                // for menu = Es Teh Manis
                else if(menuUser == 4 && statBack == 1){
                    int qty = menu.screenConfirmOrder("Es Teh Manis", menus.get("Es Teh Manis"));
                    // if input 0 back to screen menu
                    if(qty == 0){
                        statBack = 0;
                    }
                    else {
                        int subTotal = menu.calculatePerOrder(qty, menus.get("Es Teh Manis"));
                        // input value to temp variable
                        menuName.add("Es Teh Manis      ");
                        quantity.add(qty);
                        subT.add(subTotal);
                    }
                }
                // for menu = Es Jeruk
                else if(menuUser == 5 && statBack == 1){
                    int qty = menu.screenConfirmOrder("Es Jeruk", menus.get("Es Jeruk"));
                    // if input 0 back to screen menu
                    if(qty == 0){
                        statBack = 0;
                    }
                    else {
                        int subTotal = menu.calculatePerOrder(qty, menus.get("Es Jeruk"));
                        // input value to temp variable
                        menuName.add("Es Jeruk          ");
                        quantity.add(qty);
                        subT.add(subTotal);
                    }
                }
                // if input user 99 doing proses for payment
                else if(menuUser == 99 && statBack == 1){
                    // confirm order and payment
                    int inp = menu.screenConfirmPayment(menuName, quantity, subT);
                    // input 1 doing proses payment
                    if (inp == 1){
                        menu.screenPembayaran(menuName, quantity, subT);
                        menu.printStruck(menuName, quantity, subT);
                        stat = 0;
                    }
                    // input 2 back to screen menu to order something
                    else if(inp == 2){
                        statBack = 0;
                    // input 0 end aplication
                    } else if (inp == 0) {
                        stat = 0;
                    }
                }
            }
        }
    }
}