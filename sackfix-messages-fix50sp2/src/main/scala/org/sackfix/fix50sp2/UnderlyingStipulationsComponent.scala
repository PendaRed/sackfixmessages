package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class UnderlyingStipulationsComponent(noUnderlyingStipsField:Option[NoUnderlyingStipsField]=None,
                                           underlyingStipsGroups: Option[List[UnderlyingStipsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noUnderlyingStipsField.map(_.value).getOrElse(0) != underlyingStipsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingStipsField.TagId,noUnderlyingStipsField.map(_.value).getOrElse(0), underlyingStipsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noUnderlyingStipsField.foreach(fmt(b,_))
    underlyingStipsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object UnderlyingStipulationsComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    UnderlyingStipsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoUnderlyingStipsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    UnderlyingStipsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    UnderlyingStipsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoUnderlyingStipsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = UnderlyingStipsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[UnderlyingStipulationsComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(UnderlyingStipulationsComponent(myFields.get(NoUnderlyingStipsField.TagId).flatMap(f=>NoUnderlyingStipsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingStipsField.TagId)) UnderlyingStipsGroup.decode(flds, nextTagPosLookup(NoUnderlyingStipsField.TagId)) else None))
    } else None
  }

    
}
     