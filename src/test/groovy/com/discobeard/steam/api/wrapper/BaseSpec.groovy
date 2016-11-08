package com.discobeard.steam.api.wrapper

import org.mockserver.integration.ClientAndProxy
import org.mockserver.integration.ClientAndServer
import org.mockserver.model.HttpRequest
import org.mockserver.model.HttpResponse
import spock.lang.Specification

import static org.mockserver.integration.ClientAndProxy.startClientAndProxy
import static org.mockserver.integration.ClientAndServer.startClientAndServer

class BaseSpec extends Specification {

    private static ClientAndProxy proxy;
    private static ClientAndServer mockServer;

    SteamApiWrapper steamApiWrapper = new SteamApiWrapper("key",  "http://localhost:1080")

    def setupSpec() {
        mockServer = startClientAndServer(1080)
        proxy = startClientAndProxy(1090)
    }

    def cleanupSpec() {
        proxy.stop()
        mockServer.stop()
    }

    public void returnMatchDetails() {
        mock(new File("src/test/resources/responses/steam/dota2/getMatchDetailsResponse.json").text)
    }

    public void returnHeroes() {
        mock(new File("src/test/resources/responses/steam/dota2/getHerosResponse.json").text)
    }

    public void steamReturnsGetItemsResponse() {
        mock(new File("src/test/resources/responses/steam/dota2/getGameItemsResponse.json").text)
    }

    public void steamReturnsMatchHistoryResponse() {
        mock(new File("src/test/resources/responses/steam/dota2/getMatchHistoryResponse.json").text)
    }

    public void returnPlayerSummaries() {
        mock(new File("src/test/resources/responses/steam/player/getPlayerSummariesResponse.json").text)
    }

    public void returnGetRecentlyPlayedGames() {
        mock(new File("src/test/resources/responses/steam/player/getRecentlyPlayedGamesResponse.json").text)
    }

    public void returnUnparsablePlayerSummaries() {
        mock('cantParse":"me"}')
    }

    public void steamReturnsSupportedApiListResponse() {
        mock(new File("src/test/resources/responses/steam/api/getSupportedApiListResponse.json").text)
    }

    public void steamReturnsGetServerInfoResponse() {
        mock(new File("src/test/resources/responses/steam/api/getServerInfoResponse.json").text)
    }

    private mock(String body) {
        mockServer.when(
                new HttpRequest())
                .respond(
                new HttpResponse()
                        .withBody(body)
                        .withHeader('Content-Type', 'application/json')
        )
    }
}