package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class ApplicationMessageReportMessage(applReportIDField:ApplReportIDField,
                                           applReqIDField:Option[ApplReqIDField]=None,
                                           applReportTypeField:ApplReportTypeField,
                                           applIDReportGrpComponent:Option[ApplIDReportGrpComponent]=None,
                                           textField:Option[TextField]=None,
                                           encodedTextLenField:Option[EncodedTextLenField]=None,
                                           encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("BY")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,applReportIDField)
    applReqIDField.foreach(fmt(b,_))
    fmt(b,applReportTypeField)
    applIDReportGrpComponent.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object ApplicationMessageReportMessage extends SfFixMessageDecoder {
  val MsgType="BY"
  val MsgName="ApplicationMessageReport"
             
  override val MandatoryFields = HashSet[Int](
    ApplReportIDField.TagId, ApplReportTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplIDReportGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ApplReqIDField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplIDReportGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplIDReportGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ApplReportIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ApplicationMessageReportMessage(ApplReportIDField.decode(myFields.get(ApplReportIDField.TagId)).get,
        myFields.get(ApplReqIDField.TagId).flatMap(f=>ApplReqIDField.decode(f)),
        ApplReportTypeField.decode(myFields.get(ApplReportTypeField.TagId)).get,
        ApplIDReportGrpComponent.decode(flds, startPos),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     