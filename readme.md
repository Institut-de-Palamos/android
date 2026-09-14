# Llenguatge Kotlin

Kotlin és el llenguatge oficial utilitzat per desenvolupar aplicacions al sistema operatiu Android. S'executa sobre la Java Virtual Machine (JVM), la qual cosa li atorga una compatibilitat total amb Java.

---

## 1. Configuració de l'Entorn


### A) IntelliJ IDEA
Per començar a programar en Kotlin es pot utilitzar l'entorn de desenvolupament **IntelliJ IDEA**, que ofereix suport per crear, editar i executar codi Kotlin.

### B) Sense IDE
```bash
sudo apt install kotlin
```

compilar:
```bash
kotlinc programa.kt -d output.jar
```

Fer córrer:
```bash
java -jar output.jar
```


### Primer programa

Igual que en altres llenguatges com Java o C++, l'execució del programa comença a la funció principal `main`.

```kotlin
// Per escriure un comentari d'una sola línia s'utilitzen dues barres diagonals

fun main() {
    // Impressió per pantalla utilitzant println
    println("Hola món")
}
```

- Les funcions es declaren amb la paraula reservada `fun`.
- Els comentaris d'una línia s'escriuen amb `//`.
- La funció `println()` s'encarrega d'imprimir missatges per la consola.



---

## 2. Variables i Tipus de Dades

Kotlin compta amb diversos tipus de dades bàsics: `String`, `Int`, `Double`, `Float` i `Boolean`. Tots s'escriuen amb majúscula inicial perquè són classes.

Per declarar variables s'utilitzen dues paraules reservades:
- **`val`**: Per a variables que no es poden reassignar després d'inicialitzar-les. Si contenen un objecte mutable, l'objecte encara pot canviar.
- **`var`**: Per a variables mutables (valors que sí que poden variar).

*(Es recomana declarar-ho tot inicialment com a `val` i canviar a `var` només quan sigui estrictament necessari reassignar el valor)*.

```kotlin
fun main() {
    // Declaració explícita del tipus de dada
    val numero: Int = 10

    // Inferència de tipus (Kotlin dedueix automàticament que és un Int)
    var edat = 26

    // Com que 'edat' es va declarar amb 'var', se li pot assignar un nou valor
    edat = 13

    // Una variable no pot rebre un valor d'un tipus incompatible
    // edat = "tretze" // Error: s'esperava un Int

    // Un val no es pot reassignar després d'inicialitzar-lo
    // numero = 20 // Error: val no es pot reassignar

    // Increment de valors (equivalent a C++)
    var clicks = 3
    clicks++ // 'clicks' passa a valer 4

    // Diferència entre Double i Float
    val decimalDouble = 3.3 // Per defecte és Double
    val decimalFloat = 3.3f // Cal afegir la 'f' o 'F' al final per especificar Float
}
```

---

## 3. Plantilles de Text (String Templates)

Per concatenar variables dins de cadenes de text no cal utilitzar contínuament l'operador `+`. Kotlin disposa de les **String Templates** utilitzant el símbol del dòlar `$`.

```kotlin
fun main() {
    val nom = "Joan"
    val edat = 26

    // Concatenació tradicional amb l'operador +
    println("Nom: " + nom + ", edat: " + edat)

    // String template: més llegible que la concatenació amb +
    println("Em dic $nom i tinc $edat anys")

    // Inserció d'expressions més complexes o operacions amb ${}
    val contactesAntics = 2
    val contactesNous = 10

    println("La quantitat total de contactes és ${contactesAntics + contactesNous}")
}
```

---

## 4. Funcions

Les funcions poden no retornar cap valor, retornar un tipus específic o incloure paràmetres opcionals amb valors per defecte.

