/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example

import javax.annotation.{PostConstruct, PreDestroy}

import wvlet.airframe.AirframeSpec
import wvlet.log.LogSupport

/**
  * bindSingleton[X] example
  */
object BindSingleton {
  import wvlet.airframe._

  trait X {
    def hello: String = "Hello"
    def goodbye : String = "Good-bye"
  }
  trait Y {
    def world: String = "World"
  }

  trait XY extends LogSupport {
    val x = bind[X]
    val y = bind[Y]

    @PostConstruct
    def start() {
      // This will be called only once since XY is used as singleton
      info(s"${x.hello} ${y.world}!")
    }

    @PreDestroy
    def close() {
      // This will be called only once since XY is used as singleton
      info(s"${x.goodbye} ${y.world}!")
    }
  }

  trait XYService {
    // Sharing a singleton of XY between App1 and App2
    val service = bindSingleton[XY]
  }

  trait App1 extends XYService
  trait App2 extends XYService

  val session = newDesign.newSession
  val app = session.build[App1]
  val app2 = session.build[App2]
  session.shutdown
}

class BindSingleton extends AirframeSpec {
  "BindSingleton" should {
    "run" in {
      val b = BindSingleton
    }
  }
}
