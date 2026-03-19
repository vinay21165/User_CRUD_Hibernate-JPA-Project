package com.org.jpa.hibernateProject1;

import java.util.List;
import java.util.Scanner;

public class UserController {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserDao dao = new UserDao();

        while (true) {

            System.out.println("\n========= USER MENU =========");
            System.out.println("1  → Save User");
            System.out.println("2  → Update User");
            System.out.println("3  → Find User by ID");
            System.out.println("4  → Verify by Phone & Password");
            System.out.println("5  → Verify by Email & Password");
            System.out.println("6  → Verify by ID & Password");
            System.out.println("7  → Delete User");
            System.out.println("8  → Find Users by Name");
            System.out.println("9  → Find User by Phone");
            System.out.println("10 → Find User by Email");
            System.out.println("11 → Get All Phone Numbers");
            System.out.println("12 → Get All Users");
            System.out.println("13 → Get All Emails");
            System.out.println("0  → Exit");

            System.out.print(" Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                //  1. SAVE USER
                case 1:
                    System.out.println("---- SAVE USER ----");

                    sc.nextLine(); // buffer clear

                    User newUser = new User();

                    System.out.print("Enter Name: ");
                    newUser.setName(sc.nextLine());

                    System.out.print("Enter Phone: ");
                    newUser.setPhone(sc.nextLong());

                    sc.nextLine(); // buffer clear

                    System.out.print("Enter Email: ");
                    newUser.setEmail(sc.nextLine());

                    System.out.print("Enter Password: ");
                    newUser.setPassword(sc.nextLine());

                    dao.saveUser(newUser);
                    System.out.println(" User Saved Successfully");
                    break;

                // 2. UPDATE
                case 2:
                    System.out.println("---- UPDATE USER ----");
                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();

                    User u = dao.findById(id);

                    if (u != null) {
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        u.setName(sc.nextLine());

                        System.out.print("Enter New Phone: ");
                        u.setPhone(sc.nextLong());

                        sc.nextLine();

                        System.out.print("Enter New Email: ");
                        u.setEmail(sc.nextLine());

                        System.out.print("Enter New Password: ");
                        u.setPassword(sc.nextLine());

                        dao.updateUser(u);
                        System.out.println(" User Updated Successfully");
                    } else {
                        System.out.println(" User Not Found");
                    }
                    break;

                // 3. FIND BY ID
                case 3:
                    System.out.print("Enter ID: ");
                    System.out.println(dao.findById(sc.nextInt()));
                    break;

                // 4. VERIFY PHONE
                case 4:
                    System.out.print("Enter Phone: ");
                    long phone = sc.nextLong();
                    System.out.print("Enter Password: ");
                    System.out.println(dao.verifyByPhone(phone, sc.next()));
                    break;

                // 5. VERIFY EMAIL
                case 5:
                    System.out.print("Enter Email: ");
                    String email = sc.next();
                    System.out.print("Enter Password: ");
                    System.out.println(dao.verifyByEmail(email, sc.next()));
                    break;

                // 6. VERIFY ID
                case 6:
                    System.out.print("Enter ID: ");
                    int vid = sc.nextInt();
                    System.out.print("Enter Password: ");
                    System.out.println(dao.verifyById(vid, sc.next()));
                    break;

                // 7. DELETE
                case 7:
                    System.out.print("Enter ID: ");
                    dao.deleteUser(sc.nextInt());
                    System.out.println(" User Deleted");
                    break;

                // 8. FIND BY NAME
                case 8:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    List<User> list = dao.findByName(sc.nextLine());
                    list.forEach(System.out::println);
                    break;

                // 9. FIND BY PHONE
                case 9:
                    System.out.print("Enter Phone: ");
                    System.out.println(dao.findByPhone(sc.nextLong()));
                    break;

                // 10. FIND BY EMAIL
                case 10:
                    System.out.print("Enter Email: ");
                    System.out.println(dao.findByEmail(sc.next()));
                    break;

                // 11. GET PHONES
                case 11:
                    System.out.println(dao.getAllPhones());
                    break;

                // 12. GET ALL USERS
                case 12:
                    dao.getAllUsers().forEach(System.out::println);
                    break;

                // 13. GET EMAILS
                case 13:
                    System.out.println(dao.getAllEmails());
                    break;

                case 0:
                    System.out.println(" Exiting...");
                    System.exit(0);

                default:
                    System.out.println(" Invalid Choice");
                    
                    sc.close();
            }
        }
    }
}