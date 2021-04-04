package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class NestedParties2Component(noNested2PartyIDsField:Option[NoNested2PartyIDsField]=None,
                                   nested2PartyIDsGroups: Option[List[Nested2PartyIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noNested2PartyIDsField.map(_.value).getOrElse(0) != nested2PartyIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoNested2PartyIDsField.TagId,noNested2PartyIDsField.map(_.value).getOrElse(0), nested2PartyIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noNested2PartyIDsField.foreach(fmt(b,_))
    nested2PartyIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object NestedParties2Component extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    Nested2PartyIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoNested2PartyIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    Nested2PartyIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    Nested2PartyIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoNested2PartyIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = Nested2PartyIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[NestedParties2Component] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(NestedParties2Component(myFields.get(NoNested2PartyIDsField.TagId).flatMap(f=>NoNested2PartyIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoNested2PartyIDsField.TagId)) Nested2PartyIDsGroup.decode(flds, nextTagPosLookup(NoNested2PartyIDsField.TagId)) else None))
    } else None
  }

    
}
     