import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;


public class NodeData {
    public static void main(String[] args) {
        String fileURL = "https://d3c33hcgiwev3.cloudfront.net/_f370cd8b4d3482c940e4a57f489a200b_kargerMinCut.txt?Expires=1755043200&Signature=YEEZVK0BOy5q97yv2tlHOLkiuUBhn0coOJaasmmpHzmGE8UVewP6ZK75wHESowxIIb5M8c52WLmtmFZUDXlbCfTw-6jDiCNYLkvcmTHdeCadZwk2H54dY4lGr8YZ7eQkhKqXcjTE-5aIeyntIL-ojcJ4d4Tc9VSJ5ylni8Ag9ok_&Key-Pair-Id=APKAJLTNE6QMUY6HBC5A";
        String savePath = "GraphData.txt";

        try {
            URI uri = URI.create(fileURL);  //used this instead of url depreciated method //URI means Uniform Resource Identifier 
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection(); 

            //  Set a User-Agent to avoid 403 error, used this because it failed in trial 1 
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(savePath)) {

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = in.read(buffer, 0, 1024)) != -1) { // we write the input data stream to the buffer until bytesRead is finished
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("File downloaded successfully to:" + savePath);
            }
        } catch (IOException e) {
            System.err.println(" Download failed: " + e.getMessage());
        }
    }
}
