package com.github.allanccruz.bookmarket.events

import com.github.allanccruz.bookmarket.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent (
    source: Any,
    val purchaseModel: PurchaseModel
): ApplicationEvent(source)