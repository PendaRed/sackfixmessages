package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class ComplexEventTimesComponent(noComplexEventTimesField:Option[NoComplexEventTimesField]=None,
                                      complexEventTimesGroups: Option[List[ComplexEventTimesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noComplexEventTimesField.map(_.value).getOrElse(0) != complexEventTimesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoComplexEventTimesField.TagId,noComplexEventTimesField.map(_.value).getOrElse(0), complexEventTimesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noComplexEventTimesField.foreach(fmt(b,_))
    complexEventTimesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object ComplexEventTimesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ComplexEventTimesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoComplexEventTimesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ComplexEventTimesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ComplexEventTimesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoComplexEventTimesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = ComplexEventTimesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[ComplexEventTimesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(ComplexEventTimesComponent(myFields.get(NoComplexEventTimesField.TagId).flatMap(f=>NoComplexEventTimesField.decode(f)),
        if (nextTagPosLookup.contains(NoComplexEventTimesField.TagId)) ComplexEventTimesGroup.decode(flds, nextTagPosLookup(NoComplexEventTimesField.TagId)) else None))
    } else None
  }

    
}
     