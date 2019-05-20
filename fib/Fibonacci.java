import java.math.BigInteger;

public class Fibonacci{
	public static BigInteger of(int num){
		if(num==1||num==2)
			return new BigInteger("1");
		else{
			BigInteger m= of(1);
			BigInteger n=of(2);
			BigInteger result=n;
			for(int i=1;i<=num-2;i++){
				m=n;
				n=result;
				result=m.add(n);
			}
			return result;
		}						
	}	
}