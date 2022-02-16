package bloop.bsp

import io.circe.derivation.JsonCodec
import ch.epfl.scala.bsp.BuildTargetIdentifier
import io.circe.derivation.deriveDecoder
import io.circe.derivation.deriveEncoder
import io.circe.Decoder
import io.circe.Encoder
import scala.meta.jsonrpc.Endpoint
import ch.epfl.scala.bsp.ScalaTestClassesParams


object ScalaTestSuitesEndpoint {
  val endpoint = new Endpoint[ScalaTestClassesParams, ScalaTestSuitesResult]("buildTarget/scalaTestSuites")
}
final case class ScalaTestSuitesResult(
  items: List[ScalaTestSuitesItem]
)
object ScalaTestSuitesResult {
  implicit val decoder: Decoder[ScalaTestSuitesResult] = deriveDecoder
  implicit val encoder: Encoder[ScalaTestSuitesResult] = deriveEncoder
}


final case class ScalaTestSuitesItem(
    target: BuildTargetIdentifier,
    classes: List[ScalaTestFrameworkSuites]
)
object ScalaTestSuitesItem {
  implicit val decoder: Decoder[ScalaTestSuitesItem] = deriveDecoder
  implicit val encoder: Encoder[ScalaTestSuitesItem] = deriveEncoder
}


final case class ScalaTestFrameworkSuites(
    framework: String,
    // Fully qualified names of test classes
    classes: List[String]
)
object ScalaTestFrameworkSuites {
  implicit val decoder: Decoder[ScalaTestFrameworkSuites] = deriveDecoder
  implicit val encoder: Encoder[ScalaTestFrameworkSuites] = deriveEncoder
}
