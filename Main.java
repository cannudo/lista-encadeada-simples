class Main {
    public static void main(String[] args) {
        ListaEncadeadaSimples<Integer> lista = new ListaEncadeadaSimples<Integer>();
        lista.append(1);
        lista.append(2);
        lista.append(3);
        lista.append(4);
        lista.append(5);
        lista.insert(0, 10);
        lista.status();
    }
}