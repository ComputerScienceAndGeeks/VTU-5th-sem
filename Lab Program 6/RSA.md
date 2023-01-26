# <center>Lab Program 6</center>
# <center>RSA Algorithm</center>
<hr>
<div style="font-size:20px"><p>(i.)Write an program for RSA Algorithm for generation of public and private keys.</p>
</div>
<div style="font-size:20px"><p>(ii.)Write an program for Encrytion and Decryption.</p>
</div>

### <b>RsaKeyGeneration.java </b>
```java
import java.util.*;
import java.lang.*;
import java.math.BigInteger;

public class RsaKeyGeneration
{
    public static void main(String[] args) {
        Random rand1 = new Random(System.currentTimeMillis());
        Random rand2 = new Random(System.currentTimeMillis()*10);
        int pubkey = Integer.parseInt(args[1]);

        BigInteger bigB_p = BigInteger.probablePrime(32,rand1);
        BigInteger bigB_q = BigInteger.probablePrime(32,rand2);
        BigInteger bigB_n = bigB_p.multiply(bigB_q); 
        BigInteger bigB_p_1 = bigB_p.subtract(new BigInteger("1"));
        BigInteger bigB_q_1 = bigB_q.subtract(new BigInteger("1"));
        BigInteger bigB_p_1_q_1 = bigB_p_1.multiply(bigB_q_1);

        while(true)
        {
            BigInteger BigB_GCD = bigB_p_1_q_1.gcd(new BigInteger(" "+pubkey));
            if(BigB_GCD.equals(BigInteger.ONE))
            {
                break;
            }
            pubkey++;
        }
        BigInteger bigB_pubkey = new BigInteger(" "+pubkey);
        BigInteger bigB_prvkey = bigB_pubkey.modInverse(bigB_p_1_q_1);
        System.out.println("Public Key: "+ bigB_pubkey +","+bigB_n);
        System.out.println("Private Key: "+bigB_prvkey+","+bigB_n);
    }
}
```

> OUTPUT : For (i.)
```shell
public key : 23,8554464461222370751
private key : 7810597980862781087, 85544664461222370751
```

### <b>RsaEncDec.java </b>

```java
import java.math.BigInteger;
import java.util.*;

public class RsaEncDec {
    public static void main(String[] args) {
        BigInteger bigB_pubkey = new BigInteger(args[0]);
        BigInteger bigB_prvkey = new BigInteger(args[1]);
        BigInteger bigB_n = new BigInteger(args[2]);

        int asciiVal = Integer.parseInt(args[3]);
        
        BigInteger bigB_val = new BigInteger(""+asciiVal);
        BigInteger bigB_cipherval = bigB_val.modPow(bigB_pubkey,bigB_n);
        
        System.out.println("Cipher Text: "+bigB_cipherval);
        
        BigInteger bigB_plainval = bigB_cipherval.modPow(bigB_prvkey,bigB_n);
        
        int plainVal = bigB_plainval.intValue();
        
        System.out.println("Plain Text: "+plainVal);
    }
}
```

> OUTPUT : For (ii.)
```shell
f:\Cns\Lab Program 6>java RsaEncDec 23 7810597980862781087 85544664461222370751 10
Cipher Text: 83831909292270962832
Plain Text: 10
```

<h2>Short description of RSA Algorithm:</h2>
<p>RSA or Rivest–Shamir–Adleman is an algorithm employed by modern computers to encrypt and decrypt messages. It is an asymmetric cryptographic algorithm. Asymmetric means that there are two different keys. This is also called public-key cryptography because one among the keys are often given to anyone. The other is the private key which is kept private. The algorithm is predicated on the very fact that finding the factors of an outsized number is difficult: when the factors are prime numbers, the matter is named prime factorization. It is also a key pair (public and personal key) generator.</p>

#### we can summarize the steps of RSA Algo:-

1. Consider two prime numbers p and q.
2. Compute n = p*q
3. Compute ϕ(n) = (p – 1) * (q – 1)
4. Choose e such gcd(e , ϕ(n) ) = 1
5. Calculate d such e*d mod ϕ(n) = 1
6. Public Key {e,n} Private Key {d,n}
7. Cipher text C = Pe mod n where P = plaintext
8. For Decryption D = Dd mod n where D will refund the plaintext.

_______
>NOTE: Be aware of passing values in command while execution of program.

