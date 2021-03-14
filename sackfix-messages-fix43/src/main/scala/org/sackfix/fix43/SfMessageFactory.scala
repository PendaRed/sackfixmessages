package org.sackfix.fix43

import org.sackfix.common.validated.fields.SfFixMessageDecoder

/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX43.xml
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
    case "j" => Some(BusinessMessageRejectMessage)
    case "7" => Some(AdvertisementMessage)
    case "6" => Some(IndicationOfInterestMessage)
    case "B" => Some(NewsMessage)
    case "C" => Some(EmailMessage)
    case "R" => Some(QuoteRequestMessage)
    case "AG" => Some(QuoteRequestRejectMessage)
    case "AH" => Some(RFQRequestMessage)
    case "S" => Some(QuoteMessage)
    case "Z" => Some(QuoteCancelMessage)
    case "a" => Some(QuoteStatusRequestMessage)
    case "AI" => Some(QuoteStatusReportMessage)
    case "i" => Some(MassQuoteMessage)
    case "b" => Some(MassQuoteAcknowledgementMessage)
    case "V" => Some(MarketDataRequestMessage)
    case "W" => Some(MarketDataSnapshotFullRefreshMessage)
    case "X" => Some(MarketDataIncrementalRefreshMessage)
    case "Y" => Some(MarketDataRequestRejectMessage)
    case "c" => Some(SecurityDefinitionRequestMessage)
    case "d" => Some(SecurityDefinitionMessage)
    case "v" => Some(SecurityTypeRequestMessage)
    case "w" => Some(SecurityTypesMessage)
    case "x" => Some(SecurityListRequestMessage)
    case "y" => Some(SecurityListMessage)
    case "z" => Some(DerivativeSecurityListRequestMessage)
    case "AA" => Some(DerivativeSecurityListMessage)
    case "e" => Some(SecurityStatusRequestMessage)
    case "f" => Some(SecurityStatusMessage)
    case "g" => Some(TradingSessionStatusRequestMessage)
    case "h" => Some(TradingSessionStatusMessage)
    case "D" => Some(NewOrderSingleMessage)
    case "8" => Some(ExecutionReportMessage)
    case "Q" => Some(DontKnowTradeMessage)
    case "G" => Some(OrderCancelReplaceRequestMessage)
    case "F" => Some(OrderCancelRequestMessage)
    case "9" => Some(OrderCancelRejectMessage)
    case "H" => Some(OrderStatusRequestMessage)
    case "q" => Some(OrderMassCancelRequestMessage)
    case "r" => Some(OrderMassCancelReportMessage)
    case "AF" => Some(OrderMassStatusRequestMessage)
    case "s" => Some(NewOrderCrossMessage)
    case "t" => Some(CrossOrderCancelReplaceRequestMessage)
    case "u" => Some(CrossOrderCancelRequestMessage)
    case "AB" => Some(NewOrderMultilegMessage)
    case "AC" => Some(MultilegOrderCancelReplaceRequestMessage)
    case "k" => Some(BidRequestMessage)
    case "l" => Some(BidResponseMessage)
    case "E" => Some(NewOrderListMessage)
    case "m" => Some(ListStrikePriceMessage)
    case "L" => Some(ListExecuteMessage)
    case "K" => Some(ListCancelRequestMessage)
    case "M" => Some(ListStatusRequestMessage)
    case "N" => Some(ListStatusMessage)
    case "J" => Some(AllocationMessage)
    case "P" => Some(AllocationACKMessage)
    case "T" => Some(SettlementInstructionsMessage)
    case "AD" => Some(TradeCaptureReportRequestMessage)
    case "AE" => Some(TradeCaptureReportMessage)
    case "o" => Some(RegistrationInstructionsMessage)
    case "p" => Some(RegistrationInstructionsResponseMessage)
    case _ => None
  }
}
