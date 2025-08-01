import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;


public class FileDownloader {
    public static void main(String[] args) {
        String fileURL = "https://d3c33hcgiwev3.cloudfront.net/_bcb5c6658381416d19b01bfc1d3993b5_IntegerArray.txt?Expires=1754179200&Signature=b73B54OlD6tpcswoFv1pFLHge5iPLVffNyyquhZ3DJDotUAeQg5PRcCVm-Yd4bB0uDr8AAgAR7PmOdeYjCoTuCfn9NlLCZPDF~VN~jcd2CfT8iX3SmPk3anO1YvftEAH3cuA4MBwBbGmAka8yeFtlQ5rOyqsUJihe1UD8PgNpSk_&Key-Pair-Id=APKAJLTNE6QMUY6HBC5A";
        String savePath = "IntegerArray.txt";

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
