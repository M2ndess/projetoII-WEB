package com.proj2;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import entity.EnchidoEntity;
import entity.PedidoClienteEntity;
import entity.PedidoItemEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    private final ProductService productService;
    //private final ShoppingCartService shoppingCartService;
    private final PedidoClienteRepository PedidoClienteRepository;
    private final PedidoItemRepository PedidoItemRepository;
    private final Map<EnchidoEntity,Integer> test;



    @Autowired
    public ProductController(ProductService productService, PedidoClienteRepository PedidoClienteRepository,PedidoItemRepository PedidoItemRepository) {
        this.productService = productService;
        this.PedidoClienteRepository = PedidoClienteRepository;
        this.PedidoItemRepository = PedidoItemRepository;
        this.test= new HashMap<>();

        //this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/productList")
    public String productList(Model model) {
        List<EnchidoEntity> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    @GetMapping("/products/{id}")
    public String productDetails(@PathVariable("id") Long id, Model model) {
        System.out.println(id);
        EnchidoEntity product = productService.getProductById(id);
        System.out.println(product.getCustoUnitario());
        model.addAttribute("product", product);
        return "productDetails";
    }
    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") Long id, Model model) {
        //test.put(productService.getProductById(id),3);
        // Add the logic to add the product to the shopping cart
        // ...
        return "redirect:/cart";
    }

    @GetMapping("/shoppingCart")
    public String shoppingCart(Model model) {
        model.addAttribute("cartItems", test);
        return "shoppingCart";
    }
    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("productId") Long productId,
                            @RequestParam("quantidade") Integer quantidade,
                            RedirectAttributes redirectAttributes) {
        test.put(productService.getProductById(productId), quantidade);
        //shoppingCartService.addToCart(product);
        redirectAttributes.addFlashAttribute("message", "Product added to cart successfully");
        return "redirect:/productList";
    }

    @PostMapping("/checkout")
    public String checkout(Model model) {
        double x=0;
        PedidoClienteEntity order = new PedidoClienteEntity();

        System.out.println("teste");
        order.setDataPedido(Date.valueOf(java.time.LocalDate.now()));
        order.setEstadoPedido("Ativo");
        order.setIdCliente(LoginController.loggedClientID);
        order.setTaxa(23.0);
        order.setPrecoLiquido(0.0);
        order.setIdEntrega(2);//aqui devia ser o id da entrega ALTERAR SE HOUVER TEMPO
        PedidoClienteEntity savedOrder = PedidoClienteRepository.save(order);
        System.out.println(test);
        test.forEach((key,value) ->{
            PedidoItemEntity orderquantity = new PedidoItemEntity();
            orderquantity.setIdPedido(savedOrder.getIdPedido());
            orderquantity.setQuantidade(value);
            orderquantity.setCustoUnitário(key.getCustoUnitario());
            orderquantity.setIdLote(key.getIdLote());
            PedidoItemRepository.save(orderquantity);
            order.setPrecoLiquido(order.getPrecoLiquido()+value*key.getCustoUnitario());

        });
        PedidoClienteRepository.save(order);
        test.clear();
        // Clear the cart after successful checkout
        return "indexLogged";
    }
}