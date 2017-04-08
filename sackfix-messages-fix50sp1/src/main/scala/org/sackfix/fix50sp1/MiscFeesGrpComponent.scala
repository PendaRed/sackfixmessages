package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class MiscFeesGrpComponent(noMiscFeesField:Option[NoMiscFeesField]=None,
                                miscFeesGroups: Option[List[MiscFeesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noMiscFeesField.map(_.value).getOrElse(0) != miscFeesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoMiscFeesField.TagId,noMiscFeesField.map(_.value).getOrElse(0), miscFeesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noMiscFeesField.foreach(fmt(b,_))
    miscFeesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object MiscFeesGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MiscFeesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoMiscFeesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MiscFeesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MiscFeesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoMiscFeesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = MiscFeesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[MiscFeesGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(MiscFeesGrpComponent(myFields.get(NoMiscFeesField.TagId).flatMap(f=>NoMiscFeesField.decode(f)),
        if (nextTagPosLookup.contains(NoMiscFeesField.TagId)) MiscFeesGroup.decode(flds, nextTagPosLookup(NoMiscFeesField.TagId)) else None))
    } else None
  }

    
}
     