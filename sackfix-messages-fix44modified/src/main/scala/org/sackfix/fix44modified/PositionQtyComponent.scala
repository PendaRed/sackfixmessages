package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class PositionQtyComponent(noPositionsField:NoPositionsField,
                                positionsGroups: List[PositionsGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noPositionsField.value != positionsGroups.size)
    throw SfRepeatingGroupCountException(NoPositionsField.TagId,noPositionsField.value, positionsGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noPositionsField)
    b
  }

}
     
object PositionQtyComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoPositionsField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PositionsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PositionsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PositionsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoPositionsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = PositionsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[PositionQtyComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(PositionQtyComponent(NoPositionsField.decode(myFields.get(NoPositionsField.TagId)).get,
        if (nextTagPosLookup.contains(NoPositionsField.TagId)) PositionsGroup.decode(flds, nextTagPosLookup(NoPositionsField.TagId)).get else List.empty))
    } else None
  }

    
}
     