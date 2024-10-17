import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restaurante.Ingrediente;
import org.restaurante.Receta;

import java.util.ArrayList;
import java.util.List;

public class RecetaTEST {
    static List<Receta> recetas;

    @BeforeClass
    public static void puestaAPunto(){
        recetas = new ArrayList<>();
        Receta PapasFritas = new Receta("papa frita", 50, 15);
        Ingrediente i = new Ingrediente("Ketchup", "gr", 2, 12);
        PapasFritas.addIngrediente(i, 2);
        recetas.add(PapasFritas);
    }

    @Test
    public void tieneIngredientes(){
        boolean PudoRealizar=true;
        for(Receta r: recetas){
            if(!r.realizarReceta()){
               PudoRealizar=false;
            }
        }
        Assert.assertTrue("Se pudió", PudoRealizar);
    }
}
