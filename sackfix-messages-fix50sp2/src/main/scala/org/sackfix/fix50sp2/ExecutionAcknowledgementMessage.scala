package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class ExecutionAcknowledgementMessage(orderIDField:OrderIDField,
                                           secondaryOrderIDField:Option[SecondaryOrderIDField]=None,
                                           clOrdIDField:Option[ClOrdIDField]=None,
                                           execAckStatusField:ExecAckStatusField,
                                           execIDField:ExecIDField,
                                           dKReasonField:Option[DKReasonField]=None,
                                           instrumentComponent:InstrumentComponent,
                                           undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                           instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                           sideField:SideField,
                                           orderQtyDataComponent:OrderQtyDataComponent,
                                           lastQtyField:Option[LastQtyField]=None,
                                           lastPxField:Option[LastPxField]=None,
                                           priceTypeField:Option[PriceTypeField]=None,
                                           lastParPxField:Option[LastParPxField]=None,
                                           cumQtyField:Option[CumQtyField]=None,
                                           avgPxField:Option[AvgPxField]=None,
                                           textField:Option[TextField]=None,
                                           encodedTextLenField:Option[EncodedTextLenField]=None,
                                           encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("BN")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,orderIDField)
    secondaryOrderIDField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    fmt(b,execAckStatusField)
    fmt(b,execIDField)
    dKReasonField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    fmt(b,sideField)
    fmt(b,orderQtyDataComponent)
    lastQtyField.foreach(fmt(b,_))
    lastPxField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    lastParPxField.foreach(fmt(b,_))
    cumQtyField.foreach(fmt(b,_))
    avgPxField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object ExecutionAcknowledgementMessage extends SfFixMessageDecoder {
  val MsgType="BN"
  val MsgName="ExecutionAcknowledgement"
             
  override val MandatoryFields = HashSet[Int](
    OrderIDField.TagId, ExecAckStatusField.TagId, ExecIDField.TagId, SideField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || OrderQtyDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecondaryOrderIDField.TagId, ClOrdIDField.TagId, DKReasonField.TagId, LastQtyField.TagId, LastPxField.TagId, 
    PriceTypeField.TagId, LastParPxField.TagId, CumQtyField.TagId, AvgPxField.TagId, TextField.TagId, 
    EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || OrderQtyDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId) || 
    OrderQtyDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ExecutionAcknowledgementMessage(OrderIDField.decode(myFields.get(OrderIDField.TagId)).get,
        myFields.get(SecondaryOrderIDField.TagId).flatMap(f=>SecondaryOrderIDField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        ExecAckStatusField.decode(myFields.get(ExecAckStatusField.TagId)).get,
        ExecIDField.decode(myFields.get(ExecIDField.TagId)).get,
        myFields.get(DKReasonField.TagId).flatMap(f=>DKReasonField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        UndInstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        SideField.decode(myFields.get(SideField.TagId)).get,
        OrderQtyDataComponent.decode(flds, startPos).get,
        myFields.get(LastQtyField.TagId).flatMap(f=>LastQtyField.decode(f)),
        myFields.get(LastPxField.TagId).flatMap(f=>LastPxField.decode(f)),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(LastParPxField.TagId).flatMap(f=>LastParPxField.decode(f)),
        myFields.get(CumQtyField.TagId).flatMap(f=>CumQtyField.decode(f)),
        myFields.get(AvgPxField.TagId).flatMap(f=>AvgPxField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     