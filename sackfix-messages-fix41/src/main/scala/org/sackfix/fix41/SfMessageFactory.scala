package org.sackfix.fix41

import org.sackfix.common.validated.fields.SfFixMessageDecoder

/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX41.xml
  */
object SfMessageFactory {
  def getMessage(msgType:String):Option[SfFixMessageDecoder] = msgType match {
    case "0" => Some(HeartbeatMessage)
    case "A" => Some(LogonMessage)
    case "1" => Some(TestRequestMessage)
    case "2" => Some(ResendRequestMessage)
    case "3" => Some(RejectMessage)
    case "4" => Some(SequenceResetMessage)
    case "5" => Some(LogoutMessage)
    case "7" => Some(AdvertisementMessage)
    case "6" => Some(IndicationofInterestMessage)
    case "B" => Some(NewsMessage)
    case "C" => Some(EmailMessage)
    case "R" => Some(QuoteRequestMessage)
    case "S" => Some(QuoteMessage)
    case "D" => Some(NewOrderSingleMessage)
    case "8" => Some(ExecutionReportMessage)
    case "Q" => Some(DontKnowTradeMessage)
    case "G" => Some(OrderCancelReplaceRequestMessage)
    case "F" => Some(OrderCancelRequestMessage)
    case "9" => Some(OrderCancelRejectMessage)
    case "H" => Some(OrderStatusRequestMessage)
    case "J" => Some(AllocationMessage)
    case "P" => Some(AllocationACKMessage)
    case "T" => Some(SettlementInstructionsMessage)
    case "E" => Some(NewOrderListMessage)
    case "N" => Some(ListStatusMessage)
    case "L" => Some(ListExecuteMessage)
    case "K" => Some(ListCancelRequestMessage)
    case "M" => Some(ListStatusRequestMessage)
    case _ => None
  }
}
