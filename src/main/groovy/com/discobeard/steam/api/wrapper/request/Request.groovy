package com.discobeard.steam.api.wrapper.request

import com.discobeard.steam.api.wrapper.exception.SteamException
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.ObjectMapper
import org.asynchttpclient.AsyncHttpClient
import org.asynchttpclient.Response

import java.util.concurrent.Future

abstract class Request<T> {

    protected String resource
    protected Class returnType
    private AsyncHttpClient client

    public Request(AsyncHttpClient client, String baseUrl,String path, String key){
        resource = "${baseUrl}/${path}?key=${key}"
        this.client = client
    }

    public T submit() throws SteamException {
        try {

            Future<Response> f = client.prepareGet(resource).execute()

            ObjectMapper mapper = new ObjectMapper()
            mapper.readValue(f.get().responseBody, returnType)

        }
        catch (Exception e){
            if(e instanceof JsonParseException){
                throw new SteamException('Could not parse response from steam', e)
            }
            throw new SteamException('Could not connect to the steam api', e)
        }
    }
}
