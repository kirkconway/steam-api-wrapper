package com.discobeard.dota2.api.wrapper.to.getmatchdetails

import com.fasterxml.jackson.annotation.JsonProperty

class AdditionalUnits {
    String unitname

    @JsonProperty(value = 'item_0')
    int item1
    @JsonProperty(value = 'item_1')
    int item2
    @JsonProperty(value = 'item_2')
    int item3
    @JsonProperty(value = 'item_3')
    int item4
    @JsonProperty(value = 'item_4')
    int item5
    @JsonProperty(value = 'item_5')
    int item6
}
