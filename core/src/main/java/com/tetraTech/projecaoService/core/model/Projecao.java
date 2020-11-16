package com.tetraTech.projecaoService.core.model;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Projecao implements AbstractEntity{

    @EqualsAndHashCode.Include
    private Long id;
    private Long populacao;
    private PeriodoMedio periodoMedio;

    @Override
    public Long getId() {
        return id;
    }

}
