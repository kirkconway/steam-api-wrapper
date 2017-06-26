package com.discobeard.steam.api.wrapper.response.dota2.getschemaforgame

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetSchemaForGame {
    Game game
}
