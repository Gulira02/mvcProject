package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.service.AgencyService;
@RequiredArgsConstructor
@Controller
@RequestMapping("/agencies")
public class AgencyApi {

    private final AgencyService agencyService;

    @GetMapping
    public String getAllAgency(Model model) {
        model.addAttribute("customers",agencyService.getAllAgencies() );
        return "agency/mainPage";
    }

}
