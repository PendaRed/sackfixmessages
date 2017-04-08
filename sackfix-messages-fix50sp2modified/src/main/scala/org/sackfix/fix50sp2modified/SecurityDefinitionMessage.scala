package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class SecurityDefinitionMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                                     securityReportIDField:Option[SecurityReportIDField]=None,
                                     clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                     securityReqIDField:Option[SecurityReqIDField]=None,
                                     securityResponseIDField:Option[SecurityResponseIDField]=None,
                                     securityResponseTypeField:Option[SecurityResponseTypeField]=None,
                                     corporateActionField:Option[CorporateActionField]=None,
                                     instrumentComponent:Option[InstrumentComponent]=None,
                                     instrumentExtensionComponent:Option[InstrumentExtensionComponent]=None,
                                     undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                     currencyField:Option[CurrencyField]=None,
                                     textField:Option[TextField]=None,
                                     encodedTextLenField:Option[EncodedTextLenField]=None,
                                     encodedTextField:Option[EncodedTextField]=None,
                                     stipulationsComponent:Option[StipulationsComponent]=None,
                                     instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                     spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                                     yieldDataComponent:Option[YieldDataComponent]=None,
                                     marketSegmentGrpComponent:Option[MarketSegmentGrpComponent]=None,
                                     transactTimeField:Option[TransactTimeField]=None) extends SfFixMessageBody("d")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    securityReportIDField.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    securityReqIDField.foreach(fmt(b,_))
    securityResponseIDField.foreach(fmt(b,_))
    securityResponseTypeField.foreach(fmt(b,_))
    corporateActionField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    instrumentExtensionComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    stipulationsComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    yieldDataComponent.foreach(fmt(b,_))
    marketSegmentGrpComponent.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    b
  }

}
     
object SecurityDefinitionMessage extends SfFixMessageDecoder {
  val MsgType="d"
  val MsgName="SecurityDefinition"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || InstrumentExtensionComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || 
    StipulationsComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId) || 
    MarketSegmentGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecurityReportIDField.TagId, ClearingBusinessDateField.TagId, SecurityReqIDField.TagId, SecurityResponseIDField.TagId, SecurityResponseTypeField.TagId, 
    CorporateActionField.TagId, CurrencyField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, 
    TransactTimeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || InstrumentExtensionComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || 
    StipulationsComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId) || 
    MarketSegmentGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || InstrumentExtensionComponent.isFieldOf(tagId) || 
    UndInstrmtGrpComponent.isFieldOf(tagId) || StipulationsComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || YieldDataComponent.isFieldOf(tagId) || MarketSegmentGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SecurityDefinitionMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        myFields.get(SecurityReportIDField.TagId).flatMap(f=>SecurityReportIDField.decode(f)),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(SecurityReqIDField.TagId).flatMap(f=>SecurityReqIDField.decode(f)),
        myFields.get(SecurityResponseIDField.TagId).flatMap(f=>SecurityResponseIDField.decode(f)),
        myFields.get(SecurityResponseTypeField.TagId).flatMap(f=>SecurityResponseTypeField.decode(f)),
        myFields.get(CorporateActionField.TagId).flatMap(f=>CorporateActionField.decode(f)),
        InstrumentComponent.decode(flds, startPos),
        InstrumentExtensionComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        StipulationsComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        YieldDataComponent.decode(flds, startPos),
        MarketSegmentGrpComponent.decode(flds, startPos),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f))))
    } else None
  }

    
}
     