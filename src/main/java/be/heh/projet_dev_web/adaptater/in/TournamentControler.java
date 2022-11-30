package be.heh.projet_dev_web.adaptater.in;


import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentAddUseCase;
import be.heh.projet_dev_web.port.in.TournamentDeleteUseCase;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TournamentControler {

    ModelAndView m = new ModelAndView();

    private final TournamentDeleteUseCase tournamentDeleteUseCase;
    //Get
    private final TournamentListUseCase tournamentListUseCase;
    private List<Tournament> tournaments;
    @GetMapping("/")
    public ModelAndView tournamentList(Model model){
        tournaments = tournamentListUseCase.getTournamentList();
        model.addAttribute("tournaments",tournaments);

        m.setViewName("index");
        return m;
    }

    //Post
    private final TournamentAddUseCase tournamentAddUseCase;
    private Tournament tournament;
    @GetMapping("/tournamentAdd")
    @ResponseBody
    public ModelAndView tournamentAddView(Model model){

        m.setViewName("tournamentAdd");
        return m;
    }

    @PostMapping("/tournamentAdd")
    @ResponseBody
    public RedirectView tournamentAdd(@ModelAttribute("tournamentAdd") Tournament tournament){
        Tournament t = new Tournament(tournament.getNom(), tournament.getDate(), tournament.getPrix(), tournament.getId_tournament());
        tournamentAddUseCase.addTournament(t);

        RedirectView redirectView= new RedirectView("/");
        return redirectView;
    }


    @RequestMapping(value="/tournamentDelete/{id}", method = {RequestMethod.GET ,RequestMethod.DELETE})
    public RedirectView tournamentDelete(@PathVariable("id")Long id){

        tournamentDeleteUseCase.tournamentDelete(id);

        RedirectView redirectView= new RedirectView("/");
        return redirectView;

    }




}
