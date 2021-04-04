package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class InstrumentLegComponent(legSymbolField:Option[LegSymbolField]=None,
                                  legSymbolSfxField:Option[LegSymbolSfxField]=None,
                                  legSecurityIDField:Option[LegSecurityIDField]=None,
                                  legSecurityIDSourceField:Option[LegSecurityIDSourceField]=None,
                                  legSecAltIDGrpComponent:Option[LegSecAltIDGrpComponent]=None,
                                  legProductField:Option[LegProductField]=None,
                                  legCFICodeField:Option[LegCFICodeField]=None,
                                  legSecurityTypeField:Option[LegSecurityTypeField]=None,
                                  legSecuritySubTypeField:Option[LegSecuritySubTypeField]=None,
                                  legMaturityMonthYearField:Option[LegMaturityMonthYearField]=None,
                                  legMaturityDateField:Option[LegMaturityDateField]=None,
                                  legMaturityTimeField:Option[LegMaturityTimeField]=None,
                                  legCouponPaymentDateField:Option[LegCouponPaymentDateField]=None,
                                  legIssueDateField:Option[LegIssueDateField]=None,
                                  legRepoCollateralSecurityTypeField:Option[LegRepoCollateralSecurityTypeField]=None,
                                  legRepurchaseTermField:Option[LegRepurchaseTermField]=None,
                                  legRepurchaseRateField:Option[LegRepurchaseRateField]=None,
                                  legFactorField:Option[LegFactorField]=None,
                                  legCreditRatingField:Option[LegCreditRatingField]=None,
                                  legInstrRegistryField:Option[LegInstrRegistryField]=None,
                                  legCountryOfIssueField:Option[LegCountryOfIssueField]=None,
                                  legStateOrProvinceOfIssueField:Option[LegStateOrProvinceOfIssueField]=None,
                                  legLocaleOfIssueField:Option[LegLocaleOfIssueField]=None,
                                  legRedemptionDateField:Option[LegRedemptionDateField]=None,
                                  legStrikePriceField:Option[LegStrikePriceField]=None,
                                  legStrikeCurrencyField:Option[LegStrikeCurrencyField]=None,
                                  legOptAttributeField:Option[LegOptAttributeField]=None,
                                  legContractMultiplierField:Option[LegContractMultiplierField]=None,
                                  legContractMultiplierUnitField:Option[LegContractMultiplierUnitField]=None,
                                  legFlowScheduleTypeField:Option[LegFlowScheduleTypeField]=None,
                                  legUnitOfMeasureField:Option[LegUnitOfMeasureField]=None,
                                  legUnitOfMeasureQtyField:Option[LegUnitOfMeasureQtyField]=None,
                                  legPriceUnitOfMeasureField:Option[LegPriceUnitOfMeasureField]=None,
                                  legPriceUnitOfMeasureQtyField:Option[LegPriceUnitOfMeasureQtyField]=None,
                                  legTimeUnitField:Option[LegTimeUnitField]=None,
                                  legExerciseStyleField:Option[LegExerciseStyleField]=None,
                                  legCouponRateField:Option[LegCouponRateField]=None,
                                  legSecurityExchangeField:Option[LegSecurityExchangeField]=None,
                                  legIssuerField:Option[LegIssuerField]=None,
                                  encodedLegIssuerLenField:Option[EncodedLegIssuerLenField]=None,
                                  encodedLegIssuerField:Option[EncodedLegIssuerField]=None,
                                  legSecurityDescField:Option[LegSecurityDescField]=None,
                                  encodedLegSecurityDescLenField:Option[EncodedLegSecurityDescLenField]=None,
                                  encodedLegSecurityDescField:Option[EncodedLegSecurityDescField]=None,
                                  legRatioQtyField:Option[LegRatioQtyField]=None,
                                  legSideField:Option[LegSideField]=None,
                                  legCurrencyField:Option[LegCurrencyField]=None,
                                  legPoolField:Option[LegPoolField]=None,
                                  legDatedDateField:Option[LegDatedDateField]=None,
                                  legContractSettlMonthField:Option[LegContractSettlMonthField]=None,
                                  legInterestAccrualDateField:Option[LegInterestAccrualDateField]=None,
                                  legPutOrCallField:Option[LegPutOrCallField]=None,
                                  legOptionRatioField:Option[LegOptionRatioField]=None,
                                  legPriceField:Option[LegPriceField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    legSymbolField.foreach(fmt(b,_))
    legSymbolSfxField.foreach(fmt(b,_))
    legSecurityIDField.foreach(fmt(b,_))
    legSecurityIDSourceField.foreach(fmt(b,_))
    legSecAltIDGrpComponent.foreach(fmt(b,_))
    legProductField.foreach(fmt(b,_))
    legCFICodeField.foreach(fmt(b,_))
    legSecurityTypeField.foreach(fmt(b,_))
    legSecuritySubTypeField.foreach(fmt(b,_))
    legMaturityMonthYearField.foreach(fmt(b,_))
    legMaturityDateField.foreach(fmt(b,_))
    legMaturityTimeField.foreach(fmt(b,_))
    legCouponPaymentDateField.foreach(fmt(b,_))
    legIssueDateField.foreach(fmt(b,_))
    legRepoCollateralSecurityTypeField.foreach(fmt(b,_))
    legRepurchaseTermField.foreach(fmt(b,_))
    legRepurchaseRateField.foreach(fmt(b,_))
    legFactorField.foreach(fmt(b,_))
    legCreditRatingField.foreach(fmt(b,_))
    legInstrRegistryField.foreach(fmt(b,_))
    legCountryOfIssueField.foreach(fmt(b,_))
    legStateOrProvinceOfIssueField.foreach(fmt(b,_))
    legLocaleOfIssueField.foreach(fmt(b,_))
    legRedemptionDateField.foreach(fmt(b,_))
    legStrikePriceField.foreach(fmt(b,_))
    legStrikeCurrencyField.foreach(fmt(b,_))
    legOptAttributeField.foreach(fmt(b,_))
    legContractMultiplierField.foreach(fmt(b,_))
    legContractMultiplierUnitField.foreach(fmt(b,_))
    legFlowScheduleTypeField.foreach(fmt(b,_))
    legUnitOfMeasureField.foreach(fmt(b,_))
    legUnitOfMeasureQtyField.foreach(fmt(b,_))
    legPriceUnitOfMeasureField.foreach(fmt(b,_))
    legPriceUnitOfMeasureQtyField.foreach(fmt(b,_))
    legTimeUnitField.foreach(fmt(b,_))
    legExerciseStyleField.foreach(fmt(b,_))
    legCouponRateField.foreach(fmt(b,_))
    legSecurityExchangeField.foreach(fmt(b,_))
    legIssuerField.foreach(fmt(b,_))
    encodedLegIssuerLenField.foreach(fmt(b,_))
    encodedLegIssuerField.foreach(fmt(b,_))
    legSecurityDescField.foreach(fmt(b,_))
    encodedLegSecurityDescLenField.foreach(fmt(b,_))
    encodedLegSecurityDescField.foreach(fmt(b,_))
    legRatioQtyField.foreach(fmt(b,_))
    legSideField.foreach(fmt(b,_))
    legCurrencyField.foreach(fmt(b,_))
    legPoolField.foreach(fmt(b,_))
    legDatedDateField.foreach(fmt(b,_))
    legContractSettlMonthField.foreach(fmt(b,_))
    legInterestAccrualDateField.foreach(fmt(b,_))
    legPutOrCallField.foreach(fmt(b,_))
    legOptionRatioField.foreach(fmt(b,_))
    legPriceField.foreach(fmt(b,_))
    b
  }

}
     
object InstrumentLegComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    LegSecAltIDGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    LegSymbolField.TagId, LegSymbolSfxField.TagId, LegSecurityIDField.TagId, LegSecurityIDSourceField.TagId, LegProductField.TagId, 
    LegCFICodeField.TagId, LegSecurityTypeField.TagId, LegSecuritySubTypeField.TagId, LegMaturityMonthYearField.TagId, LegMaturityDateField.TagId, 
    LegMaturityTimeField.TagId, LegCouponPaymentDateField.TagId, LegIssueDateField.TagId, LegRepoCollateralSecurityTypeField.TagId, LegRepurchaseTermField.TagId, 
    LegRepurchaseRateField.TagId, LegFactorField.TagId, LegCreditRatingField.TagId, LegInstrRegistryField.TagId, LegCountryOfIssueField.TagId, 
    LegStateOrProvinceOfIssueField.TagId, LegLocaleOfIssueField.TagId, LegRedemptionDateField.TagId, LegStrikePriceField.TagId, LegStrikeCurrencyField.TagId, 
    LegOptAttributeField.TagId, LegContractMultiplierField.TagId, LegContractMultiplierUnitField.TagId, LegFlowScheduleTypeField.TagId, LegUnitOfMeasureField.TagId, 
    LegUnitOfMeasureQtyField.TagId, LegPriceUnitOfMeasureField.TagId, LegPriceUnitOfMeasureQtyField.TagId, LegTimeUnitField.TagId, LegExerciseStyleField.TagId, 
    LegCouponRateField.TagId, LegSecurityExchangeField.TagId, LegIssuerField.TagId, EncodedLegIssuerLenField.TagId, EncodedLegIssuerField.TagId, 
    LegSecurityDescField.TagId, EncodedLegSecurityDescLenField.TagId, EncodedLegSecurityDescField.TagId, LegRatioQtyField.TagId, LegSideField.TagId, 
    LegCurrencyField.TagId, LegPoolField.TagId, LegDatedDateField.TagId, LegContractSettlMonthField.TagId, LegInterestAccrualDateField.TagId, 
    LegPutOrCallField.TagId, LegOptionRatioField.TagId, LegPriceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    LegSecAltIDGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    LegSecAltIDGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==LegSymbolField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[InstrumentLegComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(InstrumentLegComponent(myFields.get(LegSymbolField.TagId).flatMap(f=>LegSymbolField.decode(f)),
        myFields.get(LegSymbolSfxField.TagId).flatMap(f=>LegSymbolSfxField.decode(f)),
        myFields.get(LegSecurityIDField.TagId).flatMap(f=>LegSecurityIDField.decode(f)),
        myFields.get(LegSecurityIDSourceField.TagId).flatMap(f=>LegSecurityIDSourceField.decode(f)),
        LegSecAltIDGrpComponent.decode(flds, startPos),
        myFields.get(LegProductField.TagId).flatMap(f=>LegProductField.decode(f)),
        myFields.get(LegCFICodeField.TagId).flatMap(f=>LegCFICodeField.decode(f)),
        myFields.get(LegSecurityTypeField.TagId).flatMap(f=>LegSecurityTypeField.decode(f)),
        myFields.get(LegSecuritySubTypeField.TagId).flatMap(f=>LegSecuritySubTypeField.decode(f)),
        myFields.get(LegMaturityMonthYearField.TagId).flatMap(f=>LegMaturityMonthYearField.decode(f)),
        myFields.get(LegMaturityDateField.TagId).flatMap(f=>LegMaturityDateField.decode(f)),
        myFields.get(LegMaturityTimeField.TagId).flatMap(f=>LegMaturityTimeField.decode(f)),
        myFields.get(LegCouponPaymentDateField.TagId).flatMap(f=>LegCouponPaymentDateField.decode(f)),
        myFields.get(LegIssueDateField.TagId).flatMap(f=>LegIssueDateField.decode(f)),
        myFields.get(LegRepoCollateralSecurityTypeField.TagId).flatMap(f=>LegRepoCollateralSecurityTypeField.decode(f)),
        myFields.get(LegRepurchaseTermField.TagId).flatMap(f=>LegRepurchaseTermField.decode(f)),
        myFields.get(LegRepurchaseRateField.TagId).flatMap(f=>LegRepurchaseRateField.decode(f)),
        myFields.get(LegFactorField.TagId).flatMap(f=>LegFactorField.decode(f)),
        myFields.get(LegCreditRatingField.TagId).flatMap(f=>LegCreditRatingField.decode(f)),
        myFields.get(LegInstrRegistryField.TagId).flatMap(f=>LegInstrRegistryField.decode(f)),
        myFields.get(LegCountryOfIssueField.TagId).flatMap(f=>LegCountryOfIssueField.decode(f)),
        myFields.get(LegStateOrProvinceOfIssueField.TagId).flatMap(f=>LegStateOrProvinceOfIssueField.decode(f)),
        myFields.get(LegLocaleOfIssueField.TagId).flatMap(f=>LegLocaleOfIssueField.decode(f)),
        myFields.get(LegRedemptionDateField.TagId).flatMap(f=>LegRedemptionDateField.decode(f)),
        myFields.get(LegStrikePriceField.TagId).flatMap(f=>LegStrikePriceField.decode(f)),
        myFields.get(LegStrikeCurrencyField.TagId).flatMap(f=>LegStrikeCurrencyField.decode(f)),
        myFields.get(LegOptAttributeField.TagId).flatMap(f=>LegOptAttributeField.decode(f)),
        myFields.get(LegContractMultiplierField.TagId).flatMap(f=>LegContractMultiplierField.decode(f)),
        myFields.get(LegContractMultiplierUnitField.TagId).flatMap(f=>LegContractMultiplierUnitField.decode(f)),
        myFields.get(LegFlowScheduleTypeField.TagId).flatMap(f=>LegFlowScheduleTypeField.decode(f)),
        myFields.get(LegUnitOfMeasureField.TagId).flatMap(f=>LegUnitOfMeasureField.decode(f)),
        myFields.get(LegUnitOfMeasureQtyField.TagId).flatMap(f=>LegUnitOfMeasureQtyField.decode(f)),
        myFields.get(LegPriceUnitOfMeasureField.TagId).flatMap(f=>LegPriceUnitOfMeasureField.decode(f)),
        myFields.get(LegPriceUnitOfMeasureQtyField.TagId).flatMap(f=>LegPriceUnitOfMeasureQtyField.decode(f)),
        myFields.get(LegTimeUnitField.TagId).flatMap(f=>LegTimeUnitField.decode(f)),
        myFields.get(LegExerciseStyleField.TagId).flatMap(f=>LegExerciseStyleField.decode(f)),
        myFields.get(LegCouponRateField.TagId).flatMap(f=>LegCouponRateField.decode(f)),
        myFields.get(LegSecurityExchangeField.TagId).flatMap(f=>LegSecurityExchangeField.decode(f)),
        myFields.get(LegIssuerField.TagId).flatMap(f=>LegIssuerField.decode(f)),
        myFields.get(EncodedLegIssuerLenField.TagId).flatMap(f=>EncodedLegIssuerLenField.decode(f)),
        myFields.get(EncodedLegIssuerField.TagId).flatMap(f=>EncodedLegIssuerField.decode(f)),
        myFields.get(LegSecurityDescField.TagId).flatMap(f=>LegSecurityDescField.decode(f)),
        myFields.get(EncodedLegSecurityDescLenField.TagId).flatMap(f=>EncodedLegSecurityDescLenField.decode(f)),
        myFields.get(EncodedLegSecurityDescField.TagId).flatMap(f=>EncodedLegSecurityDescField.decode(f)),
        myFields.get(LegRatioQtyField.TagId).flatMap(f=>LegRatioQtyField.decode(f)),
        myFields.get(LegSideField.TagId).flatMap(f=>LegSideField.decode(f)),
        myFields.get(LegCurrencyField.TagId).flatMap(f=>LegCurrencyField.decode(f)),
        myFields.get(LegPoolField.TagId).flatMap(f=>LegPoolField.decode(f)),
        myFields.get(LegDatedDateField.TagId).flatMap(f=>LegDatedDateField.decode(f)),
        myFields.get(LegContractSettlMonthField.TagId).flatMap(f=>LegContractSettlMonthField.decode(f)),
        myFields.get(LegInterestAccrualDateField.TagId).flatMap(f=>LegInterestAccrualDateField.decode(f)),
        myFields.get(LegPutOrCallField.TagId).flatMap(f=>LegPutOrCallField.decode(f)),
        myFields.get(LegOptionRatioField.TagId).flatMap(f=>LegOptionRatioField.decode(f)),
        myFields.get(LegPriceField.TagId).flatMap(f=>LegPriceField.decode(f))))
    } else None
  }

    
}
     