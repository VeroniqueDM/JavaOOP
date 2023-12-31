package christmasPastryShop;

import christmasPastryShop.core.ControllerImpl;
import christmasPastryShop.core.EngineImpl;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.io.ConsoleReader;
import christmasPastryShop.io.ConsoleWriter;
import christmasPastryShop.repositories.implementations.BoothRepositoryImpl;
import christmasPastryShop.repositories.implementations.CocktailRepositoryImpl;
import christmasPastryShop.repositories.implementations.DelicacyRepositoryImpl;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class Main {
    public static void main(String[] args) {

        String a = " ";
        int a1 = a.length();
        DelicacyRepository<Delicacy> delicacyRepository; // TODO: new DelicacyRepositoryImpl<>();
        CocktailRepository<Cocktail> cocktailRepository; // TODO: new CocktailRepositoryImpl<>();
        BoothRepository<Booth> boothRepository; // TODO: new BoothRepositoryImpl<>();

        delicacyRepository = new DelicacyRepositoryImpl();
        cocktailRepository = new CocktailRepositoryImpl();
        boothRepository = new BoothRepositoryImpl();

        Controller controller; // TODO: new ControllerImpl(delicacyRepository, cocktailRepository, boothRepository);
        controller = new ControllerImpl(delicacyRepository,cocktailRepository,boothRepository);
        // TODO:OPTIONAL

          ConsoleReader reader = new ConsoleReader();
         ConsoleWriter writer = new ConsoleWriter();
         EngineImpl engine = new EngineImpl(reader, writer, controller);
         engine.run();

    }
}
