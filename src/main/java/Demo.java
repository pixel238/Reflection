import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Disadvantage is that when a name of the class in the hidden api changes we need to manually change it here(string).
public class Demo {
    public static void main(String args[]) throws Exception
    {
        // Creating object whose property is to be checked in here Test's
        Test obj = new Test();

        // Creating class obj from the obj
        Class classObj = obj.getClass();
        System.out.println("The name of class is " + classObj.getName());//helps to get the name of the class

        // Getting the constructor of the class through the object of the class
        Constructor constructorObj = classObj.getConstructor();
        System.out.println("The name of constructor is " + constructorObj.getName());

        System.out.println("The public methods of class are : ");

        // Getting methods of the class through the object of the class by using getMethods
        Method[] methods = classObj.getMethods();

        // Printing method names
        for (Method method:methods)
            System.out.println(method.getName());

        // creates object of desired method by providing the method name and parameter class as arguments to the getDeclaredMethod
        Method method1Obj = classObj.getDeclaredMethod("method2", int.class);
        // invokes the method at runtime
        method1Obj.invoke(obj, 19);

        // creates object of the desired field by providing the name of field as argument to the getDeclaredField method
        Field field = classObj.getDeclaredField("example");
        // allows the object to access the field irrespective of the access specifier used with the field
        field.setAccessible(true);
        // takes object and the new value to be assigned to the field as arguments
        field.set(obj, "JAVA");

        // Creates object of desired method by providing the method name as argument to the getDeclaredMethod
        Method methodcall2 = classObj.getDeclaredMethod("method1");
        // invokes the method at runtime
        methodcall2.invoke(obj);

        // Creates object of the desired method by providing the name of method as argument to the getDeclaredMethod method
        Method methodcall3 = classObj.getDeclaredMethod("method3");
        // allows the object to access the method irrespective of the access specifier used with the method
        methodcall3.setAccessible(true);
        // invokes the method at runtime
        methodcall3.invoke(obj);
    }
}
