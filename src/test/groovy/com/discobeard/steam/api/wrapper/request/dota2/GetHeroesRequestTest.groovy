package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.response.dota2.getheroes.GetHeroes
import org.mockserver.model.HttpRequest

class GetHeroesRequestTest extends BaseSpec {

    def 'match details are converted correctly'(){
        given:
            returnHeroes()
        when:
            GetHeroes getHeroes =  steamApiWrapper.dota2.getHeroesRequest().submit()
        then:
            getHeroes.result.count == 110
            getHeroes.result.status == 200
    }

    def 'with language correct adds the language param'(){
        given:
            returnHeroes()
        when:
            steamApiWrapper.dota2.getHeroesRequest().withLanguage("en_us").submit()
        then:
            mockServer.verify(HttpRequest.request().withQueryStringParameter('language','en_us'))


    }
}
