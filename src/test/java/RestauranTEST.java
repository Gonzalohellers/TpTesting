import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.restaurante.Ingrediente;
import org.restaurante.ItemReceta;
import org.restaurante.Receta;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RestauranTEST {
    static List<Receta> ejemplosRecetas;
    static Receta aleatoria;

    @BeforeClass
    public static void setUpBeforeClass(){
        ejemplosRecetas = new ArrayList<Receta>();
        Ingrediente sal=new Ingrediente("sal", "gr", 23, 3);
        ItemReceta ir=new ItemReceta(sal,2);
        Receta tortaM=new Receta("Torta de manzanas", 35, 5);
        tortaM.addIngrediente(ir);
        tortaM.addIngrediente(sal, 2);
        ejemplosRecetas.add(tortaM);
        ejemplosRecetas.add(new Receta("Torta de naranjas", 35, 8));
    }

    @Before
    public void aleatorio(){
        double numeroRandom=Math.floor(Math.random()*ejemplosRecetas.size());
        aleatoria = ejemplosRecetas.get((int)numeroRandom);
    }

    @Test
    public void compuestaUnoOMasIng(){
        Assert.assertFalse(aleatoria.getIngredientes().isEmpty());
    }

}
