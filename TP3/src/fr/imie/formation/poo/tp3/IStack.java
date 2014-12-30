package fr.imie.formation.poo.tp3;

/**
 * Created by Sebastien on 30/12/2014.
 */
public interface IStack<T>
{
    public abstract boolean isEmpty();
    public abstract void push(T object);
    public abstract T pop();
    public abstract Integer count();
    public abstract T head();
}