```kotlin
// 1. Funció sense retorn (equivalent a 'void', el seu tipus intern és Unit)
fun saludar() {
    println("Hola món")
}

// 2. Funció amb tipus de retorn explícit (: Int)
fun retornarNumero(): Int {
    return 1
}

// 3. Funció amb paràmetres (el tipus de dada del paràmetre és obligatori)
fun sumarDos(numero: Int): Int {
    return numero + 2
}

// 4. Funció que retorna una cadena de text
fun descriurePersona(nom: String, edat: Int): String {
    return "Em dic $nom i tinc $edat anys"
}

// 5. Funció amb paràmetres opcionals i valors per defecte
// Si no s'especifica l'exponent, s'elevarà al quadrat (2.0)
fun elevar(base: Double, exponent: Double = 2.0): Double {
    return Math.pow(base, exponent)
}

fun main() {
    saludar()

    val valor = retornarNumero()
    val resultatSuma = sumarDos(5) // Retorna 7
    println(descriurePersona("Joan", 30))

    // Crides a funcions amb valors per defecte
    val elevarQuadrat = elevar(3.0) // Retorna 9.0
    val elevarCub = elevar(3.0, 3.0) // Retorna 27.0

    // Crida amb paràmetres anomenats (Named Arguments)
    // Permet especificar el nom del paràmetre i canviar-ne l'ordre
    val resultatExplicit = elevar(exponent = 3.0, base = 2.0) // Retorna 8.0
}
```

---

## 5. Estructures Condicionals i Expressions

### Condicional `if / else` i `when`

L'estructura `when` substitueix el tradicional `switch` de Java.

```kotlin
fun main() {
    val numero = 5

    // Estructura if / else if / else tradicional
    if (numero > 0) {
        println("El número és positiu")
    } else if (numero < 0) {
        println("El número és negatiu")
    } else {
        println("És zero")
    }

    // Estructura when (tipus switch)
    val opcio = "A"
    when (opcio) {
        "A" -> {
            println("Heu seleccionat")
            println("L'opció A")
        }
        "B" -> println("L'opció B")
        "C" -> println("L'opció C")
        else -> println("Opció no vàlida") // Aquí cobreix totes les altres opcions
    }

    // Una branca pot correspondre a diversos valors
    val nom = "Joan"
    when (nom) {
        "Joan", "Maria" -> println("És Joan o Maria")
        else -> println("No és ni Joan ni Maria")
    }

    // Evaluació de rangs i múltiples opcions dins d'un when
    val caracter = 3
    when (caracter) {
        0, 1 -> println("0 o 1")
        in 2..5 -> println("És entre 2 i 5") // Ús de rangs
        else -> println("Cap de les anteriors")
    }

    // when sense arguments per a condicions complexes
    when {
        numero > 0 -> println("És positiu")
        numero < 0 -> println("És negatiu")
        else -> println("És zero")
    }
}
```

### Bucle `for`

El bucle `for` permet repetir un bloc de codi recorrent rangs, col·leccions o mapes. La variable del bucle pren el valor de cada element en cada iteració.

#### Recórrer un rang

L'operador `..` crea un rang inclusiu, és a dir, inclou tant el primer com l'últim valor:

```kotlin
for (numero in 1..5) {
    println(numero) // 1, 2, 3, 4, 5
}
```

#### Recórrer una col·lecció

També es poden recórrer els elements d'una llista o d'un conjunt directament:

```kotlin
val noms = listOf("Anna", "Pau", "Joan")

for (nom in noms) {
    println(nom)
}
```

#### Recórrer amb índex

`indices` permet obtenir els índexs d'una llista. Amb `withIndex()` s'obtenen alhora l'índex i el valor:

```kotlin
val fruites = listOf("Poma", "Plàtan", "Taronja")

for (index in fruites.indices) {
    println("$index: ${fruites[index]}")
}

for ((index, fruita) in fruites.withIndex()) {
    println("$index: $fruita")
}
```

#### Recórrer en ordre invers o saltant valors

`downTo` recorre els valors de més gran a més petit, mentre que `step` permet indicar l'increment:

```kotlin
for (numero in 5 downTo 1) {
    println(numero) // 5, 4, 3, 2, 1
}

for (numero in 0..10 step 2) {
    println(numero) // 0, 2, 4, 6, 8, 10
}
```

#### Recórrer un mapa

En un `Map`, es poden obtenir la clau i el valor directament:

```kotlin
val edats = mapOf("Anna" to 20, "Pau" to 22)

for ((nom, edat) in edats) {
    println("$nom té $edat anys")
}
```

#### `break` i `continue`

- **`break`**: atura completament el bucle.
- **`continue`**: salta a la iteració següent.

