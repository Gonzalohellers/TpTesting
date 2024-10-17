
 # Indice
 [Before y After](#Before-y-After)
 [Test Dinamicos](#Test-Dinamicos)
 
 ## Before y After
 En este caso es Junit 5, por lo tanto cuando queremos ejecutar un metodo antes de un test usamos Before, pero en Junit4 usariamos BeforeEach y en testng BeforeMethod, igual que en after, junit5 After para ejecutar luego del metodo, AfterEach en Junit4 y AfterMethod en Testng
 ejemplo: extraido de PersonaTest:
     @Before
    public void elegirUno() throws Exception {
        //generador de numeros aleatorios
        Random generadorAleatorios = new Random();
        //genera un numero entre 1 y 5 y lo guarda en la variable numeroAleatorio
        int numeroAleatorio = generadorAleatorios.nextInt(PersonaTest.ejemplos.length);
        casoActual = ejemplos[numeroAleatorio];
        //  buCasoActual= clone(casoActual)

    }
 
 
 ## Test Dinamicos
 Las clases donde se implementan el test dinamico de la ultima consigna del tpe es en test.ProductoTest, el metodo que tiene @TestFactory
 `
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
    }`
