package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class OrderCancelReplaceRequestMessage(orderIDField:Option[OrderIDField]=None,
                                            partiesComponent:Option[PartiesComponent]=None,
                                            tradeOriginationDateField:Option[TradeOriginationDateField]=None,
                                            tradeDateField:Option[TradeDateField]=None,
                                            origClOrdIDField:Option[OrigClOrdIDField]=None,
                                            clOrdIDField:ClOrdIDField,
                                            secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                                            clOrdLinkIDField:Option[ClOrdLinkIDField]=None,
                                            listIDField:Option[ListIDField]=None,
                                            origOrdModTimeField:Option[OrigOrdModTimeField]=None,
                                            accountField:Option[AccountField]=None,
                                            acctIDSourceField:Option[AcctIDSourceField]=None,
                                            accountTypeField:Option[AccountTypeField]=None,
                                            dayBookingInstField:Option[DayBookingInstField]=None,
                                            bookingUnitField:Option[BookingUnitField]=None,
                                            preallocMethodField:Option[PreallocMethodField]=None,
                                            allocIDField:Option[AllocIDField]=None,
                                            preAllocGrpComponent:Option[PreAllocGrpComponent]=None,
                                            settlTypeField:Option[SettlTypeField]=None,
                                            settlDateField:Option[SettlDateField]=None,
                                            cashMarginField:Option[CashMarginField]=None,
                                            clearingFeeIndicatorField:Option[ClearingFeeIndicatorField]=None,
                                            handlInstField:Option[HandlInstField]=None,
                                            execInstField:Option[ExecInstField]=None,
                                            minQtyField:Option[MinQtyField]=None,
                                            matchIncrementField:Option[MatchIncrementField]=None,
                                            maxPriceLevelsField:Option[MaxPriceLevelsField]=None,
                                            displayInstructionComponent:Option[DisplayInstructionComponent]=None,
                                            maxFloorField:Option[MaxFloorField]=None,
                                            exDestinationField:Option[ExDestinationField]=None,
                                            exDestinationIDSourceField:Option[ExDestinationIDSourceField]=None,
                                            trdgSesGrpComponent:Option[TrdgSesGrpComponent]=None,
                                            instrumentComponent:InstrumentComponent,
                                            financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                            undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                            sideField:SideField,
                                            transactTimeField:TransactTimeField,
                                            qtyTypeField:Option[QtyTypeField]=None,
                                            orderQtyDataComponent:OrderQtyDataComponent,
                                            ordTypeField:OrdTypeField,
                                            priceTypeField:Option[PriceTypeField]=None,
                                            priceField:Option[PriceField]=None,
                                            priceProtectionScopeField:Option[PriceProtectionScopeField]=None,
                                            stopPxField:Option[StopPxField]=None,
                                            triggeringInstructionComponent:Option[TriggeringInstructionComponent]=None,
                                            spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                                            yieldDataComponent:Option[YieldDataComponent]=None,
                                            pegInstructionsComponent:Option[PegInstructionsComponent]=None,
                                            discretionInstructionsComponent:Option[DiscretionInstructionsComponent]=None,
                                            targetStrategyField:Option[TargetStrategyField]=None,
                                            strategyParametersGrpComponent:Option[StrategyParametersGrpComponent]=None,
                                            targetStrategyParametersField:Option[TargetStrategyParametersField]=None,
                                            participationRateField:Option[ParticipationRateField]=None,
                                            complianceIDField:Option[ComplianceIDField]=None,
                                            solicitedFlagField:Option[SolicitedFlagField]=None,
                                            currencyField:Option[CurrencyField]=None,
                                            timeInForceField:Option[TimeInForceField]=None,
                                            effectiveTimeField:Option[EffectiveTimeField]=None,
                                            expireDateField:Option[ExpireDateField]=None,
                                            expireTimeField:Option[ExpireTimeField]=None,
                                            gTBookingInstField:Option[GTBookingInstField]=None,
                                            commissionDataComponent:Option[CommissionDataComponent]=None,
                                            orderCapacityField:Option[OrderCapacityField]=None,
                                            orderRestrictionsField:Option[OrderRestrictionsField]=None,
                                            preTradeAnonymityField:Option[PreTradeAnonymityField]=None,
                                            custOrderCapacityField:Option[CustOrderCapacityField]=None,
                                            forexReqField:Option[ForexReqField]=None,
                                            settlCurrencyField:Option[SettlCurrencyField]=None,
                                            bookingTypeField:Option[BookingTypeField]=None,
                                            textField:Option[TextField]=None,
                                            encodedTextLenField:Option[EncodedTextLenField]=None,
                                            encodedTextField:Option[EncodedTextField]=None,
                                            settlDate2Field:Option[SettlDate2Field]=None,
                                            orderQty2Field:Option[OrderQty2Field]=None,
                                            price2Field:Option[Price2Field]=None,
                                            positionEffectField:Option[PositionEffectField]=None,
                                            coveredOrUncoveredField:Option[CoveredOrUncoveredField]=None,
                                            maxShowField:Option[MaxShowField]=None,
                                            locateReqdField:Option[LocateReqdField]=None,
                                            cancellationRightsField:Option[CancellationRightsField]=None,
                                            moneyLaunderingStatusField:Option[MoneyLaunderingStatusField]=None,
                                            registIDField:Option[RegistIDField]=None,
                                            designationField:Option[DesignationField]=None,
                                            manualOrderIndicatorField:Option[ManualOrderIndicatorField]=None,
                                            custDirectedOrderField:Option[CustDirectedOrderField]=None,
                                            receivedDeptIDField:Option[ReceivedDeptIDField]=None,
                                            custOrderHandlingInstField:Option[CustOrderHandlingInstField]=None,
                                            orderHandlingInstSourceField:Option[OrderHandlingInstSourceField]=None,
                                            trdRegTimestampsComponent:Option[TrdRegTimestampsComponent]=None) extends SfFixMessageBody("G")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    orderIDField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    tradeOriginationDateField.foreach(fmt(b,_))
    tradeDateField.foreach(fmt(b,_))
    origClOrdIDField.foreach(fmt(b,_))
    fmt(b,clOrdIDField)
    secondaryClOrdIDField.foreach(fmt(b,_))
    clOrdLinkIDField.foreach(fmt(b,_))
    listIDField.foreach(fmt(b,_))
    origOrdModTimeField.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    dayBookingInstField.foreach(fmt(b,_))
    bookingUnitField.foreach(fmt(b,_))
    preallocMethodField.foreach(fmt(b,_))
    allocIDField.foreach(fmt(b,_))
    preAllocGrpComponent.foreach(fmt(b,_))
    settlTypeField.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    cashMarginField.foreach(fmt(b,_))
    clearingFeeIndicatorField.foreach(fmt(b,_))
    handlInstField.foreach(fmt(b,_))
    execInstField.foreach(fmt(b,_))
    minQtyField.foreach(fmt(b,_))
    matchIncrementField.foreach(fmt(b,_))
    maxPriceLevelsField.foreach(fmt(b,_))
    displayInstructionComponent.foreach(fmt(b,_))
    maxFloorField.foreach(fmt(b,_))
    exDestinationField.foreach(fmt(b,_))
    exDestinationIDSourceField.foreach(fmt(b,_))
    trdgSesGrpComponent.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    financingDetailsComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    fmt(b,sideField)
    fmt(b,transactTimeField)
    qtyTypeField.foreach(fmt(b,_))
    fmt(b,orderQtyDataComponent)
    fmt(b,ordTypeField)
    priceTypeField.foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    priceProtectionScopeField.foreach(fmt(b,_))
    stopPxField.foreach(fmt(b,_))
    triggeringInstructionComponent.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    yieldDataComponent.foreach(fmt(b,_))
    pegInstructionsComponent.foreach(fmt(b,_))
    discretionInstructionsComponent.foreach(fmt(b,_))
    targetStrategyField.foreach(fmt(b,_))
    strategyParametersGrpComponent.foreach(fmt(b,_))
    targetStrategyParametersField.foreach(fmt(b,_))
    participationRateField.foreach(fmt(b,_))
    complianceIDField.foreach(fmt(b,_))
    solicitedFlagField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    timeInForceField.foreach(fmt(b,_))
    effectiveTimeField.foreach(fmt(b,_))
    expireDateField.foreach(fmt(b,_))
    expireTimeField.foreach(fmt(b,_))
    gTBookingInstField.foreach(fmt(b,_))
    commissionDataComponent.foreach(fmt(b,_))
    orderCapacityField.foreach(fmt(b,_))
    orderRestrictionsField.foreach(fmt(b,_))
    preTradeAnonymityField.foreach(fmt(b,_))
    custOrderCapacityField.foreach(fmt(b,_))
    forexReqField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    bookingTypeField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    settlDate2Field.foreach(fmt(b,_))
    orderQty2Field.foreach(fmt(b,_))
    price2Field.foreach(fmt(b,_))
    positionEffectField.foreach(fmt(b,_))
    coveredOrUncoveredField.foreach(fmt(b,_))
    maxShowField.foreach(fmt(b,_))
    locateReqdField.foreach(fmt(b,_))
    cancellationRightsField.foreach(fmt(b,_))
    moneyLaunderingStatusField.foreach(fmt(b,_))
    registIDField.foreach(fmt(b,_))
    designationField.foreach(fmt(b,_))
    manualOrderIndicatorField.foreach(fmt(b,_))
    custDirectedOrderField.foreach(fmt(b,_))
    receivedDeptIDField.foreach(fmt(b,_))
    custOrderHandlingInstField.foreach(fmt(b,_))
    orderHandlingInstSourceField.foreach(fmt(b,_))
    trdRegTimestampsComponent.foreach(fmt(b,_))
    b
  }

}
     
