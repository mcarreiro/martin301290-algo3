package ej4;


public class Tupla<T,E> {

   private final T dato1;
   private final E dato2;

   /**
    * Construye una nueva tupla con los dos objetos proporcionados.
    * @param dato1 El primer dato a guardar en la tupla.
    * @param dato2 El segundo dato a guardar en la tupla.
    */
   public Tupla(T dato1, E dato2) {
       this.dato1 = dato1;
       this.dato2 = dato2;
   }

   /**
    * @return El contenido del objeto actual, con el formato "(dato1,dato2)".
    */
   @Override
   public String toString() {
       return "(" + dato1 + "," + dato2 + ")";
   }

   /**
    * @return El dato1
    */
   public T getDato1() {
       return dato1;
   }

   /**
    * @return El dato2
    */
   public E getDato2() {
       return dato2;
   }
   
}