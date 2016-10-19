package com.discobeard.steam.api.wrapper.response.player.getrecentlyplayedgames

import com.fasterxml.jackson.annotation.JsonProperty

class Game {
    int appid
    String name
    @JsonProperty(value = 'playtime_2weeks')
    int playedIn2Weeks
    @JsonProperty(value = 'playtime_forever')
    int playedForever
    @JsonProperty(value = 'img_icon_url')
    String imageIconUrl
    @JsonProperty(value = 'img_logo_url')
    String imageLogoUrl

}
