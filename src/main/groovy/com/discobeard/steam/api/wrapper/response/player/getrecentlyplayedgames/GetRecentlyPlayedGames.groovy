package com.discobeard.steam.api.wrapper.response.player.getrecentlyplayedgames

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetRecentlyPlayedGames {
    GetRecentlyPlayedGamesResponse response
}