```kotlin
for (numero in 1..10) {
    if (numero == 3) continue
    if (numero == 7) break
    println(numero) // 1, 2, 4, 5, 6
}
```

### `if` i `when` com a Expressions

En Kotlin, `if` i `when` poden retornar un valor directament per assignar-lo a una variable. La darrera línia de cada bloc és la que es guarda a la variable.

```kotlin
fun main() {
    val numero = 10

    // Assignació directa mitjançant un if com a expressió (simulant un operador ternari)
    val tipus = if (numero > 0) "positiu" else "negatiu"

    // Expressió amb when i avaluant el tipus de dada amb 'is'
    val variable: Any = "Hola" // 'Any' permet guardar qualsevol tipus de dada
    val tipusDada = when (variable) {
        is Int -> "És un enter"
        is String -> "És una cadena"
        else -> "No se sap"
    }
}
```

### `Any` i comprovació de tipus amb `is`

`Any` és el tipus comú de totes les classes de Kotlin. Una variable d'aquest tipus pot contenir valors de tipus diferents, i l'operador `is` permet comprovar quin tipus té en cada moment.

```kotlin
fun main() {
    var variable: Any = "Hola"
    println(variable)

    variable = 42
    println(variable)

    val valor: Any = "Kotlin"
    if (valor is String) {
        println("És una cadena de ${valor.length} caràcters")
    }

    when (valor) {
        is String -> println("És un String")
        is Int -> println("És un Int")
        else -> println("És d'un altre tipus")
    }
}
```

---

## 6. Gestió de Nuls (Null Safety)

Per defecte, en Kotlin les variables no poden contenir valors nuls (`null`) per evitar excepcions en temps d'execució (`NullPointerException`). Per permetre que una variable pugui ser nul·la, s'ha d'afegir el signe d'interrogació `?` al tipus de dada.

```kotlin
fun main() {
    // Declaració d'una variable nul·lable
    var nomPersona: String? = "Sebastià"
    nomPersona = null // Permès gràcies al tipus String?

    // Opció 1: Safe Call Operator (?.)
    // Si la variable és nul·la, no executa el mètode i retorna 'null'
    println(nomPersona?.length)

    // Opció 2: Not-Null Assertion Operator (!!)
    // Força l'execució. Si és nul, llançarà una NullPointerException! (No recomanat)
    // println(nomPersona!!.length)

    // Opció 3: Control amb if / else tradicional o expressió
    val llargadaNom = if (nomPersona != null) nomPersona.length else -1

    // Opció 4: Operador Elvis (?:)
    // Si l'expressió de l'esquerra no és nul·la la retorna, si és nul·la retorna el valor de la dreta (-1)
    val llargadaElvis = nomPersona?.length ?: -1
}
```

---

## 7. Programació Orientada a Objectes (POO)

Kotlin permet definir l'estructura de classes directament al codi. No cal utilitzar la paraula reservada `new` per instanciar objectes.

### Declaració bàsica

Les classes es declaren amb la paraula reservada `class`. Kotlin té una sintaxi compacta i permet declarar el constructor principal directament a la capçalera.

```kotlin
class Persona(nom: String, edat: Int)
```

Quan un paràmetre del constructor porta `val` o `var`, es converteix automàticament en una propietat de la classe. Sense `val` o `var`, només es pot utilitzar durant la inicialització.

```kotlin
class Persona(val nom: String, var edat: Int) {
    // 'val' i 'var' creen propietats automàticament
}
```

Els objectes s'instancien sense utilitzar la paraula reservada `new`:

```kotlin
val persona = Persona("Joan", 26)
println(persona.nom)
```

### Constructors

#### Constructor principal

És el constructor que apareix a la capçalera de la classe:

```kotlin
class Cotxe(val marca: String, var any: Int)
```

#### Constructor secundari

S'escriu amb la paraula `constructor`. Si la classe té un constructor principal, el constructor secundari l'ha de cridar amb `this`:

```kotlin
class Cotxe {
    val marca: String
    var any: Int

    constructor(marca: String, any: Int) {
        this.marca = marca
        this.any = any
    }
}
```

#### Bloc `init`

