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
case class CollateralResponseMessage(collRespIDField:CollRespIDField,
                                     collAsgnIDField:Option[CollAsgnIDField]=None,
                                     collReqIDField:Option[CollReqIDField]=None,
                                     collAsgnReasonField:Option[CollAsgnReasonField]=None,
                                     collAsgnTransTypeField:Option[CollAsgnTransTypeField]=None,
                                     collAsgnRespTypeField:CollAsgnRespTypeField,
                                     collAsgnRejectReasonField:Option[CollAsgnRejectReasonField]=None,
                                     transactTimeField:TransactTimeField,
                                     collApplTypeField:Option[CollApplTypeField]=None,
                                     financialStatusField:Option[FinancialStatusField]=None,
                                     clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                     partiesComponent:Option[PartiesComponent]=None,
                                     accountField:Option[AccountField]=None,
                                     accountTypeField:Option[AccountTypeField]=None,
                                     clOrdIDField:Option[ClOrdIDField]=None,
                                     orderIDField:Option[OrderIDField]=None,
                                     secondaryOrderIDField:Option[SecondaryOrderIDField]=None,
                                     secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                                     execCollGrpComponent:Option[ExecCollGrpComponent]=None,
                                     trdCollGrpComponent:Option[TrdCollGrpComponent]=None,
                                     instrumentComponent:Option[InstrumentComponent]=None,
                                     financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                     settlDateField:Option[SettlDateField]=None,
                                     quantityField:Option[QuantityField]=None,
                                     qtyTypeField:Option[QtyTypeField]=None,
                                     currencyField:Option[CurrencyField]=None,
                                     instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                     undInstrmtCollGrpComponent:Option[UndInstrmtCollGrpComponent]=None,
                                     marginExcessField:Option[MarginExcessField]=None,
                                     totalNetValueField:Option[TotalNetValueField]=None,
                                     cashOutstandingField:Option[CashOutstandingField]=None,
                                     trdRegTimestampsComponent:Option[TrdRegTimestampsComponent]=None,
                                     sideField:Option[SideField]=None,
                                     miscFeesGrpComponent:Option[MiscFeesGrpComponent]=None,
                                     priceField:Option[PriceField]=None,
                                     priceTypeField:Option[PriceTypeField]=None,
                                     accruedInterestAmtField:Option[AccruedInterestAmtField]=None,
                                     endAccruedInterestAmtField:Option[EndAccruedInterestAmtField]=None,
                                     startCashField:Option[StartCashField]=None,
                                     endCashField:Option[EndCashField]=None,
                                     spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                                     stipulationsComponent:Option[StipulationsComponent]=None,
                                     textField:Option[TextField]=None,
                                     encodedTextLenField:Option[EncodedTextLenField]=None,
                                     encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("AZ")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,collRespIDField)
    collAsgnIDField.foreach(fmt(b,_))
    collReqIDField.foreach(fmt(b,_))
    collAsgnReasonField.foreach(fmt(b,_))
    collAsgnTransTypeField.foreach(fmt(b,_))
    fmt(b,collAsgnRespTypeField)
    collAsgnRejectReasonField.foreach(fmt(b,_))
    fmt(b,transactTimeField)
    collApplTypeField.foreach(fmt(b,_))
    financialStatusField.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    orderIDField.foreach(fmt(b,_))
    secondaryOrderIDField.foreach(fmt(b,_))
    secondaryClOrdIDField.foreach(fmt(b,_))
    execCollGrpComponent.foreach(fmt(b,_))
    trdCollGrpComponent.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    financingDetailsComponent.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    quantityField.foreach(fmt(b,_))
    qtyTypeField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    undInstrmtCollGrpComponent.foreach(fmt(b,_))
    marginExcessField.foreach(fmt(b,_))
    totalNetValueField.foreach(fmt(b,_))
    cashOutstandingField.foreach(fmt(b,_))
    trdRegTimestampsComponent.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    miscFeesGrpComponent.foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    accruedInterestAmtField.foreach(fmt(b,_))
    endAccruedInterestAmtField.foreach(fmt(b,_))
    startCashField.foreach(fmt(b,_))
    endCashField.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    stipulationsComponent.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object CollateralResponseMessage extends SfFixMessageDecoder {
  val MsgType="AZ"
  val MsgName="CollateralResponse"
             
  override val MandatoryFields = HashSet[Int](
    CollRespIDField.TagId, CollAsgnRespTypeField.TagId, TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || ExecCollGrpComponent.isMandatoryField(tagId) || TrdCollGrpComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || 
    FinancingDetailsComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || UndInstrmtCollGrpComponent.isMandatoryField(tagId) || TrdRegTimestampsComponent.isMandatoryField(tagId) || 
    MiscFeesGrpComponent.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || StipulationsComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    CollAsgnIDField.TagId, CollReqIDField.TagId, CollAsgnReasonField.TagId, CollAsgnTransTypeField.TagId, CollAsgnRejectReasonField.TagId, 
    CollApplTypeField.TagId, FinancialStatusField.TagId, ClearingBusinessDateField.TagId, AccountField.TagId, AccountTypeField.TagId, 
    ClOrdIDField.TagId, OrderIDField.TagId, SecondaryOrderIDField.TagId, SecondaryClOrdIDField.TagId, SettlDateField.TagId, 
    QuantityField.TagId, QtyTypeField.TagId, CurrencyField.TagId, MarginExcessField.TagId, TotalNetValueField.TagId, 
    CashOutstandingField.TagId, SideField.TagId, PriceField.TagId, PriceTypeField.TagId, AccruedInterestAmtField.TagId, 
    EndAccruedInterestAmtField.TagId, StartCashField.TagId, EndCashField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || ExecCollGrpComponent.isOptionalField(tagId) || TrdCollGrpComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || 
    FinancingDetailsComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || UndInstrmtCollGrpComponent.isOptionalField(tagId) || TrdRegTimestampsComponent.isOptionalField(tagId) || 
    MiscFeesGrpComponent.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || StipulationsComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || ExecCollGrpComponent.isFieldOf(tagId) || TrdCollGrpComponent.isFieldOf(tagId) || 
    InstrumentComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId) || 
    UndInstrmtCollGrpComponent.isFieldOf(tagId) || TrdRegTimestampsComponent.isFieldOf(tagId) || MiscFeesGrpComponent.isFieldOf(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || StipulationsComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==CollRespIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(CollateralResponseMessage(CollRespIDField.decode(myFields.get(CollRespIDField.TagId)).get,
        myFields.get(CollAsgnIDField.TagId).flatMap(f=>CollAsgnIDField.decode(f)),
        myFields.get(CollReqIDField.TagId).flatMap(f=>CollReqIDField.decode(f)),
        myFields.get(CollAsgnReasonField.TagId).flatMap(f=>CollAsgnReasonField.decode(f)),
        myFields.get(CollAsgnTransTypeField.TagId).flatMap(f=>CollAsgnTransTypeField.decode(f)),
        CollAsgnRespTypeField.decode(myFields.get(CollAsgnRespTypeField.TagId)).get,
        myFields.get(CollAsgnRejectReasonField.TagId).flatMap(f=>CollAsgnRejectReasonField.decode(f)),
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        myFields.get(CollApplTypeField.TagId).flatMap(f=>CollApplTypeField.decode(f)),
        myFields.get(FinancialStatusField.TagId).flatMap(f=>FinancialStatusField.decode(f)),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        myFields.get(SecondaryOrderIDField.TagId).flatMap(f=>SecondaryOrderIDField.decode(f)),
        myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
        ExecCollGrpComponent.decode(flds, startPos),
        TrdCollGrpComponent.decode(flds, startPos),
        InstrumentComponent.decode(flds, startPos),
        FinancingDetailsComponent.decode(flds, startPos),
        myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
        myFields.get(QuantityField.TagId).flatMap(f=>QuantityField.decode(f)),
        myFields.get(QtyTypeField.TagId).flatMap(f=>QtyTypeField.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        InstrmtLegGrpComponent.decode(flds, startPos),
        UndInstrmtCollGrpComponent.decode(flds, startPos),
        myFields.get(MarginExcessField.TagId).flatMap(f=>MarginExcessField.decode(f)),
        myFields.get(TotalNetValueField.TagId).flatMap(f=>TotalNetValueField.decode(f)),
        myFields.get(CashOutstandingField.TagId).flatMap(f=>CashOutstandingField.decode(f)),
        TrdRegTimestampsComponent.decode(flds, startPos),
        myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
        MiscFeesGrpComponent.decode(flds, startPos),
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(AccruedInterestAmtField.TagId).flatMap(f=>AccruedInterestAmtField.decode(f)),
        myFields.get(EndAccruedInterestAmtField.TagId).flatMap(f=>EndAccruedInterestAmtField.decode(f)),
        myFields.get(StartCashField.TagId).flatMap(f=>StartCashField.decode(f)),
        myFields.get(EndCashField.TagId).flatMap(f=>EndCashField.decode(f)),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        StipulationsComponent.decode(flds, startPos),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     