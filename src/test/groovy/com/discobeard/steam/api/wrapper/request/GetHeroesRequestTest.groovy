package com.discobeard.steam.api.wrapper.request

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.request.dota2.GetHeroesRequest
import com.discobeard.steam.api.wrapper.response.dota2.getheroes.GetHeroes

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

class GetHeroesRequestTest extends BaseSpec {

    Client client = ClientBuilder.newClient()
    GetHeroesRequest testObj = new GetHeroesRequest(client, "http://localhost:1080","key")

    def 'match details are converted correctly'(){
        given:
            returnHeroes()
        when:
            GetHeroes getHeroes =  testObj.submit()
        then:
            getHeroes.result.count == 110
            getHeroes.result.status == 200
    }

    def 'with language correct adds the language param'(){
        when:
            testObj.withLanguage("en_us")
        then:
            testObj.resource == 'http://localhost:1080/IEconDOTA2_570/GetHeroes/v0001/?key=key&language=en_us'

    }
}
