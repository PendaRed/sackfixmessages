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
case class InstrumentPtysSubGrpComponent(noInstrumentPartySubIDsField:Option[NoInstrumentPartySubIDsField]=None,
                                         instrumentPartySubIDsGroups: Option[List[InstrumentPartySubIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noInstrumentPartySubIDsField.map(_.value).getOrElse(0) != instrumentPartySubIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoInstrumentPartySubIDsField.TagId,noInstrumentPartySubIDsField.map(_.value).getOrElse(0), instrumentPartySubIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noInstrumentPartySubIDsField.foreach(fmt(b,_))
    instrumentPartySubIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object InstrumentPtysSubGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentPartySubIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoInstrumentPartySubIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentPartySubIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentPartySubIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoInstrumentPartySubIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = InstrumentPartySubIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[InstrumentPtysSubGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(InstrumentPtysSubGrpComponent(myFields.get(NoInstrumentPartySubIDsField.TagId).flatMap(f=>NoInstrumentPartySubIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoInstrumentPartySubIDsField.TagId)) InstrumentPartySubIDsGroup.decode(flds, nextTagPosLookup(NoInstrumentPartySubIDsField.TagId)) else None))
    } else None
  }

    
}
     