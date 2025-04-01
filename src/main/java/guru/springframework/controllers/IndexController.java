package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureepository unitOfMeasureepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureepository unitOfMeasureepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureepository = unitOfMeasureepository;
    }

    @RequestMapping({"", "/", "/index"})

    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is: " + categoryOptional.get().getId());
        System.out.println("UOM ID is: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
