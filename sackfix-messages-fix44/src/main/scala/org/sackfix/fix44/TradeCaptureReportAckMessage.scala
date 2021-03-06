package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class TradeCaptureReportAckMessage(tradeReportIDField:TradeReportIDField,
                                        tradeReportTransTypeField:Option[TradeReportTransTypeField]=None,
                                        tradeReportTypeField:Option[TradeReportTypeField]=None,
                                        trdTypeField:Option[TrdTypeField]=None,
                                        trdSubTypeField:Option[TrdSubTypeField]=None,
                                        secondaryTrdTypeField:Option[SecondaryTrdTypeField]=None,
                                        transferReasonField:Option[TransferReasonField]=None,
                                        execTypeField:ExecTypeField,
                                        tradeReportRefIDField:Option[TradeReportRefIDField]=None,
                                        secondaryTradeReportRefIDField:Option[SecondaryTradeReportRefIDField]=None,
                                        trdRptStatusField:Option[TrdRptStatusField]=None,
                                        tradeReportRejectReasonField:Option[TradeReportRejectReasonField]=None,
                                        secondaryTradeReportIDField:Option[SecondaryTradeReportIDField]=None,
                                        subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None,
                                        tradeLinkIDField:Option[TradeLinkIDField]=None,
                                        trdMatchIDField:Option[TrdMatchIDField]=None,
                                        execIDField:Option[ExecIDField]=None,
                                        secondaryExecIDField:Option[SecondaryExecIDField]=None,
                                        instrumentComponent:InstrumentComponent,
                                        transactTimeField:Option[TransactTimeField]=None,
                                        trdRegTimestampsComponent:Option[TrdRegTimestampsComponent]=None,
                                        responseTransportTypeField:Option[ResponseTransportTypeField]=None,
                                        responseDestinationField:Option[ResponseDestinationField]=None,
                                        textField:Option[TextField]=None,
                                        encodedTextLenField:Option[EncodedTextLenField]=None,
                                        encodedTextField:Option[EncodedTextField]=None,
                                        noLegsField:Option[NoLegsField]=None,
                                        legsGroups: Option[List[LegsGroup]]=None,
                                        clearingFeeIndicatorField:Option[ClearingFeeIndicatorField]=None,
                                        orderCapacityField:Option[OrderCapacityField]=None,
                                        orderRestrictionsField:Option[OrderRestrictionsField]=None,
                                        custOrderCapacityField:Option[CustOrderCapacityField]=None,
                                        accountField:Option[AccountField]=None,
                                        acctIDSourceField:Option[AcctIDSourceField]=None,
                                        accountTypeField:Option[AccountTypeField]=None,
                                        positionEffectField:Option[PositionEffectField]=None,
                                        preallocMethodField:Option[PreallocMethodField]=None,
                                        noAllocsField:Option[NoAllocsField]=None,
                                        allocsGroups: Option[List[AllocsGroup]]=None) extends SfFixMessageBody("AR")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))
  if (noAllocsField.map(_.value).getOrElse(0) != allocsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoAllocsField.TagId,noAllocsField.map(_.value).getOrElse(0), allocsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,tradeReportIDField)
    tradeReportTransTypeField.foreach(fmt(b,_))
    tradeReportTypeField.foreach(fmt(b,_))
    trdTypeField.foreach(fmt(b,_))
    trdSubTypeField.foreach(fmt(b,_))
    secondaryTrdTypeField.foreach(fmt(b,_))
    transferReasonField.foreach(fmt(b,_))
    fmt(b,execTypeField)
    tradeReportRefIDField.foreach(fmt(b,_))
    secondaryTradeReportRefIDField.foreach(fmt(b,_))
    trdRptStatusField.foreach(fmt(b,_))
    tradeReportRejectReasonField.foreach(fmt(b,_))
    secondaryTradeReportIDField.foreach(fmt(b,_))
    subscriptionRequestTypeField.foreach(fmt(b,_))
    tradeLinkIDField.foreach(fmt(b,_))
    trdMatchIDField.foreach(fmt(b,_))
    execIDField.foreach(fmt(b,_))
    secondaryExecIDField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    transactTimeField.foreach(fmt(b,_))
    trdRegTimestampsComponent.foreach(fmt(b,_))
    responseTransportTypeField.foreach(fmt(b,_))
    responseDestinationField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    clearingFeeIndicatorField.foreach(fmt(b,_))
    orderCapacityField.foreach(fmt(b,_))
    orderRestrictionsField.foreach(fmt(b,_))
    custOrderCapacityField.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    positionEffectField.foreach(fmt(b,_))
    preallocMethodField.foreach(fmt(b,_))
    noAllocsField.foreach(fmt(b,_))
    allocsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object TradeCaptureReportAckMessage extends SfFixMessageDecoder {
  val MsgType="AR"
  val MsgName="TradeCaptureReportAck"
             
  override val MandatoryFields = HashSet[Int](
    TradeReportIDField.TagId, ExecTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || TrdRegTimestampsComponent.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId) || AllocsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TradeReportTransTypeField.TagId, TradeReportTypeField.TagId, TrdTypeField.TagId, TrdSubTypeField.TagId, SecondaryTrdTypeField.TagId, 
    TransferReasonField.TagId, TradeReportRefIDField.TagId, SecondaryTradeReportRefIDField.TagId, TrdRptStatusField.TagId, TradeReportRejectReasonField.TagId, 
    SecondaryTradeReportIDField.TagId, SubscriptionRequestTypeField.TagId, TradeLinkIDField.TagId, TrdMatchIDField.TagId, ExecIDField.TagId, 
    SecondaryExecIDField.TagId, TransactTimeField.TagId, ResponseTransportTypeField.TagId, ResponseDestinationField.TagId, TextField.TagId, 
    EncodedTextLenField.TagId, EncodedTextField.TagId, NoLegsField.TagId, ClearingFeeIndicatorField.TagId, OrderCapacityField.TagId, 
    OrderRestrictionsField.TagId, CustOrderCapacityField.TagId, AccountField.TagId, AcctIDSourceField.TagId, AccountTypeField.TagId, 
    PositionEffectField.TagId, PreallocMethodField.TagId, NoAllocsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || TrdRegTimestampsComponent.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId) || AllocsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || TrdRegTimestampsComponent.isFieldOf(tagId) || LegsGroup.isFieldOf(tagId) || 
    AllocsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoLegsField.TagId, NoAllocsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==TradeReportIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(TradeCaptureReportAckMessage(TradeReportIDField.decode(myFields.get(TradeReportIDField.TagId)).get,
        myFields.get(TradeReportTransTypeField.TagId).flatMap(f=>TradeReportTransTypeField.decode(f)),
        myFields.get(TradeReportTypeField.TagId).flatMap(f=>TradeReportTypeField.decode(f)),
        myFields.get(TrdTypeField.TagId).flatMap(f=>TrdTypeField.decode(f)),
        myFields.get(TrdSubTypeField.TagId).flatMap(f=>TrdSubTypeField.decode(f)),
        myFields.get(SecondaryTrdTypeField.TagId).flatMap(f=>SecondaryTrdTypeField.decode(f)),
        myFields.get(TransferReasonField.TagId).flatMap(f=>TransferReasonField.decode(f)),
        ExecTypeField.decode(myFields.get(ExecTypeField.TagId)).get,
        myFields.get(TradeReportRefIDField.TagId).flatMap(f=>TradeReportRefIDField.decode(f)),
        myFields.get(SecondaryTradeReportRefIDField.TagId).flatMap(f=>SecondaryTradeReportRefIDField.decode(f)),
        myFields.get(TrdRptStatusField.TagId).flatMap(f=>TrdRptStatusField.decode(f)),
        myFields.get(TradeReportRejectReasonField.TagId).flatMap(f=>TradeReportRejectReasonField.decode(f)),
        myFields.get(SecondaryTradeReportIDField.TagId).flatMap(f=>SecondaryTradeReportIDField.decode(f)),
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f)),
        myFields.get(TradeLinkIDField.TagId).flatMap(f=>TradeLinkIDField.decode(f)),
        myFields.get(TrdMatchIDField.TagId).flatMap(f=>TrdMatchIDField.decode(f)),
        myFields.get(ExecIDField.TagId).flatMap(f=>ExecIDField.decode(f)),
        myFields.get(SecondaryExecIDField.TagId).flatMap(f=>SecondaryExecIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        TrdRegTimestampsComponent.decode(flds, startPos),
        myFields.get(ResponseTransportTypeField.TagId).flatMap(f=>ResponseTransportTypeField.decode(f)),
        myFields.get(ResponseDestinationField.TagId).flatMap(f=>ResponseDestinationField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
        myFields.get(ClearingFeeIndicatorField.TagId).flatMap(f=>ClearingFeeIndicatorField.decode(f)),
        myFields.get(OrderCapacityField.TagId).flatMap(f=>OrderCapacityField.decode(f)),
        myFields.get(OrderRestrictionsField.TagId).flatMap(f=>OrderRestrictionsField.decode(f)),
        myFields.get(CustOrderCapacityField.TagId).flatMap(f=>CustOrderCapacityField.decode(f)),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        myFields.get(PositionEffectField.TagId).flatMap(f=>PositionEffectField.decode(f)),
        myFields.get(PreallocMethodField.TagId).flatMap(f=>PreallocMethodField.decode(f)),
        myFields.get(NoAllocsField.TagId).flatMap(f=>NoAllocsField.decode(f)),
        if (nextTagPosLookup.contains(NoAllocsField.TagId)) AllocsGroup.decode(flds, nextTagPosLookup(NoAllocsField.TagId)) else None))
    } else None
  }

    
}
     