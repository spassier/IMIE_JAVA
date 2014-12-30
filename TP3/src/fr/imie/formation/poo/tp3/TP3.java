package fr.imie.formation.poo.tp3;

/**
 * Created by Sebastien on 30/12/2014.
 */
public class TP3
{
    public static void main(String[] args)
    {
        //Q1 :
        IStack<Integer> integerStack = new StackList<Integer>();
        IStack<String> stringStack = new StackList<String>();

        for ( int i = 0; i < 10; i++)
        {
            integerStack.push(i);
        }

        stringStack.push("hi dude");
        stringStack.push("hello world");
        stringStack.push("happy new year");
        stringStack.push("happy christmas");

        System.out.format("> Integer stack count : %s\n", integerStack.count());
        System.out.format("> Integer stack head content : %s\n", integerStack.head());

        Integer popValue;
        popValue = integerStack.pop();
        System.out.println("> Integer stack pop value : " + popValue);
        popValue = integerStack.pop();
        System.out.println("> Integer stack pop value : " + popValue);
        popValue = integerStack.pop();
        System.out.println("> Integer stack pop value : " + popValue);
        popValue = integerStack.pop();
        System.out.println("> Integer stack pop value : " + popValue);
        System.out.format("> Integer stack count : %s\n", integerStack.count());


        System.out.format("> String stack count : %s\n", stringStack.count());
        System.out.format("> String stack head content : %s\n", stringStack.count());
        String stringValue;
        stringValue = stringStack.pop();
        System.out.println("> String stack pop value : " +  stringValue);
        stringValue = stringStack.pop();
        System.out.println("> String stack pop value : " + stringValue);
        System.out.format("> String stack count : %s", stringStack.count());
    }
}
