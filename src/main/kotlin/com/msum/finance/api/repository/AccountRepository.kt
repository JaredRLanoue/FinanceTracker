package com.msum.finance.api.repository

import com.msum.finance.api.data.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AccountRepository : JpaRepository<AccountEntity, UUID> {
    fun findAllByUserId(userId: UUID): List<AccountEntity>

    fun findByUserIdAndId(userId: UUID, accountId: UUID): AccountEntity?

    fun deleteByUserIdAndId(userId: UUID, id: UUID)
}
