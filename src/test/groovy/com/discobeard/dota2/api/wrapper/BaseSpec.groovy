package com.discobeard.dota2.api.wrapper

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
        mockServer.when(
                new HttpRequest())
                .respond(
                new HttpResponse()
                        .withBody(new File("src/test/resources/responses/steam/getMatchDetailsResponse.json").text)
                        .withHeader('Content-Type', 'application/json')
                )
    }

    public void returnHeroes() {
        mockServer.when(
                new HttpRequest())
                .respond(
                new HttpResponse()
                        .withBody(new File("src/test/resources/responses/steam/getHerosResponse.json").text)
                        .withHeader('Content-Type', 'application/json')
        )
    }

    public void returnItems() {
        mockServer.when(
                new HttpRequest())
                .respond(
                new HttpResponse()
                        .withBody(new File("src/test/resources/responses/steam/getGameItemsResponse.json").text)
                        .withHeader('Content-Type', 'application/json')
        )
    }

    public void returnMatchHistory() {
        mockServer.when(
                new HttpRequest())
                .respond(
                new HttpResponse()
                        .withBody(new File("src/test/resources/responses/steam/getMatchHistoryResponse.json").text)
                        .withHeader('Content-Type', 'application/json')
        )
    }

    public void returnPlayerSummaries() {
        mockServer.when(
                new HttpRequest())
                .respond(
                new HttpResponse()
                        .withBody(new File("src/test/resources/responses/steam/getPlayerSummariesResponse.json").text)
                        .withHeader('Content-Type', 'application/json')
        )
    }

}
