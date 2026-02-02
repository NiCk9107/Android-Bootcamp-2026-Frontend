package ru.sicampus.bootcamp2026.domain.entities

import ru.sicampus.bootcamp2026.data.UserRepository

class GetUserUseCase (
    private val userRepository: UserRepository
){
    suspend operator fun invoke(): Result<List<UserEntity>>{
        return userRepository.getUsers()
    }
}
