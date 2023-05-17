import kotlin.random.Random

class DesafioBootcamp(private val limiteInferior: Int, private val limiteSuperior: Int) {

    private val numeroAleatorio: Int = gerarNumeroAleatorio()

    private fun gerarNumeroAleatorio(): Int {
        return Random.nextInt(limiteInferior, limiteSuperior)
    }

    fun verificarPalpite(palpite: Int): ResultadoPalpite {
        return when {
            palpite == numeroAleatorio -> ResultadoPalpite.CORRETO
            palpite < numeroAleatorio -> ResultadoPalpite.MAIOR
            else -> ResultadoPalpite.MENOR
        }
    }

    enum class ResultadoPalpite {
        CORRETO,
        MAIOR,
        MENOR
    }
}

fun main() {
    val limiteInferior = 1
    val limiteSuperior = 100
    val desafio = DesafioBootcamp(limiteInferior, limiteSuperior)

    println("Bem-vindo ao Desafio do Bootcamp!")
    println("Tente adivinhar o número entre $limiteInferior e $limiteSuperior.")

    var tentativas = 0
    var palpite: Int
    var resultado: DesafioBootcamp.ResultadoPalpite? = null

    do {
        print("Digite seu palpite: ")
        val palpiteStr = readLine() ?: continue
        palpite = palpiteStr.toIntOrNull() ?: continue

        resultado = desafio.verificarPalpite(palpite)
        when (resultado) {
            DesafioBootcamp.ResultadoPalpite.CORRETO -> println("Parabéns! Você acertou o número em $tentativas tentativas.")
            DesafioBootcamp.ResultadoPalpite.MAIOR -> println("Tente novamente! O número é maior.")
            DesafioBootcamp.ResultadoPalpite.MENOR -> println("Tente novamente! O número é menor.")
        }

        tentativas++
    } while (resultado != DesafioBootcamp.ResultadoPalpite.CORRETO)
}

