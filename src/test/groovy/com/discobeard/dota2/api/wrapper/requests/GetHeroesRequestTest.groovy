package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.BaseSpec
import com.discobeard.dota2.api.wrapper.to.getheroes.GetHeroes
import com.sun.jersey.api.client.Client

class GetHeroesRequestTest extends BaseSpec {

    Client client = Client.create()
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
}
