package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class TradeCaptureReportMessage(tradeReportIDField:Option[TradeReportIDField]=None,
                                     tradeReportTransTypeField:Option[TradeReportTransTypeField]=None,
                                     tradeReportTypeField:Option[TradeReportTypeField]=None,
                                     tradeRequestIDField:Option[TradeRequestIDField]=None,
                                     trdTypeField:Option[TrdTypeField]=None,
                                     trdSubTypeField:Option[TrdSubTypeField]=None,
                                     secondaryTrdTypeField:Option[SecondaryTrdTypeField]=None,
                                     transferReasonField:Option[TransferReasonField]=None,
                                     execTypeField:Option[ExecTypeField]=None,
                                     totNumTradeReportsField:Option[TotNumTradeReportsField]=None,
                                     lastRptRequestedField:Option[LastRptRequestedField]=None,
                                     unsolicitedIndicatorField:Option[UnsolicitedIndicatorField]=None,
                                     subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None,
                                     tradeReportRefIDField:Option[TradeReportRefIDField]=None,
                                     secondaryTradeReportRefIDField:Option[SecondaryTradeReportRefIDField]=None,
                                     secondaryTradeReportIDField:Option[SecondaryTradeReportIDField]=None,
                                     tradeLinkIDField:Option[TradeLinkIDField]=None,
                                     trdMatchIDField:Option[TrdMatchIDField]=None,
                                     execIDField:Option[ExecIDField]=None,
                                     ordStatusField:Option[OrdStatusField]=None,
                                     secondaryExecIDField:Option[SecondaryExecIDField]=None,
                                     execRestatementReasonField:Option[ExecRestatementReasonField]=None,
                                     previouslyReportedField:Option[PreviouslyReportedField]=None,
                                     priceTypeField:Option[PriceTypeField]=None,
                                     instrumentComponent:InstrumentComponent,
                                     financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                     orderQtyDataComponent:Option[OrderQtyDataComponent]=None,
                                     qtyTypeField:Option[QtyTypeField]=None,
                                     yieldDataComponent:Option[YieldDataComponent]=None,
                                     undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                     underlyingTradingSessionIDField:Option[UnderlyingTradingSessionIDField]=None,
                                     underlyingTradingSessionSubIDField:Option[UnderlyingTradingSessionSubIDField]=None,
                                     lastQtyField:LastQtyField,
                                     lastPxField:LastPxField,
                                     lastParPxField:Option[LastParPxField]=None,
                                     lastSpotRateField:Option[LastSpotRateField]=None,
                                     lastForwardPointsField:Option[LastForwardPointsField]=None,
                                     lastMktField:Option[LastMktField]=None,
                                     tradeDateField:TradeDateField,
                                     clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                     avgPxField:Option[AvgPxField]=None,
                                     spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                                     avgPxIndicatorField:Option[AvgPxIndicatorField]=None,
                                     positionAmountDataComponent:Option[PositionAmountDataComponent]=None,
                                     multiLegReportingTypeField:Option[MultiLegReportingTypeField]=None,
                                     tradeLegRefIDField:Option[TradeLegRefIDField]=None,
                                     trdInstrmtLegGrpComponent:Option[TrdInstrmtLegGrpComponent]=None,
                                     transactTimeField:Option[TransactTimeField]=None,
                                     trdRegTimestampsComponent:Option[TrdRegTimestampsComponent]=None,
                                     settlTypeField:Option[SettlTypeField]=None,
                                     settlDateField:Option[SettlDateField]=None,
                                     matchStatusField:Option[MatchStatusField]=None,
                                     matchTypeField:Option[MatchTypeField]=None,
                                     trdCapRptSideGrpComponent:TrdCapRptSideGrpComponent,
                                     copyMsgIndicatorField:Option[CopyMsgIndicatorField]=None,
                                     publishTrdIndicatorField:Option[PublishTrdIndicatorField]=None,
                                     shortSaleReasonField:Option[ShortSaleReasonField]=None,
                                     trdRptStatusField:Option[TrdRptStatusField]=None,
                                     asOfIndicatorField:Option[AsOfIndicatorField]=None,
                                     settlSessIDField:Option[SettlSessIDField]=None,
                                     settlSessSubIDField:Option[SettlSessSubIDField]=None,
                                     tierCodeField:Option[TierCodeField]=None,
                                     messageEventSourceField:Option[MessageEventSourceField]=None,
                                     lastUpdateTimeField:Option[LastUpdateTimeField]=None,
                                     rndPxField:Option[RndPxField]=None,
                                     tradeIDField:Option[TradeIDField]=None,
                                     secondaryTradeIDField:Option[SecondaryTradeIDField]=None,
                                     firmTradeIDField:Option[FirmTradeIDField]=None,
                                     secondaryFirmTradeIDField:Option[SecondaryFirmTradeIDField]=None,
                                     calculatedCcyLastQtyField:Option[CalculatedCcyLastQtyField]=None,
                                     lastSwapPointsField:Option[LastSwapPointsField]=None,
                                     underlyingSettlementDateField:Option[UnderlyingSettlementDateField]=None,
                                     grossTradeAmtField:Option[GrossTradeAmtField]=None,
                                     rootPartiesComponent:Option[RootPartiesComponent]=None,
                                     orderCategoryField:Option[OrderCategoryField]=None,
                                     tradeHandlingInstrField:Option[TradeHandlingInstrField]=None,
                                     origTradeHandlingInstrField:Option[OrigTradeHandlingInstrField]=None,
                                     origTradeDateField:Option[OrigTradeDateField]=None,
                                     origTradeIDField:Option[OrigTradeIDField]=None,
                                     origSecondaryTradeIDField:Option[OrigSecondaryTradeIDField]=None,
                                     tZTransactTimeField:Option[TZTransactTimeField]=None,
                                     reportedPxDiffField:Option[ReportedPxDiffField]=None) extends SfFixMessageBody("AE")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    tradeReportIDField.foreach(fmt(b,_))
    tradeReportTransTypeField.foreach(fmt(b,_))
    tradeReportTypeField.foreach(fmt(b,_))
    tradeRequestIDField.foreach(fmt(b,_))
    trdTypeField.foreach(fmt(b,_))
    trdSubTypeField.foreach(fmt(b,_))
    secondaryTrdTypeField.foreach(fmt(b,_))
    transferReasonField.foreach(fmt(b,_))
    execTypeField.foreach(fmt(b,_))
    totNumTradeReportsField.foreach(fmt(b,_))
    lastRptRequestedField.foreach(fmt(b,_))
    unsolicitedIndicatorField.foreach(fmt(b,_))
    subscriptionRequestTypeField.foreach(fmt(b,_))
    tradeReportRefIDField.foreach(fmt(b,_))
    secondaryTradeReportRefIDField.foreach(fmt(b,_))
    secondaryTradeReportIDField.foreach(fmt(b,_))
    tradeLinkIDField.foreach(fmt(b,_))
    trdMatchIDField.foreach(fmt(b,_))
    execIDField.foreach(fmt(b,_))
    ordStatusField.foreach(fmt(b,_))
    secondaryExecIDField.foreach(fmt(b,_))
    execRestatementReasonField.foreach(fmt(b,_))
    previouslyReportedField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    financingDetailsComponent.foreach(fmt(b,_))
    orderQtyDataComponent.foreach(fmt(b,_))
    qtyTypeField.foreach(fmt(b,_))
    yieldDataComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    underlyingTradingSessionIDField.foreach(fmt(b,_))
    underlyingTradingSessionSubIDField.foreach(fmt(b,_))
    fmt(b,lastQtyField)
    fmt(b,lastPxField)
    lastParPxField.foreach(fmt(b,_))
    lastSpotRateField.foreach(fmt(b,_))
    lastForwardPointsField.foreach(fmt(b,_))
    lastMktField.foreach(fmt(b,_))
    fmt(b,tradeDateField)
    clearingBusinessDateField.foreach(fmt(b,_))
    avgPxField.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    avgPxIndicatorField.foreach(fmt(b,_))
    positionAmountDataComponent.foreach(fmt(b,_))
    multiLegReportingTypeField.foreach(fmt(b,_))
    tradeLegRefIDField.foreach(fmt(b,_))
    trdInstrmtLegGrpComponent.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    trdRegTimestampsComponent.foreach(fmt(b,_))
    settlTypeField.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    matchStatusField.foreach(fmt(b,_))
    matchTypeField.foreach(fmt(b,_))
    fmt(b,trdCapRptSideGrpComponent)
    copyMsgIndicatorField.foreach(fmt(b,_))
    publishTrdIndicatorField.foreach(fmt(b,_))
    shortSaleReasonField.foreach(fmt(b,_))
    trdRptStatusField.foreach(fmt(b,_))
    asOfIndicatorField.foreach(fmt(b,_))
    settlSessIDField.foreach(fmt(b,_))
    settlSessSubIDField.foreach(fmt(b,_))
    tierCodeField.foreach(fmt(b,_))
    messageEventSourceField.foreach(fmt(b,_))
    lastUpdateTimeField.foreach(fmt(b,_))
    rndPxField.foreach(fmt(b,_))
    tradeIDField.foreach(fmt(b,_))
    secondaryTradeIDField.foreach(fmt(b,_))
    firmTradeIDField.foreach(fmt(b,_))
    secondaryFirmTradeIDField.foreach(fmt(b,_))
    calculatedCcyLastQtyField.foreach(fmt(b,_))
    lastSwapPointsField.foreach(fmt(b,_))
    underlyingSettlementDateField.foreach(fmt(b,_))
    grossTradeAmtField.foreach(fmt(b,_))
    rootPartiesComponent.foreach(fmt(b,_))
    orderCategoryField.foreach(fmt(b,_))
    tradeHandlingInstrField.foreach(fmt(b,_))
    origTradeHandlingInstrField.foreach(fmt(b,_))
    origTradeDateField.foreach(fmt(b,_))
    origTradeIDField.foreach(fmt(b,_))
    origSecondaryTradeIDField.foreach(fmt(b,_))
    tZTransactTimeField.foreach(fmt(b,_))
    reportedPxDiffField.foreach(fmt(b,_))
    b
  }

}
     
