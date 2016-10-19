package com.discobeard.steam.api.wrapper.response.dota2.getgameitems

import com.fasterxml.jackson.annotation.JsonProperty

class Item {
    int id
    String name
    int cost
    int recipe

    @JsonProperty(value = "secret_shop")
    int secretShop

    @JsonProperty(value = "side_shop")
    int sideShop

    @JsonProperty(value = "localized_name")
    String localizedName
}
