import org.jetbrains.annotations.TestOnly


fun main() {
    val result= transferCommission(15000,"Visa",0)
    println(result)
}
fun transferCommission( amount: Int,typeCard: String = "VK Pay", previousTransfers: Int = 0): Any {
    val errorLimit= "Error limit exceeded"
    val errorTypeCard= "Error type card"
    val commission = when (typeCard) {
        "Mastercard", "Maestro" -> if (previousTransfers+amount >= 75000) (0.006 * amount) + 20 else 0
        "Visa", "Mir" -> if ((0.0075 * amount) < 35) 35 else amount * 0.0075
        "VK Pay"-> 0
        else -> errorTypeCard
    }
    return when(typeCard) {
        "Mastercard", "Maestro","Visa", "Mir"-> if (amount>150000||previousTransfers+amount>=600000) errorLimit else commission
        "VK Pay"-> if (amount>15000||previousTransfers+amount>=40000) errorLimit else commission
        else -> commission
    }

}