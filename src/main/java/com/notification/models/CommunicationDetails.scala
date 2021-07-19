package com.notification.models

import com.notification.models.NotificationMethod.NotificationMethod

case class CommunicationDetails(
                                 communicationType: NotificationMethod,
                                 communicationDetails: String
                               )
