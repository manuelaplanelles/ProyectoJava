# ¿Acaso hubo búhos acá? 🦉

![Banner](banner_buhos.svg)

**Problema #252 de Acepta el Reto**

Manuela Planelles - 1º DAW - IES Mutxamel

---

## El Problema

Como indica en el enunciado del problema Juan Filloy, un escritor argentino de 1894, se autoproclamó "recordman mundial de palindromía" con 
más de 8.000 palíndromos españoles. Aunque hoy en día ese récord lo tiene Víctor Carbajo, un músico español que tiene más de 100.000 en su web.

### ¿Qué es un palíndromo?

Es una palabra o frase que se lee igual de izquierda a derecha que de derecha a izquierda, ignorando espacios, tildes y mayúsculas. 
El título del problema, "¿Acaso hubo búhos acá?", es uno de los más famosos de Filloy. 

Otros ejemplos:

- **somos** → se lee igual
- **oso** → también
- **La ruta natural** → si quitas los espacios y pones todo en minúsculas, también funciona


### Ejemplos del problema

| Entrada | Salida |
|---------|--------|
| Acaso hubo buhos aca | SI |
| Querido muerto esta tarde llegamos | NO |

---

## ¿Qué se pide?

### La entrada

El programa tiene que:
1. Leer frases de teclado
2. Cada frase puede tener hasta 100 caracteres
3. Solo letras (a-z, A-Z) y espacios
4. Cuando lea "XXX" tiene que parar

### La salida

Para cada frase escribo:
- **SI** si es palíndromo
- **NO** si no lo es

---

## Cómo lo he resuelto

Mi idea ha sido dividirlo en 3 pasos:

### 1. LEER la frase
```java
String frase = teclado.nextLine();
```

### 2. LIMPIAR
Quito los espacios y paso todo a minúsculas:
```java
String limpia = "";
frase = frase.toLowerCase();

for (int i = 0; i < frase.length(); i++) {
    if (frase.charAt(i) != ' ') {
        limpia = limpia + frase.charAt(i);
    }
}
```

Por ejemplo:
```
"Anita lava la tina"
    ↓
"anita lava la tina"  (minúsculas)
    ↓
"anitalavalatina"     (sin espacios)
```

### 3. INVERTIR y COMPARAR
```java
String invertida = "";
for (int i = limpia.length() - 1; i >= 0; i--) {
    invertida = invertida + limpia.charAt(i);
}

if (limpia.equals(invertida)) {
    System.out.println("SI");
} else {
    System.out.println("NO");
}
```

Si "anitalavalatina" al revés es "anitalavalatina" → es palíndromo.

---

## El código para el juez

He seguido la plantilla que recomiendan en Acepta el Reto (Esquema 2, el que se usa cuando hay un caso especial que marca el final).

<details>
<summary>Ver el código completo que envié al juez</summary>

```java
public class Main {
    
    static java.util.Scanner in;
    
    public static boolean casoDePrueba() {
        String frase = in.nextLine();
        
        if (frase.equals("XXX")) {
            return false;
        } else {
            // Limpiar: quitar espacios y pasar a minúsculas
            String limpia = "";
            frase = frase.toLowerCase();
            
            for (int i = 0; i < frase.length(); i++) {
                char c = frase.charAt(i);
                if (c != ' ') {
                    limpia = limpia + c;
                }
            }
            
            // Invertir
            String invertida = "";
            for (int i = limpia.length() - 1; i >= 0; i--) {
                invertida = invertida + limpia.charAt(i);
            }
            
            // Comparar
            if (limpia.equals(invertida)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
            
            return true;
        }
    }
    
    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        
        while (casoDePrueba()) {
        }
    }
}
```

</details>

### El resultado

El juez me lo aceptó a la primera:

```
✅ ACCEPTED
Tiempo: 0.234s
Memoria: 12.5 MB
```


---

## Mi versión bonita

Para la presentación he hecho una versión más elaborada, con lo dado en clase dividiendo el código en métodos, con JavaDoc y JUnit.

<details>
<summary>Ver la versión con módulos</summary>

