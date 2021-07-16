package com.notification.services

import com.notification.models.Alert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AlertHandler {
  @Autowired
  private val sendNotification: SendNotification = null



  def handle(alert: Alert): Unit = {
    //todo manage the notifications options

    //todo create the notification content
    val content: String = alert.stockInfo.stockTicker + alert.stockInfo.currentPrice
    sendNotification.send(alert.communicationTypeDetails.communicationDetails, content)

  }

}
