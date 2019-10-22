public class Test {
    // creating a private field
    private String example;

    // creating a public constructor
    public Test()  {  example = "Pixel is not here"; }

    // Creating a public method with no arguments
    public void method1()  {
        System.out.println("The Example string is " + example);
    }

    // Creating a public method with int as argument
    public void method2(int n)  {
        System.out.println("The example number is " + n);
    }

    // creating a private method
    private void method3() {
        System.out.println("Private method invoked");
    }
}
