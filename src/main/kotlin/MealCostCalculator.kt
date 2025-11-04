const val ONE = 1.0
const val ZERO = 0.0
const val DEFAULT_TAX_RATE = 0.1
const val DEFAULT_TIP_PERCENTAGE = 0.15
const val DEFAULT_DISCOUNT = 0.0

fun calculateTotalMealCost(
    baseCost: Double,
    taxRate: Double = DEFAULT_TAX_RATE,
    tipPercentage: Double = DEFAULT_TIP_PERCENTAGE,
    discount: Double = DEFAULT_DISCOUNT
): Double {

    fun applyTax(cost: Double): Double {
        val taxMultiplier = ONE + taxRate
        return cost * taxMultiplier
    }

    fun applyTip(costAfterTax: Double): Double {
        val tipMultiplier = ONE + tipPercentage
        return costAfterTax * tipMultiplier
    }

    fun applyDiscount(costAfterTip: Double): Double {
        return if (discount > ZERO) costAfterTip - discount else costAfterTip
    }

    val costWithTax = applyTax(baseCost)
    val costWithTip = applyTip(costWithTax)
    return applyDiscount(costWithTip)
}
