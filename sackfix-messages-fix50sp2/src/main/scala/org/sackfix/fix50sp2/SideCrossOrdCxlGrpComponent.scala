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
case class SideCrossOrdCxlGrpComponent(noSidesField:NoSidesField,
                                       sidesGroups: List[SidesGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSidesField.value != sidesGroups.size)
    throw SfRepeatingGroupCountException(NoSidesField.TagId,noSidesField.value, sidesGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noSidesField)
    b
  }

}
     
object SideCrossOrdCxlGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoSidesField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SidesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SidesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SidesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSidesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = SidesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SideCrossOrdCxlGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SideCrossOrdCxlGrpComponent(NoSidesField.decode(myFields.get(NoSidesField.TagId)).get,
        if (nextTagPosLookup.contains(NoSidesField.TagId)) SidesGroup.decode(flds, nextTagPosLookup(NoSidesField.TagId)).get else List.empty))
    } else None
  }

    
}
     