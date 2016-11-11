package com.discobeard.steam.api.wrapper

import com.discobeard.steam.api.wrapper.request.api.ApiWrapper
import com.discobeard.steam.api.wrapper.request.dota2.Dota2Wrapper
import com.discobeard.steam.api.wrapper.request.player.PlayerWrapper
import org.asynchttpclient.AsyncHttpClient
import org.asynchttpclient.DefaultAsyncHttpClient

class SteamApiWrapper {

    private static final DEFAULT_BASE_URL = 'https://api.steampowered.com'
    private final AsyncHttpClient client

    public Dota2Wrapper dota2
    public ApiWrapper api
    public PlayerWrapper player

    public SteamApiWrapper(String key, String baseUrl = DEFAULT_BASE_URL) {
        client = createClient()

        api = new ApiWrapper(key: key, baseUrl: baseUrl, client: client)
        dota2 = new Dota2Wrapper(key: key, baseUrl: baseUrl, client: client)
        player = new PlayerWrapper(key: key, baseUrl: baseUrl, client: client)
    }

    private static AsyncHttpClient createClient() {
        new DefaultAsyncHttpClient();
    }
}
