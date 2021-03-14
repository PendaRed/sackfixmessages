package org.sackfix.fix40

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX40.xml
  */
case class EmailMessage(emailTypeField:EmailTypeField,
                        origTimeField:Option[OrigTimeField]=None,
                        relatdSymField:Option[RelatdSymField]=None,
                        orderIDField:Option[OrderIDField]=None,
                        clOrdIDField:Option[ClOrdIDField]=None,
                        linesOfTextField:LinesOfTextField,
                        linesOfTextGroups: List[LinesOfTextGroup],
                        rawDataLengthField:Option[RawDataLengthField]=None,
                        rawDataField:Option[RawDataField]=None) extends SfFixMessageBody("C")  with SfFixRenderable with SfFixFieldsToAscii {
  if (linesOfTextField.value != linesOfTextGroups.size)
    throw SfRepeatingGroupCountException(LinesOfTextField.TagId,linesOfTextField.value, linesOfTextGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,emailTypeField)
    origTimeField.foreach(fmt(b,_))
    relatdSymField.foreach(fmt(b,_))
    orderIDField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    fmt(b,linesOfTextField)
    rawDataLengthField.foreach(fmt(b,_))
    rawDataField.foreach(fmt(b,_))
    b
  }

}
     
object EmailMessage extends SfFixMessageDecoder {
  val MsgType="C"
  val MsgName="Email"
             
  override val MandatoryFields = HashSet[Int](
    EmailTypeField.TagId, LinesOfTextField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    LinesOfTextGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrigTimeField.TagId, RelatdSymField.TagId, OrderIDField.TagId, ClOrdIDField.TagId, RawDataLengthField.TagId, 
    RawDataField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    LinesOfTextGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    LinesOfTextGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    LinesOfTextField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==EmailTypeField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(EmailMessage(EmailTypeField.decode(myFields.get(EmailTypeField.TagId)).get,
        myFields.get(OrigTimeField.TagId).flatMap(f=>OrigTimeField.decode(f)),
        myFields.get(RelatdSymField.TagId).flatMap(f=>RelatdSymField.decode(f)),
        myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        LinesOfTextField.decode(myFields.get(LinesOfTextField.TagId)).get,
        if (nextTagPosLookup.contains(LinesOfTextField.TagId)) LinesOfTextGroup.decode(flds, nextTagPosLookup(LinesOfTextField.TagId)).get else List.empty,
        myFields.get(RawDataLengthField.TagId).flatMap(f=>RawDataLengthField.decode(f)),
        myFields.get(RawDataField.TagId).flatMap(f=>RawDataField.decode(f))))
    } else None
  }

    
}
     