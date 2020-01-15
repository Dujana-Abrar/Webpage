import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

    public static void main(String args[]) throws IOException {

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            try (Socket socket = server.accept()) {
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\n" + "Content-type: text/html \r\n\r\n"+
                        "<h1 style=\"text-align:center;vertical-align:middle;\">Loves contributing to ScoreLab.\n</h1>\n\n\n"+"<p style=text-align:center>"+today+"</p>";
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}
