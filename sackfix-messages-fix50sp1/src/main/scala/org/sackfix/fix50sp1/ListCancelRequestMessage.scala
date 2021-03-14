package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class ListCancelRequestMessage(listIDField:ListIDField,
                                    partiesComponent:Option[PartiesComponent]=None,
                                    transactTimeField:TransactTimeField,
                                    tradeOriginationDateField:Option[TradeOriginationDateField]=None,
                                    tradeDateField:Option[TradeDateField]=None,
                                    textField:Option[TextField]=None,
                                    encodedTextLenField:Option[EncodedTextLenField]=None,
                                    encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("K")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,listIDField)
    partiesComponent.foreach(fmt(b,_))
    fmt(b,transactTimeField)
    tradeOriginationDateField.foreach(fmt(b,_))
    tradeDateField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object ListCancelRequestMessage extends SfFixMessageDecoder {
  val MsgType="K"
  val MsgName="ListCancelRequest"
             
  override val MandatoryFields = HashSet[Int](
    ListIDField.TagId, TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TradeOriginationDateField.TagId, TradeDateField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ListIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ListCancelRequestMessage(ListIDField.decode(myFields.get(ListIDField.TagId)).get,
        PartiesComponent.decode(flds, startPos),
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        myFields.get(TradeOriginationDateField.TagId).flatMap(f=>TradeOriginationDateField.decode(f)),
        myFields.get(TradeDateField.TagId).flatMap(f=>TradeDateField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     