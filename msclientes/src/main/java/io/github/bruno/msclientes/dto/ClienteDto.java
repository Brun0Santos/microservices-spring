package io.github.bruno.msclientes.dto;


import io.github.bruno.msclientes.entity.ClienteEntity;
import lombok.Data;
import lombok.Setter;

@Data
@Setter

public class ClienteDto {

    private String cpf;
    private String nome;
    private Integer idade;

    public ClienteDto() {

    }

    public static ClienteEntity toModel(ClienteDto cliente) {
        return new ClienteEntity(cliente.getCpf(), cliente.getNome(), cliente.getIdade());
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }
}
