package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class CollateralRequestMessage(collReqIDField:CollReqIDField,
                                    collAsgnReasonField:CollAsgnReasonField,
                                    transactTimeField:TransactTimeField,
                                    expireTimeField:Option[ExpireTimeField]=None,
                                    partiesComponent:Option[PartiesComponent]=None,
                                    accountField:Option[AccountField]=None,
                                    accountTypeField:Option[AccountTypeField]=None,
                                    clOrdIDField:Option[ClOrdIDField]=None,
                                    orderIDField:Option[OrderIDField]=None,
                                    secondaryOrderIDField:Option[SecondaryOrderIDField]=None,
                                    secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                                    noExecsField:Option[NoExecsField]=None,
                                    execsGroups: Option[List[ExecsGroup]]=None,
                                    noTradesField:Option[NoTradesField]=None,
                                    tradesGroups: Option[List[TradesGroup]]=None,
                                    instrumentComponent:Option[InstrumentComponent]=None,
                                    financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                    settlDateField:Option[SettlDateField]=None,
                                    quantityField:Option[QuantityField]=None,
                                    qtyTypeField:Option[QtyTypeField]=None,
                                    currencyField:Option[CurrencyField]=None,
                                    noLegsField:Option[NoLegsField]=None,
                                    instrumentLegComponent:Option[InstrumentLegComponent]=None,
                                    noUnderlyingsField:Option[NoUnderlyingsField]=None,
                                    underlyingsGroups: Option[List[UnderlyingsGroup]]=None,
                                    marginExcessField:Option[MarginExcessField]=None,
                                    totalNetValueField:Option[TotalNetValueField]=None,
                                    cashOutstandingField:Option[CashOutstandingField]=None,
                                    trdRegTimestampsComponent:Option[TrdRegTimestampsComponent]=None,
                                    sideField:Option[SideField]=None,
                                    noMiscFeesField:Option[NoMiscFeesField]=None,
                                    miscFeesGroups: Option[List[MiscFeesGroup]]=None,
                                    priceField:Option[PriceField]=None,
                                    priceTypeField:Option[PriceTypeField]=None,
                                    accruedInterestAmtField:Option[AccruedInterestAmtField]=None,
                                    endAccruedInterestAmtField:Option[EndAccruedInterestAmtField]=None,
                                    startCashField:Option[StartCashField]=None,
                                    endCashField:Option[EndCashField]=None,
                                    spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                                    stipulationsComponent:Option[StipulationsComponent]=None,
                                    tradingSessionIDField:Option[TradingSessionIDField]=None,
                                    tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                    settlSessIDField:Option[SettlSessIDField]=None,
                                    settlSessSubIDField:Option[SettlSessSubIDField]=None,
                                    clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                    textField:Option[TextField]=None,
                                    encodedTextLenField:Option[EncodedTextLenField]=None,
                                    encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("AX")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noExecsField.map(_.value).getOrElse(0) != execsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoExecsField.TagId,noExecsField.map(_.value).getOrElse(0), execsGroups.map(_.size).getOrElse(0))
  if (noTradesField.map(_.value).getOrElse(0) != tradesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoTradesField.TagId,noTradesField.map(_.value).getOrElse(0), tradesGroups.map(_.size).getOrElse(0))
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))
  if (noMiscFeesField.map(_.value).getOrElse(0) != miscFeesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoMiscFeesField.TagId,noMiscFeesField.map(_.value).getOrElse(0), miscFeesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,collReqIDField)
    fmt(b,collAsgnReasonField)
    fmt(b,transactTimeField)
    expireTimeField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    orderIDField.foreach(fmt(b,_))
    secondaryOrderIDField.foreach(fmt(b,_))
    secondaryClOrdIDField.foreach(fmt(b,_))
    noExecsField.foreach(fmt(b,_))
    execsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noTradesField.foreach(fmt(b,_))
    tradesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    financingDetailsComponent.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    quantityField.foreach(fmt(b,_))
    qtyTypeField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    instrumentLegComponent.foreach(fmt(b,_))
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    marginExcessField.foreach(fmt(b,_))
    totalNetValueField.foreach(fmt(b,_))
    cashOutstandingField.foreach(fmt(b,_))
    trdRegTimestampsComponent.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    noMiscFeesField.foreach(fmt(b,_))
    miscFeesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    accruedInterestAmtField.foreach(fmt(b,_))
    endAccruedInterestAmtField.foreach(fmt(b,_))
    startCashField.foreach(fmt(b,_))
    endCashField.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    stipulationsComponent.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    settlSessIDField.foreach(fmt(b,_))
    settlSessSubIDField.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object CollateralRequestMessage extends SfFixMessageDecoder {
  val MsgType="AX"
  val MsgName="CollateralRequest"
             
  override val MandatoryFields = HashSet[Int](
    CollReqIDField.TagId, CollAsgnReasonField.TagId, TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || ExecsGroup.isMandatoryField(tagId) || TradesGroup.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || 
    FinancingDetailsComponent.isMandatoryField(tagId) || InstrumentLegComponent.isMandatoryField(tagId) || UnderlyingsGroup.isMandatoryField(tagId) || TrdRegTimestampsComponent.isMandatoryField(tagId) || 
    MiscFeesGroup.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || StipulationsComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ExpireTimeField.TagId, AccountField.TagId, AccountTypeField.TagId, ClOrdIDField.TagId, OrderIDField.TagId, 
    SecondaryOrderIDField.TagId, SecondaryClOrdIDField.TagId, NoExecsField.TagId, NoTradesField.TagId, SettlDateField.TagId, 
    QuantityField.TagId, QtyTypeField.TagId, CurrencyField.TagId, NoLegsField.TagId, NoUnderlyingsField.TagId, 
    MarginExcessField.TagId, TotalNetValueField.TagId, CashOutstandingField.TagId, SideField.TagId, NoMiscFeesField.TagId, 
    PriceField.TagId, PriceTypeField.TagId, AccruedInterestAmtField.TagId, EndAccruedInterestAmtField.TagId, StartCashField.TagId, 
    EndCashField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, SettlSessIDField.TagId, SettlSessSubIDField.TagId, 
    ClearingBusinessDateField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || ExecsGroup.isOptionalField(tagId) || TradesGroup.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || 
    FinancingDetailsComponent.isOptionalField(tagId) || InstrumentLegComponent.isOptionalField(tagId) || UnderlyingsGroup.isOptionalField(tagId) || TrdRegTimestampsComponent.isOptionalField(tagId) || 
    MiscFeesGroup.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || StipulationsComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || ExecsGroup.isFieldOf(tagId) || TradesGroup.isFieldOf(tagId) || 
    InstrumentComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || InstrumentLegComponent.isFieldOf(tagId) || 
    UnderlyingsGroup.isFieldOf(tagId) || TrdRegTimestampsComponent.isFieldOf(tagId) || MiscFeesGroup.isFieldOf(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || StipulationsComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoExecsField.TagId, NoTradesField.TagId, NoUnderlyingsField.TagId, NoMiscFeesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==CollReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(CollateralRequestMessage(CollReqIDField.decode(myFields.get(CollReqIDField.TagId)).get,
        CollAsgnReasonField.decode(myFields.get(CollAsgnReasonField.TagId)).get,
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        myFields.get(SecondaryOrderIDField.TagId).flatMap(f=>SecondaryOrderIDField.decode(f)),
        myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
        myFields.get(NoExecsField.TagId).flatMap(f=>NoExecsField.decode(f)),
        if (nextTagPosLookup.contains(NoExecsField.TagId)) ExecsGroup.decode(flds, nextTagPosLookup(NoExecsField.TagId)) else None,
        myFields.get(NoTradesField.TagId).flatMap(f=>NoTradesField.decode(f)),
        if (nextTagPosLookup.contains(NoTradesField.TagId)) TradesGroup.decode(flds, nextTagPosLookup(NoTradesField.TagId)) else None,
        InstrumentComponent.decode(flds, startPos),
        FinancingDetailsComponent.decode(flds, startPos),
        myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
        myFields.get(QuantityField.TagId).flatMap(f=>QuantityField.decode(f)),
        myFields.get(QtyTypeField.TagId).flatMap(f=>QtyTypeField.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        InstrumentLegComponent.decode(flds, startPos),
        myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None,
        myFields.get(MarginExcessField.TagId).flatMap(f=>MarginExcessField.decode(f)),
        myFields.get(TotalNetValueField.TagId).flatMap(f=>TotalNetValueField.decode(f)),
        myFields.get(CashOutstandingField.TagId).flatMap(f=>CashOutstandingField.decode(f)),
        TrdRegTimestampsComponent.decode(flds, startPos),
        myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
        myFields.get(NoMiscFeesField.TagId).flatMap(f=>NoMiscFeesField.decode(f)),
        if (nextTagPosLookup.contains(NoMiscFeesField.TagId)) MiscFeesGroup.decode(flds, nextTagPosLookup(NoMiscFeesField.TagId)) else None,
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(AccruedInterestAmtField.TagId).flatMap(f=>AccruedInterestAmtField.decode(f)),
        myFields.get(EndAccruedInterestAmtField.TagId).flatMap(f=>EndAccruedInterestAmtField.decode(f)),
        myFields.get(StartCashField.TagId).flatMap(f=>StartCashField.decode(f)),
        myFields.get(EndCashField.TagId).flatMap(f=>EndCashField.decode(f)),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        StipulationsComponent.decode(flds, startPos),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(SettlSessIDField.TagId).flatMap(f=>SettlSessIDField.decode(f)),
        myFields.get(SettlSessSubIDField.TagId).flatMap(f=>SettlSessSubIDField.decode(f)),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     