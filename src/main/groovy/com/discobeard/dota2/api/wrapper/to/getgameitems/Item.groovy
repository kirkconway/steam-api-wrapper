package com.discobeard.dota2.api.wrapper.to.getgameitems

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Item {
    int id
    String name
    int cost
    @JsonProperty(value = "secret_shop")
    int secretShop
    @JsonProperty(value = "side_shop")
    int sideShop
    int recipe
    @JsonProperty(value = "localized_name")
    String localizedName
}
