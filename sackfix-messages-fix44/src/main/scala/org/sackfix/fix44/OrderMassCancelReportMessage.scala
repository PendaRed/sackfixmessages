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
case class OrderMassCancelReportMessage(clOrdIDField:Option[ClOrdIDField]=None,
                                        secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                                        orderIDField:OrderIDField,
                                        secondaryOrderIDField:Option[SecondaryOrderIDField]=None,
                                        massCancelRequestTypeField:MassCancelRequestTypeField,
                                        massCancelResponseField:MassCancelResponseField,
                                        massCancelRejectReasonStringField:Option[MassCancelRejectReasonStringField]=None,
                                        totalAffectedOrdersField:Option[TotalAffectedOrdersField]=None,
                                        noAffectedOrdersField:Option[NoAffectedOrdersField]=None,
                                        affectedOrdersGroups: Option[List[AffectedOrdersGroup]]=None,
                                        tradingSessionIDField:Option[TradingSessionIDField]=None,
                                        tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                        instrumentComponent:Option[InstrumentComponent]=None,
                                        underlyingInstrumentComponent:Option[UnderlyingInstrumentComponent]=None,
                                        sideField:Option[SideField]=None,
                                        transactTimeField:Option[TransactTimeField]=None,
                                        textField:Option[TextField]=None,
                                        encodedTextLenField:Option[EncodedTextLenField]=None,
                                        encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("r")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noAffectedOrdersField.map(_.value).getOrElse(0) != affectedOrdersGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoAffectedOrdersField.TagId,noAffectedOrdersField.map(_.value).getOrElse(0), affectedOrdersGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    clOrdIDField.foreach(fmt(b,_))
    secondaryClOrdIDField.foreach(fmt(b,_))
    fmt(b,orderIDField)
    secondaryOrderIDField.foreach(fmt(b,_))
    fmt(b,massCancelRequestTypeField)
    fmt(b,massCancelResponseField)
    massCancelRejectReasonStringField.foreach(fmt(b,_))
    totalAffectedOrdersField.foreach(fmt(b,_))
    noAffectedOrdersField.foreach(fmt(b,_))
    affectedOrdersGroups.getOrElse(List.empty).foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    underlyingInstrumentComponent.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object OrderMassCancelReportMessage extends SfFixMessageDecoder {
  val MsgType="r"
  val MsgName="OrderMassCancelReport"
             
  override val MandatoryFields = HashSet[Int](
    OrderIDField.TagId, MassCancelRequestTypeField.TagId, MassCancelResponseField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    AffectedOrdersGroup.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || UnderlyingInstrumentComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ClOrdIDField.TagId, SecondaryClOrdIDField.TagId, SecondaryOrderIDField.TagId, MassCancelRejectReasonStringField.TagId, TotalAffectedOrdersField.TagId, 
    NoAffectedOrdersField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, SideField.TagId, TransactTimeField.TagId, 
    TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    AffectedOrdersGroup.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || UnderlyingInstrumentComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    AffectedOrdersGroup.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || UnderlyingInstrumentComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoAffectedOrdersField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ClOrdIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(OrderMassCancelReportMessage(myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
        OrderIDField.decode(myFields.get(OrderIDField.TagId)).get,
        myFields.get(SecondaryOrderIDField.TagId).flatMap(f=>SecondaryOrderIDField.decode(f)),
        MassCancelRequestTypeField.decode(myFields.get(MassCancelRequestTypeField.TagId)).get,
        MassCancelResponseField.decode(myFields.get(MassCancelResponseField.TagId)).get,
        myFields.get(MassCancelRejectReasonStringField.TagId).flatMap(f=>MassCancelRejectReasonStringField.decode(f)),
        myFields.get(TotalAffectedOrdersField.TagId).flatMap(f=>TotalAffectedOrdersField.decode(f)),
        myFields.get(NoAffectedOrdersField.TagId).flatMap(f=>NoAffectedOrdersField.decode(f)),
        if (nextTagPosLookup.contains(NoAffectedOrdersField.TagId)) AffectedOrdersGroup.decode(flds, nextTagPosLookup(NoAffectedOrdersField.TagId)) else None,
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos),
        UnderlyingInstrumentComponent.decode(flds, startPos),
        myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     