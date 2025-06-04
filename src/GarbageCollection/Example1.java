package GarbageCollection;
import java.lang.System;
import java.lang.Runtime;

public class Example1 {
    public static void main(String[] args) {
        Employee E = new Employee("GFG1");
        Employee F = new Employee("GFG2");
        Employee G = new Employee("GFG3");

        E.display();
        F.display();

        E.nextIdMethod();
        G.nextIdMethod();

        /*
        garbage collector will see 2 objects free. Now to decrement nextId, garbage collector will call method to finalize() only when we programmers have overridden it in our class. And as mentioned previously, we have to request garbage collector, and for this, we have to write the following 3 steps before closing brace of sub-block.

        Set references to null(i.e X = Y = null;)
        Call, System.gc();
        Call, System.runFinalization();
         */

        {
            Employee X = new Employee("GFG4");
            Employee Y = new Employee("GFG5");
            X.display();
            Y.display();
            X.nextIdMethod();
            Y.nextIdMethod();
            System.gc();
            System.runFinalization();

        }
        E.nextIdMethod();
    }
}

class Employee{
    int id;
    String name;
    public static int nextId = 1;

    public Employee(String name)
    {
        this.name = name;
        this.id = nextId++;
    }

    public void display()
    {
        System.out.println("id : " + id + " name : " + name);
    }

    public void nextIdMethod() {
        System.out.println("Next id will be : " + nextId );
    }

    protected void finalize()
    {
        --nextId;
        // In this case,
        // gc will call finalize()
        // for 2 times for 2 objects.
    }
}