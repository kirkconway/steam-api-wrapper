package com.discobeard.dota2.api.wrapper.to.getgameitems

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetGameItemsResult {
    Item[] items
    int status
}
