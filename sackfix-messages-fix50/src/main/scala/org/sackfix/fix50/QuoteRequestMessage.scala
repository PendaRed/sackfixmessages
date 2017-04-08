package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class QuoteRequestMessage(quoteReqIDField:QuoteReqIDField,
                               rFQReqIDField:Option[RFQReqIDField]=None,
                               clOrdIDField:Option[ClOrdIDField]=None,
                               orderCapacityField:Option[OrderCapacityField]=None,
                               quotReqGrpComponent:QuotReqGrpComponent,
                               textField:Option[TextField]=None,
                               encodedTextLenField:Option[EncodedTextLenField]=None,
                               encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("R")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,quoteReqIDField)
    rFQReqIDField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    orderCapacityField.foreach(fmt(b,_))
    fmt(b,quotReqGrpComponent)
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object QuoteRequestMessage extends SfFixMessageDecoder {
  val MsgType="R"
  val MsgName="QuoteRequest"
             
  override val MandatoryFields = HashSet[Int](
    QuoteReqIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    QuotReqGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    RFQReqIDField.TagId, ClOrdIDField.TagId, OrderCapacityField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    QuotReqGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    QuotReqGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(QuoteRequestMessage(QuoteReqIDField.decode(myFields.get(QuoteReqIDField.TagId)).get,
        myFields.get(RFQReqIDField.TagId).flatMap(f=>RFQReqIDField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        myFields.get(OrderCapacityField.TagId).flatMap(f=>OrderCapacityField.decode(f)),
        QuotReqGrpComponent.decode(flds, startPos).get,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     