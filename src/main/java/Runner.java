import db.DBDancer;
import db.DBPointe;
import models.Dancer;
import models.Pointe;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Dancer dancer1 = new Dancer("Ana", "ballet");
        DBDancer.save(dancer1);
        Dancer dancer2 = new Dancer("Mario", "ballet");
        DBDancer.save(dancer2);
        Dancer dancer3 = new Dancer("Jose", "tango");
        DBDancer.save(dancer3);


        Pointe pointe1 = new Pointe("pink", 6);
        DBPointe.save(pointe1);
        Pointe pointe2 = new Pointe("purple", 4);
        DBPointe.save(pointe2);
        Pointe pointe3 = new Pointe("black", 5);
        DBPointe.save(pointe3);

        List<Dancer> dancers =  DBDancer.getAll();
        List<Pointe> pointeShoes = DBPointe.getAll();

        Dancer foundDancer = DBDancer.findById(1);
        Pointe foundPointe = DBPointe.findById(2);


    }
}
