package utils

import java.io.File

import org.scalatest.FlatSpec

class IOUtilsTest extends FlatSpec {
  "IOUtils" should "correctly return files from directory" in {
    val res = IOUtils.getFilesListFromDirectory(new File(getClass.getResource("/mocks").toURI).getAbsolutePath)

    assert(res.nonEmpty)
    assert(res.length == 1)
  }
}
