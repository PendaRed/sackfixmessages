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
case class TradeCaptureReportRequestMessage(tradeRequestIDField:TradeRequestIDField,
                                            tradeRequestTypeField:TradeRequestTypeField,
                                            subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None,
                                            tradeReportIDField:Option[TradeReportIDField]=None,
                                            secondaryTradeReportIDField:Option[SecondaryTradeReportIDField]=None,
                                            execIDField:Option[ExecIDField]=None,
                                            execTypeField:Option[ExecTypeField]=None,
                                            orderIDField:Option[OrderIDField]=None,
                                            clOrdIDField:Option[ClOrdIDField]=None,
                                            matchStatusField:Option[MatchStatusField]=None,
                                            trdTypeField:Option[TrdTypeField]=None,
                                            trdSubTypeField:Option[TrdSubTypeField]=None,
                                            transferReasonField:Option[TransferReasonField]=None,
                                            secondaryTrdTypeField:Option[SecondaryTrdTypeField]=None,
                                            tradeLinkIDField:Option[TradeLinkIDField]=None,
                                            trdMatchIDField:Option[TrdMatchIDField]=None,
                                            partiesComponent:Option[PartiesComponent]=None,
                                            instrumentComponent:Option[InstrumentComponent]=None,
                                            instrumentExtensionComponent:Option[InstrumentExtensionComponent]=None,
                                            financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                            noUnderlyingsField:Option[NoUnderlyingsField]=None,
                                            underlyingsGroups: Option[List[UnderlyingsGroup]]=None,
                                            noLegsField:Option[NoLegsField]=None,
                                            legsGroups: Option[List[LegsGroup]]=None,
                                            noDatesField:Option[NoDatesField]=None,
                                            datesGroups: Option[List[DatesGroup]]=None,
                                            clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                            tradingSessionIDField:Option[TradingSessionIDField]=None,
                                            tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                            timeBracketField:Option[TimeBracketField]=None,
                                            sideField:Option[SideField]=None,
                                            multiLegReportingTypeField:Option[MultiLegReportingTypeField]=None,
                                            tradeInputSourceField:Option[TradeInputSourceField]=None,
                                            tradeInputDeviceField:Option[TradeInputDeviceField]=None,
                                            responseTransportTypeField:Option[ResponseTransportTypeField]=None,
                                            responseDestinationField:Option[ResponseDestinationField]=None,
                                            textField:Option[TextField]=None,
                                            encodedTextLenField:Option[EncodedTextLenField]=None,
                                            encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("AD")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))
  if (noDatesField.map(_.value).getOrElse(0) != datesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoDatesField.TagId,noDatesField.map(_.value).getOrElse(0), datesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,tradeRequestIDField)
    fmt(b,tradeRequestTypeField)
    subscriptionRequestTypeField.foreach(fmt(b,_))
    tradeReportIDField.foreach(fmt(b,_))
    secondaryTradeReportIDField.foreach(fmt(b,_))
    execIDField.foreach(fmt(b,_))
    execTypeField.foreach(fmt(b,_))
    orderIDField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    matchStatusField.foreach(fmt(b,_))
    trdTypeField.foreach(fmt(b,_))
    trdSubTypeField.foreach(fmt(b,_))
    transferReasonField.foreach(fmt(b,_))
    secondaryTrdTypeField.foreach(fmt(b,_))
    tradeLinkIDField.foreach(fmt(b,_))
    trdMatchIDField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    instrumentExtensionComponent.foreach(fmt(b,_))
    financingDetailsComponent.foreach(fmt(b,_))
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noDatesField.foreach(fmt(b,_))
    datesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    timeBracketField.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    multiLegReportingTypeField.foreach(fmt(b,_))
    tradeInputSourceField.foreach(fmt(b,_))
    tradeInputDeviceField.foreach(fmt(b,_))
    responseTransportTypeField.foreach(fmt(b,_))
    responseDestinationField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object TradeCaptureReportRequestMessage extends SfFixMessageDecoder {
  val MsgType="AD"
  val MsgName="TradeCaptureReportRequest"
             
  override val MandatoryFields = HashSet[Int](
    TradeRequestIDField.TagId, TradeRequestTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || InstrumentExtensionComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || 
    UnderlyingsGroup.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId) || DatesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SubscriptionRequestTypeField.TagId, TradeReportIDField.TagId, SecondaryTradeReportIDField.TagId, ExecIDField.TagId, ExecTypeField.TagId, 
    OrderIDField.TagId, ClOrdIDField.TagId, MatchStatusField.TagId, TrdTypeField.TagId, TrdSubTypeField.TagId, 
    TransferReasonField.TagId, SecondaryTrdTypeField.TagId, TradeLinkIDField.TagId, TrdMatchIDField.TagId, NoUnderlyingsField.TagId, 
    NoLegsField.TagId, NoDatesField.TagId, ClearingBusinessDateField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, 
    TimeBracketField.TagId, SideField.TagId, MultiLegReportingTypeField.TagId, TradeInputSourceField.TagId, TradeInputDeviceField.TagId, 
    ResponseTransportTypeField.TagId, ResponseDestinationField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || InstrumentExtensionComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || 
    UnderlyingsGroup.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId) || DatesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || InstrumentExtensionComponent.isFieldOf(tagId) || 
    FinancingDetailsComponent.isFieldOf(tagId) || UnderlyingsGroup.isFieldOf(tagId) || LegsGroup.isFieldOf(tagId) || 
    DatesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoUnderlyingsField.TagId, NoLegsField.TagId, NoDatesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==TradeRequestIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(TradeCaptureReportRequestMessage(TradeRequestIDField.decode(myFields.get(TradeRequestIDField.TagId)).get,
        TradeRequestTypeField.decode(myFields.get(TradeRequestTypeField.TagId)).get,
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f)),
        myFields.get(TradeReportIDField.TagId).flatMap(f=>TradeReportIDField.decode(f)),
        myFields.get(SecondaryTradeReportIDField.TagId).flatMap(f=>SecondaryTradeReportIDField.decode(f)),
        myFields.get(ExecIDField.TagId).flatMap(f=>ExecIDField.decode(f)),
        myFields.get(ExecTypeField.TagId).flatMap(f=>ExecTypeField.decode(f)),
        myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        myFields.get(MatchStatusField.TagId).flatMap(f=>MatchStatusField.decode(f)),
        myFields.get(TrdTypeField.TagId).flatMap(f=>TrdTypeField.decode(f)),
        myFields.get(TrdSubTypeField.TagId).flatMap(f=>TrdSubTypeField.decode(f)),
        myFields.get(TransferReasonField.TagId).flatMap(f=>TransferReasonField.decode(f)),
        myFields.get(SecondaryTrdTypeField.TagId).flatMap(f=>SecondaryTrdTypeField.decode(f)),
        myFields.get(TradeLinkIDField.TagId).flatMap(f=>TradeLinkIDField.decode(f)),
        myFields.get(TrdMatchIDField.TagId).flatMap(f=>TrdMatchIDField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        InstrumentComponent.decode(flds, startPos),
        InstrumentExtensionComponent.decode(flds, startPos),
        FinancingDetailsComponent.decode(flds, startPos),
        myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None,
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
        myFields.get(NoDatesField.TagId).flatMap(f=>NoDatesField.decode(f)),
        if (nextTagPosLookup.contains(NoDatesField.TagId)) DatesGroup.decode(flds, nextTagPosLookup(NoDatesField.TagId)) else None,
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(TimeBracketField.TagId).flatMap(f=>TimeBracketField.decode(f)),
        myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
        myFields.get(MultiLegReportingTypeField.TagId).flatMap(f=>MultiLegReportingTypeField.decode(f)),
        myFields.get(TradeInputSourceField.TagId).flatMap(f=>TradeInputSourceField.decode(f)),
        myFields.get(TradeInputDeviceField.TagId).flatMap(f=>TradeInputDeviceField.decode(f)),
        myFields.get(ResponseTransportTypeField.TagId).flatMap(f=>ResponseTransportTypeField.decode(f)),
        myFields.get(ResponseDestinationField.TagId).flatMap(f=>ResponseDestinationField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     