package com.github.Raingtor.controller;

import com.github.Raingtor.entity.Product;
import com.github.Raingtor.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor(onConstructor_ = @Autowired)
@Controller
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public String getIndex(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("products/create")
    public String createProductSink(Product product) {
        return "create-product";
    }

    @PostMapping("products/create")
    public String createProduct(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-product";
        }
        productService.create(product);
        return "redirect:/";
    }

    @GetMapping("products/edit/update/{id}")
    public String updateProductSink(@PathVariable String id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "update-product";
    }

    @PostMapping("products/update/{id}")
    public String updateProduct(@PathVariable String id, @Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-product";
        }
        productService.update(id, product);
        return "redirect:/";
    }

    @GetMapping("products/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.delete(id);
        return "redirect:/";
    }
}
