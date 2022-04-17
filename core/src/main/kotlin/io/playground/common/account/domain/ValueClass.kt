package io.playground.common.account.domain

import java.math.BigDecimal

@JvmInline
value class Money(val money: BigDecimal) {
    companion object {
        fun add(a: Money, b: Money): Money {
            return Money(a.money + b.money)
        }
    }
}

@JvmInline
value class AccountId(val id: Long)

@JvmInline
value class ActivityWindow(val activityWindow: String) {
    fun calculateBalance(id: AccountId): Money {
        TODO("Not yet implemented")
    }
}
