abstract class UrlAbstrata{
    private String Endereco;
    public Reputacao reputacao;

    UrlAbstrata(){
        reputacao = new Reputacao();
    }

    public abstract boolean validaUrl(String x);

    public String getEndereco(){
        return this.Endereco;
    }

    public void setEndereco(String x){
        this.Endereco = x;
    }
}