object TradeCaptureReportMessage extends SfFixMessageDecoder {
  val MsgType="AE"
  val MsgName="TradeCaptureReport"
             
  override val MandatoryFields = HashSet[Int](
    LastQtyField.TagId, LastPxField.TagId, TradeDateField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || OrderQtyDataComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId) || 
    UndInstrmtGrpComponent.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || PositionAmountDataComponent.isMandatoryField(tagId) || TrdInstrmtLegGrpComponent.isMandatoryField(tagId) || 
    TrdRegTimestampsComponent.isMandatoryField(tagId) || TrdCapRptSideGrpComponent.isMandatoryField(tagId) || RootPartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TradeReportIDField.TagId, TradeReportTransTypeField.TagId, TradeReportTypeField.TagId, TradeRequestIDField.TagId, TrdTypeField.TagId, 
    TrdSubTypeField.TagId, SecondaryTrdTypeField.TagId, TransferReasonField.TagId, ExecTypeField.TagId, TotNumTradeReportsField.TagId, 
    LastRptRequestedField.TagId, UnsolicitedIndicatorField.TagId, SubscriptionRequestTypeField.TagId, TradeReportRefIDField.TagId, SecondaryTradeReportRefIDField.TagId, 
    SecondaryTradeReportIDField.TagId, TradeLinkIDField.TagId, TrdMatchIDField.TagId, ExecIDField.TagId, OrdStatusField.TagId, 
    SecondaryExecIDField.TagId, ExecRestatementReasonField.TagId, PreviouslyReportedField.TagId, PriceTypeField.TagId, QtyTypeField.TagId, 
    UnderlyingTradingSessionIDField.TagId, UnderlyingTradingSessionSubIDField.TagId, LastParPxField.TagId, LastSpotRateField.TagId, LastForwardPointsField.TagId, 
    LastMktField.TagId, ClearingBusinessDateField.TagId, AvgPxField.TagId, AvgPxIndicatorField.TagId, MultiLegReportingTypeField.TagId, 
    TradeLegRefIDField.TagId, TransactTimeField.TagId, SettlTypeField.TagId, SettlDateField.TagId, MatchStatusField.TagId, 
    MatchTypeField.TagId, CopyMsgIndicatorField.TagId, PublishTrdIndicatorField.TagId, ShortSaleReasonField.TagId, TrdRptStatusField.TagId, 
    AsOfIndicatorField.TagId, SettlSessIDField.TagId, SettlSessSubIDField.TagId, TierCodeField.TagId, MessageEventSourceField.TagId, 
    LastUpdateTimeField.TagId, RndPxField.TagId, TradeIDField.TagId, SecondaryTradeIDField.TagId, FirmTradeIDField.TagId, 
    SecondaryFirmTradeIDField.TagId, CalculatedCcyLastQtyField.TagId, LastSwapPointsField.TagId, UnderlyingSettlementDateField.TagId, GrossTradeAmtField.TagId, 
    OrderCategoryField.TagId, TradeHandlingInstrField.TagId, OrigTradeHandlingInstrField.TagId, OrigTradeDateField.TagId, OrigTradeIDField.TagId, 
    OrigSecondaryTradeIDField.TagId, TZTransactTimeField.TagId, ReportedPxDiffField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || OrderQtyDataComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId) || 
    UndInstrmtGrpComponent.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || PositionAmountDataComponent.isOptionalField(tagId) || TrdInstrmtLegGrpComponent.isOptionalField(tagId) || 
    TrdRegTimestampsComponent.isOptionalField(tagId) || TrdCapRptSideGrpComponent.isOptionalField(tagId) || RootPartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || OrderQtyDataComponent.isFieldOf(tagId) || 
    YieldDataComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || 
    PositionAmountDataComponent.isFieldOf(tagId) || TrdInstrmtLegGrpComponent.isFieldOf(tagId) || TrdRegTimestampsComponent.isFieldOf(tagId) || 
    TrdCapRptSideGrpComponent.isFieldOf(tagId) || RootPartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==TradeReportIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(TradeCaptureReportMessage(myFields.get(TradeReportIDField.TagId).flatMap(f=>TradeReportIDField.decode(f)),
        myFields.get(TradeReportTransTypeField.TagId).flatMap(f=>TradeReportTransTypeField.decode(f)),
        myFields.get(TradeReportTypeField.TagId).flatMap(f=>TradeReportTypeField.decode(f)),
        myFields.get(TradeRequestIDField.TagId).flatMap(f=>TradeRequestIDField.decode(f)),
        myFields.get(TrdTypeField.TagId).flatMap(f=>TrdTypeField.decode(f)),
        myFields.get(TrdSubTypeField.TagId).flatMap(f=>TrdSubTypeField.decode(f)),
        myFields.get(SecondaryTrdTypeField.TagId).flatMap(f=>SecondaryTrdTypeField.decode(f)),
        myFields.get(TransferReasonField.TagId).flatMap(f=>TransferReasonField.decode(f)),
        myFields.get(ExecTypeField.TagId).flatMap(f=>ExecTypeField.decode(f)),
        myFields.get(TotNumTradeReportsField.TagId).flatMap(f=>TotNumTradeReportsField.decode(f)),
        myFields.get(LastRptRequestedField.TagId).flatMap(f=>LastRptRequestedField.decode(f)),
        myFields.get(UnsolicitedIndicatorField.TagId).flatMap(f=>UnsolicitedIndicatorField.decode(f)),
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f)),
        myFields.get(TradeReportRefIDField.TagId).flatMap(f=>TradeReportRefIDField.decode(f)),
        myFields.get(SecondaryTradeReportRefIDField.TagId).flatMap(f=>SecondaryTradeReportRefIDField.decode(f)),
        myFields.get(SecondaryTradeReportIDField.TagId).flatMap(f=>SecondaryTradeReportIDField.decode(f)),
        myFields.get(TradeLinkIDField.TagId).flatMap(f=>TradeLinkIDField.decode(f)),
        myFields.get(TrdMatchIDField.TagId).flatMap(f=>TrdMatchIDField.decode(f)),
        myFields.get(ExecIDField.TagId).flatMap(f=>ExecIDField.decode(f)),
        myFields.get(OrdStatusField.TagId).flatMap(f=>OrdStatusField.decode(f)),
        myFields.get(SecondaryExecIDField.TagId).flatMap(f=>SecondaryExecIDField.decode(f)),
        myFields.get(ExecRestatementReasonField.TagId).flatMap(f=>ExecRestatementReasonField.decode(f)),
        myFields.get(PreviouslyReportedField.TagId).flatMap(f=>PreviouslyReportedField.decode(f)),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        FinancingDetailsComponent.decode(flds, startPos),
        OrderQtyDataComponent.decode(flds, startPos),
        myFields.get(QtyTypeField.TagId).flatMap(f=>QtyTypeField.decode(f)),
        YieldDataComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        myFields.get(UnderlyingTradingSessionIDField.TagId).flatMap(f=>UnderlyingTradingSessionIDField.decode(f)),
        myFields.get(UnderlyingTradingSessionSubIDField.TagId).flatMap(f=>UnderlyingTradingSessionSubIDField.decode(f)),
        LastQtyField.decode(myFields.get(LastQtyField.TagId)).get,
        LastPxField.decode(myFields.get(LastPxField.TagId)).get,
        myFields.get(LastParPxField.TagId).flatMap(f=>LastParPxField.decode(f)),
        myFields.get(LastSpotRateField.TagId).flatMap(f=>LastSpotRateField.decode(f)),
        myFields.get(LastForwardPointsField.TagId).flatMap(f=>LastForwardPointsField.decode(f)),
        myFields.get(LastMktField.TagId).flatMap(f=>LastMktField.decode(f)),
        TradeDateField.decode(myFields.get(TradeDateField.TagId)).get,
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(AvgPxField.TagId).flatMap(f=>AvgPxField.decode(f)),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        myFields.get(AvgPxIndicatorField.TagId).flatMap(f=>AvgPxIndicatorField.decode(f)),
        PositionAmountDataComponent.decode(flds, startPos),
        myFields.get(MultiLegReportingTypeField.TagId).flatMap(f=>MultiLegReportingTypeField.decode(f)),
        myFields.get(TradeLegRefIDField.TagId).flatMap(f=>TradeLegRefIDField.decode(f)),
        TrdInstrmtLegGrpComponent.decode(flds, startPos),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        TrdRegTimestampsComponent.decode(flds, startPos),
        myFields.get(SettlTypeField.TagId).flatMap(f=>SettlTypeField.decode(f)),
        myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
        myFields.get(MatchStatusField.TagId).flatMap(f=>MatchStatusField.decode(f)),
        myFields.get(MatchTypeField.TagId).flatMap(f=>MatchTypeField.decode(f)),
        TrdCapRptSideGrpComponent.decode(flds, startPos).get,
        myFields.get(CopyMsgIndicatorField.TagId).flatMap(f=>CopyMsgIndicatorField.decode(f)),
        myFields.get(PublishTrdIndicatorField.TagId).flatMap(f=>PublishTrdIndicatorField.decode(f)),
        myFields.get(ShortSaleReasonField.TagId).flatMap(f=>ShortSaleReasonField.decode(f)),
        myFields.get(TrdRptStatusField.TagId).flatMap(f=>TrdRptStatusField.decode(f)),
        myFields.get(AsOfIndicatorField.TagId).flatMap(f=>AsOfIndicatorField.decode(f)),
        myFields.get(SettlSessIDField.TagId).flatMap(f=>SettlSessIDField.decode(f)),
        myFields.get(SettlSessSubIDField.TagId).flatMap(f=>SettlSessSubIDField.decode(f)),
        myFields.get(TierCodeField.TagId).flatMap(f=>TierCodeField.decode(f)),
        myFields.get(MessageEventSourceField.TagId).flatMap(f=>MessageEventSourceField.decode(f)),
        myFields.get(LastUpdateTimeField.TagId).flatMap(f=>LastUpdateTimeField.decode(f)),
        myFields.get(RndPxField.TagId).flatMap(f=>RndPxField.decode(f)),
        myFields.get(TradeIDField.TagId).flatMap(f=>TradeIDField.decode(f)),
        myFields.get(SecondaryTradeIDField.TagId).flatMap(f=>SecondaryTradeIDField.decode(f)),
        myFields.get(FirmTradeIDField.TagId).flatMap(f=>FirmTradeIDField.decode(f)),
        myFields.get(SecondaryFirmTradeIDField.TagId).flatMap(f=>SecondaryFirmTradeIDField.decode(f)),
        myFields.get(CalculatedCcyLastQtyField.TagId).flatMap(f=>CalculatedCcyLastQtyField.decode(f)),
        myFields.get(LastSwapPointsField.TagId).flatMap(f=>LastSwapPointsField.decode(f)),
        myFields.get(UnderlyingSettlementDateField.TagId).flatMap(f=>UnderlyingSettlementDateField.decode(f)),
        myFields.get(GrossTradeAmtField.TagId).flatMap(f=>GrossTradeAmtField.decode(f)),
        RootPartiesComponent.decode(flds, startPos),
        myFields.get(OrderCategoryField.TagId).flatMap(f=>OrderCategoryField.decode(f)),
        myFields.get(TradeHandlingInstrField.TagId).flatMap(f=>TradeHandlingInstrField.decode(f)),
        myFields.get(OrigTradeHandlingInstrField.TagId).flatMap(f=>OrigTradeHandlingInstrField.decode(f)),
        myFields.get(OrigTradeDateField.TagId).flatMap(f=>OrigTradeDateField.decode(f)),
        myFields.get(OrigTradeIDField.TagId).flatMap(f=>OrigTradeIDField.decode(f)),
        myFields.get(OrigSecondaryTradeIDField.TagId).flatMap(f=>OrigSecondaryTradeIDField.decode(f)),
        myFields.get(TZTransactTimeField.TagId).flatMap(f=>TZTransactTimeField.decode(f)),
        myFields.get(ReportedPxDiffField.TagId).flatMap(f=>ReportedPxDiffField.decode(f))))
    } else None
  }

    
}
     