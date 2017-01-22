package com.discobeard.steam.api.wrapper.request

import com.discobeard.steam.api.wrapper.exception.SteamException
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.ObjectMapper
import org.asynchttpclient.AsyncHttpClient
import org.asynchttpclient.RequestBuilder
import org.asynchttpclient.Response

import java.util.concurrent.Future

abstract class Request<T> {

    protected RequestBuilder requestBuilder
    protected Class returnType
    private AsyncHttpClient client

    public Request(AsyncHttpClient client, requestBuilder, Class returnType) {

        this.requestBuilder = requestBuilder
        this.client = client
        this.returnType = returnType
    }

    public T submit() throws SteamException {
        try {

            def request = requestBuilder.build()
            Future<Response> f = client.executeRequest(request)

            ObjectMapper mapper = new ObjectMapper()
            mapper.readValue(f.get().responseBody, returnType)

        }
        catch (Exception e) {
            if (e instanceof JsonParseException) {
                throw new SteamException('Could not parse response from steam', e)
            }
            throw new SteamException('Could not connect to the steam api', e)
        }
    }

    protected static RequestBuilder newGetBuilder(String url) {
        new RequestBuilder('GET').setUrl(url)
    }

    protected addKey(String key) {
        requestBuilder.addQueryParam('key', key)
    }

    protected setLanugage(String language) {
        requestBuilder.addQueryParam('language', language)
    }
}
