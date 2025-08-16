package WT_Olyakov

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class WTDebug extends Simulation {

    setUp(WTScenario().inject(atOnceUsers(1)))
        .protocols(WTSimulation.httpProtocol)

}
