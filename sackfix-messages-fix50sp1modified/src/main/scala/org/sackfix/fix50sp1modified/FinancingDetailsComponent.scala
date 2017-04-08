package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class FinancingDetailsComponent(agreementDescField:Option[AgreementDescField]=None,
                                     agreementIDField:Option[AgreementIDField]=None,
                                     agreementDateField:Option[AgreementDateField]=None,
                                     agreementCurrencyField:Option[AgreementCurrencyField]=None,
                                     terminationTypeField:Option[TerminationTypeField]=None,
                                     startDateField:Option[StartDateField]=None,
                                     endDateField:Option[EndDateField]=None,
                                     deliveryTypeField:Option[DeliveryTypeField]=None,
                                     marginRatioField:Option[MarginRatioField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    agreementDescField.foreach(fmt(b,_))
    agreementIDField.foreach(fmt(b,_))
    agreementDateField.foreach(fmt(b,_))
    agreementCurrencyField.foreach(fmt(b,_))
    terminationTypeField.foreach(fmt(b,_))
    startDateField.foreach(fmt(b,_))
    endDateField.foreach(fmt(b,_))
    deliveryTypeField.foreach(fmt(b,_))
    marginRatioField.foreach(fmt(b,_))
    b
  }

}
     
object FinancingDetailsComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    AgreementDescField.TagId, AgreementIDField.TagId, AgreementDateField.TagId, AgreementCurrencyField.TagId, TerminationTypeField.TagId, 
    StartDateField.TagId, EndDateField.TagId, DeliveryTypeField.TagId, MarginRatioField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==AgreementDescField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[FinancingDetailsComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(FinancingDetailsComponent(myFields.get(AgreementDescField.TagId).flatMap(f=>AgreementDescField.decode(f)),
        myFields.get(AgreementIDField.TagId).flatMap(f=>AgreementIDField.decode(f)),
        myFields.get(AgreementDateField.TagId).flatMap(f=>AgreementDateField.decode(f)),
        myFields.get(AgreementCurrencyField.TagId).flatMap(f=>AgreementCurrencyField.decode(f)),
        myFields.get(TerminationTypeField.TagId).flatMap(f=>TerminationTypeField.decode(f)),
        myFields.get(StartDateField.TagId).flatMap(f=>StartDateField.decode(f)),
        myFields.get(EndDateField.TagId).flatMap(f=>EndDateField.decode(f)),
        myFields.get(DeliveryTypeField.TagId).flatMap(f=>DeliveryTypeField.decode(f)),
        myFields.get(MarginRatioField.TagId).flatMap(f=>MarginRatioField.decode(f))))
    } else None
  }

    
}
     