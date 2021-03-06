package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class RequestForPositionsAckMessage(posMaintRptIDField:PosMaintRptIDField,
                                         posReqIDField:Option[PosReqIDField]=None,
                                         totalNumPosReportsField:Option[TotalNumPosReportsField]=None,
                                         unsolicitedIndicatorField:Option[UnsolicitedIndicatorField]=None,
                                         posReqResultField:PosReqResultField,
                                         posReqStatusField:PosReqStatusField,
                                         posReqTypeField:Option[PosReqTypeField]=None,
                                         matchStatusField:Option[MatchStatusField]=None,
                                         clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                         subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None,
                                         settlSessIDField:Option[SettlSessIDField]=None,
                                         settlSessSubIDField:Option[SettlSessSubIDField]=None,
                                         settlCurrencyField:Option[SettlCurrencyField]=None,
                                         partiesComponent:PartiesComponent,
                                         accountField:Option[AccountField]=None,
                                         acctIDSourceField:Option[AcctIDSourceField]=None,
                                         accountTypeField:Option[AccountTypeField]=None,
                                         instrumentComponent:Option[InstrumentComponent]=None,
                                         currencyField:Option[CurrencyField]=None,
                                         instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                         undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                         responseTransportTypeField:Option[ResponseTransportTypeField]=None,
                                         responseDestinationField:Option[ResponseDestinationField]=None,
                                         textField:Option[TextField]=None,
                                         encodedTextLenField:Option[EncodedTextLenField]=None,
                                         encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("AO")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,posMaintRptIDField)
    posReqIDField.foreach(fmt(b,_))
    totalNumPosReportsField.foreach(fmt(b,_))
    unsolicitedIndicatorField.foreach(fmt(b,_))
    fmt(b,posReqResultField)
    fmt(b,posReqStatusField)
    posReqTypeField.foreach(fmt(b,_))
    matchStatusField.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    subscriptionRequestTypeField.foreach(fmt(b,_))
    settlSessIDField.foreach(fmt(b,_))
    settlSessSubIDField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    fmt(b,partiesComponent)
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    responseTransportTypeField.foreach(fmt(b,_))
    responseDestinationField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object RequestForPositionsAckMessage extends SfFixMessageDecoder {
  val MsgType="AO"
  val MsgName="RequestForPositionsAck"
             
  override val MandatoryFields = HashSet[Int](
    PosMaintRptIDField.TagId, PosReqResultField.TagId, PosReqStatusField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    PosReqIDField.TagId, TotalNumPosReportsField.TagId, UnsolicitedIndicatorField.TagId, PosReqTypeField.TagId, MatchStatusField.TagId, 
    ClearingBusinessDateField.TagId, SubscriptionRequestTypeField.TagId, SettlSessIDField.TagId, SettlSessSubIDField.TagId, SettlCurrencyField.TagId, 
    AccountField.TagId, AcctIDSourceField.TagId, AccountTypeField.TagId, CurrencyField.TagId, ResponseTransportTypeField.TagId, 
    ResponseDestinationField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId) || 
    UndInstrmtGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==PosMaintRptIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(RequestForPositionsAckMessage(PosMaintRptIDField.decode(myFields.get(PosMaintRptIDField.TagId)).get,
        myFields.get(PosReqIDField.TagId).flatMap(f=>PosReqIDField.decode(f)),
        myFields.get(TotalNumPosReportsField.TagId).flatMap(f=>TotalNumPosReportsField.decode(f)),
        myFields.get(UnsolicitedIndicatorField.TagId).flatMap(f=>UnsolicitedIndicatorField.decode(f)),
        PosReqResultField.decode(myFields.get(PosReqResultField.TagId)).get,
        PosReqStatusField.decode(myFields.get(PosReqStatusField.TagId)).get,
        myFields.get(PosReqTypeField.TagId).flatMap(f=>PosReqTypeField.decode(f)),
        myFields.get(MatchStatusField.TagId).flatMap(f=>MatchStatusField.decode(f)),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f)),
        myFields.get(SettlSessIDField.TagId).flatMap(f=>SettlSessIDField.decode(f)),
        myFields.get(SettlSessSubIDField.TagId).flatMap(f=>SettlSessSubIDField.decode(f)),
        myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f)),
        PartiesComponent.decode(flds, startPos).get,
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        InstrumentComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        InstrmtLegGrpComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        myFields.get(ResponseTransportTypeField.TagId).flatMap(f=>ResponseTransportTypeField.decode(f)),
        myFields.get(ResponseDestinationField.TagId).flatMap(f=>ResponseDestinationField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     