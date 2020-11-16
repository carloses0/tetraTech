package com.tetraTech.projecaoService.core.model;

import lombok.*;


@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProjecaoInfo implements AbstractEntity {

    @EqualsAndHashCode.Include
    private Long id;

    private String localidade;
    private String horario;
    private Projecao projecao;

    @Override
    public Long getId() {
        return id;
    }
}
