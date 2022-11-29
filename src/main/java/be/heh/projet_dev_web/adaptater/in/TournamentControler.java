package be.heh.projet_dev_web.adaptater.in;


import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TournamentControler {
    ModelAndView m = new ModelAndView();
    private final TournamentListUseCase tournamentListUseCase;

    private List<Tournament> tournaments;

    @GetMapping("/tournamentList")
    public ModelAndView tournamentList(Model model){
        tournaments = tournamentListUseCase.getTournamentList();
        model.addAttribute("tournaments",tournaments);
        m.setViewName("tournamentList");
        return m;
        //return  "tournamentList";
    }
}
