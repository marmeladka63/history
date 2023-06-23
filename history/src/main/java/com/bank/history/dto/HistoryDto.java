package com.bank.history.dto;


/**
 * Класс, описывающий Data Transfer Objects History
 *
 * @author Peshkova Valentina
 */

public record HistoryDto (
    Long id,
    Long transferAuditId,
    Long profileAuditId,
    Long accountAuditId,
    Long antiFraudAuditId,
    Long publicBankInfoAuditId,
    Long authorizationAuditId){
}
