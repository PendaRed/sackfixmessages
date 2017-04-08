package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class BusinessMessageRejectMessage(refSeqNumField:Option[RefSeqNumField]=None,
                                        refMsgTypeField:RefMsgTypeField,
                                        refApplVerIDField:Option[RefApplVerIDField]=None,
                                        refApplExtIDField:Option[RefApplExtIDField]=None,
                                        refCstmApplVerIDField:Option[RefCstmApplVerIDField]=None,
                                        businessRejectRefIDField:Option[BusinessRejectRefIDField]=None,
                                        businessRejectReasonField:BusinessRejectReasonField,
                                        textField:Option[TextField]=None,
                                        encodedTextLenField:Option[EncodedTextLenField]=None,
                                        encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("j")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    refSeqNumField.foreach(fmt(b,_))
    fmt(b,refMsgTypeField)
    refApplVerIDField.foreach(fmt(b,_))
    refApplExtIDField.foreach(fmt(b,_))
    refCstmApplVerIDField.foreach(fmt(b,_))
    businessRejectRefIDField.foreach(fmt(b,_))
    fmt(b,businessRejectReasonField)
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object BusinessMessageRejectMessage extends SfFixMessageDecoder {
  val MsgType="j"
  val MsgName="BusinessMessageReject"
             
  override val MandatoryFields = HashSet[Int](
    RefMsgTypeField.TagId, BusinessRejectReasonField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    RefSeqNumField.TagId, RefApplVerIDField.TagId, RefApplExtIDField.TagId, RefCstmApplVerIDField.TagId, BusinessRejectRefIDField.TagId, 
    TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==RefSeqNumField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(BusinessMessageRejectMessage(myFields.get(RefSeqNumField.TagId).flatMap(f=>RefSeqNumField.decode(f)),
        RefMsgTypeField.decode(myFields.get(RefMsgTypeField.TagId)).get,
        myFields.get(RefApplVerIDField.TagId).flatMap(f=>RefApplVerIDField.decode(f)),
        myFields.get(RefApplExtIDField.TagId).flatMap(f=>RefApplExtIDField.decode(f)),
        myFields.get(RefCstmApplVerIDField.TagId).flatMap(f=>RefCstmApplVerIDField.decode(f)),
        myFields.get(BusinessRejectRefIDField.TagId).flatMap(f=>BusinessRejectRefIDField.decode(f)),
        BusinessRejectReasonField.decode(myFields.get(BusinessRejectReasonField.TagId)).get,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     