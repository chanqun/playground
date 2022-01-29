package io.playground.common

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux

class FluxMonoTest {

    @Test
    fun `subscribe method example`() {
        val ints = Flux.range(1, 3)

        ints.subscribe { println(it) }
    }
}
