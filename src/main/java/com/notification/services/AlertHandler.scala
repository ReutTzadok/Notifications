package com.notification.services

import com.notification.models.{Alert, StockInfo}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AlertHandler {
  @Autowired
  private val sendNotification: SendNotification = null



  def handle(alert: Alert): Unit = {
    //todo manage the notifications options

    //todo add "canceled" option
    val content = alert.stockInfo match {
      case StockInfo(stockTicker, _, "BUY", actionRequestedAmount) => s"The price of $stockTicker stock is lower than $actionRequestedAmount"
      case StockInfo(stockTicker, _, "SELL", actionRequestedAmount) => s"The price of $stockTicker stock is higher than $actionRequestedAmount"
    }

    sendNotification.send(alert.communicationTypeDetails.communicationDetails, content)

  }

}
