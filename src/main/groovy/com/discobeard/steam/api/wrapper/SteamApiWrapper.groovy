package com.discobeard.steam.api.wrapper

import com.discobeard.steam.api.wrapper.request.api.ApiWrapper
import com.discobeard.steam.api.wrapper.request.dota2.Dota2Wrapper
import com.discobeard.steam.api.wrapper.request.player.PlayerWrapper
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
import org.glassfish.jersey.client.ClientConfig

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

class SteamApiWrapper {

    private static final DEFAULT_BASE_URL = 'https://api.steampowered.com'
    private final Client client

    public Dota2Wrapper dota2
    public ApiWrapper api
    public PlayerWrapper player

    public SteamApiWrapper(String key, String baseUrl = DEFAULT_BASE_URL) {
        client = createClient()

        api = new ApiWrapper(key: key, baseUrl: baseUrl, client: client)
        dota2 = new Dota2Wrapper(key: key, baseUrl: baseUrl, client: client)
        player = new PlayerWrapper(key: key, baseUrl: baseUrl, client: client)
    }

    public Client createClient() {
        JacksonJsonProvider jacksonJsonProvider = new JacksonJaxbJsonProvider()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ClientBuilder.newClient(new ClientConfig(jacksonJsonProvider))
    }

}
