package fr.imie.formation.poo.tp3;

/**
 * Created by Sebastien on 30/12/2014.
 */
public class TP3_1
{
    public static void main(String[] args)
    {
        Pair<Integer,String> p5 = new Pair<Integer,String>(9,"plus grand chiffre");

        Integer[] tab=new Integer[2];

        Pair.copieFstTab(p5,tab,0);

        Pair<Integer,Integer> p2 = new Pair<Integer,Integer>(9,10);

        System.out.println(p5.memeFst(p2));

        // Q2: p2.getClass() == p5.getClass() est TRUE, on peut conclure que l'objet P2 et P5 sont des instances d'une meme classe
        System.out.println(p2.getClass() == p5.getClass());

        //Q3
        System.out.println(p5.getNbInstances());
        Pair<String, String> p6 = new Pair<String, String>("hello", "world");
        System.out.println(p5.getNbInstances());

        //Q4: le paramètrage de type de classe Pair du constructeur s'est substitué a celui de l'objet p3
        Pair<?,?> p3 = new Pair<Integer, String>();
        p3.setFst(12);
        System.out.println(p3);

        //Q5
        affiche_ab(p6);
        affiche(p6);

    }

    public static<A,B> void affiche_ab(Pair<A,B> p)
    {
        System.out.println(p.getFst() + " " + p.getSnd());
    }

    public static void affiche(Pair<?,?> p)
    {
        System.out.println(p.getFst() + " " + p.getSnd());
    }
}
