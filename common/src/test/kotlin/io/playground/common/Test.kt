package io.playground.common

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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
            delay(1000L) // delay는 suspend - suspend fun 은 coroutine scope 안 에서만 실행할 수 있음
            println("World!")
        }

        println("Hello, ")
        Thread.sleep(2000L) // thread는 blocking 하는 것
    }

    @Test
    fun `runBlocking`() = runBlocking { // coroutine builder
        GlobalScope.launch {
            delay(1000L)
            println("World!")
        }

        println("Hello, ")
        delay(2000L)
    }

    @Test
    fun `job을 기다리자`() = runBlocking {
        val job = GlobalScope.launch {
            delay(2000L)
            println("World!")
        }

        println("Hello, ")
        job.join() // coroutine이 완료될 때 까지 기다렸다가 종료함
    }

    @Test
    fun `join으로 job을 계속 관리해야할까`() = runBlocking {
        // structured concurrency
        launch {
            delay(2000L)
            println("World!")
        }

        launch {
            delay(2000L)
            println("World!")
        }

        println("Hello, ")
    }
}
