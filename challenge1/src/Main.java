import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader inputreader = new BufferedReader(new InputStreamReader(System.in));
        String webaddress = "https://www.southampton.ac.uk/people/" + inputreader.readLine();
        URL url = new URL(webaddress);
        BufferedReader urlreader = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        String[] lines = {};
        while ((inputLine = urlreader.readLine()) != null) {
            if (inputLine.contains("<meta property=\"og:title\"")) {
                System.out.println(inputLine.substring(inputLine.indexOf("content=")+9, inputLine.indexOf(">")-3));
                break;
            }
        }
        inputreader.close();
        urlreader.close();
    }
}