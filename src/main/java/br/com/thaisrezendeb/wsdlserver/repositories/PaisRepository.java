package br.com.thaisrezendeb.wsdlserver.repositories;

import br.com.thaisrezendeb.wsdlserver.assets.Moeda;
import br.com.thaisrezendeb.wsdlserver.assets.Pais;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class PaisRepository {

    private static final Map<String, Pais> paises = new HashMap<>();

    @PostConstruct
    public void initData() {
        Pais brasil = new Pais();
        brasil.setNome("Brasil");
        brasil.setCapital("Brasilia");
        brasil.setMoeda(Moeda.BRL);
        brasil.setPopulacao(209300000);
        paises.put(brasil.getNome(), brasil);

        Pais uk = new Pais();
        uk.setNome("Reino Unido");
        uk.setCapital("Londres");
        uk.setMoeda(Moeda.GPB);
        uk.setPopulacao(63705000);
        paises.put(uk.getNome(), uk);
    }

    public Pais buscarPorPais(String nome) {
        Assert.notNull(nome, "O pais nao pode ser nulo");
        return paises.get(nome);
    }
}
