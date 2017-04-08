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
case class NestedInstrumentAttributeComponent(noNestedInstrAttribField:Option[NoNestedInstrAttribField]=None,
                                              nestedInstrAttribGroups: Option[List[NestedInstrAttribGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noNestedInstrAttribField.map(_.value).getOrElse(0) != nestedInstrAttribGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoNestedInstrAttribField.TagId,noNestedInstrAttribField.map(_.value).getOrElse(0), nestedInstrAttribGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noNestedInstrAttribField.foreach(fmt(b,_))
    nestedInstrAttribGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object NestedInstrumentAttributeComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NestedInstrAttribGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoNestedInstrAttribField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NestedInstrAttribGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NestedInstrAttribGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoNestedInstrAttribField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = NestedInstrAttribGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[NestedInstrumentAttributeComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(NestedInstrumentAttributeComponent(myFields.get(NoNestedInstrAttribField.TagId).flatMap(f=>NoNestedInstrAttribField.decode(f)),
        if (nextTagPosLookup.contains(NoNestedInstrAttribField.TagId)) NestedInstrAttribGroup.decode(flds, nextTagPosLookup(NoNestedInstrAttribField.TagId)) else None))
    } else None
  }

    
}
     