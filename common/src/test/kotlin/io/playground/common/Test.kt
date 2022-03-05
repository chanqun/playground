package io.playground.common

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux

class Test {

    @Test
    fun `subscribe method example`() {
        val ints = Flux.range(1, 3)

        ints.subscribe { println(it) }
    }

    @Test
    fun `coroutine scope`() {
        // 전역 스코프
        GlobalScope.launch {
            delay(1000L)
            println("World!")
        }

        println("Hello, ")
        Thread.sleep(2000L)
    }
}
