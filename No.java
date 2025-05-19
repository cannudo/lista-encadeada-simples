public class No<TipoGenerico> {
    private TipoGenerico dado;
    private No<TipoGenerico> proximoNo;

    public No() {
        this.dado = null;
        this.proximoNo = null;
    }
    
    public No(TipoGenerico dado) {
        this.dado = dado;
        this.proximoNo = null;
    }

    public TipoGenerico getDado() {
        return this.dado;
    }

    public void setDado(TipoGenerico novoDado) {
        this.dado = novoDado;
    }

    public boolean temProximoNo() {
        return this.getProximoNo() != null;
    }

    public No<TipoGenerico> getProximoNo() {
        return this.proximoNo;
    }

    public void setProximoNo(No<TipoGenerico> novoNo) {
        this.proximoNo = novoNo;
    }

    public String toString() {
        String retorno;
        retorno = this.getDado() + " ➞ ";
        if(!this.temProximoNo()) {
            retorno += "∅";
        } else {
            retorno += this.getProximoNo().getDado();
        }
        return retorno;
    }
}