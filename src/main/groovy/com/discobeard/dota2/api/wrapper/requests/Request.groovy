package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.exception.SteamException
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import com.sun.jersey.api.client.WebResource

abstract class Request<T> {

    protected String resource
    protected Class returnType
    private Client client

    public Request(Client client, String baseUrl,String path, String key){
        resource = "${baseUrl}/${path}?key=${key}"
        this.client = client
    }

    public T submit() throws SteamException {
        try {
            WebResource webResource = client.resource(resource)
            System.out.println("submitting ${resource}")
            ClientResponse response = webResource.get(ClientResponse.class)
            response.getEntity(returnType)
        }
        catch (Exception e){
            if(e.cause instanceof UnrecognizedPropertyException){
                throw new SteamException("Could not parse response from steam", e.cause)
            }

            throw new SteamException("Could not connect to the steam api", e.cause)

        }
    }
}
