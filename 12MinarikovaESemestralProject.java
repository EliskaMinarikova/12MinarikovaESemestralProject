/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.*;
/**
 * 12. Program for testing a random number generator 
 * @author Eliška Minaříková
 * 15/12/22
 */
public class 12MinarikovaESemestralProject {
    static void starLeft (int X)
    {
        for (int R = 0; R < X; R++) 
        {
            for (int V = 0; V < X; V++) 
            {
                if (R == V || R + V == X - 1 || V == X / 2 || R == X / 2)       //cykly pro vytvoření libovolně velké hvězdy
                {
                    System.out.print("* ");                                     //pro vytvoření perfektní hvězdy je však nejlepší zadat liché číslo
                }
                else 
                {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }

    static void starRight (int Y)                                               //metoda pro vytvoření "rámečku" v horní a dolní části textu
    {

        for (int R = 0; R < Y; R++) 
        {
            for (int V = 0; V < Y; V++) 
            {
                if (R == V || R + V == Y - 1 || V == Y || R == Y )              //jedná se o identickou metodu jako starLeft jen s většími mezery a chybí středová linie
                {
                    System.out.print("       *       ");
                } 
                else 
                {
                    System.out.print("                 ");
                }
            }
            System.out.println("");
        }
    }
    
    public static int VanocniUloha() 
    {
        Scanner sc = new Scanner(System.in);
        
        while (true)
        {
            System.out.println("Přejete si pokračovat? (a/n):");
            String answerVan = sc.next();
            int X = 0;
        
            if ("a".equals(answerVan) || "A".equals(answerVan))
        {
        System.out.println("Zadejte rok: ");
            int text = sc.nextInt();
            
            if (text < 1000)
            {
                System.out.println("Zadejte prosím čtyřčíselné číslo");         //ošetření kódu
                text = sc.nextInt();
            }
            
        System.out.println("Zadejte velikost hvězdy: ");
             X = sc.nextInt();

        int width = 100;                                                        //šířka "plátna", kde se vyobrazí text
        int height = 50;                                                        //výška "plátna"
        int Y = 7;                                                              //předdefinovaná velikost starRight

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("ComicSans", Font.BOLD, 24));                        //typ písma 

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("PF "+ text, 9, 17);                                //aktuální text a šířka + velikost písma

        starLeft(X);  
        starRight(Y);
        

        for (int y = 0; y < height; y++) 
        {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) 
            {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "*");

            }
            if (sb.toString().trim().isEmpty()) 
            {
                continue;
            }

            System.out.println(sb);
        }
        starRight(Y);
        starLeft(X);
        }
         
            if("n".equals(answerVan) || "N".equals(answerVan))
        {
            return X;                                                     //ukončení metody
        }  
        
        /*if (!"a".equals(answerVan) || !"A".equals(answerVan) || !"n".equals(answerVan) || !"N".equals(answerVan))
        {
            System.out.println("Zadejte 'a' nebo 'n'");
            answerVan = sc.next();
        
        }     */
        }
    }
    
    public static String Koeficient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pokracovat ve zpracovani (a/n):");
        String answer = sc.next();
        
        while(true)
        {
           
            double sxx = 0;
            double syy = 0;
            double sxy = 0;
            float sumX = 0;                                                          
            float sumY = 0;                                                          
            
        if ("a".equals(answer) || "A".equals(answer))
        {
            System.out.println("Dolni mez intervalu:");
            int a = sc.nextInt();
            
            System.out.println("Horni mez intervalu:");
            int b = sc.nextInt();
            
            System.out.println("Pocet generovanych hodnot:");
            int numbers = sc.nextInt();
            
            System.out.println("Delka kroku pro vytvoreni dvojic:");
            int step = sc.nextInt();
            
            if (numbers <= 0 || step <= 0)
            {
                System.out.println("Počet čísel nebo krok nesmí mít zápornou hodnotu");
            }
            
            if (step >= numbers)
            {
                System.out.println("Krok nesmí být větší než počet čísel");
            }
            
            ArrayList<Integer> list = new ArrayList<Integer>(numbers);          //vytvoření listu, do kterého se ukládají vygenerovaná náhodná čísla
            Random rand = new Random();
            for (int i = 0; i < numbers; i++)
            {
            list.add(rand.nextInt(b-a) + a);                                    //vygenerovaní náhodných čísel v určitém rozsahu
            }           
            
            for (int i = 0; i < (numbers - step); i++)
            {
                sumX = sumX + list.get(i);                                      //Suma X je sečtení prvních x čísel - krok
            }                                                                   //např. 8 čísel a krok je 2 = vezme prvních 6 čísel 
            
            float avgX = sumX / (numbers - step);                               //Average X je průměrná hodnota X
            
            for (int i = step; i < numbers; i++)
            {
                sumY = sumY + list.get(i);                                      //Suma Y je krok + sečtení prvních y čísel 
            }                                                                   //např. 8 čísel a krok je 2 = 2 čísla vynechá a sečte zbylých 6 čísel 
            
            float avgY = sumY / (numbers - step);                               //Average Y je průměrná hodnota Y
         
            for (int i = 0; i < (numbers-step); i++)
            {
                double x = list.get(i);                                         //převedení prvků do proměnné x
                double y = list.get(i+step);                                    //převedení prvků do proměnné y
                                                                             
                sxx += (x - avgX) * (x - avgX);                                 //vytvoření specifických proměnných pro snadnější orientaci ve vzorci
                syy += (y - avgY) * (y - avgY);
                sxy += (x - avgX) * (y - avgY);                
            }
            
            double koef = sxy / (Math.sqrt(sxx) * Math.sqrt(syy));
                        
            System.out.println("Vypocteny korelacni koeficient ma hodnotu: " + koef);
        }
        
        if("n".equals(answer) || "N".equals(answer))
        {
            return answer;                                                     //ukončení metody
        }  
        
        if (!"a".equals(answer) || !"A".equals(answer) || !"n".equals(answer) || !"N".equals(answer))
        {
            System.out.println("Pokracovat ve zpracovani (a/n):");
            answer = sc.next();
        
        }     
        }
    }
    
    
    
    
    
    public static void main(String[] args) {
        System.out.println("Vítejte u semestrální práce Elišky Minaříkové.");
        Scanner sc = new Scanner(System.in);
        
        while (true)
        {
            System.out.println("Pro provedení akce s názvem 'Vánoční úloha', zadejte číslo 1");
            System.out.println("Pro provedení akce s názvem 'Semestrální úloha', zadejte číslo 2");
            System.out.println("Pro ukončení semestrální práce, zadejte číslo 3");
            int menu = sc.nextInt();
            
            if (menu == 1)
            {
                VanocniUloha();
            }
            if (menu == 2)
            {
                Koeficient();
            }
            if (menu == 3)
            {
                System.exit(0);
            }
            
            if (menu != 1 || menu != 2 || menu != 3)
            {
                System.out.println("Zadejte čísla '1' nebo '2' nebo '3'");
            }
            
        }
    }
}
