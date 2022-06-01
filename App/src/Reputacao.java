public class Reputacao{
    public boolean confiavel;
    private String listaNaoConfiavel;


    public String getListaNaoConfiavel(){
        return this.listaNaoConfiavel;
    }

    public void setListaNaoConfiavel(String x){
        this.listaNaoConfiavel = x;
    }

    public boolean verificaReputacaoNaLista(String x){ //Tratar String
        if(x == "true"){
            return true;
        }else{
            return false;
        }
    }

    private String requestListaNaoConfiavel(){
        String listaGit = " ";
        return listaGit;
    }
}