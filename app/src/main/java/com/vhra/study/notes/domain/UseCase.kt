package com.vhra.study.notes.domain

interface UseCase<Input, Output> {
    fun run(input: Input, callback: (Output) -> Unit)
}