package com.github.allanccruz.bookmarket.model

import com.github.allanccruz.bookmarket.BookStatus
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "book")
data class BookModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus?,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel?
)