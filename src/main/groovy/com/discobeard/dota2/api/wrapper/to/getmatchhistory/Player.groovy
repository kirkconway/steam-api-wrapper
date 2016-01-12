package com.discobeard.dota2.api.wrapper.to.getmatchhistory

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Player {

    @JsonProperty(value = 'account_id')
    long accountId
    @JsonProperty(value = 'player_slot')
    int playerSlot
    @JsonProperty(value = 'hero_id')
    int heroId
}
