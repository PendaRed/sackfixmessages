package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class ExpirationQtyComponent(noExpirationField:Option[NoExpirationField]=None,
                                  expirationGroups: Option[List[ExpirationGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noExpirationField.map(_.value).getOrElse(0) != expirationGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoExpirationField.TagId,noExpirationField.map(_.value).getOrElse(0), expirationGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noExpirationField.foreach(fmt(b,_))
    expirationGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object ExpirationQtyComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ExpirationGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoExpirationField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ExpirationGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ExpirationGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoExpirationField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = ExpirationGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[ExpirationQtyComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(ExpirationQtyComponent(myFields.get(NoExpirationField.TagId).flatMap(f=>NoExpirationField.decode(f)),
        if (nextTagPosLookup.contains(NoExpirationField.TagId)) ExpirationGroup.decode(flds, nextTagPosLookup(NoExpirationField.TagId)) else None))
    } else None
  }

    
}
     