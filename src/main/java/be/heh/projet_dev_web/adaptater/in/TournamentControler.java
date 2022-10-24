package be.heh.projet_dev_web.adaptater.in;


import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TournamentControler {

    private final TournamentListUseCase tournamentListUseCase;

    private List<Tournament> tournaments;

    @GetMapping("/")
    public String tournamentList(Model model){
        tournaments = tournamentListUseCase.getTournamentList();
        model.addAttribute("tournaments",tournaments);
        return  "tournamentList";
    }



}
