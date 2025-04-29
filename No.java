public class No<TipoGenerico> {
    private TipoGenerico dado;
    private No<TipoGenerico> proximoNo;

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

    public No<TipoGenerico> getProximoNo() {
        return this.proximoNo;
    }

    public void setProximoNo(No<TipoGenerico> novoNo) {
        this.proximoNo = novoNo;
    }
}