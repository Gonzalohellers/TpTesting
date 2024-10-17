import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restaurante.*;

import java.util.ArrayList;
import java.util.List;


public class PedidoTest {

    static Pedido pedido;
    static Usuario usuario;

    @BeforeClass
    public static void cargarPedido(){
        Usuario Gonza = new Usuario("Gonzalo Hellers", 1, 500000, "gonzalohellers@gmail.com");
        ProductoBasico tomate = new ProductoBasico("Tomate", 6, 20);
        ItemPedido Ketchup = new ItemPedido(5, tomate);
        List<ItemPedido> pedidos = new ArrayList<>();
        pedidos.add(Ketchup);
        Pedido papasFritas = new Pedido(pedidos, Gonza);
        pedido = papasFritas;
        usuario = Gonza;
    }

    @Test
    public void reduceSaldo() throws SinSaldoException {
        int valorInicial =(int) usuario.getSaldo();
        pedido.entregarPedido();
        pedido.solicitarPedido();
        System.out.println(usuario.getSaldo());
        Assert.assertTrue("Valor Inicial: "+valorInicial+" Valor Actual: "+usuario.getSaldo(),valorInicial > usuario.getSaldo());
    }

}

