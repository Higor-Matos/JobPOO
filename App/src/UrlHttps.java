
//Utilizado para verificar Urls
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlHttps extends UrlAbstrata {
    public boolean validaUrl(String x) {
        Pattern regex = Pattern.compile(
                "^[https:\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)");
        Matcher matcher = regex.matcher(x);
        System.out.println(matcher.find());
        if (!matcher.find()) { // Verificação inicial de segurança é verdadeira
            return false;
        }
        try {
            URL url = new URL(x);
            URLConnection conn = url.openConnection();
            conn.connect();
            return true;// Conseguiu conexão
        } catch (MalformedURLException e) {
            return false;// Não conseguiu conectar
        } catch (IOException e) {
            return false;// Não conseguiu conectar
        }
    }
}