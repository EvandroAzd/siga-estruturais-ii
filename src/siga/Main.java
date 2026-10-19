package siga;

/**
 * Demonstra os três deslizes acontecendo. Execute e observe a saída:
 * é dela que partem as etapas da ficha de atividade prática.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Aula 11: Decorator e Composite (codigo inicial) ===");

        System.out.println();
        System.out.println("1) Relatorios: uma subclasse por combinacao");
        System.out.println("Exemplo 1: Relatorio com numeração e cabeçalho");

        Relatorio r = new RelatorioDeAlunos();
        r = new RelatorioComNumeracao(r);
        r = new RelatorioComCabecalho(r);
        System.out.println(r.gerar());

        System.out.println("\nExemplo 2: Relatorio com numeraçao, cabeçalho e marca d agua");
        Relatorio r2 = new RelatorioDeAlunos();
        r2 = new RelatorioComNumeracao(r2);
        r2 = new RelatorioComMarcaDAgua(r2);
        r2 = new RelatorioComCabecalho(r2);
        System.out.println(r2.gerar());

        System.out.println();
        System.out.println("2) Estrutura curricular percorrida sem instanceof");
        Modulo curso = new Modulo("DSM - Desenvolvimento de Software Multiplataforma");

        Modulo primeiro = new Modulo("1o semestre");
        primeiro.adicionar(new Disciplina("Algoritmos", 80));
        primeiro.adicionar(new Disciplina("Banco de Dados I", 60));

        Modulo segundo = new Modulo("2o semestre");
        segundo.adicionar(new Disciplina("Tecnicas de Programacao II", 80));
        segundo.adicionar(new Disciplina("Desenvolvimento Web II", 80));

        // submódulo de terceiro nível dentro do 2o semestre
        Modulo laboratorio = new Modulo("Laboratorio de Praticas");
        laboratorio.adicionar(new Disciplina("Pratica Web", 40));
        laboratorio.adicionar(new Disciplina("Pratica Mobile", 40));
        segundo.adicionar(laboratorio);

        curso.adicionar(primeiro);
        curso.adicionar(segundo);
        curso.adicionar(new Disciplina("Projeto Integrador", 40));

        //aplicando o composite
        System.out.println(curso.imprimir(0));
        System.out.println("Carga total: " + curso.getCargaHoraria() + "h");

//        GradeCurricular grade = new GradeCurricular();
//        grade.imprimir(curso, 1);
//        System.out.println("   Carga total: " + grade.calcularCarga(curso) + "h");
//        System.out.println("   >> DESLIZE 3: a travessia com instanceof aparece DUAS vezes,");
//        System.out.println("      uma em calcularCarga e outra em imprimir. Uma terceira");
//        System.out.println("      operacao exigiria uma terceira copia.");

    }
}
