package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.model.movie.MovieUpdateData;
import br.com.alura.screenmatch.model.movie.Filme;
import br.com.alura.screenmatch.model.movie.FilmeRepository;
import br.com.alura.screenmatch.model.movie.MovieData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @GetMapping("/formulario")
    public String loadForm(Long id, Model model) {
        if (id != null) {
            Filme filme = repository.getReferenceById(id);

            model.addAttribute("filme", filme);
        }
        return "filmes/formulario";
    }

    @GetMapping
    public String loadList(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "filmes/listagem";
    }

    @PostMapping
    @Transactional
    public String addMovie(MovieData data) {
        Filme filme = new Filme(data);

        repository.save(filme);

        return "redirect:/filmes";
    }

    @PutMapping
    @Transactional
    public String updateMovie(MovieUpdateData data) {
        Filme filme = repository.getReferenceById(data.id());

        filme.updateData(data);

        return "redirect:/filmes";
    }

    @DeleteMapping
    @Transactional
    public String deleteMovie(Long id) {
        repository.deleteById(id);

        return "redirect:/filmes";
    }
}