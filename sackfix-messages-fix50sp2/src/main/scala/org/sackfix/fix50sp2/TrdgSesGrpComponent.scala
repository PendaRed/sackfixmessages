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
case class TrdgSesGrpComponent(noTradingSessionsField:Option[NoTradingSessionsField]=None,
                               tradingSessionsGroups: Option[List[TradingSessionsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noTradingSessionsField.map(_.value).getOrElse(0) != tradingSessionsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoTradingSessionsField.TagId,noTradingSessionsField.map(_.value).getOrElse(0), tradingSessionsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noTradingSessionsField.foreach(fmt(b,_))
    tradingSessionsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object TrdgSesGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    TradingSessionsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoTradingSessionsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    TradingSessionsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    TradingSessionsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoTradingSessionsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = TradingSessionsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[TrdgSesGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(TrdgSesGrpComponent(myFields.get(NoTradingSessionsField.TagId).flatMap(f=>NoTradingSessionsField.decode(f)),
        if (nextTagPosLookup.contains(NoTradingSessionsField.TagId)) TradingSessionsGroup.decode(flds, nextTagPosLookup(NoTradingSessionsField.TagId)) else None))
    } else None
  }

    
}
     