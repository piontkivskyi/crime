package utils

import java.io.File

/**
  * IOUtils is helper class, which is used to work with IO
  */
object IOUtils {
  /**
    * Return list of all files from given directory
    * @param directoryPath
    * @return
    */
  def getFilesListFromDirectory(directoryPath: String): List[File] = {
    val directory = new File(directoryPath)
    directory.listFiles.filter(_.isFile).toList
  }
}
