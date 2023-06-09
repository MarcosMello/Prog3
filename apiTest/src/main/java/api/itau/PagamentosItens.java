package api.itau;

public record PagamentosItens(String id_pagamento,
                              String status,
                              String nome_favorecido,
                              String cpf_cnpj,
                              String cod_banco,
                              String numero_agencia,
                              String numero_conta,
                              String tipo_pagamento,
                              String data_pagamento,
                              String valor_pagamento,
                              String numero_lancamento) {
}
