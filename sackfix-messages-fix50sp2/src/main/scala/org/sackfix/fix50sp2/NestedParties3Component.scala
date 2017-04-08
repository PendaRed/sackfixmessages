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
case class NestedParties3Component(noNested3PartyIDsField:Option[NoNested3PartyIDsField]=None,
                                   nested3PartyIDsGroups: Option[List[Nested3PartyIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noNested3PartyIDsField.map(_.value).getOrElse(0) != nested3PartyIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoNested3PartyIDsField.TagId,noNested3PartyIDsField.map(_.value).getOrElse(0), nested3PartyIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noNested3PartyIDsField.foreach(fmt(b,_))
    nested3PartyIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object NestedParties3Component extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    Nested3PartyIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoNested3PartyIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    Nested3PartyIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    Nested3PartyIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoNested3PartyIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = Nested3PartyIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[NestedParties3Component] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(NestedParties3Component(myFields.get(NoNested3PartyIDsField.TagId).flatMap(f=>NoNested3PartyIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoNested3PartyIDsField.TagId)) Nested3PartyIDsGroup.decode(flds, nextTagPosLookup(NoNested3PartyIDsField.TagId)) else None))
    } else None
  }

    
}
     