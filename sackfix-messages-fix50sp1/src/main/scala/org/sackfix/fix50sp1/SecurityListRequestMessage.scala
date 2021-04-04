package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class SecurityListRequestMessage(securityReqIDField:SecurityReqIDField,
                                      securityListRequestTypeField:SecurityListRequestTypeField,
                                      marketIDField:Option[MarketIDField]=None,
                                      marketSegmentIDField:Option[MarketSegmentIDField]=None,
                                      instrumentComponent:Option[InstrumentComponent]=None,
                                      instrumentExtensionComponent:Option[InstrumentExtensionComponent]=None,
                                      financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                      undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                      instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                      currencyField:Option[CurrencyField]=None,
                                      textField:Option[TextField]=None,
                                      encodedTextLenField:Option[EncodedTextLenField]=None,
                                      encodedTextField:Option[EncodedTextField]=None,
                                      tradingSessionIDField:Option[TradingSessionIDField]=None,
                                      tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                      subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None) extends SfFixMessageBody("x")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,securityReqIDField)
    fmt(b,securityListRequestTypeField)
    marketIDField.foreach(fmt(b,_))
    marketSegmentIDField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    instrumentExtensionComponent.foreach(fmt(b,_))
    financingDetailsComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    subscriptionRequestTypeField.foreach(fmt(b,_))
    b
  }

}
     
object SecurityListRequestMessage extends SfFixMessageDecoder {
  val MsgType="x"
  val MsgName="SecurityListRequest"
             
  override val MandatoryFields = HashSet[Int](
    SecurityReqIDField.TagId, SecurityListRequestTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || InstrumentExtensionComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || 
    InstrmtLegGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    MarketIDField.TagId, MarketSegmentIDField.TagId, CurrencyField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, SubscriptionRequestTypeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || InstrumentExtensionComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || 
    InstrmtLegGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || InstrumentExtensionComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || 
    UndInstrmtGrpComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SecurityReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SecurityListRequestMessage(SecurityReqIDField.decode(myFields.get(SecurityReqIDField.TagId)).get,
        SecurityListRequestTypeField.decode(myFields.get(SecurityListRequestTypeField.TagId)).get,
        myFields.get(MarketIDField.TagId).flatMap(f=>MarketIDField.decode(f)),
        myFields.get(MarketSegmentIDField.TagId).flatMap(f=>MarketSegmentIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos),
        InstrumentExtensionComponent.decode(flds, startPos),
        FinancingDetailsComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f))))
    } else None
  }

    
}
     