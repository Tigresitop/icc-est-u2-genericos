
import models.Persona;
import models.genericos.Caja;
import models.genericos.Par;

public class App {
    public static void main(String[] args) throws Exception {
        
        Caja<String> cajaString = new Caja<>();
        Caja<Integer> cajaInt = new Caja<>();
        Caja<Persona> cajaPersona = new Caja<>();

        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setEdad(21);

        cajaString.guardar("Guardo un String");
        cajaInt.guardar(10);

        System.out.println(cajaString.obtener());
        System.out.println(cajaInt.obtener());
        System.out.println(cajaPersona.obtener());

        Par<String, Integer> par = new Par<>();
        par.establecerClave("Hola que hace");
        par.establecerValor(54);

        System.out.println(par.obtenerClave());
        System.out.println(par.obtenerValor());

        Par<Integer, String> par2 = new Par<>();
        par2.establecerClave(41);
        par2.establecerValor("De nuevo");

        System.out.println(par2.obtenerClave());
        System.out.println(par2.obtenerValor());

        ///-----------------------------------
        
        Persona[] personas = {
            new Persona("Juan", 25),
            new Persona("María", 17),
            new Persona("Carlos", 30),
            new Persona("Ana", 16),
            new Persona("Pedro", 20),
            new Persona("Laura", 18),
            new Persona("Sofía", 15),
            new Persona("Luis", 21),
            new Persona("Marta", 19),
            new Persona("Jorge", 14)
        };

        Par<String, Integer>[] mayores = new Par[personas.length];
        Par<Integer, String>[] menores = new Par[personas.length];

        int contadorMayores = 0;
        int contadorMenores = 0;

        for (Persona perso : personas) {
            if (perso.getEdad() >= 18) {
                Par<String, Integer> parMayor = new Par<>();
                parMayor.establecerClave(perso.getNombre());
                parMayor.establecerValor(perso.getEdad());
                mayores[contadorMayores++] = parMayor;
            } else {
                Par<Integer, String> parMenor = new Par<>();
                parMenor.establecerClave(perso.getEdad());
                parMenor.establecerValor(perso.getNombre());
                menores[contadorMenores++] = parMenor;
            }
        }

        System.out.println("Menores de Edad:");
        for (int i = 0; i < contadorMenores; i++) {
            Par<Integer, String> menor = menores[i];
            System.out.println(menor.obtenerClave() + " --- " + menor.obtenerValor());
        }

        System.out.println("Mayores de Edad:");
        for (int i = 0; i < contadorMayores; i++) {
            Par<String, Integer> mayor = mayores[i];
            System.out.println(mayor.obtenerClave() + " --- " + mayor.obtenerValor());
        }

        
    }
}