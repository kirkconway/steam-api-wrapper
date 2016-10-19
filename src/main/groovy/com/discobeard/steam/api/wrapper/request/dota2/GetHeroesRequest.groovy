package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.dota2.getheroes.GetHeroes
import javax.ws.rs.client.Client

class GetHeroesRequest extends Request<GetHeroes> {

    private static final PATH = 'IEconDOTA2_570/GetHeroes/v0001/'

    public GetHeroesRequest(Client client, String baseUrl, String key){
        super(client, baseUrl, PATH, key)
        this.returnType = GetHeroes.class
    }

    public GetHeroesRequest withLanguage(String language){
        resource += "&language=${language}"
        this
    }
}