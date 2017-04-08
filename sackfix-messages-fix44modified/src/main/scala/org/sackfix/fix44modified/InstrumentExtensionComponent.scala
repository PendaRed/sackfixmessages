package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class InstrumentExtensionComponent(deliveryFormField:Option[DeliveryFormField]=None,
                                        pctAtRiskField:Option[PctAtRiskField]=None,
                                        noInstrAttribField:Option[NoInstrAttribField]=None,
                                        instrAttribGroups: Option[List[InstrAttribGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noInstrAttribField.map(_.value).getOrElse(0) != instrAttribGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoInstrAttribField.TagId,noInstrAttribField.map(_.value).getOrElse(0), instrAttribGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    deliveryFormField.foreach(fmt(b,_))
    pctAtRiskField.foreach(fmt(b,_))
    noInstrAttribField.foreach(fmt(b,_))
    instrAttribGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object InstrumentExtensionComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrAttribGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    DeliveryFormField.TagId, PctAtRiskField.TagId, NoInstrAttribField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrAttribGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrAttribGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoInstrAttribField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==DeliveryFormField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[InstrumentExtensionComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(InstrumentExtensionComponent(myFields.get(DeliveryFormField.TagId).flatMap(f=>DeliveryFormField.decode(f)),
        myFields.get(PctAtRiskField.TagId).flatMap(f=>PctAtRiskField.decode(f)),
        myFields.get(NoInstrAttribField.TagId).flatMap(f=>NoInstrAttribField.decode(f)),
        if (nextTagPosLookup.contains(NoInstrAttribField.TagId)) InstrAttribGroup.decode(flds, nextTagPosLookup(NoInstrAttribField.TagId)) else None))
    } else None
  }

    
}
     