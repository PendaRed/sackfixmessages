package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class TrdCollGrpComponent(noTradesField:Option[NoTradesField]=None,
                               tradesGroups: Option[List[TradesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noTradesField.map(_.value).getOrElse(0) != tradesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoTradesField.TagId,noTradesField.map(_.value).getOrElse(0), tradesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noTradesField.foreach(fmt(b,_))
    tradesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object TrdCollGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    TradesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoTradesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    TradesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    TradesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoTradesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = TradesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[TrdCollGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(TrdCollGrpComponent(myFields.get(NoTradesField.TagId).flatMap(f=>NoTradesField.decode(f)),
        if (nextTagPosLookup.contains(NoTradesField.TagId)) TradesGroup.decode(flds, nextTagPosLookup(NoTradesField.TagId)) else None))
    } else None
  }

    
}
     