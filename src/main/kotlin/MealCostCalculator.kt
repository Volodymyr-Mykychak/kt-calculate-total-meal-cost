const val ONE = 1.0
const val ONE_PLUS_TAX = 1.0
const val ONE_PLUS_TIP = 1.0
const val TAX_RATE_ADDITION = 1.0
const val TIP_PERCENTAGE_ADDITION = 1.0
const val DEFAULT_TAX_RATE = 0.1
const val DEFAULT_TIP_PERCENTAGE = 0.15
const val DEFAULT_DISCOUNT = 0.0

fun calculateTotalMealCost(baseCost: Double, taxRate: Double = DEFAULT_TAX_RATE, tipPercentage: Double = DEFAULT_TIP_PERCENTAGE, discount: Double = DEFAULT_DISCOUNT): Double {

    fun applyTax(cost: Double): Double {
        return cost * (TAX_RATE_ADDITION + taxRate)
    }

    fun applyTip(costAfterTax: Double): Double {
        return costAfterTax * (TIP_PERCENTAGE_ADDITION + tipPercentage)
    }

    fun applyDiscount(costAfterTip: Double): Double {
        return if (discount > 0) costAfterTip - discount else costAfterTip
    }

    val costWithTax = applyTax(baseCost)
    val costWithTip = applyTip(costWithTax)
    return applyDiscount(costWithTip)
}

fun main() {
    val baseCost = 100.0
    val taxRate = DEFAULT_TAX_RATE
    val tipPercentage = DEFAULT_TIP_PERCENTAGE
    val discount = 10.0
    val totalMealCost = calculateTotalMealCost(baseCost, taxRate, tipPercentage, discount)
    println("Загальна вартість обіду: $totalMealCost")
}
