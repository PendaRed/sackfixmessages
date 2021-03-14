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
case class TargetPartiesComponent(noTargetPartyIDsField:Option[NoTargetPartyIDsField]=None,
                                  targetPartyIDsGroups: Option[List[TargetPartyIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noTargetPartyIDsField.map(_.value).getOrElse(0) != targetPartyIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoTargetPartyIDsField.TagId,noTargetPartyIDsField.map(_.value).getOrElse(0), targetPartyIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noTargetPartyIDsField.foreach(fmt(b,_))
    targetPartyIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object TargetPartiesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    TargetPartyIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoTargetPartyIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    TargetPartyIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    TargetPartyIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoTargetPartyIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = TargetPartyIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[TargetPartiesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(TargetPartiesComponent(myFields.get(NoTargetPartyIDsField.TagId).flatMap(f=>NoTargetPartyIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoTargetPartyIDsField.TagId)) TargetPartyIDsGroup.decode(flds, nextTagPosLookup(NoTargetPartyIDsField.TagId)) else None))
    } else None
  }

    
}
     