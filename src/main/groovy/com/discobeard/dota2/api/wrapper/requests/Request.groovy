package com.discobeard.dota2.api.wrapper.requests

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import com.sun.jersey.api.client.WebResource

abstract class Request<T> {

    protected Client client
    protected String resource
    protected Class returnType

    public T submit(){
        WebResource webResource = client.resource(resource)
        System.out.println("submitting ${resource}")
        ClientResponse response = webResource.get(ClientResponse.class)
        response.getEntity(returnType)
    }
}
