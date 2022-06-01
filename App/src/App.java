import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Entrada;
        UrlHttp urlhttp = new UrlHttp();
        UrlHttps urlhttps = new UrlHttps();

        do{
            System.out.print("Insira a Url para verificar confiabilidade.\nExemplo: https://www.google.com.br/\nUrl: ");
            Entrada = scanner.next();

            if (Entrada.contains("https")) {//Verifico o protocolo do endereco
                if(urlhttps.validaUrl(Entrada)){//Chamo a função para verificar se o endereco é valido
                    urlhttps.Endereco = Entrada;//Quando válido, coloco na varíavel do objeto
                    System.out.println("É válida " + urlhttps.Endereco);
                }
            } else if (Entrada.contains("http")) {
                if(urlhttp.validaUrl(Entrada)){
                    urlhttp.Endereco = Entrada;
                    System.out.println("É válida " + urlhttp.Endereco);
                }
            } else {
                System.out.println(">>> URL inválida <<< \nVerifique se inseriu corretamente com o protocolo HTTP ou HTTPS");
            }
        }while(true);
    }
}