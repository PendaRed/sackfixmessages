package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class RateSourceComponent(noRateSourcesField:Option[NoRateSourcesField]=None,
                               rateSourcesGroups: Option[List[RateSourcesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noRateSourcesField.map(_.value).getOrElse(0) != rateSourcesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoRateSourcesField.TagId,noRateSourcesField.map(_.value).getOrElse(0), rateSourcesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noRateSourcesField.foreach(fmt(b,_))
    rateSourcesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object RateSourceComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RateSourcesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoRateSourcesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RateSourcesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RateSourcesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoRateSourcesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = RateSourcesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[RateSourceComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(RateSourceComponent(myFields.get(NoRateSourcesField.TagId).flatMap(f=>NoRateSourcesField.decode(f)),
        if (nextTagPosLookup.contains(NoRateSourcesField.TagId)) RateSourcesGroup.decode(flds, nextTagPosLookup(NoRateSourcesField.TagId)) else None))
    } else None
  }

    
}
     