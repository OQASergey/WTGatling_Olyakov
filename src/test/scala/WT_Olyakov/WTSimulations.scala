package WT_Olyakov

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import scala.concurrent.duration._

object WTSimulation {
    val httpProtocol: HttpProtocolBuilder = http
        .baseUrl("http://webtours.load-test.ru:1080")
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
  
}

class WTSimulation extends Simulation {
  setUp(
    WTScenario()
      .inject(
        incrementUsersPerSec(1)
          .times(11)
          .eachLevelLasting(2 minutes)
          .startingFrom(0)
      )
  ).protocols(WTSimulation.httpProtocol)
}