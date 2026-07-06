import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Viola {

    public static void main(String[] xx) {

          Frame okno = new Frame(" Nasa GUI app");
   
          Button gumb = new Button(new String("Klikne me"));

          gumb.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                 System.out.println(" Hvala, da se me dotikas");
              }
          });

          gumb.addActionListener(e->
              {   System.out.println(" Daj ponovno");
          }    
          );

          okno.addWindowListener(new WindowAdapter() {
               
               @Override
               public void windowClosing(WindowEvent e) {
                  System.exit(0);
               }

          });

          okno.setSize(200,300);
          okno.add(gumb);

          okno.setVisible(true);

          ArrayList<String> imena = new ArrayList<String>();
          imena.add("Metka");
          imena.add("Metka");
          imena.add("Metka");
          imena.add("Marica");
          imena.add("Ana");

          Collections.sort(imena);

//          imena.add(gumb);

          System.out.println(imena);
  

/*
    try {
       System.out.println("Vnesi st ponovitev in besedilo");
   
       Scanner vhod = new Scanner(System.in);

       int st = vhod.nextInt();
       String besedilo = vhod.nextLine();

       FileWriter datoteka = new FileWriter("datoteka.dat", true);

       for (int i=0; i<st; i++) {
         System.out.println(besedilo);
         datoteka.write(besedilo + "\n");
       
        datoteka.flush();

       }
       } catch (IOException e) {
           
       }

       try {

         int st = Integer.parseInt(xx[0]);
   
         for (int i=0; i<st; i++, System.out.println())
           for (int j=1; j<xx.length; j++)
              System.out.print(xx[j]+" ");
       } catch (ArrayIndexOutOfBoundsException e) {
             System.out.println("Pozabil si na stevilo");
         } catch (NumberFormatException e) {
             System.out.println("Prvi arg mora biti stevilo");
          } 
*/  

  }


}