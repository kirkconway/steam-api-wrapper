package com.discobeard.dota2.api.wrapper.to.getheroes

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetHeroes {
    GetHeroesResult result
}
