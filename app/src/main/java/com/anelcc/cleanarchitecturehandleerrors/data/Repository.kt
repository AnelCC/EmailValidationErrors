package com.anelcc.cleanarchitecturehandleerrors.data

import com.anelcc.cleanarchitecturehandleerrors.domain.RepositoryInterface
import com.anelcc.cleanarchitecturehandleerrors.util.Resource
import kotlinx.coroutines.delay
import kotlin.random.Random

class Repository: RepositoryInterface {
    override suspend fun submitEmail(email: String): Resource<Unit> {
        delay(500L)
        return if (Random.nextBoolean()) {
            return Resource.Success(Unit)
        } else {
            if (Random.nextBoolean()) {
                Resource.Error("Server error")
            } else {
                Resource.Error("Not authenticate error")
            }
        }
    }
}