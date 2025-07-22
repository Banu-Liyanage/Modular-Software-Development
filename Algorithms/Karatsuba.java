import java.math.BigInteger;
public class Karatsuba {

    public static BigInteger karatsuba(BigInteger x, BigInteger y){
        if (x.compareTo(BigInteger.TEN) < 0 || y.compareTo(BigInteger.TEN) < 0) { //this is the base case where we can do single digit multiplication
            return x.multiply(y);
        }

        int n= Math.max(x.toString().length(), y.toString().length()); //get the number of digits 
        int Half=n/2; 

        BigInteger tenPowerHalf = BigInteger.TEN.pow(Half); //10^(n/2)

        BigInteger a= x.divide(tenPowerHalf); //divide x into 2 parts a and b 
        BigInteger b= x.mod(tenPowerHalf);

        BigInteger c=y.divide(tenPowerHalf);//divide y into 2 parts c and d
        BigInteger d=y.mod(tenPowerHalf);


        BigInteger ac=karatsuba(a,c); //apply the logic behind karatsuba 
        BigInteger bd=karatsuba(b,d);
        BigInteger adbc=karatsuba(a.add(b),c.add(d));  //recursion 

        BigInteger mid_Term= adbc.subtract(ac).subtract(bd);

        return ac.multiply(BigInteger.TEN.pow(2*Half)).add(mid_Term.multiply(tenPowerHalf)).add(bd);
    }

    public static void main(String[] args){

        BigInteger x= new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger y=new BigInteger("2718281828459045235360287471352662497757247093699959574966967627"); //customize this to get a user input 

        BigInteger result = karatsuba(x, y);
        System.out.println("Result is;\n"+ result);

    }
}
