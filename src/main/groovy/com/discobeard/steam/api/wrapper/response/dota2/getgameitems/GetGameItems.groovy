package com.discobeard.steam.api.wrapper.response.dota2.getgameitems

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetGameItems {
    GetGameItemsResult result
}
