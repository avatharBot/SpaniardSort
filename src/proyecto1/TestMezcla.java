package proyecto1;

import junit.framework.TestCase;
import org.junit.Assert;

public class TestMezcla extends TestCase {

    private Dato[] datos = {
            new Dato("Agustin", "Morales", 45),
            new Dato("Tomas", "Martin", 15),
            new Dato("Maria", "Gutierrez", 30),
            new Dato("Maria", "Gutierrez", 15)
    };

    private Mezcla m;

    public TestMezcla(String name) { super(name); }

    public void setUp(){
        this.m = new Mezcla();
    }

    public void test00(){
        Dato a = this.datos[2];
        Dato b = this.datos[3];
        assertEquals("Nope", 0, a.compareTo(a));
        assertEquals("Nope", -1, b.compareTo(a));
        assertEquals("Nope", 1, a.compareTo(b));
    }

    public void test01(){
        m.ordena(datos);
        Dato a = datos[0];
        Dato b = datos[3];
        assertEquals("Nope", 15, a.getEdad());
        assertEquals("Nope", 45, b.getEdad());
    }


    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestMezcla.class);
    }

}
