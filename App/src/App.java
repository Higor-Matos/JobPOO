import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UrlHttp urlhttp = new UrlHttp();
        UrlHttps urlhttps = new UrlHttps();
        ArrayList<String> urlsNaoConfiaveis = new ArrayList<String>();
        do{

            System.out.print("Insira a Url para verificar confiabilidade.\nExemplo: https://www.google.com.br/\nUrl: ");
            String Entrada = scanner.next();

            if (Entrada.contains("https")) {//Verifico o protocolo do endereco
                if(urlhttps.validaUrl(Entrada)){//Chamo a função para verificar se o endereco é valido
                    urlhttps.setEndereco(Entrada);//Quando válido, coloco na varíavel do objeto
                    System.out.println(urlhttps.getEndereco());
                    System.out.println(urlhttps.reputacao.getListaNaoConfiavel());
                    if(urlhttps.getEndereco().contains(urlhttps.reputacao.getListaNaoConfiavel())){
                        urlsNaoConfiaveis.add(urlhttps.getEndereco());//Se não for confiável, adiciona na lista.
                    }
                }
            } else if (Entrada.contains("http")) {
                if(urlhttp.validaUrl(Entrada)){
                    urlhttp.setEndereco(Entrada);
                    if(urlhttp.getEndereco().equals(urlhttp.reputacao.getListaNaoConfiavel())){
                        urlsNaoConfiaveis.add(Entrada);
                    }
                }
            } else {
                System.out.println(">>> URL inválida <<< \nVerifique se inseriu corretamente com o protocolo HTTP ou HTTPS");
            }

            System.out.println("\n >>>> Lista de Urls não confiáveis <<<<\n" + urlsNaoConfiaveis);
        }while(true);
    }
}