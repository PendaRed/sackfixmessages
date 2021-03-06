package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class PositionReportMessage(posMaintRptIDField:PosMaintRptIDField,
                                 posReqIDField:Option[PosReqIDField]=None,
                                 posReqTypeField:Option[PosReqTypeField]=None,
                                 subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None,
                                 totalNumPosReportsField:Option[TotalNumPosReportsField]=None,
                                 unsolicitedIndicatorField:Option[UnsolicitedIndicatorField]=None,
                                 posReqResultField:Option[PosReqResultField]=None,
                                 clearingBusinessDateField:ClearingBusinessDateField,
                                 settlSessIDField:Option[SettlSessIDField]=None,
                                 settlSessSubIDField:Option[SettlSessSubIDField]=None,
                                 partiesComponent:PartiesComponent,
                                 accountField:Option[AccountField]=None,
                                 acctIDSourceField:Option[AcctIDSourceField]=None,
                                 accountTypeField:Option[AccountTypeField]=None,
                                 instrumentComponent:Option[InstrumentComponent]=None,
                                 currencyField:Option[CurrencyField]=None,
                                 settlPriceField:Option[SettlPriceField]=None,
                                 settlPriceTypeField:Option[SettlPriceTypeField]=None,
                                 priorSettlPriceField:Option[PriorSettlPriceField]=None,
                                 instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                 posUndInstrmtGrpComponent:Option[PosUndInstrmtGrpComponent]=None,
                                 positionQtyComponent:Option[PositionQtyComponent]=None,
                                 positionAmountDataComponent:Option[PositionAmountDataComponent]=None,
                                 registStatusField:Option[RegistStatusField]=None,
                                 deliveryDateField:Option[DeliveryDateField]=None,
                                 textField:Option[TextField]=None,
                                 encodedTextLenField:Option[EncodedTextLenField]=None,
                                 encodedTextField:Option[EncodedTextField]=None,
                                 matchStatusField:Option[MatchStatusField]=None,
                                 priceTypeField:Option[PriceTypeField]=None,
                                 settlCurrencyField:Option[SettlCurrencyField]=None,
                                 messageEventSourceField:Option[MessageEventSourceField]=None) extends SfFixMessageBody("AP")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,posMaintRptIDField)
    posReqIDField.foreach(fmt(b,_))
    posReqTypeField.foreach(fmt(b,_))
    subscriptionRequestTypeField.foreach(fmt(b,_))
    totalNumPosReportsField.foreach(fmt(b,_))
    unsolicitedIndicatorField.foreach(fmt(b,_))
    posReqResultField.foreach(fmt(b,_))
    fmt(b,clearingBusinessDateField)
    settlSessIDField.foreach(fmt(b,_))
    settlSessSubIDField.foreach(fmt(b,_))
    fmt(b,partiesComponent)
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    settlPriceField.foreach(fmt(b,_))
    settlPriceTypeField.foreach(fmt(b,_))
    priorSettlPriceField.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    posUndInstrmtGrpComponent.foreach(fmt(b,_))
    positionQtyComponent.foreach(fmt(b,_))
    positionAmountDataComponent.foreach(fmt(b,_))
    registStatusField.foreach(fmt(b,_))
    deliveryDateField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    matchStatusField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    messageEventSourceField.foreach(fmt(b,_))
    b
  }

}
     
object PositionReportMessage extends SfFixMessageDecoder {
  val MsgType="AP"
  val MsgName="PositionReport"
             
  override val MandatoryFields = HashSet[Int](
    PosMaintRptIDField.TagId, ClearingBusinessDateField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || PosUndInstrmtGrpComponent.isMandatoryField(tagId) || 
    PositionQtyComponent.isMandatoryField(tagId) || PositionAmountDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    PosReqIDField.TagId, PosReqTypeField.TagId, SubscriptionRequestTypeField.TagId, TotalNumPosReportsField.TagId, UnsolicitedIndicatorField.TagId, 
    PosReqResultField.TagId, SettlSessIDField.TagId, SettlSessSubIDField.TagId, AccountField.TagId, AcctIDSourceField.TagId, 
    AccountTypeField.TagId, CurrencyField.TagId, SettlPriceField.TagId, SettlPriceTypeField.TagId, PriorSettlPriceField.TagId, 
    RegistStatusField.TagId, DeliveryDateField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, 
    MatchStatusField.TagId, PriceTypeField.TagId, SettlCurrencyField.TagId, MessageEventSourceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || PosUndInstrmtGrpComponent.isOptionalField(tagId) || 
    PositionQtyComponent.isOptionalField(tagId) || PositionAmountDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId) || 
    PosUndInstrmtGrpComponent.isFieldOf(tagId) || PositionQtyComponent.isFieldOf(tagId) || PositionAmountDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==PosMaintRptIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(PositionReportMessage(PosMaintRptIDField.decode(myFields.get(PosMaintRptIDField.TagId)).get,
        myFields.get(PosReqIDField.TagId).flatMap(f=>PosReqIDField.decode(f)),
        myFields.get(PosReqTypeField.TagId).flatMap(f=>PosReqTypeField.decode(f)),
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f)),
        myFields.get(TotalNumPosReportsField.TagId).flatMap(f=>TotalNumPosReportsField.decode(f)),
        myFields.get(UnsolicitedIndicatorField.TagId).flatMap(f=>UnsolicitedIndicatorField.decode(f)),
        myFields.get(PosReqResultField.TagId).flatMap(f=>PosReqResultField.decode(f)),
        ClearingBusinessDateField.decode(myFields.get(ClearingBusinessDateField.TagId)).get,
        myFields.get(SettlSessIDField.TagId).flatMap(f=>SettlSessIDField.decode(f)),
        myFields.get(SettlSessSubIDField.TagId).flatMap(f=>SettlSessSubIDField.decode(f)),
        PartiesComponent.decode(flds, startPos).get,
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        InstrumentComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(SettlPriceField.TagId).flatMap(f=>SettlPriceField.decode(f)),
        myFields.get(SettlPriceTypeField.TagId).flatMap(f=>SettlPriceTypeField.decode(f)),
        myFields.get(PriorSettlPriceField.TagId).flatMap(f=>PriorSettlPriceField.decode(f)),
        InstrmtLegGrpComponent.decode(flds, startPos),
        PosUndInstrmtGrpComponent.decode(flds, startPos),
        PositionQtyComponent.decode(flds, startPos),
        PositionAmountDataComponent.decode(flds, startPos),
        myFields.get(RegistStatusField.TagId).flatMap(f=>RegistStatusField.decode(f)),
        myFields.get(DeliveryDateField.TagId).flatMap(f=>DeliveryDateField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(MatchStatusField.TagId).flatMap(f=>MatchStatusField.decode(f)),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f)),
        myFields.get(MessageEventSourceField.TagId).flatMap(f=>MessageEventSourceField.decode(f))))
    } else None
  }

    
}
     