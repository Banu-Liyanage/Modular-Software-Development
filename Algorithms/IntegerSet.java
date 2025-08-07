import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;


public class IntegerSet {
    public static void main(String[] args) {
        String fileURL = "https://d3c33hcgiwev3.cloudfront.net/_32387ba40b36359a38625cbb397eee65_QuickSort.txt?Expires=1754697600&Signature=Ujuk66wl7GBcMgbMBkFRPuKQFlV0emkaS-tXm6jGfaseVY3CEDNvCDceADvyluvDWGcLQwiY~MsJrnJJZ-c46SWUtyUGcGLddAzull7uyr1Pqrqo2gdIpmCHBxoOBpq~b7-BYxRRHOUo3jg4hfiRy021MtHMXtCYtb8U-ELwYog_&Key-Pair-Id=APKAJLTNE6QMUY6HBC5A";
        String savePath = "IntegerArray_2.txt";

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
