class Main {
    public static void main(String[] args) {
        ListaEncadeadaSimples<String> lista = new ListaEncadeadaSimples<String>();
        lista.append("LAX");
        lista.append("MSP");
        lista.append("ATL");
        lista.append("BOS");
        Nodo<String> cauda = new Nodo<String>(null);
        cauda = lista.get(3);
        System.out.println(cauda.obterProximoNodo() + "\n");
        lista.status();
    }
}