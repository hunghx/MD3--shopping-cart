package ra.model.service.product;

import ra.config.Config;
import ra.model.entity.Product;
import ra.model.service.product.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService {
    private static List<Product> productList = new Config<Product>().readFromFile(Config.PATH_PRODUCT);
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getProductId())==null){
            productList.add(product);
        }else {
            productList.set(productList.indexOf(findById(product.getProductId())),product);
        }
        new Config<Product>().writeToFile(Config.PATH_PRODUCT,productList);

    }

    @Override
    public Product findById(int id) {
        for (Product product:productList) {
            if (product.getProductId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (Product product:productList) {
            if (product.getProductId() == id){
                productList.remove(product);
                new Config<Product>().writeToFile(Config.PATH_PRODUCT,productList);
                return;

            }
        }
        System.err.println("Id not found! ");
    }

    @Override
    public List<Product> searchByName(String searchName) {
        List<Product> productListSearch= new ArrayList<>();
        for (Product p:productList) {
            if (p.getProductName().toLowerCase().contains(searchName.toLowerCase())){
               productListSearch.add(p);
            }
        }
        return productListSearch;
    }
}
