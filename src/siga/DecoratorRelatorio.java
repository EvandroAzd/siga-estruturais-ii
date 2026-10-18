package siga;

public abstract class DecoratorRelatorio implements Relatorio {
    protected Relatorio relatorio;

    public DecoratorRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    @Override
    public String gerar(){
        return relatorio.gerar();
    }
}
