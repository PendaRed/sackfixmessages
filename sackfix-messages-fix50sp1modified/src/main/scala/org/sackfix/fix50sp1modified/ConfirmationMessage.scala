package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class ConfirmationMessage(confirmIDField:ConfirmIDField,
                               confirmRefIDField:Option[ConfirmRefIDField]=None,
                               confirmReqIDField:Option[ConfirmReqIDField]=None,
                               confirmTransTypeField:ConfirmTransTypeField,
                               confirmTypeField:ConfirmTypeField,
                               copyMsgIndicatorField:Option[CopyMsgIndicatorField]=None,
                               legalConfirmField:Option[LegalConfirmField]=None,
                               confirmStatusField:ConfirmStatusField,
                               partiesComponent:Option[PartiesComponent]=None,
                               ordAllocGrpComponent:Option[OrdAllocGrpComponent]=None,
                               allocIDField:Option[AllocIDField]=None,
                               secondaryAllocIDField:Option[SecondaryAllocIDField]=None,
                               individualAllocIDField:Option[IndividualAllocIDField]=None,
                               transactTimeField:TransactTimeField,
                               tradeDateField:TradeDateField,
                               trdRegTimestampsComponent:Option[TrdRegTimestampsComponent]=None,
                               instrumentComponent:InstrumentComponent,
                               instrumentExtensionComponent:Option[InstrumentExtensionComponent]=None,
                               financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                               undInstrmtGrpComponent:UndInstrmtGrpComponent,
                               instrmtLegGrpComponent:InstrmtLegGrpComponent,
                               yieldDataComponent:Option[YieldDataComponent]=None,
                               allocQtyField:AllocQtyField,
                               qtyTypeField:Option[QtyTypeField]=None,
                               sideField:SideField,
                               currencyField:Option[CurrencyField]=None,
                               lastMktField:Option[LastMktField]=None,
                               cpctyConfGrpComponent:CpctyConfGrpComponent,
                               allocAccountField:AllocAccountField,
                               allocAcctIDSourceField:Option[AllocAcctIDSourceField]=None,
                               allocAccountTypeField:Option[AllocAccountTypeField]=None,
                               avgPxField:AvgPxField,
                               avgPxPrecisionField:Option[AvgPxPrecisionField]=None,
                               priceTypeField:Option[PriceTypeField]=None,
                               avgParPxField:Option[AvgParPxField]=None,
                               spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                               reportedPxField:Option[ReportedPxField]=None,
                               textField:Option[TextField]=None,
                               encodedTextLenField:Option[EncodedTextLenField]=None,
                               encodedTextField:Option[EncodedTextField]=None,
                               processCodeField:Option[ProcessCodeField]=None,
                               grossTradeAmtField:GrossTradeAmtField,
                               numDaysInterestField:Option[NumDaysInterestField]=None,
                               exDateField:Option[ExDateField]=None,
                               accruedInterestRateField:Option[AccruedInterestRateField]=None,
                               accruedInterestAmtField:Option[AccruedInterestAmtField]=None,
                               interestAtMaturityField:Option[InterestAtMaturityField]=None,
                               endAccruedInterestAmtField:Option[EndAccruedInterestAmtField]=None,
                               startCashField:Option[StartCashField]=None,
                               endCashField:Option[EndCashField]=None,
                               concessionField:Option[ConcessionField]=None,
                               totalTakedownField:Option[TotalTakedownField]=None,
                               netMoneyField:NetMoneyField,
                               maturityNetMoneyField:Option[MaturityNetMoneyField]=None,
                               settlCurrAmtField:Option[SettlCurrAmtField]=None,
                               settlCurrencyField:Option[SettlCurrencyField]=None,
                               settlCurrFxRateField:Option[SettlCurrFxRateField]=None,
                               settlCurrFxRateCalcField:Option[SettlCurrFxRateCalcField]=None,
                               settlTypeField:Option[SettlTypeField]=None,
                               settlDateField:Option[SettlDateField]=None,
                               settlInstructionsDataComponent:Option[SettlInstructionsDataComponent]=None,
                               commissionDataComponent:Option[CommissionDataComponent]=None,
                               sharedCommissionField:Option[SharedCommissionField]=None,
                               stipulationsComponent:Option[StipulationsComponent]=None,
                               miscFeesGrpComponent:Option[MiscFeesGrpComponent]=None) extends SfFixMessageBody("AK")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,confirmIDField)
    confirmRefIDField.foreach(fmt(b,_))
    confirmReqIDField.foreach(fmt(b,_))
    fmt(b,confirmTransTypeField)
    fmt(b,confirmTypeField)
    copyMsgIndicatorField.foreach(fmt(b,_))
    legalConfirmField.foreach(fmt(b,_))
    fmt(b,confirmStatusField)
    partiesComponent.foreach(fmt(b,_))
    ordAllocGrpComponent.foreach(fmt(b,_))
    allocIDField.foreach(fmt(b,_))
    secondaryAllocIDField.foreach(fmt(b,_))
    individualAllocIDField.foreach(fmt(b,_))
    fmt(b,transactTimeField)
    fmt(b,tradeDateField)
    trdRegTimestampsComponent.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    instrumentExtensionComponent.foreach(fmt(b,_))
    financingDetailsComponent.foreach(fmt(b,_))
    fmt(b,undInstrmtGrpComponent)
    fmt(b,instrmtLegGrpComponent)
    yieldDataComponent.foreach(fmt(b,_))
    fmt(b,allocQtyField)
    qtyTypeField.foreach(fmt(b,_))
    fmt(b,sideField)
    currencyField.foreach(fmt(b,_))
    lastMktField.foreach(fmt(b,_))
    fmt(b,cpctyConfGrpComponent)
    fmt(b,allocAccountField)
    allocAcctIDSourceField.foreach(fmt(b,_))
    allocAccountTypeField.foreach(fmt(b,_))
    fmt(b,avgPxField)
    avgPxPrecisionField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    avgParPxField.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    reportedPxField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    processCodeField.foreach(fmt(b,_))
    fmt(b,grossTradeAmtField)
    numDaysInterestField.foreach(fmt(b,_))
    exDateField.foreach(fmt(b,_))
    accruedInterestRateField.foreach(fmt(b,_))
    accruedInterestAmtField.foreach(fmt(b,_))
    interestAtMaturityField.foreach(fmt(b,_))
    endAccruedInterestAmtField.foreach(fmt(b,_))
    startCashField.foreach(fmt(b,_))
    endCashField.foreach(fmt(b,_))
    concessionField.foreach(fmt(b,_))
    totalTakedownField.foreach(fmt(b,_))
    fmt(b,netMoneyField)
    maturityNetMoneyField.foreach(fmt(b,_))
    settlCurrAmtField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    settlCurrFxRateField.foreach(fmt(b,_))
    settlCurrFxRateCalcField.foreach(fmt(b,_))
    settlTypeField.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    settlInstructionsDataComponent.foreach(fmt(b,_))
    commissionDataComponent.foreach(fmt(b,_))
    sharedCommissionField.foreach(fmt(b,_))
    stipulationsComponent.foreach(fmt(b,_))
    miscFeesGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object ConfirmationMessage extends SfFixMessageDecoder {
  val MsgType="AK"
  val MsgName="Confirmation"
             
  override val MandatoryFields = HashSet[Int](
    ConfirmIDField.TagId, ConfirmTransTypeField.TagId, ConfirmTypeField.TagId, ConfirmStatusField.TagId, TransactTimeField.TagId, 
    TradeDateField.TagId, AllocQtyField.TagId, SideField.TagId, AllocAccountField.TagId, AvgPxField.TagId, 
    GrossTradeAmtField.TagId, NetMoneyField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || OrdAllocGrpComponent.isMandatoryField(tagId) || TrdRegTimestampsComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || 
    InstrumentExtensionComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || 
    YieldDataComponent.isMandatoryField(tagId) || CpctyConfGrpComponent.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || SettlInstructionsDataComponent.isMandatoryField(tagId) || 
    CommissionDataComponent.isMandatoryField(tagId) || StipulationsComponent.isMandatoryField(tagId) || MiscFeesGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ConfirmRefIDField.TagId, ConfirmReqIDField.TagId, CopyMsgIndicatorField.TagId, LegalConfirmField.TagId, AllocIDField.TagId, 
    SecondaryAllocIDField.TagId, IndividualAllocIDField.TagId, QtyTypeField.TagId, CurrencyField.TagId, LastMktField.TagId, 
    AllocAcctIDSourceField.TagId, AllocAccountTypeField.TagId, AvgPxPrecisionField.TagId, PriceTypeField.TagId, AvgParPxField.TagId, 
    ReportedPxField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, ProcessCodeField.TagId, 
    NumDaysInterestField.TagId, ExDateField.TagId, AccruedInterestRateField.TagId, AccruedInterestAmtField.TagId, InterestAtMaturityField.TagId, 
    EndAccruedInterestAmtField.TagId, StartCashField.TagId, EndCashField.TagId, ConcessionField.TagId, TotalTakedownField.TagId, 
    MaturityNetMoneyField.TagId, SettlCurrAmtField.TagId, SettlCurrencyField.TagId, SettlCurrFxRateField.TagId, SettlCurrFxRateCalcField.TagId, 
    SettlTypeField.TagId, SettlDateField.TagId, SharedCommissionField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || OrdAllocGrpComponent.isOptionalField(tagId) || TrdRegTimestampsComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || 
    InstrumentExtensionComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || 
    YieldDataComponent.isOptionalField(tagId) || CpctyConfGrpComponent.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || SettlInstructionsDataComponent.isOptionalField(tagId) || 
    CommissionDataComponent.isOptionalField(tagId) || StipulationsComponent.isOptionalField(tagId) || MiscFeesGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || OrdAllocGrpComponent.isFieldOf(tagId) || TrdRegTimestampsComponent.isFieldOf(tagId) || 
    InstrumentComponent.isFieldOf(tagId) || InstrumentExtensionComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || 
    UndInstrmtGrpComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId) || YieldDataComponent.isFieldOf(tagId) || 
    CpctyConfGrpComponent.isFieldOf(tagId) || SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || SettlInstructionsDataComponent.isFieldOf(tagId) || 
    CommissionDataComponent.isFieldOf(tagId) || StipulationsComponent.isFieldOf(tagId) || MiscFeesGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ConfirmIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ConfirmationMessage(ConfirmIDField.decode(myFields.get(ConfirmIDField.TagId)).get,
        myFields.get(ConfirmRefIDField.TagId).flatMap(f=>ConfirmRefIDField.decode(f)),
        myFields.get(ConfirmReqIDField.TagId).flatMap(f=>ConfirmReqIDField.decode(f)),
        ConfirmTransTypeField.decode(myFields.get(ConfirmTransTypeField.TagId)).get,
        ConfirmTypeField.decode(myFields.get(ConfirmTypeField.TagId)).get,
        myFields.get(CopyMsgIndicatorField.TagId).flatMap(f=>CopyMsgIndicatorField.decode(f)),
        myFields.get(LegalConfirmField.TagId).flatMap(f=>LegalConfirmField.decode(f)),
        ConfirmStatusField.decode(myFields.get(ConfirmStatusField.TagId)).get,
        PartiesComponent.decode(flds, startPos),
        OrdAllocGrpComponent.decode(flds, startPos),
        myFields.get(AllocIDField.TagId).flatMap(f=>AllocIDField.decode(f)),
        myFields.get(SecondaryAllocIDField.TagId).flatMap(f=>SecondaryAllocIDField.decode(f)),
        myFields.get(IndividualAllocIDField.TagId).flatMap(f=>IndividualAllocIDField.decode(f)),
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        TradeDateField.decode(myFields.get(TradeDateField.TagId)).get,
        TrdRegTimestampsComponent.decode(flds, startPos),
        InstrumentComponent.decode(flds, startPos).get,
        InstrumentExtensionComponent.decode(flds, startPos),
        FinancingDetailsComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos).get,
        InstrmtLegGrpComponent.decode(flds, startPos).get,
        YieldDataComponent.decode(flds, startPos),
        AllocQtyField.decode(myFields.get(AllocQtyField.TagId)).get,
        myFields.get(QtyTypeField.TagId).flatMap(f=>QtyTypeField.decode(f)),
        SideField.decode(myFields.get(SideField.TagId)).get,
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(LastMktField.TagId).flatMap(f=>LastMktField.decode(f)),
        CpctyConfGrpComponent.decode(flds, startPos).get,
        AllocAccountField.decode(myFields.get(AllocAccountField.TagId)).get,
        myFields.get(AllocAcctIDSourceField.TagId).flatMap(f=>AllocAcctIDSourceField.decode(f)),
        myFields.get(AllocAccountTypeField.TagId).flatMap(f=>AllocAccountTypeField.decode(f)),
        AvgPxField.decode(myFields.get(AvgPxField.TagId)).get,
        myFields.get(AvgPxPrecisionField.TagId).flatMap(f=>AvgPxPrecisionField.decode(f)),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(AvgParPxField.TagId).flatMap(f=>AvgParPxField.decode(f)),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        myFields.get(ReportedPxField.TagId).flatMap(f=>ReportedPxField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(ProcessCodeField.TagId).flatMap(f=>ProcessCodeField.decode(f)),
        GrossTradeAmtField.decode(myFields.get(GrossTradeAmtField.TagId)).get,
        myFields.get(NumDaysInterestField.TagId).flatMap(f=>NumDaysInterestField.decode(f)),
        myFields.get(ExDateField.TagId).flatMap(f=>ExDateField.decode(f)),
        myFields.get(AccruedInterestRateField.TagId).flatMap(f=>AccruedInterestRateField.decode(f)),
        myFields.get(AccruedInterestAmtField.TagId).flatMap(f=>AccruedInterestAmtField.decode(f)),
        myFields.get(InterestAtMaturityField.TagId).flatMap(f=>InterestAtMaturityField.decode(f)),
        myFields.get(EndAccruedInterestAmtField.TagId).flatMap(f=>EndAccruedInterestAmtField.decode(f)),
        myFields.get(StartCashField.TagId).flatMap(f=>StartCashField.decode(f)),
        myFields.get(EndCashField.TagId).flatMap(f=>EndCashField.decode(f)),
        myFields.get(ConcessionField.TagId).flatMap(f=>ConcessionField.decode(f)),
        myFields.get(TotalTakedownField.TagId).flatMap(f=>TotalTakedownField.decode(f)),
        NetMoneyField.decode(myFields.get(NetMoneyField.TagId)).get,
        myFields.get(MaturityNetMoneyField.TagId).flatMap(f=>MaturityNetMoneyField.decode(f)),
        myFields.get(SettlCurrAmtField.TagId).flatMap(f=>SettlCurrAmtField.decode(f)),
        myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f)),
        myFields.get(SettlCurrFxRateField.TagId).flatMap(f=>SettlCurrFxRateField.decode(f)),
        myFields.get(SettlCurrFxRateCalcField.TagId).flatMap(f=>SettlCurrFxRateCalcField.decode(f)),
        myFields.get(SettlTypeField.TagId).flatMap(f=>SettlTypeField.decode(f)),
        myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
        SettlInstructionsDataComponent.decode(flds, startPos),
        CommissionDataComponent.decode(flds, startPos),
        myFields.get(SharedCommissionField.TagId).flatMap(f=>SharedCommissionField.decode(f)),
        StipulationsComponent.decode(flds, startPos),
        MiscFeesGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     