package com.github.Raingtor.controller;

import com.github.Raingtor.entity.Client;
import com.github.Raingtor.entity.Product;
import com.github.Raingtor.entity.ProductsOrders;
import com.github.Raingtor.repository.ClientRepository;
import com.github.Raingtor.repository.ProductRepository;
import com.github.Raingtor.service.ClientService;
import com.github.Raingtor.service.OrderService;
import com.github.Raingtor.service.ProductService;
import com.github.Raingtor.service.ProductsOrdersService;
import com.github.Raingtor.service.impl.OrderServiceImpl;
import com.github.Raingtor.service.impl.ProductServiceImpl;
import com.github.Raingtor.service.impl.ProductsOrdersServiceImpl;
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

    //для теста запроса, потом убрать
    private final ProductRepository productRepository;
    private final ProductsOrdersService productsOrdersService;
    private final OrderService orderService;

    @GetMapping("")
    public String getIndex(Model model) throws Exception{
        //для теста запроса, потом убрать
        //List<Product> products = productRepository.findTopProductsBetweenDates(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-04"), new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-16"));
        //productRepository.importFromCsv("D:\\SpringMvc\\src\\main\\resources\\csv\\pricelist.csv");
        String id = productsOrdersService.create(new ProductsOrders(1, orderService.findById("c0ecd124-1db6-11eb-adc1-0242ac120002"), productService.findById("0ed9f836-1db6-11eb-adc1-0242ac120002")));

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
