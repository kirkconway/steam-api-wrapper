package com.discobeard.steam.api.wrapper.exception

class SteamException extends Exception{

    SteamException(String message, Throwable e){
        super(message, e)
    }
}
