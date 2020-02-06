package com.mtzperez.springidea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("coches")
public class HelloWorld {
    @Autowired
    private CocheRepository cocheRepository;
    @GetMapping
    public List<Coche> index(){
        return cocheRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Coche create(@Valid @RequestBody  Coche coche){
        return cocheRepository.save(coche);
    }
}
