import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SimpleJavaClient {
    public SimpleJavaClient() {
    }

    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 9999);
            InputStream i = s.getInputStream();
            OutputStream o = s.getOutputStream();
            String str;
            do {
                byte[] line = new byte[100];
                System.in.read(line);
                o.write(line);
                //Thread.sleep(100);
                i.read(line);
                str = new String(line);
                System.out.println(str);
            } while(!str.trim().equals("bye"));

            s.close();
        } catch (Exception var6) {
            System.err.println(var6);
        }

    }
}
