package domain.models;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlHttp extends UrlAbstrata {

    public boolean validaUrl(String x) {
        try {
            URL url = new URL(x);
            URLConnection conn = url.openConnection();
            conn.connect();
            return true;
        } catch (MalformedURLException e) {
            return false;// Não conseguiu conectar por conta da URL escrita errada
        } catch (IOException e) {
            return false;// Não conseguir conectar por erro no sistema (internet ruim, bloqueio externo, site fora do ar...)
        }
    }
}
