/*
 * Copyright 2017 Equal Experts
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.equalexperts.play.asyncmvc.async

import org.scalatest.concurrent.{Eventually, ScalaFutures}
import uk.gov.hmrc.play.test.UnitSpec
import scala.concurrent.duration._

class TimedEventSpec extends UnitSpec with ScalaFutures with Eventually {

  "TimedEvent" should {

    "Incur a delay before executing the Future" in {

      val now = System.currentTimeMillis()
      val response: Int = await(TimedEvent.delayedSuccess(2000, 999))(4 seconds)

      val processTime = System.currentTimeMillis()
      println(s"start time $now - Expired time $processTime")

      response shouldBe 999
      processTime shouldBe >(now + 1000)

    }
  }
}
