package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.response.dota2.getheroes.GetHeroes

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
        when:
            GetHeroesRequest request =  steamApiWrapper.dota2.getHeroesRequest().withLanguage("en_us")
        then:
            request.resource == 'http://localhost:1080/IEconDOTA2_570/GetHeroes/v0001/?key=key&language=en_us'

    }
}
