/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.userapp;

/**
 *
 * @author ACER
 */
import java.util.Scanner;
public class User {
    private String userId; 
    private String email; 

  
    public User(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }
    

   
    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }
 
    public void capNhatEmail(String emailMoi) {
        if (emailMoi == null || !emailMoi.contains("@")) { 
            throw new IllegalArgumentException("Error: Invalid email!");
        }
        this.email = emailMoi; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("Enter user ID: ");
        String userId = scanner.hasNextLine() ? scanner.nextLine() : ""; 
        
        System.out.print("Enter email: ");
        String email = scanner.hasNextLine() ? scanner.nextLine() : ""; 
        
        User user = new User(userId, email); 
        System.out.println("\nUser created successfully!");
        
        while (true) { 
            System.out.println("\n=== MENU ===");
            System.out.println("1. View current email");
            System.out.println("2. Update new email");
            System.out.println("3. Exit the program");
            System.out.print("Select function: ");
            
            if (!scanner.hasNextInt()) { 
                System.out.println("Error: Please enter a number between 1 and 3.");
                scanner.next(); 
                continue; 
            }
            
            int luaChon = scanner.nextInt(); 
            scanner.nextLine(); 
            
            switch(luaChon) {
                case 1:
                    System.out.println("Current email: " + user.getEmail()); // Hiển thị email hiện tại
                case 2:
                    System.out.print("Enter new email: ");
                    String emailMoi = scanner.hasNextLine() ? scanner.nextLine() : ""; 
                    try {
                        user.capNhatEmail(emailMoi);
                        System.out.println("Email updated successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage()); 
                    }
                    break;
                case 3:
                    System.out.println("close");
                    scanner.close(); 
                    return;
                default:
                    System.out.println("Invalid selection, please try again!");
            }
        }
    }

}
