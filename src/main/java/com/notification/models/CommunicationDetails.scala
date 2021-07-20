package com.notification.models

import com.notification.models.CommunicationType.CommunicationType

case class CommunicationDetails(
                                 communicationType: CommunicationType,
                                 communicationDetails: String
                               )
