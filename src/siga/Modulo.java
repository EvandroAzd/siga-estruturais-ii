package siga;

import java.util.ArrayList;
import java.util.List;

public class Modulo implements ItemCurricular{

    private final String nome;
    private final List<ItemCurricular> filhos = new ArrayList<>();

    public Modulo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        int total = 0;
        for (ItemCurricular item : filhos){
            total += item.getCargaHoraria();
        }
        return total;
    }

    public String imprimir(int nivel){
        StringBuilder sb = new StringBuilder();
        sb.append("  ".repeat(nivel) + nome + " (" + getCargaHoraria() + "h)\n");
        for (ItemCurricular item : filhos) {
            sb.append(item.imprimir(nivel + 1) + "\n");
        }
        return sb.toString();
    }

    public void adicionar(ItemCurricular filho) {
        filhos.add(filho);
    }

    public List<ItemCurricular> getFilhos() {
        return filhos;
    }
}
