package com.example.bank.messaging;

import com.example.bank.domain.types.AuditMessage;

public interface AuditMessageProducer {
    void send(AuditMessage message);
}
