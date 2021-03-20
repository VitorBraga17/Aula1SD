import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SimpleJavaServer {
    public SimpleJavaServer() {
    }

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(9999);
            String str,resposta;
            int cont=0;
            while(true) {
                Socket c = s.accept();
                InputStream i = c.getInputStream();
                OutputStream o = c.getOutputStream();
                do {
                    byte[] line = new byte[100];
                    i.read(line);
                    str = new String(line).trim();
                    if(cont==0){
                        o.write(" | Opção A |\n | Opção B |\n | Opção C |\n | Opção D |\n Digite uma opção: ".getBytes());
                    }else{
                        switch (str){
                            case "A":
                                resposta = "a resposta é 1";
                                break;
                            case "B":
                                resposta = "a resposta é 2";
                                break;
                            case "C":
                                resposta = "a resposta é 3";
                                break;
                            case "D":
                                resposta = "a resposta é 4";
                                break;
                            default:
                                resposta = "nao ha resposta";
                        }
                        o.write(resposta.getBytes());
                    }
                    cont++;
                } while(!str.trim().equals("bye"));
                c.close();
            }
        } catch (Exception var7) {
            System.err.println(var7);
        }
    }
}