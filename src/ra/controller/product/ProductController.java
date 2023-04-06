package ra.controller.product;

import ra.controller.product.IProductController;
import ra.model.entity.Product;
import ra.model.service.product.IProductService;
import ra.model.service.product.ProductServiceIMPL;

import java.util.List;

public class ProductController implements IProductController {
    private static IProductService productService = new ProductServiceIMPL();
    private static List<Product> productList = productService.findAll();
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productService.save(product);
    }

    @Override
    public Product findById(int id) {
        return productService.findById(id);
    }

    @Override
    public void delete(int id) {
        productService.delete(id);
    }

    @Override
    public List<Product> searchByName(String searchName) {
        return productService.searchByName(searchName);
    }
}
