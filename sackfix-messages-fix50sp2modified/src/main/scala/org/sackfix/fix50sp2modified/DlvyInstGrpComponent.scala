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
case class DlvyInstGrpComponent(noDlvyInstField:Option[NoDlvyInstField]=None,
                                dlvyInstGroups: Option[List[DlvyInstGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noDlvyInstField.map(_.value).getOrElse(0) != dlvyInstGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoDlvyInstField.TagId,noDlvyInstField.map(_.value).getOrElse(0), dlvyInstGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noDlvyInstField.foreach(fmt(b,_))
    dlvyInstGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object DlvyInstGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    DlvyInstGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoDlvyInstField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    DlvyInstGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    DlvyInstGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoDlvyInstField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = DlvyInstGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[DlvyInstGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(DlvyInstGrpComponent(myFields.get(NoDlvyInstField.TagId).flatMap(f=>NoDlvyInstField.decode(f)),
        if (nextTagPosLookup.contains(NoDlvyInstField.TagId)) DlvyInstGroup.decode(flds, nextTagPosLookup(NoDlvyInstField.TagId)) else None))
    } else None
  }

    
}
     