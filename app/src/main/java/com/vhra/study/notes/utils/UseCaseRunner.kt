package com.vhra.study.notes.utils

import com.vhra.study.notes.domain.UseCase

class UseCaseRunner<I, O>(
    private val useCase: UseCase<I, O>
) : UseCase<I, O> {
    override fun run(input: I, callback: (O) -> Unit) {
        Thread {
            useCase.run(input, callback)
        }.start()
    }
}