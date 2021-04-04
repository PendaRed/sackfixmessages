package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class SecurityDefinitionMessage(securityReqIDField:Option[SecurityReqIDField]=None,
                                     securityResponseIDField:Option[SecurityResponseIDField]=None,
                                     securityResponseTypeField:Option[SecurityResponseTypeField]=None,
                                     instrumentComponent:Option[InstrumentComponent]=None,
                                     instrumentExtensionComponent:Option[InstrumentExtensionComponent]=None,
                                     undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                     currencyField:Option[CurrencyField]=None,
                                     tradingSessionIDField:Option[TradingSessionIDField]=None,
                                     tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                     textField:Option[TextField]=None,
                                     encodedTextLenField:Option[EncodedTextLenField]=None,
                                     encodedTextField:Option[EncodedTextField]=None,
                                     instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                     expirationCycleField:Option[ExpirationCycleField]=None,
                                     roundLotField:Option[RoundLotField]=None,
                                     minTradeVolField:Option[MinTradeVolField]=None,
                                     securityReportIDField:Option[SecurityReportIDField]=None,
                                     clearingBusinessDateField:Option[ClearingBusinessDateField]=None) extends SfFixMessageBody("d")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    securityReqIDField.foreach(fmt(b,_))
    securityResponseIDField.foreach(fmt(b,_))
    securityResponseTypeField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    instrumentExtensionComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    expirationCycleField.foreach(fmt(b,_))
    roundLotField.foreach(fmt(b,_))
    minTradeVolField.foreach(fmt(b,_))
    securityReportIDField.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    b
  }

}
     
object SecurityDefinitionMessage extends SfFixMessageDecoder {
  val MsgType="d"
  val MsgName="SecurityDefinition"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || InstrumentExtensionComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecurityReqIDField.TagId, SecurityResponseIDField.TagId, SecurityResponseTypeField.TagId, CurrencyField.TagId, TradingSessionIDField.TagId, 
    TradingSessionSubIDField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, ExpirationCycleField.TagId, 
    RoundLotField.TagId, MinTradeVolField.TagId, SecurityReportIDField.TagId, ClearingBusinessDateField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || InstrumentExtensionComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || InstrumentExtensionComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || 
    InstrmtLegGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SecurityReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SecurityDefinitionMessage(myFields.get(SecurityReqIDField.TagId).flatMap(f=>SecurityReqIDField.decode(f)),
        myFields.get(SecurityResponseIDField.TagId).flatMap(f=>SecurityResponseIDField.decode(f)),
        myFields.get(SecurityResponseTypeField.TagId).flatMap(f=>SecurityResponseTypeField.decode(f)),
        InstrumentComponent.decode(flds, startPos),
        InstrumentExtensionComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        InstrmtLegGrpComponent.decode(flds, startPos),
        myFields.get(ExpirationCycleField.TagId).flatMap(f=>ExpirationCycleField.decode(f)),
        myFields.get(RoundLotField.TagId).flatMap(f=>RoundLotField.decode(f)),
        myFields.get(MinTradeVolField.TagId).flatMap(f=>MinTradeVolField.decode(f)),
        myFields.get(SecurityReportIDField.TagId).flatMap(f=>SecurityReportIDField.decode(f)),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f))))
    } else None
  }

    
}
     