El bloc `init` s'executa automàticament quan es crea l'objecte, després d'inicialitzar els paràmetres i les propietats del constructor principal. És útil per executar validacions o altres accions d'inicialització.

```kotlin
class Usuari(val nom: String) {
    init {
        println("Usuari creat: $nom")
    }
}
```

### Getters i setters personalitzats

Kotlin genera automàticament el getter i el setter de les propietats. Es poden personalitzar amb `get` i `set`. Dins d'un setter, `value` és el valor rebut i `field` és el valor emmagatzemat internament.

```kotlin
class Persona(val nom: String, edatInicial: Int) {
    var edat: Int = edatInicial
        set(value) {
            field = if (value > 0) value else 0
        }
}
```

### Herència

Per defecte, les classes de Kotlin són `final`, és a dir, no es poden heretar. Cal marcar la classe pare amb `open`. Els mètodes que es vulguin sobreescriure també han de ser `open`.

```kotlin
open class Animal(val nom: String) {
    open fun so() = "..."
}

class Gos(nom: String) : Animal(nom) {
    override fun so() = "Bup bup!"
}
```

- **`open`**: permet heretar una classe o sobreescriure un membre.
- **`override`**: indica que es redefineix un membre de la classe pare.
- **`super`**: permet cridar la implementació de la classe pare.

```kotlin
class Gat(nom: String) : Animal(nom) {
    override fun so(): String {
        return "Mèu!"
    }
}
```

### Modificadors de visibilitat

| Modificador | Significat |
| --- | --- |
| `public` | Visible des de qualsevol lloc. És el valor per defecte. |
| `private` | Visible només dins de la classe o del fitxer si és una declaració top-level. |
| `protected` | Visible dins de la classe i de les seves subclasses. |
| `internal` | Visible dins del mateix mòdul. |

#### Quan fer servir `private`?

S'utilitza quan una propietat o funció és un detall intern i no s'ha de poder modificar directament des de fora:

```kotlin
class CompteBancari {
    private var saldo: Double = 0.0

    fun ingressar(quantitat: Double) {
        saldo += quantitat
    }

    fun consultarSaldo() = saldo
}
```

#### Quan fer servir `protected`?

Permet que les subclasses accedeixin a una propietat sense exposar-la al codi exterior:

```kotlin
open class Figura {
    protected var color: String = "negre"
}

class Cercle : Figura() {
    fun pintar() {
        color = "vermell"
    }
}
```

`internal` és útil per compartir codi dins d'un mateix mòdul, com ara una llibreria, sense exposar-lo com a API pública.

### Altres modificadors i tipus de classe

- **`abstract`**: classe o membre sense implementació; les subclasses l'han de definir.

```kotlin
abstract class Forma {
    abstract fun area(): Double
}
```

- **`sealed`**: defineix una jerarquia tancada de classes, molt útil amb `when`.

```kotlin
sealed class Resultat
class Exit(val dades: String) : Resultat()
class Error(val missatge: String) : Resultat()
```

- **`data class`**: genera automàticament `equals`, `hashCode`, `toString` i `copy`.

```kotlin
data class Punt(val x: Int, val y: Int)
```

- **`object`**: crea una única instància, és a dir, un singleton.

```kotlin
object Configuracio {
    val versio = "1.0"
}
```

- **`companion object`**: permet definir membres associats a una classe, amb un ús semblant als membres `static` de Java.

```kotlin
class Utils {
    companion object {
        fun suma(a: Int, b: Int) = a + b
    }
}

Utils.suma(2, 3)
```

### Exemple complet d'herència

```kotlin
// Classe pare amb una funció que es pot sobreescriure
open class Persona(val nom: String, edatInicial: Int) {
    var edat: Int = edatInicial
        set(value) {
            field = if (value > 0) value else 0
        }

    open fun saludar() {
        println("Em dic $nom i tinc $edat anys")
    }
}

class Treballador(
    nom: String,
    edat: Int,
    val feina: String,
    val salari: Double
) : Persona(nom, edat) {
    var estalvi: Double = 0.0

    override fun saludar() {
        super.saludar()
        println("Treballo de $feina")
    }

    fun treballar() {
        estalvi += salari
    }
}

fun main() {
    val treballador = Treballador("Diego", 26, "Desenvolupador", 3000.0)
    treballador.saludar()
    treballador.treballar()
    println("Estalvi: ${treballador.estalvi}")
}
```

