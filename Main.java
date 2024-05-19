class Main {
    public static void main(String[] args) {
        ListaEncadeadaSimples<String> lista = new ListaEncadeadaSimples<String>();
        Nodo<String> noQueNaoPodeSerCauda = new Nodo<String>("Requisito para o nó ser cauda: getProximoNodo() deve ser null!");
        noQueNaoPodeSerCauda.setProximoNodo(noQueNaoPodeSerCauda);
        lista.adicionarNovoNodo(noQueNaoPodeSerCauda);

        System.out.println();
    }
}