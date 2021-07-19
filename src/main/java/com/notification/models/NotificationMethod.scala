package com.notification.models

import scala.language.implicitConversions

object NotificationMethod extends Enumeration {
  type NotificationMethod = Value
  val EMAIL, SMS = Value

}
