package com.discobeard.steam.api.wrapper.response.player.getplayersummaries

import com.discobeard.steam.api.wrapper.deserializer.SteamIdDeserializer
import com.discobeard.steam.api.wrapper.domain.SteamId
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonIgnoreProperties(ignoreUnknown = true)
class Player {

    @JsonDeserialize(using=SteamIdDeserializer.class, as = SteamId.class)
    SteamId steamid

    String communityvisibilitystate
    int profilestate
    String personaname
    long lastlogoff
    String profileurl
    String avatar
    String avatarmedium
    String avatarfull
    int personastate
    int commentpermission
    String realname
    String primaryclanid
    long timecreated
    String loccountrycode
    String locstatecode
    String loccitycode
    String loccityid
    String personastateflags
    String gameid
    String gameextrainfo
    String gameserverip
    String gameserversteamid
    String lobbysteamid

}
