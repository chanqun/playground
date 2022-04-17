package io.playground.common.account.domain

class Account(
    private val id: AccountId,

    private val baselineBalance: Money,

    private val activityWindow: ActivityWindow
) {
    fun calculateBalance(): Money {
        return Money.add(
            this.baselineBalance,
            this.activityWindow.calculateBalance(this.id)
        )
    }
}
