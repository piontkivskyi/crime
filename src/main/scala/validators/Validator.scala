package validators

/**
  * Trait for validators
  *
  * @tparam T
  */
trait Validator[T] {
  /**
    * Method, which get some param and validate it
    *
    * @param param
    * @return
    */
  def validate(param: T): Boolean
}
