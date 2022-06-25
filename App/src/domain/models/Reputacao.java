package domain.models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class Reputacao{
    public boolean confiavel;
    private String listaNaoConfiavel;

    public Reputacao(){//Sempre começo o programa chamando a função para baixar as listas
        try {
            setListaNaoConfiavel(requestListaNaoConfiavel());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getListaNaoConfiavel(){
        return this.listaNaoConfiavel;
    }

    public void setListaNaoConfiavel(String x) throws IOException, InterruptedException{
        this.listaNaoConfiavel = x;
    }

    public boolean verificaReputacaoNaLista(String x){ //Tratar String
        if(getListaNaoConfiavel().contains(x)){
            return true;
        }
        return false;
    }

    private String requestListaNaoConfiavel(){
        URI uri = URI.create("https://raw.githubusercontent.com/Higor-Matos/JobPOO/master/App/hostsblock/listblock");
        HttpRequest request = HttpRequest.newBuilder(uri).build();
        String content = " ";
        try {
            content = HttpClient.newHttpClient().send(request, BodyHandlers.ofString()).body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return content;
    }
}
