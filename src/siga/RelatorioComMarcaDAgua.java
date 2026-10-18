package siga;

public class RelatorioComMarcaDAgua extends DecoratorRelatorio {

    public RelatorioComMarcaDAgua(Relatorio relatorio) {
        super(relatorio);
    }

    @Override
    public String gerar(){
        return "*** CONFIDENCIAL ***\n"
        + super.gerar();
    }
}
