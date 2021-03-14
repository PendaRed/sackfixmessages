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
case class QuoteStatusReportMessage(quoteStatusReqIDField:Option[QuoteStatusReqIDField]=None,
                                    quoteReqIDField:Option[QuoteReqIDField]=None,
                                    quoteIDField:Option[QuoteIDField]=None,
                                    quoteMsgIDField:Option[QuoteMsgIDField]=None,
                                    quoteRespIDField:Option[QuoteRespIDField]=None,
                                    quoteTypeField:Option[QuoteTypeField]=None,
                                    quoteCancelTypeField:Option[QuoteCancelTypeField]=None,
                                    partiesComponent:Option[PartiesComponent]=None,
                                    targetPartiesComponent:Option[TargetPartiesComponent]=None,
                                    tradingSessionIDField:Option[TradingSessionIDField]=None,
                                    tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                    instrumentComponent:Option[InstrumentComponent]=None,
                                    financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                    undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                    sideField:Option[SideField]=None,
                                    orderQtyDataComponent:Option[OrderQtyDataComponent]=None,
                                    settlTypeField:Option[SettlTypeField]=None,
                                    settlDateField:Option[SettlDateField]=None,
                                    settlDate2Field:Option[SettlDate2Field]=None,
                                    orderQty2Field:Option[OrderQty2Field]=None,
                                    currencyField:Option[CurrencyField]=None,
                                    stipulationsComponent:Option[StipulationsComponent]=None,
                                    accountField:Option[AccountField]=None,
                                    acctIDSourceField:Option[AcctIDSourceField]=None,
                                    accountTypeField:Option[AccountTypeField]=None,
                                    legQuotStatGrpComponent:Option[LegQuotStatGrpComponent]=None,
                                    quotQualGrpComponent:Option[QuotQualGrpComponent]=None,
                                    expireTimeField:Option[ExpireTimeField]=None,
                                    priceField:Option[PriceField]=None,
                                    priceTypeField:Option[PriceTypeField]=None,
                                    spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                                    yieldDataComponent:Option[YieldDataComponent]=None,
                                    bidPxField:Option[BidPxField]=None,
                                    offerPxField:Option[OfferPxField]=None,
                                    mktBidPxField:Option[MktBidPxField]=None,
                                    mktOfferPxField:Option[MktOfferPxField]=None,
                                    minBidSizeField:Option[MinBidSizeField]=None,
                                    bidSizeField:Option[BidSizeField]=None,
                                    minOfferSizeField:Option[MinOfferSizeField]=None,
                                    offerSizeField:Option[OfferSizeField]=None,
                                    minQtyField:Option[MinQtyField]=None,
                                    validUntilTimeField:Option[ValidUntilTimeField]=None,
                                    bidSpotRateField:Option[BidSpotRateField]=None,
                                    offerSpotRateField:Option[OfferSpotRateField]=None,
                                    bidForwardPointsField:Option[BidForwardPointsField]=None,
                                    offerForwardPointsField:Option[OfferForwardPointsField]=None,
                                    midPxField:Option[MidPxField]=None,
                                    bidYieldField:Option[BidYieldField]=None,
                                    midYieldField:Option[MidYieldField]=None,
                                    offerYieldField:Option[OfferYieldField]=None,
                                    transactTimeField:Option[TransactTimeField]=None,
                                    ordTypeField:Option[OrdTypeField]=None,
                                    bidForwardPoints2Field:Option[BidForwardPoints2Field]=None,
                                    offerForwardPoints2Field:Option[OfferForwardPoints2Field]=None,
                                    settlCurrBidFxRateField:Option[SettlCurrBidFxRateField]=None,
                                    settlCurrOfferFxRateField:Option[SettlCurrOfferFxRateField]=None,
                                    settlCurrFxRateCalcField:Option[SettlCurrFxRateCalcField]=None,
                                    commTypeField:Option[CommTypeField]=None,
                                    commissionField:Option[CommissionField]=None,
                                    custOrderCapacityField:Option[CustOrderCapacityField]=None,
                                    exDestinationField:Option[ExDestinationField]=None,
                                    exDestinationIDSourceField:Option[ExDestinationIDSourceField]=None,
                                    bookingTypeField:Option[BookingTypeField]=None,
                                    orderCapacityField:Option[OrderCapacityField]=None,
                                    orderRestrictionsField:Option[OrderRestrictionsField]=None,
                                    quoteStatusField:Option[QuoteStatusField]=None,
                                    quoteRejectReasonField:Option[QuoteRejectReasonField]=None,
                                    textField:Option[TextField]=None,
                                    encodedTextLenField:Option[EncodedTextLenField]=None,
                                    encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("AI")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    quoteStatusReqIDField.foreach(fmt(b,_))
    quoteReqIDField.foreach(fmt(b,_))
    quoteIDField.foreach(fmt(b,_))
    quoteMsgIDField.foreach(fmt(b,_))
    quoteRespIDField.foreach(fmt(b,_))
    quoteTypeField.foreach(fmt(b,_))
    quoteCancelTypeField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    targetPartiesComponent.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    financingDetailsComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    orderQtyDataComponent.foreach(fmt(b,_))
    settlTypeField.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    settlDate2Field.foreach(fmt(b,_))
    orderQty2Field.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    stipulationsComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    legQuotStatGrpComponent.foreach(fmt(b,_))
    quotQualGrpComponent.foreach(fmt(b,_))
    expireTimeField.foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    yieldDataComponent.foreach(fmt(b,_))
    bidPxField.foreach(fmt(b,_))
    offerPxField.foreach(fmt(b,_))
    mktBidPxField.foreach(fmt(b,_))
    mktOfferPxField.foreach(fmt(b,_))
    minBidSizeField.foreach(fmt(b,_))
    bidSizeField.foreach(fmt(b,_))
    minOfferSizeField.foreach(fmt(b,_))
    offerSizeField.foreach(fmt(b,_))
    minQtyField.foreach(fmt(b,_))
    validUntilTimeField.foreach(fmt(b,_))
    bidSpotRateField.foreach(fmt(b,_))
    offerSpotRateField.foreach(fmt(b,_))
    bidForwardPointsField.foreach(fmt(b,_))
    offerForwardPointsField.foreach(fmt(b,_))
    midPxField.foreach(fmt(b,_))
    bidYieldField.foreach(fmt(b,_))
    midYieldField.foreach(fmt(b,_))
    offerYieldField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    ordTypeField.foreach(fmt(b,_))
    bidForwardPoints2Field.foreach(fmt(b,_))
    offerForwardPoints2Field.foreach(fmt(b,_))
    settlCurrBidFxRateField.foreach(fmt(b,_))
    settlCurrOfferFxRateField.foreach(fmt(b,_))
    settlCurrFxRateCalcField.foreach(fmt(b,_))
    commTypeField.foreach(fmt(b,_))
    commissionField.foreach(fmt(b,_))
    custOrderCapacityField.foreach(fmt(b,_))
    exDestinationField.foreach(fmt(b,_))
    exDestinationIDSourceField.foreach(fmt(b,_))
    bookingTypeField.foreach(fmt(b,_))
    orderCapacityField.foreach(fmt(b,_))
    orderRestrictionsField.foreach(fmt(b,_))
    quoteStatusField.foreach(fmt(b,_))
    quoteRejectReasonField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object QuoteStatusReportMessage extends SfFixMessageDecoder {
  val MsgType="AI"
  val MsgName="QuoteStatusReport"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || TargetPartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || 
    UndInstrmtGrpComponent.isMandatoryField(tagId) || OrderQtyDataComponent.isMandatoryField(tagId) || StipulationsComponent.isMandatoryField(tagId) || LegQuotStatGrpComponent.isMandatoryField(tagId) || 
    QuotQualGrpComponent.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    QuoteStatusReqIDField.TagId, QuoteReqIDField.TagId, QuoteIDField.TagId, QuoteMsgIDField.TagId, QuoteRespIDField.TagId, 
    QuoteTypeField.TagId, QuoteCancelTypeField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, SideField.TagId, 
    SettlTypeField.TagId, SettlDateField.TagId, SettlDate2Field.TagId, OrderQty2Field.TagId, CurrencyField.TagId, 
    AccountField.TagId, AcctIDSourceField.TagId, AccountTypeField.TagId, ExpireTimeField.TagId, PriceField.TagId, 
    PriceTypeField.TagId, BidPxField.TagId, OfferPxField.TagId, MktBidPxField.TagId, MktOfferPxField.TagId, 
    MinBidSizeField.TagId, BidSizeField.TagId, MinOfferSizeField.TagId, OfferSizeField.TagId, MinQtyField.TagId, 
    ValidUntilTimeField.TagId, BidSpotRateField.TagId, OfferSpotRateField.TagId, BidForwardPointsField.TagId, OfferForwardPointsField.TagId, 
    MidPxField.TagId, BidYieldField.TagId, MidYieldField.TagId, OfferYieldField.TagId, TransactTimeField.TagId, 
    OrdTypeField.TagId, BidForwardPoints2Field.TagId, OfferForwardPoints2Field.TagId, SettlCurrBidFxRateField.TagId, SettlCurrOfferFxRateField.TagId, 
    SettlCurrFxRateCalcField.TagId, CommTypeField.TagId, CommissionField.TagId, CustOrderCapacityField.TagId, ExDestinationField.TagId, 
    ExDestinationIDSourceField.TagId, BookingTypeField.TagId, OrderCapacityField.TagId, OrderRestrictionsField.TagId, QuoteStatusField.TagId, 
    QuoteRejectReasonField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || TargetPartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || 
    UndInstrmtGrpComponent.isOptionalField(tagId) || OrderQtyDataComponent.isOptionalField(tagId) || StipulationsComponent.isOptionalField(tagId) || LegQuotStatGrpComponent.isOptionalField(tagId) || 
    QuotQualGrpComponent.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || TargetPartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || 
    FinancingDetailsComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || OrderQtyDataComponent.isFieldOf(tagId) || 
    StipulationsComponent.isFieldOf(tagId) || LegQuotStatGrpComponent.isFieldOf(tagId) || QuotQualGrpComponent.isFieldOf(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || YieldDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteStatusReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(QuoteStatusReportMessage(myFields.get(QuoteStatusReqIDField.TagId).flatMap(f=>QuoteStatusReqIDField.decode(f)),
        myFields.get(QuoteReqIDField.TagId).flatMap(f=>QuoteReqIDField.decode(f)),
        myFields.get(QuoteIDField.TagId).flatMap(f=>QuoteIDField.decode(f)),
        myFields.get(QuoteMsgIDField.TagId).flatMap(f=>QuoteMsgIDField.decode(f)),
        myFields.get(QuoteRespIDField.TagId).flatMap(f=>QuoteRespIDField.decode(f)),
        myFields.get(QuoteTypeField.TagId).flatMap(f=>QuoteTypeField.decode(f)),
        myFields.get(QuoteCancelTypeField.TagId).flatMap(f=>QuoteCancelTypeField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        TargetPartiesComponent.decode(flds, startPos),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos),
        FinancingDetailsComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
        OrderQtyDataComponent.decode(flds, startPos),
        myFields.get(SettlTypeField.TagId).flatMap(f=>SettlTypeField.decode(f)),
        myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
        myFields.get(SettlDate2Field.TagId).flatMap(f=>SettlDate2Field.decode(f)),
        myFields.get(OrderQty2Field.TagId).flatMap(f=>OrderQty2Field.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        StipulationsComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        LegQuotStatGrpComponent.decode(flds, startPos),
        QuotQualGrpComponent.decode(flds, startPos),
        myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        YieldDataComponent.decode(flds, startPos),
        myFields.get(BidPxField.TagId).flatMap(f=>BidPxField.decode(f)),
        myFields.get(OfferPxField.TagId).flatMap(f=>OfferPxField.decode(f)),
        myFields.get(MktBidPxField.TagId).flatMap(f=>MktBidPxField.decode(f)),
        myFields.get(MktOfferPxField.TagId).flatMap(f=>MktOfferPxField.decode(f)),
        myFields.get(MinBidSizeField.TagId).flatMap(f=>MinBidSizeField.decode(f)),
        myFields.get(BidSizeField.TagId).flatMap(f=>BidSizeField.decode(f)),
        myFields.get(MinOfferSizeField.TagId).flatMap(f=>MinOfferSizeField.decode(f)),
        myFields.get(OfferSizeField.TagId).flatMap(f=>OfferSizeField.decode(f)),
        myFields.get(MinQtyField.TagId).flatMap(f=>MinQtyField.decode(f)),
        myFields.get(ValidUntilTimeField.TagId).flatMap(f=>ValidUntilTimeField.decode(f)),
        myFields.get(BidSpotRateField.TagId).flatMap(f=>BidSpotRateField.decode(f)),
        myFields.get(OfferSpotRateField.TagId).flatMap(f=>OfferSpotRateField.decode(f)),
        myFields.get(BidForwardPointsField.TagId).flatMap(f=>BidForwardPointsField.decode(f)),
        myFields.get(OfferForwardPointsField.TagId).flatMap(f=>OfferForwardPointsField.decode(f)),
        myFields.get(MidPxField.TagId).flatMap(f=>MidPxField.decode(f)),
        myFields.get(BidYieldField.TagId).flatMap(f=>BidYieldField.decode(f)),
        myFields.get(MidYieldField.TagId).flatMap(f=>MidYieldField.decode(f)),
        myFields.get(OfferYieldField.TagId).flatMap(f=>OfferYieldField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(OrdTypeField.TagId).flatMap(f=>OrdTypeField.decode(f)),
        myFields.get(BidForwardPoints2Field.TagId).flatMap(f=>BidForwardPoints2Field.decode(f)),
        myFields.get(OfferForwardPoints2Field.TagId).flatMap(f=>OfferForwardPoints2Field.decode(f)),
        myFields.get(SettlCurrBidFxRateField.TagId).flatMap(f=>SettlCurrBidFxRateField.decode(f)),
        myFields.get(SettlCurrOfferFxRateField.TagId).flatMap(f=>SettlCurrOfferFxRateField.decode(f)),
        myFields.get(SettlCurrFxRateCalcField.TagId).flatMap(f=>SettlCurrFxRateCalcField.decode(f)),
        myFields.get(CommTypeField.TagId).flatMap(f=>CommTypeField.decode(f)),
        myFields.get(CommissionField.TagId).flatMap(f=>CommissionField.decode(f)),
        myFields.get(CustOrderCapacityField.TagId).flatMap(f=>CustOrderCapacityField.decode(f)),
        myFields.get(ExDestinationField.TagId).flatMap(f=>ExDestinationField.decode(f)),
        myFields.get(ExDestinationIDSourceField.TagId).flatMap(f=>ExDestinationIDSourceField.decode(f)),
        myFields.get(BookingTypeField.TagId).flatMap(f=>BookingTypeField.decode(f)),
        myFields.get(OrderCapacityField.TagId).flatMap(f=>OrderCapacityField.decode(f)),
        myFields.get(OrderRestrictionsField.TagId).flatMap(f=>OrderRestrictionsField.decode(f)),
        myFields.get(QuoteStatusField.TagId).flatMap(f=>QuoteStatusField.decode(f)),
        myFields.get(QuoteRejectReasonField.TagId).flatMap(f=>QuoteRejectReasonField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     