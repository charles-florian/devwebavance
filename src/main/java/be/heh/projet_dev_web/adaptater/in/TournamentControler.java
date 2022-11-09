package be.heh.projet_dev_web.adaptater.in;


import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentAddUseCase;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TournamentControler {

    //Get
    private final TournamentListUseCase tournamentListUseCase;

    private List<Tournament> tournaments;

    @GetMapping("/")
    public String tournamentList(Model model){
        tournaments = tournamentListUseCase.getTournamentList();
        model.addAttribute("tournaments",tournaments);
        return  "tournamentList";
    }


    //Post
    private final TournamentAddUseCase tournamentAddUseCase;

    private Tournament tournament;



    @PostMapping("/")
    public String tournamentAdd(Model model){
        tournamentAddUseCase.addTournament(tournament);
        model.addAttribute("tournament",tournament);
        return("tournamentAdd");
    }





}
