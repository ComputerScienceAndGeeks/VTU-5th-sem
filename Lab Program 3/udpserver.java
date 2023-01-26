import java.io.*;
import java.util.*;
import java.net.*;

public class udpserver 
{
    public static void main(String[] args) throws IOException
    {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc=new Scanner(System.in);
        String str = "";
        System.out.println("\nEnter the message : ");
        str = sc.nextLine();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp =new DatagramPacket(str.getBytes(),str.length(),ip,3000);
        ds.send(dp);
        ds.close();
    }
}

