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
case class FillsGrpComponent(noFillsField:Option[NoFillsField]=None,
                             fillsGroups: Option[List[FillsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noFillsField.map(_.value).getOrElse(0) != fillsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoFillsField.TagId,noFillsField.map(_.value).getOrElse(0), fillsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noFillsField.foreach(fmt(b,_))
    fillsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object FillsGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    FillsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoFillsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    FillsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    FillsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoFillsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = FillsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[FillsGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(FillsGrpComponent(myFields.get(NoFillsField.TagId).flatMap(f=>NoFillsField.decode(f)),
        if (nextTagPosLookup.contains(NoFillsField.TagId)) FillsGroup.decode(flds, nextTagPosLookup(NoFillsField.TagId)) else None))
    } else None
  }

    
}
     