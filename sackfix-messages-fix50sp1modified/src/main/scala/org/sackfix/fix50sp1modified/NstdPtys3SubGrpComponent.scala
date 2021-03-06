package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class NstdPtys3SubGrpComponent(noNested3PartySubIDsField:Option[NoNested3PartySubIDsField]=None,
                                    nested3PartySubIDsGroups: Option[List[Nested3PartySubIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noNested3PartySubIDsField.map(_.value).getOrElse(0) != nested3PartySubIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoNested3PartySubIDsField.TagId,noNested3PartySubIDsField.map(_.value).getOrElse(0), nested3PartySubIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noNested3PartySubIDsField.foreach(fmt(b,_))
    nested3PartySubIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object NstdPtys3SubGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    Nested3PartySubIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoNested3PartySubIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    Nested3PartySubIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    Nested3PartySubIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoNested3PartySubIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = Nested3PartySubIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[NstdPtys3SubGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(NstdPtys3SubGrpComponent(myFields.get(NoNested3PartySubIDsField.TagId).flatMap(f=>NoNested3PartySubIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoNested3PartySubIDsField.TagId)) Nested3PartySubIDsGroup.decode(flds, nextTagPosLookup(NoNested3PartySubIDsField.TagId)) else None))
    } else None
  }

    
}
     