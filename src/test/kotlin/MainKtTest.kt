import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commission_0VKPay() {
        val accountType = "VKPay"
        val totalDay = 0
        val totalMonth = 0
        val transferAmount = 1000

        val result = commission(accountType, totalDay, totalMonth, transferAmount)

        assertEquals("Комиссия 0 рублей", result)
    }

    @Test
    fun commission_0MasterCard() {
        val accountType = "MasterCard"
        val totalDay = 0
        val totalMonth = 0
        val transferAmount = 1000

        val result = commission(accountType, totalDay, totalMonth, transferAmount)

        assertEquals("Комиссия 0 рублей", result)
    }

    @Test
    fun commission_0Maestro() {
        val accountType = "Maestro"
        val totalDay = 0
        val totalMonth = 0
        val transferAmount = 1000

        val result = commission(accountType, totalDay, totalMonth, transferAmount)

        assertEquals("Комиссия 0 рублей", result)
    }

    @Test
    fun commission_TransferLimitOverVKpay() {
        val VKMax = 15_000
        val accountType = "VKPay"
        val totalDay = 0
        val totalMonth = 0
        val transferAmount = 16000

        val result = commission(accountType, totalDay, totalMonth, transferAmount)

        assertEquals("Сумма перевода превышает максимально допустимую ${VKMax} руб", result)
    }

    @Test
    fun commission_DayLimitOverCards() {
        val CardDayMax = 150_000
        val accountType = "Visa"
        val totalDay = 0
        val totalMonth = 0
        val transferAmount = 700000

        val result = commission(accountType, totalDay, totalMonth, transferAmount)

        assertEquals("Сумма перевода превышает максимально допустимую ${CardDayMax} руб", result)
    }

    @Test
    fun commission_075() {
        val accountType = "Visa"
        val totalDay = 0
        val totalMonth = 0
        val transferAmount = 15000

        val result = commission(accountType, totalDay, totalMonth, transferAmount)

        assertEquals("Комиссия ${(0.0075 * transferAmount).toInt()} руб", result)
    }

    @Test
    fun commission_06() {
        val accountType = "Maestro"
        val totalDay = 0
        val totalMonth = 0
        val transferAmount = 80000

        val result = commission(accountType, totalDay, totalMonth, transferAmount)

        assertEquals("Комиссия ${(0.006 * transferAmount).toInt()+20} руб", result)
    }

    @Test
    fun commission_wrongAccountType() {
        val accountType = "UnionPay"
        val totalDay = 0
        val totalMonth = 0
        val transferAmount = 15000

        val result = commission(accountType, totalDay, totalMonth, transferAmount)

        assertEquals("Тип карты неизвестен", result)
    }
}