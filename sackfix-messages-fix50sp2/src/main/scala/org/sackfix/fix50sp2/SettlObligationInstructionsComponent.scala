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
case class SettlObligationInstructionsComponent(noSettlObligField:Option[NoSettlObligField]=None,
                                                settlObligGroups: Option[List[SettlObligGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSettlObligField.map(_.value).getOrElse(0) != settlObligGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoSettlObligField.TagId,noSettlObligField.map(_.value).getOrElse(0), settlObligGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noSettlObligField.foreach(fmt(b,_))
    settlObligGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object SettlObligationInstructionsComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SettlObligGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoSettlObligField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SettlObligGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SettlObligGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSettlObligField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = SettlObligGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SettlObligationInstructionsComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SettlObligationInstructionsComponent(myFields.get(NoSettlObligField.TagId).flatMap(f=>NoSettlObligField.decode(f)),
        if (nextTagPosLookup.contains(NoSettlObligField.TagId)) SettlObligGroup.decode(flds, nextTagPosLookup(NoSettlObligField.TagId)) else None))
    } else None
  }

    
}
     