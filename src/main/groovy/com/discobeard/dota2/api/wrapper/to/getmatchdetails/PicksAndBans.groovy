package com.discobeard.dota2.api.wrapper.to.getmatchdetails

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class PicksAndBans {
    @JsonProperty(value = 'is_pick')
    boolean isPick
    @JsonProperty(value = 'hero_id')
    int heroId
    int team
    int order
}
