fun calculateTotalMealCost(baseCost: Double, taxRate: Double, tipPercentage: Double, discount: Double = 0.0): Double {

    fun applyTax(cost: Double): Double {
        return cost * (1 + taxRate)
    }


    fun applyTip(costAfterTax: Double): Double {
        return costAfterTax * (1 + tipPercentage)
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
    val taxRate = 0.1
    val tipPercentage = 0.15
    val discount = 10.0
    val totalMealCost = calculateTotalMealCost(baseCost, taxRate, tipPercentage, discount)
    println("Загальна вартість обіду: $totalMealCost")
}
