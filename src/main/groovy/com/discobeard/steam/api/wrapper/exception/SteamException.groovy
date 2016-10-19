package com.discobeard.steam.api.wrapper.exception

class SteamException extends Exception{

    SteamException(String message, Throwable e){
        super(message, e)
    }

    SteamException(Throwable e){
        super("Something when wrong while attempting to connect to the steam servers", e)
    }
}
