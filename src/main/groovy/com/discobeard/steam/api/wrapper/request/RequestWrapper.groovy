package com.discobeard.steam.api.wrapper.request

import org.asynchttpclient.AsyncHttpClient

class RequestWrapper {
    protected String key
    protected String baseUrl
    protected AsyncHttpClient client
}