object OrderCancelReplaceRequestMessage extends SfFixMessageDecoder {
  val MsgType="G"
  val MsgName="OrderCancelReplaceRequest"
             
  override val MandatoryFields = HashSet[Int](
    ClOrdIDField.TagId, SideField.TagId, TransactTimeField.TagId, OrdTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || PreAllocGrpComponent.isMandatoryField(tagId) || DisplayInstructionComponent.isMandatoryField(tagId) || TrdgSesGrpComponent.isMandatoryField(tagId) || 
    InstrumentComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || OrderQtyDataComponent.isMandatoryField(tagId) || 
    TriggeringInstructionComponent.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId) || PegInstructionsComponent.isMandatoryField(tagId) || 
    DiscretionInstructionsComponent.isMandatoryField(tagId) || StrategyParametersGrpComponent.isMandatoryField(tagId) || CommissionDataComponent.isMandatoryField(tagId) || TrdRegTimestampsComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrderIDField.TagId, TradeOriginationDateField.TagId, TradeDateField.TagId, OrigClOrdIDField.TagId, SecondaryClOrdIDField.TagId, 
    ClOrdLinkIDField.TagId, ListIDField.TagId, OrigOrdModTimeField.TagId, AccountField.TagId, AcctIDSourceField.TagId, 
    AccountTypeField.TagId, DayBookingInstField.TagId, BookingUnitField.TagId, PreallocMethodField.TagId, AllocIDField.TagId, 
    SettlTypeField.TagId, SettlDateField.TagId, CashMarginField.TagId, ClearingFeeIndicatorField.TagId, HandlInstField.TagId, 
    ExecInstField.TagId, MinQtyField.TagId, MatchIncrementField.TagId, MaxPriceLevelsField.TagId, MaxFloorField.TagId, 
    ExDestinationField.TagId, ExDestinationIDSourceField.TagId, QtyTypeField.TagId, PriceTypeField.TagId, PriceField.TagId, 
    PriceProtectionScopeField.TagId, StopPxField.TagId, TargetStrategyField.TagId, TargetStrategyParametersField.TagId, ParticipationRateField.TagId, 
    ComplianceIDField.TagId, SolicitedFlagField.TagId, CurrencyField.TagId, TimeInForceField.TagId, EffectiveTimeField.TagId, 
    ExpireDateField.TagId, ExpireTimeField.TagId, GTBookingInstField.TagId, OrderCapacityField.TagId, OrderRestrictionsField.TagId, 
    PreTradeAnonymityField.TagId, CustOrderCapacityField.TagId, ForexReqField.TagId, SettlCurrencyField.TagId, BookingTypeField.TagId, 
    TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, SettlDate2Field.TagId, OrderQty2Field.TagId, 
    Price2Field.TagId, PositionEffectField.TagId, CoveredOrUncoveredField.TagId, MaxShowField.TagId, LocateReqdField.TagId, 
    CancellationRightsField.TagId, MoneyLaunderingStatusField.TagId, RegistIDField.TagId, DesignationField.TagId, ManualOrderIndicatorField.TagId, 
    CustDirectedOrderField.TagId, ReceivedDeptIDField.TagId, CustOrderHandlingInstField.TagId, OrderHandlingInstSourceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || PreAllocGrpComponent.isOptionalField(tagId) || DisplayInstructionComponent.isOptionalField(tagId) || TrdgSesGrpComponent.isOptionalField(tagId) || 
    InstrumentComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || OrderQtyDataComponent.isOptionalField(tagId) || 
    TriggeringInstructionComponent.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId) || PegInstructionsComponent.isOptionalField(tagId) || 
    DiscretionInstructionsComponent.isOptionalField(tagId) || StrategyParametersGrpComponent.isOptionalField(tagId) || CommissionDataComponent.isOptionalField(tagId) || TrdRegTimestampsComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || PreAllocGrpComponent.isFieldOf(tagId) || DisplayInstructionComponent.isFieldOf(tagId) || 
    TrdgSesGrpComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || 
    UndInstrmtGrpComponent.isFieldOf(tagId) || OrderQtyDataComponent.isFieldOf(tagId) || TriggeringInstructionComponent.isFieldOf(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || YieldDataComponent.isFieldOf(tagId) || PegInstructionsComponent.isFieldOf(tagId) || 
    DiscretionInstructionsComponent.isFieldOf(tagId) || StrategyParametersGrpComponent.isFieldOf(tagId) || CommissionDataComponent.isFieldOf(tagId) || 
    TrdRegTimestampsComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(OrderCancelReplaceRequestMessage(myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(TradeOriginationDateField.TagId).flatMap(f=>TradeOriginationDateField.decode(f)),
        myFields.get(TradeDateField.TagId).flatMap(f=>TradeDateField.decode(f)),
        myFields.get(OrigClOrdIDField.TagId).flatMap(f=>OrigClOrdIDField.decode(f)),
        ClOrdIDField.decode(myFields.get(ClOrdIDField.TagId)).get,
        myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
        myFields.get(ClOrdLinkIDField.TagId).flatMap(f=>ClOrdLinkIDField.decode(f)),
        myFields.get(ListIDField.TagId).flatMap(f=>ListIDField.decode(f)),
        myFields.get(OrigOrdModTimeField.TagId).flatMap(f=>OrigOrdModTimeField.decode(f)),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        myFields.get(DayBookingInstField.TagId).flatMap(f=>DayBookingInstField.decode(f)),
        myFields.get(BookingUnitField.TagId).flatMap(f=>BookingUnitField.decode(f)),
        myFields.get(PreallocMethodField.TagId).flatMap(f=>PreallocMethodField.decode(f)),
        myFields.get(AllocIDField.TagId).flatMap(f=>AllocIDField.decode(f)),
        PreAllocGrpComponent.decode(flds, startPos),
        myFields.get(SettlTypeField.TagId).flatMap(f=>SettlTypeField.decode(f)),
        myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
        myFields.get(CashMarginField.TagId).flatMap(f=>CashMarginField.decode(f)),
        myFields.get(ClearingFeeIndicatorField.TagId).flatMap(f=>ClearingFeeIndicatorField.decode(f)),
        myFields.get(HandlInstField.TagId).flatMap(f=>HandlInstField.decode(f)),
        myFields.get(ExecInstField.TagId).flatMap(f=>ExecInstField.decode(f)),
        myFields.get(MinQtyField.TagId).flatMap(f=>MinQtyField.decode(f)),
        myFields.get(MatchIncrementField.TagId).flatMap(f=>MatchIncrementField.decode(f)),
        myFields.get(MaxPriceLevelsField.TagId).flatMap(f=>MaxPriceLevelsField.decode(f)),
        DisplayInstructionComponent.decode(flds, startPos),
        myFields.get(MaxFloorField.TagId).flatMap(f=>MaxFloorField.decode(f)),
        myFields.get(ExDestinationField.TagId).flatMap(f=>ExDestinationField.decode(f)),
        myFields.get(ExDestinationIDSourceField.TagId).flatMap(f=>ExDestinationIDSourceField.decode(f)),
        TrdgSesGrpComponent.decode(flds, startPos),
        InstrumentComponent.decode(flds, startPos).get,
        FinancingDetailsComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        SideField.decode(myFields.get(SideField.TagId)).get,
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        myFields.get(QtyTypeField.TagId).flatMap(f=>QtyTypeField.decode(f)),
        OrderQtyDataComponent.decode(flds, startPos).get,
        OrdTypeField.decode(myFields.get(OrdTypeField.TagId)).get,
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(PriceProtectionScopeField.TagId).flatMap(f=>PriceProtectionScopeField.decode(f)),
        myFields.get(StopPxField.TagId).flatMap(f=>StopPxField.decode(f)),
        TriggeringInstructionComponent.decode(flds, startPos),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        YieldDataComponent.decode(flds, startPos),
        PegInstructionsComponent.decode(flds, startPos),
        DiscretionInstructionsComponent.decode(flds, startPos),
        myFields.get(TargetStrategyField.TagId).flatMap(f=>TargetStrategyField.decode(f)),
        StrategyParametersGrpComponent.decode(flds, startPos),
        myFields.get(TargetStrategyParametersField.TagId).flatMap(f=>TargetStrategyParametersField.decode(f)),
        myFields.get(ParticipationRateField.TagId).flatMap(f=>ParticipationRateField.decode(f)),
        myFields.get(ComplianceIDField.TagId).flatMap(f=>ComplianceIDField.decode(f)),
        myFields.get(SolicitedFlagField.TagId).flatMap(f=>SolicitedFlagField.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(TimeInForceField.TagId).flatMap(f=>TimeInForceField.decode(f)),
        myFields.get(EffectiveTimeField.TagId).flatMap(f=>EffectiveTimeField.decode(f)),
        myFields.get(ExpireDateField.TagId).flatMap(f=>ExpireDateField.decode(f)),
        myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
        myFields.get(GTBookingInstField.TagId).flatMap(f=>GTBookingInstField.decode(f)),
        CommissionDataComponent.decode(flds, startPos),
        myFields.get(OrderCapacityField.TagId).flatMap(f=>OrderCapacityField.decode(f)),
        myFields.get(OrderRestrictionsField.TagId).flatMap(f=>OrderRestrictionsField.decode(f)),
        myFields.get(PreTradeAnonymityField.TagId).flatMap(f=>PreTradeAnonymityField.decode(f)),
        myFields.get(CustOrderCapacityField.TagId).flatMap(f=>CustOrderCapacityField.decode(f)),
        myFields.get(ForexReqField.TagId).flatMap(f=>ForexReqField.decode(f)),
        myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f)),
        myFields.get(BookingTypeField.TagId).flatMap(f=>BookingTypeField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(SettlDate2Field.TagId).flatMap(f=>SettlDate2Field.decode(f)),
        myFields.get(OrderQty2Field.TagId).flatMap(f=>OrderQty2Field.decode(f)),
        myFields.get(Price2Field.TagId).flatMap(f=>Price2Field.decode(f)),
        myFields.get(PositionEffectField.TagId).flatMap(f=>PositionEffectField.decode(f)),
        myFields.get(CoveredOrUncoveredField.TagId).flatMap(f=>CoveredOrUncoveredField.decode(f)),
        myFields.get(MaxShowField.TagId).flatMap(f=>MaxShowField.decode(f)),
        myFields.get(LocateReqdField.TagId).flatMap(f=>LocateReqdField.decode(f)),
        myFields.get(CancellationRightsField.TagId).flatMap(f=>CancellationRightsField.decode(f)),
        myFields.get(MoneyLaunderingStatusField.TagId).flatMap(f=>MoneyLaunderingStatusField.decode(f)),
        myFields.get(RegistIDField.TagId).flatMap(f=>RegistIDField.decode(f)),
        myFields.get(DesignationField.TagId).flatMap(f=>DesignationField.decode(f)),
        myFields.get(ManualOrderIndicatorField.TagId).flatMap(f=>ManualOrderIndicatorField.decode(f)),
        myFields.get(CustDirectedOrderField.TagId).flatMap(f=>CustDirectedOrderField.decode(f)),
        myFields.get(ReceivedDeptIDField.TagId).flatMap(f=>ReceivedDeptIDField.decode(f)),
        myFields.get(CustOrderHandlingInstField.TagId).flatMap(f=>CustOrderHandlingInstField.decode(f)),
        myFields.get(OrderHandlingInstSourceField.TagId).flatMap(f=>OrderHandlingInstSourceField.decode(f)),
        TrdRegTimestampsComponent.decode(flds, startPos)))
    } else None
  }

    
}
     