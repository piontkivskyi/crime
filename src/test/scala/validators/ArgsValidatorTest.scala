package validators

import org.scalatest.FlatSpec

class ArgsValidatorTest extends FlatSpec {
  "A Args validator" should " validate -d <path> params" in {
    assert(ArgsValidator.validate(List(("-d", "<path>"))))
  }

  it should "not validate other params" in {
    assert(!ArgsValidator.validate(List()))
    assert(!ArgsValidator.validate(List(("some other key", "value"))))
  }
}
