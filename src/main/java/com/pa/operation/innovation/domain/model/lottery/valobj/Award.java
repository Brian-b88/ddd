package com.pa.operation.innovation.domain.model.lottery.valobj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 值对象-奖品
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Award {

    private Integer awardProbability;

    private Integer probability;
}