### Associació entre classes

Una classe pot relacionar-se amb objectes d'una altra classe. Per exemple, una empresa pot tenir una llista de treballadors.

```kotlin
class Empresa(val nom: String, val treballadors: List<Treballador>)

fun main() {
    val treballadors = listOf(
        Treballador("Anna", 30, "Dissenyadora", 2800.0),
        Treballador("Pau", 28, "Desenvolupador", 3200.0)
    )

    val empresa = Empresa("CodiNord", treballadors)
    println("${empresa.nom} té ${empresa.treballadors.size} treballadors")
}
```

---

## 8. Programació Funcional i Expressions Lambda

En Kotlin, les funcions es poden tractar com a variables i passar-se com a paràmetres a altres funcions (Funcions d'Ordre Superior).

```kotlin
// Funció tradicional
fun mostraNombre(numero: Int) {
    println("El número és $numero")
}

// Funció d'ordre superior que rep una altra funció com a paràmetre
fun operacioMatematica(a: Int, b: Int, operacio: (Int, Int) -> Int): Int {
    return operacio(a, b)
}

fun main() {
    // Assignar una funció existent a una variable usant l'operador ::
    val funcioMostrarNumero = ::mostraNombre
    funcioMostrarNumero(3)

    // Declaració d'una expressió Lambda directament
    val lambdaMostrarNumero: (Int) -> Unit = { numero ->
        println("El número és $numero")
    }

    // Ús del paràmetre implícit 'it' quan només hi ha un paràmetre
    val mostrarNumeroIt: (Int) -> Unit = {
        println("El número és $it")
    }

    // Execució de funcions d'ordre superior passant una Lambda directament
    val resta = operacioMatematica(10, 2) { a, b -> a - b } // Retorna 8
    println("Resultat de la resta: $resta")
}
```

### Exemple Pràctic: Esdeveniments i Col·leccions

#### 1. Botó d'Interfície d'Usuari

```kotlin
class Boto(val nom: String, val onClick: () -> Unit)

fun main() {
    // En lloc de crear múltiples funcions, es defineix la lambda directament al botó
    val botoComiat = Boto("Botó adeu", {println("Adeu")})
    botoComiat.onClick()
}
```

#### 2. Recorregut i Filtratge de Llistes

```kotlin
class Estudiant(val edat: Int, val mitjana: Double)

fun main() {
    val llistaEstudiants = listOf(
        Estudiant(20, 8.5),
        Estudiant(22, 9.0),
        Estudiant(19, 7.0)
    )

    // Recorregut amb forEach utilitzant 'it'
    llistaEstudiants.forEach {
        println("L'estudiant té una edat de ${it.edat} i una mitjana de ${it.mitjana}")
    }

    // Cerca de l'element màxim amb maxBy / maxByOrNull
    val millorMitjana = llistaEstudiants.maxBy { it.mitjana }
    println("La mitjana més alta és ${millorMitjana?.mitjana}")
}
```

### Operacions habituals amb col·leccions

Les funcions `filter`, `map` i `find` permeten seleccionar, transformar i cercar elements sense haver d'escriure els bucles manualment.

```kotlin
data class Producte(val nom: String, val preu: Double)

fun main() {
    val productes = listOf(
        Producte("Llibreta", 3.5),
        Producte("Bolígraf", 1.5),
        Producte("Motxilla", 25.0)
    )

    val productesCars = productes.filter { it.preu > 5.0 }
    val noms = productes.map { it.nom }
    val primerProducteCar = productes.find { it.preu > 5.0 }

    println(productesCars)
    println(noms)
    println(primerProducteCar)
}
```

`Set` emmagatzema valors sense duplicats i `Map` associa claus amb valors:

```kotlin
val categories = setOf("Llibres", "Accessoris", "Llibres")
val preus = mapOf("Llibreta" to 3.5, "Motxilla" to 25.0)

println(categories) // [Llibres, Accessoris]
println(preus["Motxilla"]) // 25.0
```

---

## 9. Funcions d'abast

Les funcions d'abast executen una lambda dins del context d'un objecte. Són útils per agrupar operacions relacionades i fer el codi més llegible. Les cinc funcions principals són `let`, `run`, `with`, `apply` i `also`.

- **`let`**: utilitza `it` per referir-se a l'objecte i retorna el resultat de la lambda. És útil per transformar valors o treballar amb valors nul·lables.
- **`run`**: utilitza `this` dins de la lambda i retorna el seu resultat.
- **`with`**: rep l'objecte com a argument, utilitza `this` dins de la lambda i retorna el seu resultat.
- **`apply`**: utilitza `this` i retorna el mateix objecte. És útil per configurar-lo.
- **`also`**: utilitza `it` i retorna el mateix objecte. És útil per fer una operació addicional, com ara registrar informació.

```kotlin
data class Usuari(var nom: String, var actiu: Boolean)

fun main() {
    val usuari = Usuari("Joan", true)

    // let retorna el resultat de la lambda
    val descripcio = usuari.let {
        "${it.nom} està actiu: ${it.actiu}"
    }
    println(descripcio)

    // apply configura l'objecte i retorna el mateix objecte
    val usuariConfigurat = Usuari("Maria", false).apply {
        actiu = true
    }

    // also permet fer una operació addicional i retorna l'objecte
    val usuariFinal = usuariConfigurat.also {
        println("Usuari creat: ${it.nom}")
    }

    // with agrupa diverses operacions sobre un objecte
    val resum = with(usuariFinal) {
        "$nom està actiu: $actiu"
    }
    println(resum)
}
```

En general, `let` i `also` fan servir `it`, mentre que `run`, `with` i `apply` fan servir `this`. Cal triar la funció segons si es vol obtenir el resultat de la lambda o conservar l'objecte original.

---

## 10. Tipus Especials de Kotlin

Kotlin ofereix estructures especialitzades per modelar dades i comportaments:

### 1. `data class`
Classes dissenyades exclusivament per emmagatzemar dades. Implementen automàticament mètodes com `toString()` i `equals()` sense haver-los d'escriure manualment.

```kotlin
data class Gos(val nom: String, val raça: String, val edat: Int)

fun main() {
    val gos = Gos("Lucas", "Labrador", 3)
    // Imprimeix directament els atributs de l'objecte i no la seva adreça de memòria
    println(gos) // Sortida: Gos(nom=Lucas, raça=Labrador, edat=3)
}
```

### 2. `enum class`
S'utilitza per crear una llista tancada i finita de valors possibles.

```kotlin
enum class Sexe {
    MASCLE, FEMELLA
}

data class GosAmbSexe(val nom: String, val sexe: Sexe)

fun main() {
    val gos = GosAmbSexe("Lucas", Sexe.MASCLE)
}
```

### 3. `object` (Patró Singleton)
Crea una instància única i global accessible des de qualsevol punt del programa sense necessitat d'instanciar-la prèviament amb parèntesis.

```kotlin
object Gossera {
    val llistaGossos = mutableListOf<Gos>()

    fun afegirGos(gos: Gos) {
        llistaGossos.add(gos)
    }
}

fun main() {
    // S'accedeix directament al nom de l'objecte
    Gossera.afegirGos(Gos("Fifi", "Caniche", 2))
    println(Gossera.llistaGossos.size)
}
```

### 4. `interface`

Una interfície defineix un contracte que les classes poden implementar. Una classe pot implementar diverses interfícies.

```kotlin
interface Animal {
    fun ferSoroll()
}

class Gat : Animal {
    override fun ferSoroll() {
        println("Mèu!")
    }
}

fun main() {
    val animal: Animal = Gat()
    animal.ferSoroll()
}
```

---

## 11. Tipus Genèrics

Els genèrics permeten escriure funcions i classes que treballen amb diferents tipus de dades mantenint la comprovació de tipus.

```kotlin
fun <T> imprimirLlista(llista: List<T>) {
    llista.forEach { println(it) }
}

fun main() {
    imprimirLlista(listOf(1, 2, 3))
    imprimirLlista(listOf("Hola", "Món"))
}
```

El tipus concret es dedueix automàticament a partir de l'argument que es passa a la funció.