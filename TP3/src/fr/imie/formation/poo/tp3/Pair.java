package fr.imie.formation.poo.tp3;

/**
 * Created by Sebastien on 30/12/2014.
 */
public class Pair<A,B>
{
    static Integer nbInstances = 0;

    private Object fst;
    private Object snd;

    public Pair(){}

    public Pair(Object f, Object s)
    {
        fst = f;
        snd = s;

        nbInstances++;
    }

    public Integer getNbInstances()
    {
        return nbInstances;
    }

    public Object getFst()
    {
        return fst;
    }

    public Object getSnd()
    {
        return snd;
    }

    public void setFst(Object a)
    {
        fst = a;
    }

    public void setSnd(Object b)
    {
        snd = b;
    }

    public static<X,Y> void copieFstTab(Pair<X,Y> p, X[] tableau, int i)
    {
        tableau[i] = (X) p.getFst();
    }

    public <C> boolean memeFst(Pair<A,C> p)
    {
        return p.getFst() == getFst();
    }

    @Override
    public String toString()
    {
        return getFst() + "-" + getSnd();
    }
}
