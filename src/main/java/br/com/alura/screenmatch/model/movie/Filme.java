package br.com.alura.screenmatch.model.movie;

import jakarta.persistence.*;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filmeSequence")
    @SequenceGenerator(name = "filmeSequence", sequenceName = "filme_sequence", allocationSize = 1)
    private Long id;
    private String nome;
    private Integer duracao;
    private Integer lancamento;
    private String genero;

    public Filme() {
    }

    public Filme(MovieData data) {
        this.nome = data.nome();
        this.duracao = data.duracao();
        this.lancamento = data.ano();
        this.genero = data.genero();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public Integer getLancamento() {
        return lancamento;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", lancamento=" + lancamento +
                ", genero='" + genero + '\'' +
                '}';
    }

    public void updateData(MovieUpdateData data) {
        this.nome = data.nome();
        this.duracao = data.duracao();
        this.lancamento = data.ano();
        this.genero = data.genero();
    }
}