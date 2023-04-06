package ra.model.service.catalog;

import ra.config.Config;
import ra.model.entity.Catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogServiceIMPL implements ICatalogService {
    private static List<Catalog> catalogList = new Config<Catalog>().readFromFile(Config.PATH_CATALOG);
    @Override
    public List<Catalog> findAll() {
        return catalogList;
    }

    @Override
    public void save(Catalog catalog) {
       if (findById(catalog.getId())==null){
           catalogList.add(catalog);
       }else {
           catalogList.set(catalogList.indexOf(findById(catalog.getId())),catalog);
       }

        new Config<Catalog>().writeToFile(Config.PATH_CATALOG,catalogList);
    }

    @Override
    public Catalog findById(int id) {
        for (Catalog c:catalogList) {
            if (c.getId()==id){
                return c;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (Catalog c: catalogList) {
            if (c.getId()==id){
                catalogList.remove(c);
                new Config<Catalog>().writeToFile(Config.PATH_CATALOG,catalogList);
                return;
            }
        }
        System.out.println("Id not found! ");
    }

    @Override
    public List<Catalog> searchByName(String searchName) {
        List<Catalog> catalogListSearch = new ArrayList<>();
        for (Catalog catalog:catalogList) {
            if (catalog.getName().toLowerCase().contains(searchName.toLowerCase())){
                catalogListSearch.add(catalog);
            }
        }
        return catalogListSearch;
    }
}
