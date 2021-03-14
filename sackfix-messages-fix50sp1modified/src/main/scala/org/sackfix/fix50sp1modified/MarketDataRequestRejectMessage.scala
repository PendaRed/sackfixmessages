package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class MarketDataRequestRejectMessage(mDReqIDField:MDReqIDField,
                                          partiesComponent:Option[PartiesComponent]=None,
                                          mDReqRejReasonField:Option[MDReqRejReasonField]=None,
                                          mDRjctGrpComponent:Option[MDRjctGrpComponent]=None,
                                          textField:Option[TextField]=None,
                                          encodedTextLenField:Option[EncodedTextLenField]=None,
                                          encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("Y")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,mDReqIDField)
    partiesComponent.foreach(fmt(b,_))
    mDReqRejReasonField.foreach(fmt(b,_))
    mDRjctGrpComponent.foreach(fmt(b,_))
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
    PartiesComponent.isMandatoryField(tagId) || MDRjctGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    MDReqRejReasonField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || MDRjctGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || MDRjctGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==MDReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MarketDataRequestRejectMessage(MDReqIDField.decode(myFields.get(MDReqIDField.TagId)).get,
        PartiesComponent.decode(flds, startPos),
        myFields.get(MDReqRejReasonField.TagId).flatMap(f=>MDReqRejReasonField.decode(f)),
        MDRjctGrpComponent.decode(flds, startPos),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     