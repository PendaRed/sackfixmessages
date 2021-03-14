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
case class QuoteResponseMessage(quoteRespIDField:QuoteRespIDField,
                                quoteIDField:Option[QuoteIDField]=None,
                                quoteMsgIDField:Option[QuoteMsgIDField]=None,
                                quoteRespTypeField:QuoteRespTypeField,
                                clOrdIDField:Option[ClOrdIDField]=None,
                                orderCapacityField:Option[OrderCapacityField]=None,
                                orderRestrictionsField:Option[OrderRestrictionsField]=None,
                                iOIIDField:Option[IOIIDField]=None,
                                quoteTypeField:Option[QuoteTypeField]=None,
                                preTradeAnonymityField:Option[PreTradeAnonymityField]=None,
                                quotQualGrpComponent:Option[QuotQualGrpComponent]=None,
                                partiesComponent:Option[PartiesComponent]=None,
                                tradingSessionIDField:Option[TradingSessionIDField]=None,
                                tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                instrumentComponent:InstrumentComponent,
                                financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                sideField:Option[SideField]=None,
                                orderQtyDataComponent:Option[OrderQtyDataComponent]=None,
                                minQtyField:Option[MinQtyField]=None,
                                settlTypeField:Option[SettlTypeField]=None,
                                settlDateField:Option[SettlDateField]=None,
                                settlDate2Field:Option[SettlDate2Field]=None,
                                orderQty2Field:Option[OrderQty2Field]=None,
                                currencyField:Option[CurrencyField]=None,
                                stipulationsComponent:Option[StipulationsComponent]=None,
                                accountField:Option[AccountField]=None,
                                acctIDSourceField:Option[AcctIDSourceField]=None,
                                accountTypeField:Option[AccountTypeField]=None,
                                legQuotGrpComponent:Option[LegQuotGrpComponent]=None,
                                bidPxField:Option[BidPxField]=None,
                                offerPxField:Option[OfferPxField]=None,
                                mktBidPxField:Option[MktBidPxField]=None,
                                mktOfferPxField:Option[MktOfferPxField]=None,
                                minBidSizeField:Option[MinBidSizeField]=None,
                                bidSizeField:Option[BidSizeField]=None,
                                minOfferSizeField:Option[MinOfferSizeField]=None,
                                offerSizeField:Option[OfferSizeField]=None,
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
                                commissionField:Option[CommissionField]=None,
                                commTypeField:Option[CommTypeField]=None,
                                custOrderCapacityField:Option[CustOrderCapacityField]=None,
                                exDestinationField:Option[ExDestinationField]=None,
                                exDestinationIDSourceField:Option[ExDestinationIDSourceField]=None,
                                textField:Option[TextField]=None,
                                encodedTextLenField:Option[EncodedTextLenField]=None,
                                encodedTextField:Option[EncodedTextField]=None,
                                priceField:Option[PriceField]=None,
                                priceTypeField:Option[PriceTypeField]=None,
                                spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                                yieldDataComponent:Option[YieldDataComponent]=None) extends SfFixMessageBody("AJ")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,quoteRespIDField)
    quoteIDField.foreach(fmt(b,_))
    quoteMsgIDField.foreach(fmt(b,_))
    fmt(b,quoteRespTypeField)
    clOrdIDField.foreach(fmt(b,_))
    orderCapacityField.foreach(fmt(b,_))
    orderRestrictionsField.foreach(fmt(b,_))
    iOIIDField.foreach(fmt(b,_))
    quoteTypeField.foreach(fmt(b,_))
    preTradeAnonymityField.foreach(fmt(b,_))
    quotQualGrpComponent.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    financingDetailsComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    orderQtyDataComponent.foreach(fmt(b,_))
    minQtyField.foreach(fmt(b,_))
    settlTypeField.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    settlDate2Field.foreach(fmt(b,_))
    orderQty2Field.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    stipulationsComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    legQuotGrpComponent.foreach(fmt(b,_))
    bidPxField.foreach(fmt(b,_))
    offerPxField.foreach(fmt(b,_))
    mktBidPxField.foreach(fmt(b,_))
    mktOfferPxField.foreach(fmt(b,_))
    minBidSizeField.foreach(fmt(b,_))
    bidSizeField.foreach(fmt(b,_))
    minOfferSizeField.foreach(fmt(b,_))
    offerSizeField.foreach(fmt(b,_))
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
    commissionField.foreach(fmt(b,_))
    commTypeField.foreach(fmt(b,_))
    custOrderCapacityField.foreach(fmt(b,_))
    exDestinationField.foreach(fmt(b,_))
    exDestinationIDSourceField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    yieldDataComponent.foreach(fmt(b,_))
    b
  }

}
     
object QuoteResponseMessage extends SfFixMessageDecoder {
  val MsgType="AJ"
  val MsgName="QuoteResponse"
             
