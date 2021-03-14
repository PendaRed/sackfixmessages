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
case class SettlPartiesComponent(noSettlPartyIDsField:Option[NoSettlPartyIDsField]=None,
                                 settlPartyIDsGroups: Option[List[SettlPartyIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSettlPartyIDsField.map(_.value).getOrElse(0) != settlPartyIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoSettlPartyIDsField.TagId,noSettlPartyIDsField.map(_.value).getOrElse(0), settlPartyIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noSettlPartyIDsField.foreach(fmt(b,_))
    settlPartyIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object SettlPartiesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SettlPartyIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoSettlPartyIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SettlPartyIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SettlPartyIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSettlPartyIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = SettlPartyIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SettlPartiesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SettlPartiesComponent(myFields.get(NoSettlPartyIDsField.TagId).flatMap(f=>NoSettlPartyIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoSettlPartyIDsField.TagId)) SettlPartyIDsGroup.decode(flds, nextTagPosLookup(NoSettlPartyIDsField.TagId)) else None))
    } else None
  }

    
}
     