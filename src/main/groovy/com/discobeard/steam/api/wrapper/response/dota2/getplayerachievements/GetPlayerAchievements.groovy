package com.discobeard.steam.api.wrapper.response.dota2.getplayerachievements

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetPlayerAchievements {
    PlayerStats playerstats
}
