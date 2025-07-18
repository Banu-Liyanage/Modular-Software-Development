public class Variables { 
    private int myVariable ; // This is an instance variable

    public void myMethod(){
        int myVariable = 5; // This is a local variable
        System.out.println("Local variable: " + myVariable);

        System.out.println(this.myVariable); // Accessing the instance variable
    }
    
    public static void main(String[] args) {
        Variables variables = new Variables();
        variables.myMethod(); // Calling the method to demonstrate variable scope
    }
}
