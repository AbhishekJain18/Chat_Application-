import java.lang.*;
import java.net.*;
import java.io.*;

class Server
{
    public static void main(String arg[])throws Exception
    {
        System.out.println("Server application is running");
        String s1= null, s2=null;

        ServerSocket ss = new ServerSocket(1100);
        Socket s = ss.accept();
        
        System.out.println("Connection Sucessful");
        BufferedReader brk = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream ps = new PrintStream(s.getOutputStream());
        while((s1=br.readLine())!= null)
        {
            System.out.println("Client says : "+s1);
            System.out.println("enter Message for client : ");
            s2 = brk.readLine();
            ps.println(s2);
        }
        s.close();
        ss.close();
        br.close();
        brk.close();
        ps.close();
    }
}