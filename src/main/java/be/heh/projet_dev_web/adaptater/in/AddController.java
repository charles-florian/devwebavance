package be.heh.projet_dev_web.adaptater.in;

import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentAddUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AddController {

    private final TournamentAddUseCase tournamentAddUseCase;

    private Tournament tournament;

    @GetMapping("/")
    public String tournamentAdd(Model model){
        tournament=tournamentAddUseCase.addTournament();
        model.addAttribute("tournament",tournament);
        return("tournamentAdd");
    }
}
