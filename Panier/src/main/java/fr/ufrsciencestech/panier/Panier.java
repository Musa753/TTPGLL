package fr.ufrsciencestech.panier;


import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author mouss
 */
public class Panier {
     ArrayList<melon> L;
     int taille;  
   
     public Panier(int t)
     {
        L=new ArrayList<melon>();
        this.taille=t;
     }
     
     
     public boolean estPlein(){ return L.size()>=this.taille;}
     
     public boolean estVide(){ return L.isEmpty();}
     
    
     @Override
    public String toString()
     {
         String chaine="Contenu du panier\n";
         for(int i=0;i<L.size();i++)
         {   chaine+=L.get(i).getPrix()+" "+L.get(i).getOrigine()+"\n";
             
         }
         return chaine;
     }
    
     @Override
     public boolean equals(Object obj)
     {    boolean drapeau = false;
           if(obj == null)
              drapeau= false;
           if(obj instanceof Panier && this ==obj)
              drapeau=true;
         return drapeau;
     }
     public void ajouteMelon(melon o)
     {
        if(!estPlein())
              L.add(o);
        else 
            System.out.print("plein");
     }
     
     public void retirmelon(melon o)
     {
       for(int i=0;i<L.size();i++)
       {
             if(!L.get(i).equals(o))
                 L.remove(i);
       }
     
     }
     
     
     public int getPrix()
     { int cpt=0;
       for(int i=0;i<L.size();i++)
           cpt+=L.get(i).getPrix();
        return cpt;
     }
     
     public void  BoycotteOrigine(String  o)
     {
       for(int i=0;i<L.size();i++)
       {
          if(L.get(i).getOrigine()==o)
              this.retirmelon(L.get(i));
       
       }
            
     }
     
    public static void main(String[] args) {
        
        Panier P=new Panier(3);
        P.ajouteMelon(new melon(0.9,"Mali"));
        P.ajouteMelon(new melon(0.9,"France"));
        P.ajouteMelon(new melon(0.9,"France"));
        P.BoycotteOrigine("France");
        System.out.println(P.toString());
    }
}
