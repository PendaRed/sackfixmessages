package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class QuotQualGrpComponent(noQuoteQualifiersField:Option[NoQuoteQualifiersField]=None,
                                quoteQualifiersGroups: Option[List[QuoteQualifiersGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noQuoteQualifiersField.map(_.value).getOrElse(0) != quoteQualifiersGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoQuoteQualifiersField.TagId,noQuoteQualifiersField.map(_.value).getOrElse(0), quoteQualifiersGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noQuoteQualifiersField.foreach(fmt(b,_))
    quoteQualifiersGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object QuotQualGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    QuoteQualifiersGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoQuoteQualifiersField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    QuoteQualifiersGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    QuoteQualifiersGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoQuoteQualifiersField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = QuoteQualifiersGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[QuotQualGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(QuotQualGrpComponent(myFields.get(NoQuoteQualifiersField.TagId).flatMap(f=>NoQuoteQualifiersField.decode(f)),
        if (nextTagPosLookup.contains(NoQuoteQualifiersField.TagId)) QuoteQualifiersGroup.decode(flds, nextTagPosLookup(NoQuoteQualifiersField.TagId)) else None))
    } else None
  }

    
}
     