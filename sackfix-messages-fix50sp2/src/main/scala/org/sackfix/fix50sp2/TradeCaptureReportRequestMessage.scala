package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class TradeCaptureReportRequestMessage(tradeRequestIDField:TradeRequestIDField,
                                            tradeIDField:Option[TradeIDField]=None,
                                            secondaryTradeIDField:Option[SecondaryTradeIDField]=None,
                                            firmTradeIDField:Option[FirmTradeIDField]=None,
                                            secondaryFirmTradeIDField:Option[SecondaryFirmTradeIDField]=None,
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
                                            tradeHandlingInstrField:Option[TradeHandlingInstrField]=None,
                                            transferReasonField:Option[TransferReasonField]=None,
                                            secondaryTrdTypeField:Option[SecondaryTrdTypeField]=None,
                                            tradeLinkIDField:Option[TradeLinkIDField]=None,
                                            trdMatchIDField:Option[TrdMatchIDField]=None,
                                            partiesComponent:Option[PartiesComponent]=None,
                                            instrumentComponent:Option[InstrumentComponent]=None,
                                            instrumentExtensionComponent:Option[InstrumentExtensionComponent]=None,
                                            financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                            undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                            instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                            trdCapDtGrpComponent:Option[TrdCapDtGrpComponent]=None,
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
                                            encodedTextField:Option[EncodedTextField]=None,
                                            messageEventSourceField:Option[MessageEventSourceField]=None) extends SfFixMessageBody("AD")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,tradeRequestIDField)
    tradeIDField.foreach(fmt(b,_))
    secondaryTradeIDField.foreach(fmt(b,_))
    firmTradeIDField.foreach(fmt(b,_))
    secondaryFirmTradeIDField.foreach(fmt(b,_))
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
    tradeHandlingInstrField.foreach(fmt(b,_))
    transferReasonField.foreach(fmt(b,_))
    secondaryTrdTypeField.foreach(fmt(b,_))
    tradeLinkIDField.foreach(fmt(b,_))
    trdMatchIDField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    instrumentExtensionComponent.foreach(fmt(b,_))
    financingDetailsComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    trdCapDtGrpComponent.foreach(fmt(b,_))
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
    messageEventSourceField.foreach(fmt(b,_))
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
    UndInstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || TrdCapDtGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TradeIDField.TagId, SecondaryTradeIDField.TagId, FirmTradeIDField.TagId, SecondaryFirmTradeIDField.TagId, SubscriptionRequestTypeField.TagId, 
    TradeReportIDField.TagId, SecondaryTradeReportIDField.TagId, ExecIDField.TagId, ExecTypeField.TagId, OrderIDField.TagId, 
    ClOrdIDField.TagId, MatchStatusField.TagId, TrdTypeField.TagId, TrdSubTypeField.TagId, TradeHandlingInstrField.TagId, 
    TransferReasonField.TagId, SecondaryTrdTypeField.TagId, TradeLinkIDField.TagId, TrdMatchIDField.TagId, ClearingBusinessDateField.TagId, 
    TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, TimeBracketField.TagId, SideField.TagId, MultiLegReportingTypeField.TagId, 
    TradeInputSourceField.TagId, TradeInputDeviceField.TagId, ResponseTransportTypeField.TagId, ResponseDestinationField.TagId, TextField.TagId, 
    EncodedTextLenField.TagId, EncodedTextField.TagId, MessageEventSourceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || InstrumentExtensionComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || 
    UndInstrmtGrpComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || TrdCapDtGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || InstrumentExtensionComponent.isFieldOf(tagId) || 
    FinancingDetailsComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId) || 
    TrdCapDtGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==TradeRequestIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(TradeCaptureReportRequestMessage(TradeRequestIDField.decode(myFields.get(TradeRequestIDField.TagId)).get,
        myFields.get(TradeIDField.TagId).flatMap(f=>TradeIDField.decode(f)),
        myFields.get(SecondaryTradeIDField.TagId).flatMap(f=>SecondaryTradeIDField.decode(f)),
        myFields.get(FirmTradeIDField.TagId).flatMap(f=>FirmTradeIDField.decode(f)),
        myFields.get(SecondaryFirmTradeIDField.TagId).flatMap(f=>SecondaryFirmTradeIDField.decode(f)),
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
        myFields.get(TradeHandlingInstrField.TagId).flatMap(f=>TradeHandlingInstrField.decode(f)),
        myFields.get(TransferReasonField.TagId).flatMap(f=>TransferReasonField.decode(f)),
        myFields.get(SecondaryTrdTypeField.TagId).flatMap(f=>SecondaryTrdTypeField.decode(f)),
        myFields.get(TradeLinkIDField.TagId).flatMap(f=>TradeLinkIDField.decode(f)),
        myFields.get(TrdMatchIDField.TagId).flatMap(f=>TrdMatchIDField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        InstrumentComponent.decode(flds, startPos),
        InstrumentExtensionComponent.decode(flds, startPos),
        FinancingDetailsComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        TrdCapDtGrpComponent.decode(flds, startPos),
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
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(MessageEventSourceField.TagId).flatMap(f=>MessageEventSourceField.decode(f))))
    } else None
  }

    
}
     