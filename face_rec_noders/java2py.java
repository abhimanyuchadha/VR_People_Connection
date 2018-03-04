import java.io.*;

public class java2py
{

public static void main(String a[])
{
    try
    {
        int number1 = 10;
        int number2 = 32;
        ProcessBuilder pb = new ProcessBuilder("python3","face_rec_noders.py","obama.jpg");
        Process p = pb.start();
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String ret = in.readLine();
        System.out.println("value is : "+ret);
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
}
