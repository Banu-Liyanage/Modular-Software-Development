import java.math.BigInteger;
public class Karatsuba {

    public static BigInteger karatsuba(BigInteger x, BigInteger y){
        if (x.compareTo(BigInteger.TEN) < 0 || y.compareTo(BigInteger.TEN) < 0) {
            return x.multiply(y);
        }

        int n= Math.max(x.toString().length(), y.toString().length());
        int Half=n/2;

        BigInteger tenPowerHalf = BigInteger.TEN.pow(Half);

        BigInteger a= x.divide(tenPowerHalf);
        BigInteger b= x.mod(tenPowerHalf);

        BigInteger c=y.divide(tenPowerHalf);
        BigInteger d=y.mod(tenPowerHalf);


        BigInteger ac=karatsuba(a,c);
        BigInteger bd=karatsuba(b,d);
        BigInteger adbc=karatsuba(a.add(b),c.add(d));

        BigInteger mid_Term= adbc.subtract(ac).subtract(bd);

        return ac.multiply(BigInteger.TEN.pow(2*Half)).add(mid_Term.multiply(tenPowerHalf)).add(bd);
    }

    public static void main(String[] args){

        BigInteger x= new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger y=new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");

        BigInteger result = karatsuba(x, y);
        System.out.println("Result is;\n"+ result);

    }
}
