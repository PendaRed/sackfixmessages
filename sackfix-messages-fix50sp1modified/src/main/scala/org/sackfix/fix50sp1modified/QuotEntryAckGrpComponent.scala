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
case class QuotEntryAckGrpComponent(noQuoteEntriesField:Option[NoQuoteEntriesField]=None,
                                    quoteEntriesGroups: Option[List[QuoteEntriesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noQuoteEntriesField.map(_.value).getOrElse(0) != quoteEntriesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoQuoteEntriesField.TagId,noQuoteEntriesField.map(_.value).getOrElse(0), quoteEntriesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noQuoteEntriesField.foreach(fmt(b,_))
    quoteEntriesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object QuotEntryAckGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    QuoteEntriesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoQuoteEntriesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    QuoteEntriesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    QuoteEntriesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoQuoteEntriesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = QuoteEntriesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[QuotEntryAckGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(QuotEntryAckGrpComponent(myFields.get(NoQuoteEntriesField.TagId).flatMap(f=>NoQuoteEntriesField.decode(f)),
        if (nextTagPosLookup.contains(NoQuoteEntriesField.TagId)) QuoteEntriesGroup.decode(flds, nextTagPosLookup(NoQuoteEntriesField.TagId)) else None))
    } else None
  }

    
}
     