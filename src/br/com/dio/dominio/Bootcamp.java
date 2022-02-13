package br.com.dio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Bootcamp {

    private String nome;
    private String descricao;
    private final LocalDate dataInicio = LocalDate.now();
    private final LocalDate dateFinal = dataInicio.plusDays(45);
    private Set<Dev> devInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDateFinal() {
        return dateFinal;
    }

    public Set<Dev> getDevInscritos() {
        return devInscritos;
    }

    public void setDevInscritos(Set<Dev> devInscritos) {
        this.devInscritos = devInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    public void removeConteudo(Conteudo conteudo){
        if (this.conteudos.contains(conteudo)) {
            this.conteudos.remove(conteudo);
        }else{
            System.err.println("Conteúdo não está cadastrado nesse bootcamp!");
        }
    }

    public int qtdConteudosBootcamp(Bootcamp bootcamp){
        return bootcamp.getConteudos().size();
    }

    public void devInscritos(){
        Set<Dev> devIncritos = new TreeSet<>(new ComparatorNomeXp());
        devIncritos.addAll(this.getDevInscritos());
        for (Dev dev: devIncritos){
            System.out.println("Nome: " + dev.getNome() + " XP adquiridos " + dev.calcularTotalXp());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao) && Objects.equals(dataInicio, bootcamp.dataInicio) && Objects.equals(dateFinal, bootcamp.dateFinal) && Objects.equals(devInscritos, bootcamp.devInscritos) && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicio, dateFinal, devInscritos, conteudos);
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicio=" + dataInicio +
                ", dateFinal=" + dateFinal +
                ", devInscritos=" + devInscritos +
                ", conteudos=" + conteudos +
                '}';
    }
}

class ComparatorNomeXp implements Comparator<Dev>{

    @Override
    public int compare(Dev d1, Dev d2) {
        int nome = d1.getNome().compareTo(d2.getNome());
        if (nome != 0) return nome;
        return Integer.compare((int) d1.calcularTotalXp(), (int) d2.calcularTotalXp());
    }
}