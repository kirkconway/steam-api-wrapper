package com.discobeard.dota2.api.wrapper.exception

class SteamException extends Exception{

    SteamException(String message, Exception e){
        super(message, e)
    }

    SteamException(Exception e){
        super("Something when wrong while attempting to connect to the steam servers", e)
    }
}
