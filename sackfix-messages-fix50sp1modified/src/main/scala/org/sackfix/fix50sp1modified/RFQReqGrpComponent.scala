package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class RFQReqGrpComponent(noRelatedSymField:NoRelatedSymField,
                              relatedSymGroups: List[RelatedSymGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noRelatedSymField.value != relatedSymGroups.size)
    throw SfRepeatingGroupCountException(NoRelatedSymField.TagId,noRelatedSymField.value, relatedSymGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noRelatedSymField)
    b
  }

}
     
object RFQReqGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoRelatedSymField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RelatedSymGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RelatedSymGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RelatedSymGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoRelatedSymField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = RelatedSymGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[RFQReqGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(RFQReqGrpComponent(NoRelatedSymField.decode(myFields.get(NoRelatedSymField.TagId)).get,
        if (nextTagPosLookup.contains(NoRelatedSymField.TagId)) RelatedSymGroup.decode(flds, nextTagPosLookup(NoRelatedSymField.TagId)).get else List.empty))
    } else None
  }

    
}
     