package recipeproject.cookbook.bootstrap;

//@Component
//@Profile({"dev", "prod"})
public class MySQLBootstrap{ //implements ApplicationListener<ContextRefreshedEvent>{

//    private final CategoryRepository categoryRepository;
//    private final UnitMeasureRepository unitMeasureRepository;
//
//    public MySQLBootstrap(CategoryRepository categoryRepository, UnitMeasureRepository unitMeasureRepository) {
//        this.categoryRepository = categoryRepository;
//        this.unitMeasureRepository = unitMeasureRepository;
//    }
//
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        if(categoryRepository.count() == 0L){
//            loadCategories();
//        }
//
//        if(unitMeasureRepository.count() == 0L){
//            loadUom();
//        }
//    }
//
//    private void loadCategories(){
//        Category cat1 = new Category();
//        cat1.setDescription("Amercian");
//        categoryRepository.save(cat1);
//
//        Category cat2 = new Category();
//        cat2.setDescription("Mexican");
//        categoryRepository.save(cat2);
//
//        Category cat3 = new Category();
//        cat3.setDescription("European");
//        categoryRepository.save(cat3);
//
//        Category cat4 = new Category();
//        cat4.setDescription("Fast Food");
//        categoryRepository.save(cat4);
//
//        Category cat5 = new Category();
//        cat5.setDescription("Italian");
//        categoryRepository.save(cat5);
//    }
//
//    private void loadUom(){
//        UnitOfMeasure uom1 = new UnitOfMeasure();
//        uom1.setUom("Teaspoon");
//        unitMeasureRepository.save(uom1);
//
//        UnitOfMeasure uom7 = new UnitOfMeasure();
//        uom7.setUom("Dash");
//        unitMeasureRepository.save(uom7);
//
//        UnitOfMeasure uom2 = new UnitOfMeasure();
//        uom2.setUom("Tablespoon");
//        unitMeasureRepository.save(uom2);
//
//        UnitOfMeasure uom3 = new UnitOfMeasure();
//        uom3.setUom("Cup");
//        unitMeasureRepository.save(uom3);
//
//        UnitOfMeasure uom4 = new UnitOfMeasure();
//        uom4.setUom("Each");
//        unitMeasureRepository.save(uom4);
//
//        UnitOfMeasure uom5 = new UnitOfMeasure();
//        uom5.setUom("Pinch");
//        unitMeasureRepository.save(uom5);
//
//        UnitOfMeasure uom6 = new UnitOfMeasure();
//        uom6.setUom("Clove");
//        unitMeasureRepository.save(uom6);
//
//        UnitOfMeasure uom8 = new UnitOfMeasure();
//        uom8.setUom("Mililiters");
//        unitMeasureRepository.save(uom8);
//    }
}
