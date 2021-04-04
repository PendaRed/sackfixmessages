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
case class SecTypesGrpComponent(noSecurityTypesField:Option[NoSecurityTypesField]=None,
                                securityTypesGroups: Option[List[SecurityTypesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSecurityTypesField.map(_.value).getOrElse(0) != securityTypesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoSecurityTypesField.TagId,noSecurityTypesField.map(_.value).getOrElse(0), securityTypesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noSecurityTypesField.foreach(fmt(b,_))
    securityTypesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object SecTypesGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SecurityTypesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoSecurityTypesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SecurityTypesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SecurityTypesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSecurityTypesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = SecurityTypesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SecTypesGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SecTypesGrpComponent(myFields.get(NoSecurityTypesField.TagId).flatMap(f=>NoSecurityTypesField.decode(f)),
        if (nextTagPosLookup.contains(NoSecurityTypesField.TagId)) SecurityTypesGroup.decode(flds, nextTagPosLookup(NoSecurityTypesField.TagId)) else None))
    } else None
  }

    
}
     