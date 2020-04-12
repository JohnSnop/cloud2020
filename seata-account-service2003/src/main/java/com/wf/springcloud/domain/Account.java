package com.wf.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author wf
 * @create 2020-04-12 16:28
 * @desc
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private Long userId;
    private BigDecimal toal;
    private BigDecimal used;
    private BigDecimal residue;
}
