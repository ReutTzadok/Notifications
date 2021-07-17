package com.notification.models

import java.sql.Timestamp

//todo use Broker - wait for Ella
//todo change timestamp's type
case class Alert(
                brokerId: String,
                brokerFirstName: String,
                brokerLastName: String,
                brokerCompany: String,
                communicationTypeDetails: CommunicationDetails,
                timeStamp: String,
                stockInfo: StockInfo
                )
