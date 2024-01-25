import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transferCommissionVisaMin() {
        val result = transferCommission(1000, "Visa", 0)
        assertEquals(35, result)
    }

    @Test
    fun transferCommissionMirMin() {
        val result = transferCommission(1000, "Mir", 0)
        assertEquals(35, result)
    }

    @Test
    fun transferCommissionVisa() {
        val result = transferCommission(15000, "Visa", 0)
        assertEquals(110, result)
    }

    @Test
    fun transferCommissionMir() {
        val result = transferCommission(5000, "Mir", 0)
        assertEquals(37.5, result)
    }

    @Test
    fun transferCommissionMaestroNoComm() {
        val result = transferCommission(5000, "Maestro", 0)
        assertEquals(0, result)
    }

    @Test
    fun transferCommissionMasterNoComm() {
        val result = transferCommission(5000, "Mastercard", 0)
        assertEquals(0, result)
    }

    @Test
    fun transferCommissionMaestro() {
        val result = transferCommission(80000, "Maestro", 0)
        assertEquals(500.0, result)
    }

    @Test
    fun transferCommissionMaster() {
        val result = transferCommission(80000, "Mastercard", 0)
        assertEquals(500.0, result)
    }

    @Test
    fun transferCommissionVK() {
        val result = transferCommission(4000)
        assertEquals(0, result)
    }

    @Test
    fun transferCommissionErrorCard() {
        val result = transferCommission(4000, "UnionPay")
        assertEquals("Error type card", result)
    }

    @Test
    fun transferCommissionMirLimit() {
        val result = transferCommission(160000, "Mir", 0)
        assertEquals("Error limit exceeded", result)
    }

    @Test
    fun transferCommissionVisaLimit() {
        val result = transferCommission(1000, "Visa", 600000)
        assertEquals("Error limit exceeded", result)
    }

    @Test
    fun transferCommissionVKLimit() {
        val result = transferCommission(16000)
        assertEquals("Error limit exceeded", result)
    }

    @Test
    fun transferCommissionVKLimit2() {
        val result = transferCommission(4000, "VK Pay", 40000)
        assertEquals("Error limit exceeded", result)
    }

}