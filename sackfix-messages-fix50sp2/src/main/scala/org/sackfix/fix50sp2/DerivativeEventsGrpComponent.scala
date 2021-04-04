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
case class DerivativeEventsGrpComponent(noDerivativeEventsField:Option[NoDerivativeEventsField]=None,
                                        derivativeEventsGroups: Option[List[DerivativeEventsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noDerivativeEventsField.map(_.value).getOrElse(0) != derivativeEventsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoDerivativeEventsField.TagId,noDerivativeEventsField.map(_.value).getOrElse(0), derivativeEventsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noDerivativeEventsField.foreach(fmt(b,_))
    derivativeEventsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object DerivativeEventsGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    DerivativeEventsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoDerivativeEventsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    DerivativeEventsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    DerivativeEventsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoDerivativeEventsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = DerivativeEventsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[DerivativeEventsGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(DerivativeEventsGrpComponent(myFields.get(NoDerivativeEventsField.TagId).flatMap(f=>NoDerivativeEventsField.decode(f)),
        if (nextTagPosLookup.contains(NoDerivativeEventsField.TagId)) DerivativeEventsGroup.decode(flds, nextTagPosLookup(NoDerivativeEventsField.TagId)) else None))
    } else None
  }

    
}
     