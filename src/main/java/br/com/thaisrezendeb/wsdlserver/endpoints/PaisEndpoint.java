package br.com.thaisrezendeb.wsdlserver.endpoints;

import br.com.thaisrezendeb.wsdlserver.assets.GetPaisRequest;
import br.com.thaisrezendeb.wsdlserver.assets.GetPaisResponse;
import br.com.thaisrezendeb.wsdlserver.repositories.PaisRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaisEndpoint {

    private static final String NAMESPACE_URL = "http://thaisrezendeb.com.br/wsdlserver/assets";

    private final PaisRepository paisRepository;

    public PaisEndpoint(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getPaisRequest")
    @ResponsePayload
    public GetPaisResponse getCountry(@RequestPayload GetPaisRequest request) {
        GetPaisResponse response = new GetPaisResponse();
        response.setPais(paisRepository.buscarPorPais(request.getNome()));
        return response;
    }
}
