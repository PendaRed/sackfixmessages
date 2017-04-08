package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class TradingSessionStatusMessage(tradSesReqIDField:Option[TradSesReqIDField]=None,
                                       tradingSessionIDField:TradingSessionIDField,
                                       tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                       tradSesMethodField:Option[TradSesMethodField]=None,
                                       tradSesModeField:Option[TradSesModeField]=None,
                                       unsolicitedIndicatorField:Option[UnsolicitedIndicatorField]=None,
                                       tradSesStatusField:TradSesStatusField,
                                       tradSesStatusRejReasonField:Option[TradSesStatusRejReasonField]=None,
                                       tradSesStartTimeField:Option[TradSesStartTimeField]=None,
                                       tradSesOpenTimeField:Option[TradSesOpenTimeField]=None,
                                       tradSesPreCloseTimeField:Option[TradSesPreCloseTimeField]=None,
                                       tradSesCloseTimeField:Option[TradSesCloseTimeField]=None,
                                       tradSesEndTimeField:Option[TradSesEndTimeField]=None,
                                       totalVolumeTradedField:Option[TotalVolumeTradedField]=None,
                                       textField:Option[TextField]=None,
                                       encodedTextLenField:Option[EncodedTextLenField]=None,
                                       encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("h")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    tradSesReqIDField.foreach(fmt(b,_))
    fmt(b,tradingSessionIDField)
    tradingSessionSubIDField.foreach(fmt(b,_))
    tradSesMethodField.foreach(fmt(b,_))
    tradSesModeField.foreach(fmt(b,_))
    unsolicitedIndicatorField.foreach(fmt(b,_))
    fmt(b,tradSesStatusField)
    tradSesStatusRejReasonField.foreach(fmt(b,_))
    tradSesStartTimeField.foreach(fmt(b,_))
    tradSesOpenTimeField.foreach(fmt(b,_))
    tradSesPreCloseTimeField.foreach(fmt(b,_))
    tradSesCloseTimeField.foreach(fmt(b,_))
    tradSesEndTimeField.foreach(fmt(b,_))
    totalVolumeTradedField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object TradingSessionStatusMessage extends SfFixMessageDecoder {
  val MsgType="h"
  val MsgName="TradingSessionStatus"
             
  override val MandatoryFields = HashSet[Int](
    TradingSessionIDField.TagId, TradSesStatusField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    TradSesReqIDField.TagId, TradingSessionSubIDField.TagId, TradSesMethodField.TagId, TradSesModeField.TagId, UnsolicitedIndicatorField.TagId, 
    TradSesStatusRejReasonField.TagId, TradSesStartTimeField.TagId, TradSesOpenTimeField.TagId, TradSesPreCloseTimeField.TagId, TradSesCloseTimeField.TagId, 
    TradSesEndTimeField.TagId, TotalVolumeTradedField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==TradSesReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(TradingSessionStatusMessage(myFields.get(TradSesReqIDField.TagId).flatMap(f=>TradSesReqIDField.decode(f)),
        TradingSessionIDField.decode(myFields.get(TradingSessionIDField.TagId)).get,
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(TradSesMethodField.TagId).flatMap(f=>TradSesMethodField.decode(f)),
        myFields.get(TradSesModeField.TagId).flatMap(f=>TradSesModeField.decode(f)),
        myFields.get(UnsolicitedIndicatorField.TagId).flatMap(f=>UnsolicitedIndicatorField.decode(f)),
        TradSesStatusField.decode(myFields.get(TradSesStatusField.TagId)).get,
        myFields.get(TradSesStatusRejReasonField.TagId).flatMap(f=>TradSesStatusRejReasonField.decode(f)),
        myFields.get(TradSesStartTimeField.TagId).flatMap(f=>TradSesStartTimeField.decode(f)),
        myFields.get(TradSesOpenTimeField.TagId).flatMap(f=>TradSesOpenTimeField.decode(f)),
        myFields.get(TradSesPreCloseTimeField.TagId).flatMap(f=>TradSesPreCloseTimeField.decode(f)),
        myFields.get(TradSesCloseTimeField.TagId).flatMap(f=>TradSesCloseTimeField.decode(f)),
        myFields.get(TradSesEndTimeField.TagId).flatMap(f=>TradSesEndTimeField.decode(f)),
        myFields.get(TotalVolumeTradedField.TagId).flatMap(f=>TotalVolumeTradedField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     