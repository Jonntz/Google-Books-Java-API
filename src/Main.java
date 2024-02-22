import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual livro deseja pesquisar?");
        String title = scanner.nextLine().replaceAll("\\s", "+");

        String baseUrl = "https://www.googleapis.com/books/v1/volumes?q=";

        HttpClient http = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + title + "+intitle"))
                .build();

        HttpResponse<String> response = http.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}