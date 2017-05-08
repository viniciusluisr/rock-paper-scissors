package com.rps.game.player

import com.rps.game.action.GameOption
import com.rps.game.support.ScalaTestSupport
import com.rps.game.action.GameOption
import com.rps.game.support.ScalaTestSupport
import org.fest.assertions.Assertions.assertThat
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ComputerPlayerTest extends ScalaTestSupport {

  val player:ComputerPlayer = new ComputerPlayer()

  feature("Computer player results") {

    scenario("returns Computer type") {
      assertThat(player.`type`).isEqualTo("Computer")
    }

    scenario("returns random Game option") {
      player.play()
      assertThat(player.getGameOption).isInstanceOf(classOf[GameOption])
    }

  }

}
