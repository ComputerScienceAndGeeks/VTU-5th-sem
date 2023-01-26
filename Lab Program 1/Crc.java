import java.io.*;
import java.util.Scanner;

public class Crc {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int[] data;
		int[] div;
		int[] divisor;
		int[] rem;
		int[] crc;
		
		int data_bits,divisor_bits,tot_length;
		
		System.out.println("Enter number of data bits: ");
	    data_bits = sc.nextInt();
	    data =new int[data_bits];
	    System.out.println("Enter data bits: ");
	    for(int i=0;i<data_bits;i++)
	    	data[i] = sc.nextInt();
	    
		System.out.println("Enter number of divisor bits: ");
	    divisor_bits = sc.nextInt();
	    divisor = new int[divisor_bits];
	    System.out.println("Enter divisor bits: ");
	    for(int i=0;i<divisor_bits;i++)
	    	divisor[i] = sc.nextInt();
	    
	    System.out.print("Data Bits are: ");
	    for(int i=0;i<data_bits;i++)
	    	System.out.print(data[i]);
	    System.out.println();
	    System.out.println("Divisor Bits are: ");
	    for(int i=0;i<divisor_bits;i++)
	    	System.out.print(divisor[i]);
	    System.out.println();
	    
	    tot_length = data_bits + divisor_bits - 1;
	    
	    div = new int[tot_length];
	    rem = new int[tot_length];
	    crc = new int[tot_length];
	    
	    for(int i=0; i<data.length ;i++)
	    	div[i] = data[i];
	    System.out.println("Dividend (after appending 0's) are: ");
	    for(int i=0; i<div.length ;i++)
	    	System.out.print(div[i]);
	    System.out.println();
	    for(int j=0; j<div.length ;j++)
	    	rem[j] = div[j];
	    
	    rem = divide(div, divisor, rem);
	    
	    for(int i=0;i<div.length;i++) 
	    {
	    	crc[i] = (div[i]^rem[i]);
	    }
	    System.out.println();
	    System.out.println("CRC Code: ");
	    for(int i=0; i<crc.length; i++)
	    	System.out.print(crc[i]);
	    System.out.println();
	    
	    System.out.println("Enter CRC Code of "+tot_length+" bits");
	    for(int i=0; i<crc.length ;i++)
	    	crc[i] = sc.nextInt();
	    for(int j=0; j<crc.length; j++)
	    	rem[j] = crc[j];
	    
	    rem = divide(crc, divisor, rem);
	    
	    for(int i=0;i<rem.length;i++)
	    {
	    	if(rem[i] != 0)
	    	{
	    		System.out.println("ERROR...");
	    		break;
	    	}
	    	if(i == rem.length-1)
	    		System.out.println("NO ERROR...");
	    }
	    
	    System.out.println("THANK YOU !!!");
 	}
	
	static int[] divide(int div[],int divisor[],int[] rem)
	{
		int cur = 0;
		while(true)
		{
			for(int i=0; i<divisor.length; i++)
				rem[cur+i] = (rem[cur+i]^divisor[i]);
			while(rem[cur] == 0 && cur!= rem.length-1)
				cur++;
			if((rem.length-cur)<divisor.length)
				break;
		}
		return rem;
	}
}


/*
OUTPUT: With NO-ERROR

Enter number of data bits: 
17
Enter data bits: 
1 0 0 0 1 0 0 0 0 0 0 1 0 0 0 0 1
Enter number of divisor bits: 
4
Enter divisor bits: 
1 0 1 1 
Data Bits are: 10001000000100001
Divisor Bits are:
1011
Dividend (after appending 0's) are:
10001000000100001000

CRC Code:
10001000000100001100
Enter CRC Code of 20 bits
1 0 0 0 1 0 0 0 0 0 0 1 0 0 0 0 1 1 0 0
NO ERROR...
THANK YOU !!!


OUTPUT : With ERROR

Enter number of data bits: 
17
Enter data bits: 
1 0 0 0 1 0 0 0 0 0 0 1 0 0 0 0 1
Enter number of divisor bits: 
4
Enter divisor bits: 
1 0 1 1
Data Bits are: 10001000000100001
Divisor Bits are:
1011
Dividend (after appending 0's) are:
10001000000100001000

CRC Code:
10001000000100001100
Enter CRC Code of 20 bits
1 0 0 0 1 0 0 0 0 0 0 1 0 0 0 0 1 0 0 0
ERROR...
THANK YOU !!!

 */
