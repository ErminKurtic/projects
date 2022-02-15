package com.part.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/lego")
public class LegoController {

    @Autowired
    LegoService service;

    @GetMapping("/all")
    public Collection<Lego> getLego(HttpServletResponse response) {
        return service.getAllLego();
    }

    @GetMapping("/search/{searchValue}")
    public Collection<Lego> getSearch(@PathVariable("searchValue")String searchValue, HttpServletResponse response) {
        return service.getSearchedLego(searchValue);
    }
}
