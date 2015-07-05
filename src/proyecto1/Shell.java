package proyecto1;

public class Shell implements Ordenador {

    public Shell(){ }

    @Override
    public void ordena(Dato[] datos){
        // traza info
        System.out.print("Shell [info]: [");
        for(Dato d: datos){
            System.out.print(d + " ");
        }
        System.out.println("]");

        int gap = datos.length/2;
        while (gap > 0){
            for (int nextPos = gap; nextPos < datos.length; nextPos++){
                Dato nextVal = datos[nextPos];
                while (nextPos > 0 && datos[nextPos-1].compareTo(nextVal) > 0){
                    datos[nextPos] = datos[nextPos-1];
                    nextPos--;
                    System.out.print("Shell [fine]: [");
                    for(Dato d: datos){
                        System.out.print(d + " ");
                    }
                    System.out.println("]");

                }
                datos[nextPos] = nextVal;
            }
            if (gap == 2) {
                gap = 1;
            }else{
                gap = (int) (gap/2.2);
            }
        }
        // traza info
        System.out.print("Shell [info]: [");
        for(Dato d: datos){
            System.out.print(d + " ");
        }
        System.out.println("]");
    }
}
