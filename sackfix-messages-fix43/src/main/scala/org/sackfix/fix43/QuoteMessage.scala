package org.sackfix.fix43

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX43.xml
  */
case class QuoteMessage(quoteReqIDField:Option[QuoteReqIDField]=None,
                        quoteIDField:QuoteIDField,
                        quoteTypeField:Option[QuoteTypeField]=None,
                        quoteResponseLevelField:Option[QuoteResponseLevelField]=None,
                        partiesComponent:Option[PartiesComponent]=None,
                        accountField:Option[AccountField]=None,
                        accountTypeField:Option[AccountTypeField]=None,
                        tradingSessionIDField:Option[TradingSessionIDField]=None,
                        tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                        instrumentComponent:InstrumentComponent,
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
                        settlmntTypField:Option[SettlmntTypField]=None,
                        futSettDateField:Option[FutSettDateField]=None,
                        ordTypeField:Option[OrdTypeField]=None,
                        futSettDate2Field:Option[FutSettDate2Field]=None,
                        orderQty2Field:Option[OrderQty2Field]=None,
                        bidForwardPoints2Field:Option[BidForwardPoints2Field]=None,
                        offerForwardPoints2Field:Option[OfferForwardPoints2Field]=None,
                        currencyField:Option[CurrencyField]=None,
                        settlCurrBidFxRateField:Option[SettlCurrBidFxRateField]=None,
                        settlCurrOfferFxRateField:Option[SettlCurrOfferFxRateField]=None,
                        settlCurrFxRateCalcField:Option[SettlCurrFxRateCalcField]=None,
                        commTypeField:Option[CommTypeField]=None,
                        commissionField:Option[CommissionField]=None,
                        custOrderCapacityField:Option[CustOrderCapacityField]=None,
                        exDestinationField:Option[ExDestinationField]=None,
                        textField:Option[TextField]=None,
                        encodedTextLenField:Option[EncodedTextLenField]=None,
                        encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("S")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    quoteReqIDField.foreach(fmt(b,_))
    fmt(b,quoteIDField)
    quoteTypeField.foreach(fmt(b,_))
    quoteResponseLevelField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
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
    settlmntTypField.foreach(fmt(b,_))
    futSettDateField.foreach(fmt(b,_))
    ordTypeField.foreach(fmt(b,_))
    futSettDate2Field.foreach(fmt(b,_))
    orderQty2Field.foreach(fmt(b,_))
    bidForwardPoints2Field.foreach(fmt(b,_))
    offerForwardPoints2Field.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    settlCurrBidFxRateField.foreach(fmt(b,_))
    settlCurrOfferFxRateField.foreach(fmt(b,_))
    settlCurrFxRateCalcField.foreach(fmt(b,_))
    commTypeField.foreach(fmt(b,_))
    commissionField.foreach(fmt(b,_))
    custOrderCapacityField.foreach(fmt(b,_))
    exDestinationField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object QuoteMessage extends SfFixMessageDecoder {
  val MsgType="S"
  val MsgName="Quote"
             
  override val MandatoryFields = HashSet[Int](
    QuoteIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    QuoteReqIDField.TagId, QuoteTypeField.TagId, QuoteResponseLevelField.TagId, AccountField.TagId, AccountTypeField.TagId, 
    TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, BidPxField.TagId, OfferPxField.TagId, MktBidPxField.TagId, 
    MktOfferPxField.TagId, MinBidSizeField.TagId, BidSizeField.TagId, MinOfferSizeField.TagId, OfferSizeField.TagId, 
    ValidUntilTimeField.TagId, BidSpotRateField.TagId, OfferSpotRateField.TagId, BidForwardPointsField.TagId, OfferForwardPointsField.TagId, 
    MidPxField.TagId, BidYieldField.TagId, MidYieldField.TagId, OfferYieldField.TagId, TransactTimeField.TagId, 
    SettlmntTypField.TagId, FutSettDateField.TagId, OrdTypeField.TagId, FutSettDate2Field.TagId, OrderQty2Field.TagId, 
    BidForwardPoints2Field.TagId, OfferForwardPoints2Field.TagId, CurrencyField.TagId, SettlCurrBidFxRateField.TagId, SettlCurrOfferFxRateField.TagId, 
    SettlCurrFxRateCalcField.TagId, CommTypeField.TagId, CommissionField.TagId, CustOrderCapacityField.TagId, ExDestinationField.TagId, 
    TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(QuoteMessage(myFields.get(QuoteReqIDField.TagId).flatMap(f=>QuoteReqIDField.decode(f)),
        QuoteIDField.decode(myFields.get(QuoteIDField.TagId)).get,
        myFields.get(QuoteTypeField.TagId).flatMap(f=>QuoteTypeField.decode(f)),
        myFields.get(QuoteResponseLevelField.TagId).flatMap(f=>QuoteResponseLevelField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
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
        myFields.get(SettlmntTypField.TagId).flatMap(f=>SettlmntTypField.decode(f)),
        myFields.get(FutSettDateField.TagId).flatMap(f=>FutSettDateField.decode(f)),
        myFields.get(OrdTypeField.TagId).flatMap(f=>OrdTypeField.decode(f)),
        myFields.get(FutSettDate2Field.TagId).flatMap(f=>FutSettDate2Field.decode(f)),
        myFields.get(OrderQty2Field.TagId).flatMap(f=>OrderQty2Field.decode(f)),
        myFields.get(BidForwardPoints2Field.TagId).flatMap(f=>BidForwardPoints2Field.decode(f)),
        myFields.get(OfferForwardPoints2Field.TagId).flatMap(f=>OfferForwardPoints2Field.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(SettlCurrBidFxRateField.TagId).flatMap(f=>SettlCurrBidFxRateField.decode(f)),
        myFields.get(SettlCurrOfferFxRateField.TagId).flatMap(f=>SettlCurrOfferFxRateField.decode(f)),
        myFields.get(SettlCurrFxRateCalcField.TagId).flatMap(f=>SettlCurrFxRateCalcField.decode(f)),
        myFields.get(CommTypeField.TagId).flatMap(f=>CommTypeField.decode(f)),
        myFields.get(CommissionField.TagId).flatMap(f=>CommissionField.decode(f)),
        myFields.get(CustOrderCapacityField.TagId).flatMap(f=>CustOrderCapacityField.decode(f)),
        myFields.get(ExDestinationField.TagId).flatMap(f=>ExDestinationField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     