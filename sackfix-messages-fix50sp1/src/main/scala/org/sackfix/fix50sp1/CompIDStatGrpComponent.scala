package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class CompIDStatGrpComponent(noCompIDsField:NoCompIDsField,
                                  compIDsGroups: List[CompIDsGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noCompIDsField.value != compIDsGroups.size)
    throw SfRepeatingGroupCountException(NoCompIDsField.TagId,noCompIDsField.value, compIDsGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noCompIDsField)
    b
  }

}
     
object CompIDStatGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoCompIDsField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    CompIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    CompIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    CompIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoCompIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = CompIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[CompIDStatGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(CompIDStatGrpComponent(NoCompIDsField.decode(myFields.get(NoCompIDsField.TagId)).get,
        if (nextTagPosLookup.contains(NoCompIDsField.TagId)) CompIDsGroup.decode(flds, nextTagPosLookup(NoCompIDsField.TagId)).get else List.empty))
    } else None
  }

    
}
     