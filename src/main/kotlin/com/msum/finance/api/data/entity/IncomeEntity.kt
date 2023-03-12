package com.msum.finance.api.data.entity

import com.msum.finance.api.data.model.Income
import com.msum.finance.user.data.entity.UserEntity
import com.msum.finance.user.data.entity.toModel
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.math.BigDecimal
import java.time.Instant
import java.util.*

@Entity
@Table(name = "incomes")
class IncomeEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    @JoinColumn(name = "account_id")
    val accountId: UUID,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,
    val amount: BigDecimal,
    @Column(name = "payer_name")
    val payerName: String,
    val description: String,
    val category: String,
    val date: Instant,
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: Instant = Instant.now(),
    @LastModifiedDate
    @Column(name = "updated_at")
    val updatedAt: Instant = Instant.now()
)

fun IncomeEntity.toModel() = Income(
    id = id,
    accountId = accountId,
    user = user.toModel(),
    amount = amount,
    payerName = payerName,
    description = description,
    category = category,
    date = date,
    createdAt = createdAt,
    updatedAt = updatedAt
)