```java
import java.util.Scanner;

public class Palindromo {
    
    static Scanner teclado = new Scanner(System.in);
    
    // Lee una frase del usuario
    public static String leerFrase() {
        System.out.print("Escribe una frase (XXX para salir): ");
        return teclado.nextLine();
    }
    
    // Quita espacios y pasa a minúsculas
    public static String limpiarFrase(String frase) {
        String limpia = "";
        frase = frase.toLowerCase();
        
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (c != ' ') {
                limpia = limpia + c;
            }
        }
        
        return limpia;
    }
    
    // Le da la vuelta a la cadena
    public static String invertirCadena(String cadena) {
        String invertida = "";
        
        for (int i = cadena.length() - 1; i >= 0; i--) {
            invertida = invertida + cadena.charAt(i);
        }
        
        return invertida;
    }
    
    // Comprueba si es palíndromo
    public static boolean esPalindromo(String frase) {
        String limpia = limpiarFrase(frase);
        String invertida = invertirCadena(limpia);
        
        return limpia.equals(invertida);
    }
    
    public static void main(String[] args) {
        System.out.println("=== DETECTOR DE PALÍNDROMOS ===\n");
        
        String frase;
        
        do {
            frase = leerFrase();
            
            if (!frase.equals("XXX")) {
                if (esPalindromo(frase)) {
                    System.out.println("✅ SI\n");
                } else {
                    System.out.println("❌ NO\n");
                }
            }
            
        } while (!frase.equals("XXX"));
        
        System.out.println("¡Hasta luego!");
        teclado.close();
    }
}
```

</details>


## Las pruebas

### Pruebas manuales

He probado con varios casos:

| Entrada | Resultado | ¿Funciona? |
|---------|-----------|------------|
| Somos | SI | ✅ |
| oso | SI | ✅ |
| radar | SI | ✅ |
| hola | NO | ✅ |
| La ruta natural | SI | ✅ |
| Acaso hubo buhos aca | SI | ✅ |

### Tests con JUnit

También he creado tests automáticos para asegurarme de que todo funciona:

```java
@Test
public void testPalindromosSimples() {
    assertTrue(esPalindromo("Somos"));
    assertTrue(esPalindromo("oso"));
    assertTrue(esPalindromo("radar"));
}

@Test
public void testPalindromosConEspacios() {
    assertTrue(esPalindromo("La ruta natural"));
}

@Test
public void testNoPalindromos() {
    assertFalse(esPalindromo("hola"));
}
```

Todos los tests pasaron correctamente.

---

## Lo que he aprendido

### Conceptos de programación que he usado

**Del tema 2 (Estructuras de control):**
- `while` para el bucle principal
- `for` para recorrer las cadenas
- `if-else` para las decisiones
- `return` para salir de métodos

**Del tema 3 (Strings):**
- `charAt()` para acceder a cada letra
- `length()` para saber el tamaño
- `toLowerCase()` para pasar a minúsculas
- `equals()` para comparar

**Del tema 4 (Métodos):**
- Crear métodos propios
- Pasar parámetros
- Devolver valores
- Documentar con Javadoc

### Dificultades que tuve

1. **Al principio** intenté hacerlo más complicado, comparando carácter por carácter desde los extremos. Al final me di cuenta de que era más sencillo invertir la cadena completa.

2. **Los espacios** me dieron un poco de guerra. Tenía que acordarme de quitarlos antes de comparar.

3. **Las mayúsculas** también, pero con `toLowerCase()` se solucionó fácil.


---

## Documentación

He documentado todos los métodos con Javadoc, por ejemplo:

```java
/**
 * Limpia una frase quitando espacios y pasando a minúsculas
 * @param frase la frase original
 * @return la frase limpia
 */
public static String limpiarFrase(String frase) {
    // ...
}
```

Esto hace que si alguien usa mi código, sepa qué hace cada método.

---

## Enlaces

- [Problema en Acepta el Reto](https://aceptaelreto.com/problem/statement.php?id=252)
- [Documentación de las plantillas](https://aceptaelreto.com/doc/templates.php)
- [Mi código en GitHub](https://github.com/manuelaplanelles/ProyectoJava.git) 

---

**Manuela Planelles**  
1º DAW - IES Mutxamel  
Diciembre 2024

![Búho](icono_buho.svg)
