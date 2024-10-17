import org.example.Persona;

import java.util.Random;

public class PersonaTest {

    static Persona ejemplos[];
    static Persona casoActual;
    static Persona buCasoActual;

    @BeforeClass
    public static void cargarEjemplos() throws Exception {
        ejemplos = new Persona[6];


        ejemplos[0] = new Persona("Juan", "26.150.235", "1979-01-01","juan@gmail.com", 42, true);
        ejemplos[1] = new Persona("Pedro", "27.280.234", "1980-02-01", "creatinamonstruosa@gmail.com",41, true);
        ejemplos[2] = new Persona("Maria", "28.184.259", "1981-03-01","ratoncitofuerte@gmail.com", 47, true);
        ejemplos[3] = new Persona("Cecilia", "32.234.528", "1983-04-01","quesofurioso@gmail.com",38, true);
        ejemplos[4] = new Persona("Carlos", "33.124.235",  "1985-04-01", "milei1865@gmail.com",36, true);
        ejemplos[5] = new Persona("Jose", "35.345.534",  "1987-04-01", "myriambregman@gmail.com", 34, true);
    }


    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Bye byte ");
    }


    @Before
    public void elegirUno() throws Exception {
        //generador de numeros aleatorios
        Random generadorAleatorios = new Random();
        //genera un numero entre 1 y 5 y lo guarda en la variable numeroAleatorio
        int numeroAleatorio = generadorAleatorios.nextInt(PersonaTest.ejemplos.length);
        casoActual = ejemplos[numeroAleatorio];
        //  buCasoActual= clone(casoActual)

    }


    @Test
    public void tesHabilitadoParaVotar() {
        boolean obtenido = casoActual.isHabilitadoParaVotar();
        boolean esperado = casoActual.getEdad() > 16;
        Assert.assertEquals(obtenido, esperado);
    }


    @Test
    public void noExistenDuplicados() {
        boolean hayRepetidos = false;
        for (Persona persona : ejemplos) {
            for (Persona persona2 : ejemplos) {
                if ((!persona.equals(persona2)) && persona.getDNI().equals(persona2.getDNI())) {
                    System.out.println(persona);
                    System.out.println(persona2);
                    hayRepetidos = true;
                    break;
                }
                if (hayRepetidos)
                    break;
            }
        }
        Assert.assertFalse(hayRepetidos);
    }

    @Test
    public void correoValido(){
        boolean correoV=true;
        for(Persona persona : ejemplos){
            if(!persona.getCorreo().contains("@")){
               correoV=false;
            }
        }
        Assert.assertTrue(correoV);
    }

    public void compuestaUnoOMasIng(){

    }

}

