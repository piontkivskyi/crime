package utils

import org.scalatest._

class CommandLineArgsParserTest extends FlatSpec {
  "A CommandLineArgsParser" should "parse valid command line params" in {
    val result = CommandLineArgsParser.parse(Array("-d", "some string"))

    assert(result.length == 1)
  }

  it should "return empty List if not paired args is presented" in {
    assert(CommandLineArgsParser.parse(Array("-d")) eq List())
  }
}
