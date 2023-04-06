package ra.controller.catalog;

import ra.model.entity.Catalog;
import ra.model.service.catalog.CatalogServiceIMPL;
import ra.model.service.catalog.ICatalogService;

import java.util.List;

public class CatalogController implements ICatalogController {
    private  static  ICatalogService catalogService = new CatalogServiceIMPL();
    private static List<Catalog> catalogList = catalogService.findAll();
    @Override
    public List<Catalog> findAll() {
        return catalogList;
    }

    @Override
    public void save(Catalog catalog) {
        catalogService.save(catalog);
    }

    @Override
    public Catalog findById(int id) {
        return catalogService.findById(id);
    }

    @Override
    public void delete(int id) {
        catalogService.delete(id);
    }

    @Override
    public List<Catalog> searchByName(String searchName) {
        return catalogService.searchByName(searchName);
    }
}
