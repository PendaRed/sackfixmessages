package org.sackfix.fix44modified

import org.sackfix.common.validated.fields.SfFixMessageDecoder

/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
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
    case "BE" => Some(UserRequestMessage)
    case "BF" => Some(UserResponseMessage)
    case "7" => Some(AdvertisementMessage)
    case "6" => Some(IndicationOfInterestMessage)
    case "B" => Some(NewsMessage)
    case "C" => Some(EmailMessage)
    case "R" => Some(QuoteRequestMessage)
    case "AJ" => Some(QuoteResponseMessage)
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
    case "N" => Some(ListStatusMessage)
    case "L" => Some(ListExecuteMessage)
    case "K" => Some(ListCancelRequestMessage)
    case "M" => Some(ListStatusRequestMessage)
    case "J" => Some(AllocationInstructionMessage)
    case "P" => Some(AllocationInstructionAckMessage)
    case "AS" => Some(AllocationReportMessage)
    case "AT" => Some(AllocationReportAckMessage)
    case "AK" => Some(ConfirmationMessage)
    case "AU" => Some(ConfirmationAckMessage)
    case "BH" => Some(ConfirmationRequestMessage)
    case "T" => Some(SettlementInstructionsMessage)
    case "AV" => Some(SettlementInstructionRequestMessage)
    case "AD" => Some(TradeCaptureReportRequestMessage)
    case "AQ" => Some(TradeCaptureReportRequestAckMessage)
    case "AE" => Some(TradeCaptureReportMessage)
    case "AR" => Some(TradeCaptureReportAckMessage)
    case "o" => Some(RegistrationInstructionsMessage)
    case "p" => Some(RegistrationInstructionsResponseMessage)
    case "AL" => Some(PositionMaintenanceRequestMessage)
    case "AM" => Some(PositionMaintenanceReportMessage)
    case "AN" => Some(RequestForPositionsMessage)
    case "AO" => Some(RequestForPositionsAckMessage)
    case "AP" => Some(PositionReportMessage)
    case "AW" => Some(AssignmentReportMessage)
    case "AX" => Some(CollateralRequestMessage)
    case "AY" => Some(CollateralAssignmentMessage)
    case "AZ" => Some(CollateralResponseMessage)
    case "BA" => Some(CollateralReportMessage)
    case "BB" => Some(CollateralInquiryMessage)
    case "BC" => Some(NetworkStatusRequestMessage)
    case "BD" => Some(NetworkStatusResponseMessage)
    case "BG" => Some(CollateralInquiryAckMessage)
    case _ => None
  }
}
