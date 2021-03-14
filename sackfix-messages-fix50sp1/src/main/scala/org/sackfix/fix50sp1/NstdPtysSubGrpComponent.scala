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
case class NstdPtysSubGrpComponent(noNestedPartySubIDsField:Option[NoNestedPartySubIDsField]=None,
                                   nestedPartySubIDsGroups: Option[List[NestedPartySubIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noNestedPartySubIDsField.map(_.value).getOrElse(0) != nestedPartySubIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoNestedPartySubIDsField.TagId,noNestedPartySubIDsField.map(_.value).getOrElse(0), nestedPartySubIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noNestedPartySubIDsField.foreach(fmt(b,_))
    nestedPartySubIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object NstdPtysSubGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NestedPartySubIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoNestedPartySubIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NestedPartySubIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NestedPartySubIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoNestedPartySubIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = NestedPartySubIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[NstdPtysSubGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(NstdPtysSubGrpComponent(myFields.get(NoNestedPartySubIDsField.TagId).flatMap(f=>NoNestedPartySubIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoNestedPartySubIDsField.TagId)) NestedPartySubIDsGroup.decode(flds, nextTagPosLookup(NoNestedPartySubIDsField.TagId)) else None))
    } else None
  }

    
}
     