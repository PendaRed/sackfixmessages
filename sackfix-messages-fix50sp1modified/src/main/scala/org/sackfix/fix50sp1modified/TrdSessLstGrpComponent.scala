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
case class TrdSessLstGrpComponent(noTradingSessionsField:NoTradingSessionsField,
                                  tradingSessionsGroups: List[TradingSessionsGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noTradingSessionsField.value != tradingSessionsGroups.size)
    throw SfRepeatingGroupCountException(NoTradingSessionsField.TagId,noTradingSessionsField.value, tradingSessionsGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noTradingSessionsField)
    b
  }

}
     
object TrdSessLstGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoTradingSessionsField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    TradingSessionsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    TradingSessionsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    TradingSessionsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoTradingSessionsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = TradingSessionsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[TrdSessLstGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(TrdSessLstGrpComponent(NoTradingSessionsField.decode(myFields.get(NoTradingSessionsField.TagId)).get,
        if (nextTagPosLookup.contains(NoTradingSessionsField.TagId)) TradingSessionsGroup.decode(flds, nextTagPosLookup(NoTradingSessionsField.TagId)).get else List.empty))
    } else None
  }

    
}
     