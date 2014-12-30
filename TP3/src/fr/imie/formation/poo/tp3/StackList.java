package fr.imie.formation.poo.tp3;

import java.util.LinkedList;


/**
 * Created by Sebastien on 30/12/2014.
 */
public class StackList<T> implements IStack<T>
{
    private LinkedList stack = new LinkedList();

    @Override
    public boolean isEmpty()
    {
        boolean result = false;

        if ( !stack.isEmpty() )
            result = true;

        return result;
    }

    @Override
    public void push(T object)
    {
        stack.add(object);
    }

    @Override
    public T pop()
    {
        return (T)stack.removeLast();
    }

    @Override
    public Integer count()
    {
        return stack.size();
    }

    @Override
    public T head()
    {
        return (T)stack.getFirst();
    }
}
