package br.com.alura.screenmatch.model.movie;

public record MovieUpdateData(Long id, String nome, Integer duracao, Integer ano, String genero) {
}