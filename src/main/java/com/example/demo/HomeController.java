package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String loadData(Model model)
    {
        Actor a = new Actor();
        a.setName("Sandra Bullock");
        a.setRealname("Sandra Mae Bullowski");
        

        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017L);
        movie.setDescription("About Emojis...");

        a.addMovie(movie);
        actorRepository.save(a);
        movieRepository.save(movie);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }

}
