package com.discobeard.dota2.api.wrapper.to.getrecentlyplayedgames

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class GetRecentlyPlayedGamesResponse {

    @JsonProperty(value = 'total_count')
    int total_count

    List<Game> games
}
