package com.tetraTech.projecaoService.core.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PeriodoMedio implements AbstractEntity {

    @EqualsAndHashCode.Include
    private Long id;
    private Integer incrementoPopulacional;
    private Integer nascimento;
    private Integer obito;

    @Override
    public Long getId() {
        return id;
    }

}
