// Hands-on 3: companion object & @JvmStatic
class Greeter {
    companion object {
        // TODO 1: Tambahkan anotasi @JvmStatic pada fungsi ini
        @JvmStatic
        fun greet(name: String): String {
            return "Halo, $name!"
        }
    }
}

fun main() {
    println(Greeter.greet("Mahasiswa"))

    // Bukti lewat java.lang.Class reflection (BUKAN kotlin-reflect):
    // Tanpa @JvmStatic, method "greet" HANYA ada di Greeter.Companion.class,
    // TIDAK ada di Greeter.class secara langsung.
    val staticMethodNames = Greeter::class.java.methods.map { it.name }
    println("Method pada Greeter.class: $staticMethodNames")

    // TODO 2: Setelah menambahkan @JvmStatic di atas, baris ini harus mencetak true
    val punyaStaticGreet = staticMethodNames.contains("greet")
    println("Greeter.class punya static method 'greet'? $punyaStaticGreet")

    check(punyaStaticGreet) {
        "greet() belum jadi static method di Greeter.class — tambahkan @JvmStatic!"
    }
}
