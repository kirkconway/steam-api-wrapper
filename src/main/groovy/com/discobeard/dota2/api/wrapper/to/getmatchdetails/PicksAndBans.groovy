package com.discobeard.dota2.api.wrapper.to.getmatchdetails

import com.fasterxml.jackson.annotation.JsonProperty

class PicksAndBans {
    @JsonProperty(value = 'is_pick')
    boolean isPick
    @JsonProperty(value = 'hero_id')
    int heroId
    int team
    int order
}
