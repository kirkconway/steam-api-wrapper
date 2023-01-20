package com.discobeard.steam.api.wrapper.response.player.getrecentlyplayedgames

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class GetRecentlyPlayedGamesResponse {

    @JsonProperty(value = 'total_count')
    int total_count

    List<Game> games
}
