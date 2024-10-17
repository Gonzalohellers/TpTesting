import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.restaurante.Producto;
import org.restaurante.ProductoBasico;
import org.restaurante.ProductoElaborado;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTEST {
    static List<Producto> productos;

    @BeforeClass
    public static void inicializar(){
        productos = new ArrayList<Producto>();
        productos.add(new ProductoElaborado("Huevo De Pascua", 20));
        productos.add(new ProductoBasico("Chocolate", 20, 23));
    }

    @Test
    public void dejaGanancia(){
        for(Producto p: productos){
            if(p.getPrecioUnitarioCompra()!=0){
            if(p.getPrecioUnitarioCompra() * 1.20 > p.getPrecioUnitarioVenta()){
                Assert.assertTrue(false);
            }}
        }
        Assert.assertTrue(true);
    }


    @TestFactory
    Collection<DynamicTest> testDejaGanancia() {
        // Crear una colección de DynamicTest
        List<DynamicTest> tests = new ArrayList<>();

        // Iterar sobre los productos
        for (Producto p : productos) {
            // Solo pruebas para productos con precio de compra mayor a 0
            if (p.getPrecioUnitarioCompra() != 0) {
                // Generar la prueba para cada producto
                tests.add(DynamicTest.dynamicTest("Test producto " + p.getNombre(), () -> {
                    // Comprobar que el precio de venta cubre el 20% de ganancia
                    Assert.assertTrue(p.getPrecioUnitarioCompra() * 1.20 <= p.getPrecioUnitarioVenta(),
                            "El producto " + p.getNombre() + " no deja suficiente ganancia.");
                }));
            }
        }

        return tests;
    }

}
