package org.example.settlingscores;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ScoreController {

    static Score score = new Score(30, 20, 10);

    @GetMapping("/health-check")
    public String getHealthCheck() {
        return "Still working ok";
    }

    @GetMapping("/score")
    public Score getScore() {
        return score;
    }

    @GetMapping("/score/{winslossesties}")
    public int getWinsLossesties(@PathVariable String winslossesties) {
        return switch (winslossesties) {
            case "wins" -> score.getWins();
            case "losses" -> score.getLosses();
            case "ties" -> score.getTies();
            default -> -1;
        };
    }

    @PostMapping("/score/wins")
    public Score increaseWins() {
            score.setWins(score.getWins() + 1);
            return score;
        }

    @PostMapping("/score/ties")
    public Score increaseTies() {
        score.setTies(score.getTies() + 1);
        return score;

        }

    @PostMapping("/score/losses")
    public Score increaseLosses() {
        score.setLosses(score.getLosses() + 1);
        return score;
    }

    @PatchMapping("/score/wins")
    public Score updateWins(@RequestParam(name="new-value") int newValue) {
        score.setWins(newValue);
        return score;

    }

    @PutMapping("/score")
    public Score replaceScore(@RequestBody Score newScore) {
        score = newScore;
        return score;
    }


}
