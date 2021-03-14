package org.sackfix.fix41

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX41.xml
  */
case class OrderCancelRejectMessage(orderIDField:OrderIDField,
                                    secondaryOrderIDField:Option[SecondaryOrderIDField]=None,
                                    clOrdIDField:ClOrdIDField,
                                    origClOrdIDField:OrigClOrdIDField,
                                    ordStatusField:OrdStatusField,
                                    clientIDField:Option[ClientIDField]=None,
                                    execBrokerField:Option[ExecBrokerField]=None,
                                    listIDField:Option[ListIDField]=None,
                                    cxlRejReasonField:Option[CxlRejReasonField]=None,
                                    textField:Option[TextField]=None) extends SfFixMessageBody("9")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,orderIDField)
    secondaryOrderIDField.foreach(fmt(b,_))
    fmt(b,clOrdIDField)
    fmt(b,origClOrdIDField)
    fmt(b,ordStatusField)
    clientIDField.foreach(fmt(b,_))
    execBrokerField.foreach(fmt(b,_))
    listIDField.foreach(fmt(b,_))
    cxlRejReasonField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    b
  }

}
     
object OrderCancelRejectMessage extends SfFixMessageDecoder {
  val MsgType="9"
  val MsgName="OrderCancelReject"
             
  override val MandatoryFields = HashSet[Int](
    OrderIDField.TagId, ClOrdIDField.TagId, OrigClOrdIDField.TagId, OrdStatusField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    SecondaryOrderIDField.TagId, ClientIDField.TagId, ExecBrokerField.TagId, ListIDField.TagId, CxlRejReasonField.TagId, 
    TextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(OrderCancelRejectMessage(OrderIDField.decode(myFields.get(OrderIDField.TagId)).get,
        myFields.get(SecondaryOrderIDField.TagId).flatMap(f=>SecondaryOrderIDField.decode(f)),
        ClOrdIDField.decode(myFields.get(ClOrdIDField.TagId)).get,
        OrigClOrdIDField.decode(myFields.get(OrigClOrdIDField.TagId)).get,
        OrdStatusField.decode(myFields.get(OrdStatusField.TagId)).get,
        myFields.get(ClientIDField.TagId).flatMap(f=>ClientIDField.decode(f)),
        myFields.get(ExecBrokerField.TagId).flatMap(f=>ExecBrokerField.decode(f)),
        myFields.get(ListIDField.TagId).flatMap(f=>ListIDField.decode(f)),
        myFields.get(CxlRejReasonField.TagId).flatMap(f=>CxlRejReasonField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f))))
    } else None
  }

    
}
     