package com.discobeard.steam.api.wrapper.response.player.getplayersummaries

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetPlayerSummariesResponse {
    Player[] players
}
