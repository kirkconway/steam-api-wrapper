package com.discobeard.steam.api.wrapper

import org.mockserver.integration.ClientAndProxy
import org.mockserver.integration.ClientAndServer
import org.mockserver.model.HttpRequest
import org.mockserver.model.HttpResponse
import spock.lang.Specification
import static org.mockserver.integration.ClientAndProxy.startClientAndProxy;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

class BaseSpec extends Specification {
    private static ClientAndProxy proxy;
    private static ClientAndServer mockServer;

    def setupSpec() {
        mockServer = startClientAndServer(1080)
        proxy = startClientAndProxy(1090)
    }

    def cleanupSpec() {
        proxy.stop()
        mockServer.stop()
    }

    public void returnMatchDetails() {
        mock(new File("src/test/resources/responses/steam/getMatchDetailsResponse.json").text)
    }

    public void returnHeroes() {
        mock(new File("src/test/resources/responses/steam/getHerosResponse.json").text)
    }

    public void returnItems() {
        mock(new File("src/test/resources/responses/steam/getGameItemsResponse.json").text)
    }

    public void returnMatchHistory() {
        mock(new File("src/test/resources/responses/steam/getMatchHistoryResponse.json").text)
    }

    public void returnPlayerSummaries() {
        mock(new File("src/test/resources/responses/steam/getPlayerSummariesResponse.json").text)
    }

    public void returnGetRecentlyPlayedGames() {
        mock(new File("src/test/resources/responses/steam/getRecentlyPlayedGamesResponse.json").text)
    }

    public void returnUnparsablePlayerSummaries() {
        mock('cantParse":"me"}')
    }

    private mock(String body){
        mockServer.when(
                new HttpRequest())
                .respond(
                new HttpResponse()
                        .withBody(body)
                        .withHeader('Content-Type', 'application/json')
        )
    }
}