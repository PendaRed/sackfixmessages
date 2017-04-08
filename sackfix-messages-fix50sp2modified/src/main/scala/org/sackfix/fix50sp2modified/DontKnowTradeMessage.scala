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
case class DontKnowTradeMessage(orderIDField:OrderIDField,
                                secondaryOrderIDField:Option[SecondaryOrderIDField]=None,
                                execIDField:ExecIDField,
                                dKReasonField:DKReasonField,
                                instrumentComponent:InstrumentComponent,
                                undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                sideField:SideField,
                                orderQtyDataComponent:OrderQtyDataComponent,
                                lastQtyField:Option[LastQtyField]=None,
                                lastPxField:Option[LastPxField]=None,
                                textField:Option[TextField]=None,
                                encodedTextLenField:Option[EncodedTextLenField]=None,
                                encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("Q")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,orderIDField)
    secondaryOrderIDField.foreach(fmt(b,_))
    fmt(b,execIDField)
    fmt(b,dKReasonField)
    fmt(b,instrumentComponent)
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    fmt(b,sideField)
    fmt(b,orderQtyDataComponent)
    lastQtyField.foreach(fmt(b,_))
    lastPxField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object DontKnowTradeMessage extends SfFixMessageDecoder {
  val MsgType="Q"
  val MsgName="DontKnowTrade"
             
  override val MandatoryFields = HashSet[Int](
    OrderIDField.TagId, ExecIDField.TagId, DKReasonField.TagId, SideField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || OrderQtyDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecondaryOrderIDField.TagId, LastQtyField.TagId, LastPxField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId)

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
      Some(DontKnowTradeMessage(OrderIDField.decode(myFields.get(OrderIDField.TagId)).get,
        myFields.get(SecondaryOrderIDField.TagId).flatMap(f=>SecondaryOrderIDField.decode(f)),
        ExecIDField.decode(myFields.get(ExecIDField.TagId)).get,
        DKReasonField.decode(myFields.get(DKReasonField.TagId)).get,
        InstrumentComponent.decode(flds, startPos).get,
        UndInstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        SideField.decode(myFields.get(SideField.TagId)).get,
        OrderQtyDataComponent.decode(flds, startPos).get,
        myFields.get(LastQtyField.TagId).flatMap(f=>LastQtyField.decode(f)),
        myFields.get(LastPxField.TagId).flatMap(f=>LastPxField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     