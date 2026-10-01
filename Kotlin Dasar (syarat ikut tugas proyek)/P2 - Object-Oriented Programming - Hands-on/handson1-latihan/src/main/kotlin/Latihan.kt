// Hands-on 1: Class & Inheritance
// Tugas: Buat hierarki class kendaraan menggunakan open class, primary constructor,
// dan override fungsi. Vehicle adalah base class, Car dan Motorcycle adalah turunannya.

// TODO 1: class dijadikan "open" agar bisa diturunkan
open class Vehicle(val name: String, val maxSpeed: Int) {

    // TODO 2: fungsi dijadikan "open" agar bisa di-override
    open fun describe(): String {
        return "$name dapat melaju hingga $maxSpeed km/h"
    }
}

// TODO 3: Car turunan dari Vehicle, maxSpeed diteruskan 180
class Car(name: String, val numberOfDoors: Int) : Vehicle(name, maxSpeed = 180) {
    override fun describe(): String {
        return "${super.describe()} dan punya $numberOfDoors pintu"
    }
}

// TODO 4: Motorcycle turunan dari Vehicle, maxSpeed diteruskan 220
class Motorcycle(name: String, val hasSidecar: Boolean) : Vehicle(name, maxSpeed = 220) {
    override fun describe(): String {
        val sidecarInfo = if (hasSidecar) "dengan sidecar" else "tanpa sidecar"
        return "${super.describe()} ($sidecarInfo)"
    }
}

fun main() {
    val vehicles = listOf<Vehicle>(
        // TODO 5: satu instance Car dan satu Motorcycle
        Car("Toyota", numberOfDoors = 4),
        Motorcycle("Ninja", hasSidecar = false)
    )

    // Polymorphism: describe() yang dipanggil adalah versi subclass masing-masing
    vehicles.forEach { println(it.describe()) }
}