  override val MandatoryFields = HashSet[Int](
    QuoteRespIDField.TagId, QuoteRespTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    QuotQualGrpComponent.isMandatoryField(tagId) || PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || 
    UndInstrmtGrpComponent.isMandatoryField(tagId) || OrderQtyDataComponent.isMandatoryField(tagId) || StipulationsComponent.isMandatoryField(tagId) || LegQuotGrpComponent.isMandatoryField(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    QuoteIDField.TagId, QuoteMsgIDField.TagId, ClOrdIDField.TagId, OrderCapacityField.TagId, OrderRestrictionsField.TagId, 
    IOIIDField.TagId, QuoteTypeField.TagId, PreTradeAnonymityField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, 
    SideField.TagId, MinQtyField.TagId, SettlTypeField.TagId, SettlDateField.TagId, SettlDate2Field.TagId, 
    OrderQty2Field.TagId, CurrencyField.TagId, AccountField.TagId, AcctIDSourceField.TagId, AccountTypeField.TagId, 
    BidPxField.TagId, OfferPxField.TagId, MktBidPxField.TagId, MktOfferPxField.TagId, MinBidSizeField.TagId, 
    BidSizeField.TagId, MinOfferSizeField.TagId, OfferSizeField.TagId, ValidUntilTimeField.TagId, BidSpotRateField.TagId, 
    OfferSpotRateField.TagId, BidForwardPointsField.TagId, OfferForwardPointsField.TagId, MidPxField.TagId, BidYieldField.TagId, 
    MidYieldField.TagId, OfferYieldField.TagId, TransactTimeField.TagId, OrdTypeField.TagId, BidForwardPoints2Field.TagId, 
    OfferForwardPoints2Field.TagId, SettlCurrBidFxRateField.TagId, SettlCurrOfferFxRateField.TagId, SettlCurrFxRateCalcField.TagId, CommissionField.TagId, 
    CommTypeField.TagId, CustOrderCapacityField.TagId, ExDestinationField.TagId, ExDestinationIDSourceField.TagId, TextField.TagId, 
    EncodedTextLenField.TagId, EncodedTextField.TagId, PriceField.TagId, PriceTypeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    QuotQualGrpComponent.isOptionalField(tagId) || PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || 
    UndInstrmtGrpComponent.isOptionalField(tagId) || OrderQtyDataComponent.isOptionalField(tagId) || StipulationsComponent.isOptionalField(tagId) || LegQuotGrpComponent.isOptionalField(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    QuotQualGrpComponent.isFieldOf(tagId) || PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || 
    FinancingDetailsComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || OrderQtyDataComponent.isFieldOf(tagId) || 
    StipulationsComponent.isFieldOf(tagId) || LegQuotGrpComponent.isFieldOf(tagId) || SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || 
    YieldDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteRespIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(QuoteResponseMessage(QuoteRespIDField.decode(myFields.get(QuoteRespIDField.TagId)).get,
        myFields.get(QuoteIDField.TagId).flatMap(f=>QuoteIDField.decode(f)),
        myFields.get(QuoteMsgIDField.TagId).flatMap(f=>QuoteMsgIDField.decode(f)),
        QuoteRespTypeField.decode(myFields.get(QuoteRespTypeField.TagId)).get,
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        myFields.get(OrderCapacityField.TagId).flatMap(f=>OrderCapacityField.decode(f)),
        myFields.get(OrderRestrictionsField.TagId).flatMap(f=>OrderRestrictionsField.decode(f)),
        myFields.get(IOIIDField.TagId).flatMap(f=>IOIIDField.decode(f)),
        myFields.get(QuoteTypeField.TagId).flatMap(f=>QuoteTypeField.decode(f)),
        myFields.get(PreTradeAnonymityField.TagId).flatMap(f=>PreTradeAnonymityField.decode(f)),
        QuotQualGrpComponent.decode(flds, startPos),
        PartiesComponent.decode(flds, startPos),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        FinancingDetailsComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
        OrderQtyDataComponent.decode(flds, startPos),
        myFields.get(MinQtyField.TagId).flatMap(f=>MinQtyField.decode(f)),
        myFields.get(SettlTypeField.TagId).flatMap(f=>SettlTypeField.decode(f)),
        myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
        myFields.get(SettlDate2Field.TagId).flatMap(f=>SettlDate2Field.decode(f)),
        myFields.get(OrderQty2Field.TagId).flatMap(f=>OrderQty2Field.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        StipulationsComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        LegQuotGrpComponent.decode(flds, startPos),
        myFields.get(BidPxField.TagId).flatMap(f=>BidPxField.decode(f)),
        myFields.get(OfferPxField.TagId).flatMap(f=>OfferPxField.decode(f)),
        myFields.get(MktBidPxField.TagId).flatMap(f=>MktBidPxField.decode(f)),
        myFields.get(MktOfferPxField.TagId).flatMap(f=>MktOfferPxField.decode(f)),
        myFields.get(MinBidSizeField.TagId).flatMap(f=>MinBidSizeField.decode(f)),
        myFields.get(BidSizeField.TagId).flatMap(f=>BidSizeField.decode(f)),
        myFields.get(MinOfferSizeField.TagId).flatMap(f=>MinOfferSizeField.decode(f)),
        myFields.get(OfferSizeField.TagId).flatMap(f=>OfferSizeField.decode(f)),
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
        myFields.get(CommissionField.TagId).flatMap(f=>CommissionField.decode(f)),
        myFields.get(CommTypeField.TagId).flatMap(f=>CommTypeField.decode(f)),
        myFields.get(CustOrderCapacityField.TagId).flatMap(f=>CustOrderCapacityField.decode(f)),
        myFields.get(ExDestinationField.TagId).flatMap(f=>ExDestinationField.decode(f)),
        myFields.get(ExDestinationIDSourceField.TagId).flatMap(f=>ExDestinationIDSourceField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        YieldDataComponent.decode(flds, startPos)))
    } else None
  }

    
}
     