package br.com.dio;

import br.com.dio.dominio.Bootcamp;
import br.com.dio.dominio.Curso;
import br.com.dio.dominio.Dev;
import br.com.dio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Curso curso = new Curso();
        curso.setTitulo("Curso Java");
        curso.setDescricao("Descrição curso Java");
        curso.setCargaHorario(80);

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Javascript");
        curso1.setDescricao("Descrição curso Javascript");
        curso1.setCargaHorario(80);

        //System.out.println(curso);
        //System.out.println(curso1);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("Descrição mentoria Java");
        mentoria.setData(LocalDate.now());

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria Javascript");
        mentoria1.setDescricao("Descrição mentoria Javascript");
        mentoria1.setData(LocalDate.now());

        //System.out.println(mentoria);
        //System.out.println(mentoria1);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(mentoria);
        bootcamp.getConteudos().add(mentoria1);

        //REMOVE CONTEÚDOS
        System.out.println(bootcamp);
        System.out.println("Bootcamp: " + bootcamp.getNome() + " quantidade de conteúdos: " + bootcamp.qtdConteudosBootcamp(bootcamp));
        bootcamp.removeConteudo(curso1);
        System.out.println(bootcamp);
        System.out.println("Bootcamp: " + bootcamp.getNome() + " quantidade de conteúdos: " + bootcamp.qtdConteudosBootcamp(bootcamp));
        System.out.println("");

        Dev dev1 = new Dev();
        dev1.setNome("Anderson");
        dev1.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos escritos " + dev1.getNome() + " "+ dev1.getConteudosInscritos());
        dev1.progredir();
        dev1.progredir();
        System.out.println("");
        System.out.println("Conteúdos concluídos " + dev1.getNome() + " "+ dev1.getConteudosConluidos());
        System.out.println("Conteúdos escritos " + dev1.getNome() + " "+ dev1.getConteudosInscritos());
        System.out.println("XP = " + dev1.calcularTotalXp());

        System.out.println("");
        System.out.println("-------------------------------------------------");

        Dev dev2 = new Dev();
        dev2.setNome("Junior");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos escritos " + dev2.getNome() + " "+ dev2.getConteudosInscritos());
        dev2.progredir();
        System.out.println("");
        System.out.println("Conteudos concluídos " + dev2.getNome() + " "+ dev2.getConteudosConluidos());
        System.out.println("Conteudos escritos " + dev2.getNome() + " "+ dev2.getConteudosInscritos());
        System.out.println("XP = " + dev2.calcularTotalXp());

        System.out.println("");
        System.out.println("Devs inscritos");
        bootcamp.devInscritos();

    }

}
