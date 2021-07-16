package com.notification.models

case class StockInfo(
                      stockTicker: String,
                      currentPrice: Double,
                      brokerAction: String,
                      actionRequestedAmount: Double
                    )
