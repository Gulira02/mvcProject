package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Customer;
import peaksoft.model.House;
import peaksoft.service.CustomerService;
import peaksoft.service.HouseService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/houses")
public class HouseApi {

    private final HouseService houseService;
    @GetMapping
    public String getAllHouse(Model model) {
        model.addAttribute("houses",houseService.getAllHouses() );
        return "house/mainPage";
    }


    @DeleteMapping("/{houseId}/delete")
    public String deleteUser(@PathVariable("houseId") Long id) {
        houseService.deleteHouseById(id);
        return "redirect:/houses";
    }


/*    @GetMapping("/{houseId}/edit")
    public String get(@PathVariable("houseId") Long id,
                      Model model) {
        model.addAttribute("house", houseService.getHouseById(id));
        return "house/edit";
    }

    @PutMapping("{houseId}/update")
    public String update(@ModelAttribute("house")House house,
                         @PathVariable("houseId") Long id) {
        houseService.updateHouse(id, house);
        return "redirect:/houses";
    }*/


}
