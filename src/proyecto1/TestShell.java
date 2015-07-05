package proyecto1;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class TestShell extends TestCase {

    private Dato[] datos = {
            new Dato("Agustin", "Morales", 45),
            new Dato("Tomas", "Martin", 15),
            new Dato("Maria", "Gutierrez", 30),
            new Dato("Maria", "Gutierrez", 15)
    };

    private Shell s;

    public TestShell(String name) { super(name); }

    public void setUp(){
        this.s = new Shell();
    }

    public void test00(){
        Dato a = this.datos[2];
        Dato b = this.datos[3];
        assertEquals("Nope", 0, a.compareTo(a));
        assertEquals("Nope", -1, b.compareTo(a));
        assertEquals("Nope", 1, a.compareTo(b));
    }

    public void test01(){
        s.ordena(datos);
        Dato b = datos[0];
        assertEquals("Nope", 15, b.getEdad());
    }


    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestShell.class);
    }

}
