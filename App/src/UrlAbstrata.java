abstract class UrlAbstrata{
    public String Endereco;
    public Reputacao reputacao;
    private boolean validacaoUrl;

    UrlAbstrata(){
        reputacao = new Reputacao();
    }

    public abstract boolean validaUrl(String x);

    public boolean getValidacaoUrl(){
        return this.validacaoUrl;
    }

    public void setValidacaoUrl(String x){
        //If testar validacaoUrl
        this.validacaoUrl = true;
        this.validacaoUrl = false;
    }


}