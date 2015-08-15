package com.discobeard.dota2.api.wrapper.domain

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class SteamId {

    final String accountId32Bit
    final String accountId64Bit

    public static SteamId createFrom64Bit(String accountId64Bit){
        new SteamId(convertTo32Bit(accountId64Bit), accountId64Bit)
    }

    SteamId(String accountId32Bit){
        this.accountId32Bit = accountId32Bit
        this.accountId64Bit = convertTo64Bit(accountId32Bit)
    }

    SteamId(String accountId32Bit, String accountId64Bit){
        this.accountId32Bit = accountId32Bit
        this.accountId64Bit = accountId64Bit
    }

    private static String convertTo64Bit(String accountId32Bit) {
        BigInteger steamId32Bit = new BigInteger(accountId32Bit)
        BigInteger numberToAdd = new BigInteger("76561197960265728")
        (steamId32Bit + numberToAdd).toString()
    }

    private static String convertTo32Bit(String accountId64Bit) {
        BigInteger steamId64Bit = new BigInteger(accountId64Bit)
        BigInteger numberToSubtract = new BigInteger("76561197960265728")
        (steamId64Bit - numberToSubtract).toString()
    }
}
