package be.heh.projet_dev_web.adaptater.in;


import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentAddUseCase;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
import be.heh.projet_dev_web.port.in.TournamentUpdateUseCase;
import jdk.internal.icu.text.NormalizerBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TournamentControler {

    ModelAndView m = new ModelAndView();

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

    //UPDATE
    private final TournamentUpdateUseCase tournamentUpdateUseCase;

    @RequestMapping(value = "/tournamentUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView tournamentUpdateView(@PathVariable("id") String id,Model model) {
        Tournament t=tournamentUpdateUseCase.toUpdateTournament(id);

        m.setViewName("tournamentUpdate");
        m.addObject(t);
        model.addAttribute("tournament",t);
        //System.out.println(t.getNom()+" "+t.getId_tournament());
        return m ;

    }

    @RequestMapping(value="tournamentUpdate/tournamentUpdateConfirm/{id}", method = RequestMethod.POST)
    public RedirectView tournamentUpdate(@PathVariable("id") String id,@ModelAttribute("tournamentUpdate")Tournament tournament){
        Tournament t=new Tournament(tournament.getNom(),tournament.getDate(),tournament.getPrix(),tournament.getId_tournament());

        tournamentUpdateUseCase.updateTournament(t);

       RedirectView redirectView= new RedirectView("/");
        return redirectView;

    }

}
