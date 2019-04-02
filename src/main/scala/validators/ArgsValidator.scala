package validators

/**
  * Validator for command line args, which is already parsed ( application specific )
  */
object ArgsValidator extends Validator[List[(String, String)]] {
  /**
    *
    * @param param
    * @return
    */
  override def validate(param: List[(String, String)]): Boolean = {
    // check if param pair is specified (no checking for specific params for now)
    param.nonEmpty && param.exists(_._1 == "-d")
  }
}
