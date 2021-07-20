package com.notification.services


import com.notification.models.{Alert, BrokerAction, CommunicationType}
import org.json4s.{DefaultFormats, Formats}
import org.json4s.jackson.JsonMethods
import org.json4s.ext.EnumNameSerializer
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class AlertsListener(val alertHandler: AlertHandler) {

  implicit lazy val formats: Formats = DefaultFormats + new EnumNameSerializer(CommunicationType) + new EnumNameSerializer(BrokerAction)
  @KafkaListener(id = "${spring.kafka.consumer.group-id}", topics = Array("${spring.kafka.consumer.topic}"))
  def listen(jsonAlert: String): Unit = {
    println("message read\n" + jsonAlert)

    val alert: Alert = JsonMethods.parse(jsonAlert).extract[Alert]
    alertHandler.handle(alert)
  }


}
