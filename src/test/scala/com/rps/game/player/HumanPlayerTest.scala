package com.rps.game.player

import com.rps.game.action.GameOption.SCISSORS
import com.rps.game.action.{GameOption, UserInput}
import com.rps.game.action.{GameOption, UserInput}
import com.rps.game.support.ScalaTestSupport
import org.fest.assertions.Assertions.assertThat
import org.junit.runner.RunWith
import org.mockito.Mockito.when
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class HumanPlayerTest extends ScalaTestSupport {

  val player:HumanPlayer = new HumanPlayer()
  val userInput:UserInput = mock[UserInput]

  override protected def beforeAll(): Unit = {
    player.setUserInput(userInput)
  }

  feature("Human player results") {

    scenario("returns Human type") {
      assertThat(player.`type`).isEqualTo("Human")
    }

    scenario("Returns user selected Game option") {
      Given("the Scissors Game option")
      when(userInput.readGameOption()).thenReturn(SCISSORS)

      When("the player plays")
      val option:GameOption = player.play()

      Then("the game options menu should repreats")
      assertThat(option).isEqualTo(SCISSORS)
    }



  }

}
