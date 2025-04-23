public class Aresta {
    private final No no1;  // Tornado final para imutabilidade
    private final No no2;  // Tornado final para imutabilidade
    private final int peso;

    public Aresta(No no1, No no2, int peso) {
        if (no1 == null || no2 == null) {
            throw new IllegalArgumentException("Os nós não podem ser nulos");
        }
        if (peso < 0) {
            throw new IllegalArgumentException("Peso não pode ser negativo");
        }
        this.no1 = no1;
        this.no2 = no2;
        this.peso = peso;
    }

    // Getters básicos
    public No getNo1() {
        return no1;
    }

    public No getNo2() {
        return no2;
    }

    public int getPeso() {
        return peso;
    }

    public boolean conecta(No no) {
        return no1.equals(no) || no2.equals(no);
    }

    public No getNoOposto(No no) {
        if (no.equals(no1)) {
            return no2;
        } else if (no.equals(no2)) {
            return no1;
        }
        throw new IllegalArgumentException("O nó não pertence a esta aresta");
    }

    @Override
    public String toString() {
        return no1 + " --" + peso + "--> " + no2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aresta aresta = (Aresta) o;
        return peso == aresta.peso &&
               ((no1.equals(aresta.no1) && no2.equals(aresta.no2)) ||
               (no1.equals(aresta.no2) && no2.equals(aresta.no1)));
    }

    @Override
    public int hashCode() {
        return no1.hashCode() + no2.hashCode() + peso;
    }
}
