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
case class CpctyConfGrpComponent(noCapacitiesField:NoCapacitiesField,
                                 capacitiesGroups: List[CapacitiesGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noCapacitiesField.value != capacitiesGroups.size)
    throw SfRepeatingGroupCountException(NoCapacitiesField.TagId,noCapacitiesField.value, capacitiesGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noCapacitiesField)
    b
  }

}
     
object CpctyConfGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoCapacitiesField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    CapacitiesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    CapacitiesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    CapacitiesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoCapacitiesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = CapacitiesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[CpctyConfGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(CpctyConfGrpComponent(NoCapacitiesField.decode(myFields.get(NoCapacitiesField.TagId)).get,
        if (nextTagPosLookup.contains(NoCapacitiesField.TagId)) CapacitiesGroup.decode(flds, nextTagPosLookup(NoCapacitiesField.TagId)).get else List.empty))
    } else None
  }

    
}
     