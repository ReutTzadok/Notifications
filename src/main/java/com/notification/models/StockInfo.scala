package com.notification.models

import com.notification.models.BrokerAction.BrokerAction

case class StockInfo(
                      stockTicker: String,
                      currentPrice: Double,
                      brokerAction: BrokerAction,
                      actionRequestedAmount: Double
                    )