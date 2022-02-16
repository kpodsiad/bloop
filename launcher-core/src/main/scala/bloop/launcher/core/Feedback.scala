package bloop.launcher.core

import java.nio.file.Path

object Feedback {
  val SkippingFullInstallation: String =
    "Python is missing from the classpath, skipping full bloop installation..."
  val UseFallbackInstallation: String =
    "The launcher will now try to resolve bloop and spawn an embedded build server..."
  val NoBloopVersion: String =
    "The bloop launcher accepts only one argument: the bloop version."
  val DetectedBloopinstallation: String =
    "A bloop installation has been detected either in the PATH or $HOME/.bloop"

  def installationLogs(bloopDirectory: Path): String = {
    val bloopDir = bloopDirectory.toAbsolutePath.toString
    s"""The launcher has installed `bloop` in $bloopDir
       |Recommendation: Add bloop to your $$PATH to use the command-line tool with:
       |    export PATH=$$PATH:$bloopDir""".stripMargin
  }

  def installingBloop(version: String): String =
    s"Bloop is not available in the machine, installing bloop ${version}..."

  def downloadingInstallerAt(url: java.net.URL): String = s"Downloading installer at ${url}..."
  def failedToDownloadInstallerAt(url: java.net.URL): String = {
    s"Failed to download installer at ${url}..."
  }

  def startingBloopServer(cmd: List[String]): String = {
    val suffix = if (cmd.isEmpty) "" else s" with '${cmd.mkString(" ")}'..."
    s"Starting the bloop server$suffix"
  }

  def resolvingDependency(dependency: String): String = s"Resolving $dependency..."
  def resolvingDependencyWithNoScalaSuffix(dependency: String): String =
    s"Resolution of $dependency failed, let's try to resolve bloop with no scala suffix..."

  def openingBspConnection(cmd: List[String]): String = {
    val suffix = if (cmd.isEmpty) "" else s" with '${cmd.mkString(" ")}'..."
    s"Opening a bsp server connection$suffix"
  }
}
