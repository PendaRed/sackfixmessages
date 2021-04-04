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
case class NstdPtys2SubGrpComponent(noNested2PartySubIDsField:Option[NoNested2PartySubIDsField]=None,
                                    nested2PartySubIDsGroups: Option[List[Nested2PartySubIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noNested2PartySubIDsField.map(_.value).getOrElse(0) != nested2PartySubIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoNested2PartySubIDsField.TagId,noNested2PartySubIDsField.map(_.value).getOrElse(0), nested2PartySubIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noNested2PartySubIDsField.foreach(fmt(b,_))
    nested2PartySubIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object NstdPtys2SubGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    Nested2PartySubIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoNested2PartySubIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    Nested2PartySubIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    Nested2PartySubIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoNested2PartySubIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = Nested2PartySubIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[NstdPtys2SubGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(NstdPtys2SubGrpComponent(myFields.get(NoNested2PartySubIDsField.TagId).flatMap(f=>NoNested2PartySubIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoNested2PartySubIDsField.TagId)) Nested2PartySubIDsGroup.decode(flds, nextTagPosLookup(NoNested2PartySubIDsField.TagId)) else None))
    } else None
  }

    
}
     