package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class MarketSegmentGrpComponent(noMarketSegmentsField:Option[NoMarketSegmentsField]=None,
                                     marketSegmentsGroups: Option[List[MarketSegmentsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noMarketSegmentsField.map(_.value).getOrElse(0) != marketSegmentsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoMarketSegmentsField.TagId,noMarketSegmentsField.map(_.value).getOrElse(0), marketSegmentsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noMarketSegmentsField.foreach(fmt(b,_))
    marketSegmentsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object MarketSegmentGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MarketSegmentsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoMarketSegmentsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MarketSegmentsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MarketSegmentsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoMarketSegmentsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = MarketSegmentsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[MarketSegmentGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(MarketSegmentGrpComponent(myFields.get(NoMarketSegmentsField.TagId).flatMap(f=>NoMarketSegmentsField.decode(f)),
        if (nextTagPosLookup.contains(NoMarketSegmentsField.TagId)) MarketSegmentsGroup.decode(flds, nextTagPosLookup(NoMarketSegmentsField.TagId)) else None))
    } else None
  }

    
}
     