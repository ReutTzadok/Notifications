package com.notification.services


import com.notification.models.Alert
import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class AlertsListener {
  @Autowired
  private val alertHandler: AlertHandler = null


  //todo move topic-2 and group id to application properties
  implicit val formats: DefaultFormats.type = DefaultFormats
  @KafkaListener(id = "group_id", topics = Array("topic-2"))
  def listen(jsonAlert: String): Unit = {
    println("message read\n" + jsonAlert)

    val alert: Alert = JsonMethods.parse(jsonAlert).extract[Alert]
    alertHandler.handle(alert)
  }


}
