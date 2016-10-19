package com.discobeard.steam.api.wrapper.domain

enum LobbyType {
    PublicMatchmaking(0, "Public Match Making"),
    Practice(1, "Practice"),
    Tournament(2, "Tournament"),
    Tutorial(3, "Tournament"),
    CoopWithBots(4, "Coop WIth Bots"),
    TeamMatch(5, "Team Match"),
    SoloQueue(6, "Solo Queue"),
    Ranked(7, "Ranked"),
    SoloMid1vs1(8, "Solo Mid 1 vs 1")

    int value
    String name

    LobbyType(int value, String name){
        this.value = value
        this.name = name
    }

    public static LobbyType getLobbyType(int value){
        LobbyType lobbyType = values().find{
            it.value == value
        }

        return lobbyType
    }
}
