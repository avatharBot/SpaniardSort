package proyecto1;


public class Dato implements Comparable<Dato>{


    private String nombre;
    private String apellido;
    private int edad;

    public Dato(String n, String a, int e){
        this.nombre = n;
        this.apellido = a;
        this.edad = e;
    }

    public int compareTo(Dato dato){
        int nombComp = this.nombre.compareTo(dato.getNombre());
        int apelComp = this.apellido.compareTo(dato.getApellido());
        // son iguales
        if(nombComp == 0 && apelComp == 0 && this.edad == dato.getEdad()){
            return 0;
        }
        // es primero el apellido de THIS
        if (apelComp < 0){
            return -1;
        }
        // mismo apellido
        if(apelComp == 0){
            // va primero el nombre de THIS
            if(nombComp < 0) {
                return -1;
            }
            // mismo nombre
            if (nombComp == 0){
                return this.edad - dato.getEdad();
            }
        }
        // va primero dato
        return 1;
    }

    @Override
    public boolean equals(Object o){
        assert(o instanceof Dato);
        Dato d = (Dato) o;
        return this.nombre.equals(d.getNombre()) &&
                this.apellido.equals(d.getApellido()) &&
                this.edad == d.getEdad();
    }

    @Override
    public String toString(){
        return this.nombre + " " + this.apellido + " (" + this.edad + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

}
