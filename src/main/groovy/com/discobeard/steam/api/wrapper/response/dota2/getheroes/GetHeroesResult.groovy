package com.discobeard.steam.api.wrapper.response.dota2.getheroes

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetHeroesResult {
    Hero[] heroes
    int count
    int status
}
