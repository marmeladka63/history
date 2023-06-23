package com.bank.history.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Класс, описывающий сущность History
 *
 * @author Peshkova Valentina
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "history")

public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "transfer_audit_id")
    private Long transferAuditId;
    @Column(name = "profile_audit_id")
    private Long profileAuditId;
    @Column(name = "account_audit_id")
    private Long accountAuditId;
    @Column(name = "anti_fraud_audit_id")
    private Long antiFraudAuditId;
    @Column(name = "public_bank_info_audit_id")
    private Long publicBankInfoAuditId;
    @Column(name = "authorization_audit_id")
    private Long authorizationAuditId;


}
