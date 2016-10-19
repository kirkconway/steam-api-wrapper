package com.discobeard.steam.api.wrapper.domain

enum LeaverStatus {
    None(0),
    Disconnected(1),
    DisconnectedToLong(2),
    Abandoned(3),
    AFK(4),
    NeverConnected(5),
    NeverConnectedTolong(6)

    int value

    LeaverStatus(int value){
        this.value = value
    }

    static LeaverStatus getByValue(int value){
        values().find {
            it.value == value
        }
    }
}