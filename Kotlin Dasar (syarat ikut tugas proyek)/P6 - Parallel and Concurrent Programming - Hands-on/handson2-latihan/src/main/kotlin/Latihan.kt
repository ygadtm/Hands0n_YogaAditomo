import java.util.concurrent.Callable
import java.util.concurrent.Executors

// Hands-on 2: ExecutorService & Future
// Tugas: Jalankan 4 "task" perhitungan yang lambat (simulasi delay dengan
// Thread.sleep) secara PARALEL menggunakan thread pool, lalu kumpulkan semua
// hasilnya. Jika dijalankan sequential, total waktu ~4 detik. Dengan thread
// pool 4 pekerja, seharusnya total waktu ~1 detik.

fun hitungKuadrat(n: Int): Int {
    Thread.sleep(1000)
    return n * n
}

fun main() {
    val angka = listOf(1, 2, 3, 4)
    val startTime = System.currentTimeMillis()

    // TODO 1: thread pool dengan 4 pekerja
    val executor = Executors.newFixedThreadPool(4)

    // TODO 2: submit satu Callable per angka, simpan Future-nya
    val futures = angka.map { n -> executor.submit(Callable { hitungKuadrat(n) }) }

    // TODO 3: ambil semua hasil dengan get(), lalu tampilkan
    val hasil = futures.map { it.get() }
    println("Hasil: $hasil")

    // TODO 4: matikan executor supaya JVM bisa berhenti
    executor.shutdown()

    val endTime = System.currentTimeMillis()
    println("Waktu: ${endTime - startTime}ms")
}
