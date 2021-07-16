package com.notification.models

import java.sql.Timestamp

//todo use Broker - wait for Ella
case class Alert(
                brokerId: String,
                brokerFirstName: String,
                brokerLastName: String,
                brokerCompany: String,
                communicationTypeDetails: CommunicationDetails,
                timeStamp: Timestamp,
                stockInfo: StockInfo
                )
