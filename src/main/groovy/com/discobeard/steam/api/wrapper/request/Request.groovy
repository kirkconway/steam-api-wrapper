package com.discobeard.steam.api.wrapper.request

import com.discobeard.steam.api.wrapper.exception.SteamException
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import javax.ws.rs.client.Client
import javax.ws.rs.client.Invocation
import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.Response

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
            WebTarget webTarget = client.target(resource)
            System.out.println("submitting ${resource}")

            Invocation.Builder invocationBuilder = webTarget.request()

            Response response = invocationBuilder.get()
            response.readEntity(returnType)
        }
        catch (Exception e){
            if(e.cause instanceof UnrecognizedPropertyException || e.cause instanceof JsonParseException){
                throw new SteamException('Could not parse response from steam', e.cause)
            }
            throw new SteamException('Could not connect response the steam api', e.cause)
        }
    }
}
