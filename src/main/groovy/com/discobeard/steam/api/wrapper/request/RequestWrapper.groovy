package com.discobeard.steam.api.wrapper.request

import javax.ws.rs.client.Client

class RequestWrapper {
    protected String key
    protected String baseUrl
    protected Client client
}
