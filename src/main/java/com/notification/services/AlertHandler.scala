package com.notification.services

import com.notification.models.BrokerAction.{BUY, SELL}
import com.notification.models.CommunicationType._
import com.notification.models.{Alert, StockInfo}
import org.springframework.stereotype.Component

@Component
class AlertHandler (email: SendEmailNotification,
                   sms: SendSmsNotification){

  private val sendNotificationsMethod:Map[CommunicationType, SendNotification] = Map(
    (EMAIL, email),
    (SMS, sms)
  )



  def handle(alert: Alert): Unit = {

    //todo add "canceled" option
    val content = alert.stockInfo match {
      case StockInfo(stockTicker, _, BUY, actionRequestedAmount) => s"The price of $stockTicker stock is lower than $actionRequestedAmount"
      case StockInfo(stockTicker, _, SELL, actionRequestedAmount) => s"The price of $stockTicker stock is higher than $actionRequestedAmount"
    }

    sendNotificationsMethod(alert.communicationTypeDetails.communicationType)
      .send(alert.communicationTypeDetails.communicationDetails, content)

  }

}
