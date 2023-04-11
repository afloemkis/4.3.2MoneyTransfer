import java.lang.Integer.max

fun main() {
    println(commission("Visa", 15000, 30000, 10000))

}

fun commission(accountType: String = "VKPay", totalDay: Int = 0, totalMonth: Int = 0, transferAmount: Int): String {
    val VKMax = 15_000
    val VKmonthMax = 40_000
    val CardDayMax = 150_000
    val CardMonthMax = 600_000
    val minCommission = 35
    val CardLimit = 75_000
    if (accountType == "VKPay") {
        return when {
            transferAmount > VKMax -> "Сумма перевода превышает максимально допустимую ${VKMax} руб"
            totalMonth >= VKmonthMax -> "В этом месяце лимит переводов по VKpay исчерпан"
            totalMonth + transferAmount > VKmonthMax -> "В этом месяце вы можете перевести не более ${VKmonthMax - totalMonth} руб"
            else -> "комиссия 0 рублей"
        }
    } else {
        return when {
            transferAmount > CardDayMax -> "Сумма перевода превышает максимально допустимую ${CardDayMax} руб"
            totalMonth >= CardMonthMax -> "В этом месяце лимит переводов по карте исчерпан"
            totalMonth + transferAmount > CardMonthMax -> "В этом месяце вы можете перевести не более ${CardDayMax - totalMonth} руб"
            (accountType == "Visa") or (accountType == "Мир") -> "Комиссия ${
                max(
                    minCommission,
                    (0.0075 * transferAmount).toInt()
                )
            } руб"

            ((accountType == "MasterCard") or (accountType == "Maestro")) and (transferAmount > CardLimit) -> "Комиссия ${0.006 * transferAmount + 20} руб"
            (accountType == "MasterCard") or (accountType == "Maestro") -> "Комиссия 0 руб"
            else -> "Тип карты неизвестен"
        }

    }
}


