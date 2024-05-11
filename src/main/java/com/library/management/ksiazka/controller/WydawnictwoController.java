import com.library.management.ksiazka.entities.Wydawnictwo;
import com.library.management.ksiazka.services.WydawnictwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wydawnictwa")
public class WydawnictwoController {
    private WydawnictwoService wydawnictwoService;

    public WydawnictwoController(WydawnictwoService wydawnictwoService) {
        this.wydawnictwoService = wydawnictwoService;
    }

    @PostMapping
    public Wydawnictwo dodajWydawnictwo(@RequestBody Wydawnictwo wydawnictwo) {
        return wydawnictwoService.dodajWydawnictwo(wydawnictwo);
    }

    @GetMapping
    public List<Wydawnictwo> wszystkieWydawnictwa() {
        return wydawnictwoService.wszystkieWydawnictwa();
    }
}
