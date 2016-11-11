package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.dota2.getheroes.GetHeroes
import org.asynchttpclient.AsyncHttpClient

class GetHeroesRequest extends Request<GetHeroes> {

    private static final PATH = 'IEconDOTA2_570/GetHeroes/v0001/'

    GetHeroesRequest(AsyncHttpClient client, String baseUrl, String key) {
        super(client, baseUrl, PATH, key)
        this.returnType = GetHeroes.class
    }

    GetHeroesRequest withLanguage(String language) {
        resource += "&language=${language}"
        this
    }
}
