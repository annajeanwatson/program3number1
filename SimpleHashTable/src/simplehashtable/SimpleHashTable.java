/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplehashtable;

import java.util.Scanner;
/*
* Anna Watson
* CSCI232 Program 3 - 2
* The purpose of this program is to impliment and manipulate a simple hashtable.  
* The program allows for user input to add, delete, and search nodes by key. 
* The program will automatically re-hash when the load is over .8.
*/
public class SimpleHashTable {
    
    
    
    public static void main(String[] args) 
    {
       HashTable hashTable = new HashTable();
       int input = 0;
       while(input != -1){
            Scanner scanner = new Scanner( System.in );
            System.out.println("What would you like to do?");
            System.out.println("Press 1 to add a key value pair");
            System.out.println("Press 2 to delete an item");
            System.out.println("Press 3 to search a key");
            System.out.println("Press -1 to exit");
            input = scanner.nextInt();
                
            
            switch(input){

                case 1:
                    System.out.println("Please enter a key: ");
                    Scanner scanner1 = new Scanner( System.in );
                    int key = scanner1.nextInt();
                    System.out.println("Please enter a value: ");
                    Scanner scanner2 = new Scanner( System.in );
                    int value = scanner2.nextInt();
                    hashTable.add(key, value);
                    
                    hashTable.print();
                        
                    break;
                case 2:
                    System.out.println("Please enter a key to delete: ");
                    Scanner scanner3 = new Scanner( System.in );
                    int key2 = scanner3.nextInt();
                    hashTable.delete(key2);    

                    hashTable.print();
                    
                    break;
                        
                case 3:
                    System.out.println("Please enter a key to search: ");
                    Scanner scanner4 = new Scanner( System.in );
                    int key3 = scanner4.nextInt();

                    if(hashTable.containsKey(key3))
                    {
                        System.out.println("This is contained in the hashtable!");
                    }
                    
                    else
                    {
                        System.out.println("This is not contained in the hashtable!");
                    }
                    
                    hashTable.print();
                        
                        break;
                        
                case -1:
                    input = -1;
                    break;
                }
            }
       
       
    }
    
}
