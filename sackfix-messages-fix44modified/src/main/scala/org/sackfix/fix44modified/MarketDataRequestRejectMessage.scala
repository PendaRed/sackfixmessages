package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class MarketDataRequestRejectMessage(mDReqIDField:MDReqIDField,
                                          mDReqRejReasonField:Option[MDReqRejReasonField]=None,
                                          noAltMDSourceField:Option[NoAltMDSourceField]=None,
                                          altMDSourceGroups: Option[List[AltMDSourceGroup]]=None,
                                          textField:Option[TextField]=None,
                                          encodedTextLenField:Option[EncodedTextLenField]=None,
                                          encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("Y")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noAltMDSourceField.map(_.value).getOrElse(0) != altMDSourceGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoAltMDSourceField.TagId,noAltMDSourceField.map(_.value).getOrElse(0), altMDSourceGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,mDReqIDField)
    mDReqRejReasonField.foreach(fmt(b,_))
    noAltMDSourceField.foreach(fmt(b,_))
    altMDSourceGroups.getOrElse(List.empty).foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object MarketDataRequestRejectMessage extends SfFixMessageDecoder {
  val MsgType="Y"
  val MsgName="MarketDataRequestReject"
             
  override val MandatoryFields = HashSet[Int](
    MDReqIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    AltMDSourceGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    MDReqRejReasonField.TagId, NoAltMDSourceField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    AltMDSourceGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    AltMDSourceGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoAltMDSourceField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==MDReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MarketDataRequestRejectMessage(MDReqIDField.decode(myFields.get(MDReqIDField.TagId)).get,
        myFields.get(MDReqRejReasonField.TagId).flatMap(f=>MDReqRejReasonField.decode(f)),
        myFields.get(NoAltMDSourceField.TagId).flatMap(f=>NoAltMDSourceField.decode(f)),
        if (nextTagPosLookup.contains(NoAltMDSourceField.TagId)) AltMDSourceGroup.decode(flds, nextTagPosLookup(NoAltMDSourceField.TagId)) else None,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     