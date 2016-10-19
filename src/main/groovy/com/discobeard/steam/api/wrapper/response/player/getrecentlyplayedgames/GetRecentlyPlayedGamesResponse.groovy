package com.discobeard.steam.api.wrapper.response.player.getrecentlyplayedgames

import com.fasterxml.jackson.annotation.JsonProperty

class GetRecentlyPlayedGamesResponse {

    @JsonProperty(value = 'total_count')
    int total_count

    List<Game> games
}
