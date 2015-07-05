package proyecto1;

public class Mezcla implements Ordenador{

    private int comp;
    /**
     * Mergesort algorithm.
     * @param datos an array of Comparable items.
     */
    @Override
    public void ordena( Dato [ ] datos ) {
        // traza info
        System.out.print("Mezcla [info]: [");
        for(Dato d: datos){
            System.out.print(d + " ");
        }
        System.out.println("]");

        Dato [ ] tmpArray = new Dato[ datos.length ];
        int sorted = mergeSort( datos, tmpArray, 0, datos.length - 1 );

        // traza info
        System.out.print("Mezcla [info]: [");
        for(Dato d: datos){
            System.out.print(d + " ");
        }
        System.out.println("]");

    }

    private int mergeSort( Dato [ ] arr, Dato [ ] tmpArray, int left, int right ) {
        if( left < right ) {
            int center = ( left + right ) / 2;
            mergeSort( arr, tmpArray, left, center );
            mergeSort( arr, tmpArray, center + 1, right );

            return merge( arr, tmpArray, left, center + 1, right );
        }

        return -1;
    }

    private int merge( Dato [ ] arr, Dato [ ] tmpArray, int leftPos, int rightPos, int rightEnd ) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // main loop
        while( leftPos <= leftEnd && rightPos <= rightEnd ) {
            comp++;

            if( arr[ leftPos ].compareTo( arr[ rightPos ] ) <= 0 ) {
                tmpArray[tmpPos++] = arr[leftPos++];
            } else {
                tmpArray[tmpPos++] = arr[rightPos++];
            }
        }

        // Copy rest of the first half.
        while( leftPos <= leftEnd ) {
            tmpArray[tmpPos++] = arr[leftPos++];
        }
        // Copy rest of the second half.
        while( rightPos <= rightEnd ) {
            tmpArray[tmpPos++] = arr[rightPos++];
        }
        // Copy tmpArray.
        for( int i = 0; i < numElements; i++, rightEnd-- ) {
            arr[rightEnd] = tmpArray[rightEnd];
        }
        return comp;
    }

}
