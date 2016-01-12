package com.discobeard.dota2.api.wrapper.to.getrecentlyplayedgames

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetRecentlyPlayedGames {
    GetRecentlyPlayedGamesResponse response
}
