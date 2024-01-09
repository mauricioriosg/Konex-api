package com.test.cliente.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dealer {

    private BigInteger code;
    private String dealerName;
    private String socialReason;

}
