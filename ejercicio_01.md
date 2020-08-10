El siguiente codigo `no es un programa de java válido`:
```java
 String letra = "6";
    String prefijo = "Iteracion nro ";
    for (int i = 0; i < 10; i++) {
        if (letra == String.valueOf(i)) {
            System.out.println("El bucle continua");
            break;
        } else {
            System.out.println(prefijo + i);
        }
    }
```    
 Para que se pueda ejecutar un programa en java se necesita un metodo de entrada Main()
 
 
 ```java
 public static void main(String[] args) {
        String letra = "6";
        String prefijo = "Iteracion nro ";
        for (int i = 0; i < 10; i++) {
            if (letra == String.valueOf(i)) {
                System.out.println("El bucle continua");
                break;
            } else {
                System.out.println(prefijo + i);
            }
        }
    }
 ```
 En ese caso el resultado es:
 ```
Iteracion nro 0
Iteracion nro 1
Iteracion nro 2
Iteracion nro 3
Iteracion nro 4
Iteracion nro 5
Iteracion nro 6
Iteracion nro 7
Iteracion nro 8
Iteracion nro 9
 ```
 En el statement ` if (letra == String.valueOf(i)) {` no llega a ser **true** porque esta comparando dirección de memoria
 Si remplazamos con el metodo equals()  `if (letra.equals(String.valueOf(i)))` está comparando el contenido de los dos objetos y el resultado sería el siguiente:
 
 ```
 Iteracion nro 0
Iteracion nro 1
Iteracion nro 2
Iteracion nro 3
Iteracion nro 4
Iteracion nro 5
El bucle continua
 ```
 termina el loop con el cuando llega a al iteracion i=6
 
