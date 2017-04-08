package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class ComplexEventDatesComponent(noComplexEventDatesField:Option[NoComplexEventDatesField]=None,
                                      complexEventDatesGroups: Option[List[ComplexEventDatesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noComplexEventDatesField.map(_.value).getOrElse(0) != complexEventDatesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoComplexEventDatesField.TagId,noComplexEventDatesField.map(_.value).getOrElse(0), complexEventDatesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noComplexEventDatesField.foreach(fmt(b,_))
    complexEventDatesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object ComplexEventDatesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ComplexEventDatesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoComplexEventDatesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ComplexEventDatesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ComplexEventDatesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoComplexEventDatesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = ComplexEventDatesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[ComplexEventDatesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(ComplexEventDatesComponent(myFields.get(NoComplexEventDatesField.TagId).flatMap(f=>NoComplexEventDatesField.decode(f)),
        if (nextTagPosLookup.contains(NoComplexEventDatesField.TagId)) ComplexEventDatesGroup.decode(flds, nextTagPosLookup(NoComplexEventDatesField.TagId)) else None))
    } else None
  }

    
}
     