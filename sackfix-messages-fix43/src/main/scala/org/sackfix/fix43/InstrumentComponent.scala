package org.sackfix.fix43

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX43.xml
  */
case class InstrumentComponent(symbolField:SymbolField,
                               symbolSfxField:Option[SymbolSfxField]=None,
                               securityIDField:Option[SecurityIDField]=None,
                               securityIDSourceField:Option[SecurityIDSourceField]=None,
                               noSecurityAltIDField:Option[NoSecurityAltIDField]=None,
                               securityAltIDGroups: Option[List[SecurityAltIDGroup]]=None,
                               productField:Option[ProductField]=None,
                               cFICodeField:Option[CFICodeField]=None,
                               securityTypeField:Option[SecurityTypeField]=None,
                               maturityMonthYearField:Option[MaturityMonthYearField]=None,
                               maturityDateField:Option[MaturityDateField]=None,
                               couponPaymentDateField:Option[CouponPaymentDateField]=None,
                               issueDateField:Option[IssueDateField]=None,
                               repoCollateralSecurityTypeField:Option[RepoCollateralSecurityTypeField]=None,
                               repurchaseTermField:Option[RepurchaseTermField]=None,
                               repurchaseRateField:Option[RepurchaseRateField]=None,
                               factorField:Option[FactorField]=None,
                               creditRatingField:Option[CreditRatingField]=None,
                               instrRegistryField:Option[InstrRegistryField]=None,
                               countryOfIssueField:Option[CountryOfIssueField]=None,
                               stateOrProvinceOfIssueField:Option[StateOrProvinceOfIssueField]=None,
                               localeOfIssueField:Option[LocaleOfIssueField]=None,
                               redemptionDateField:Option[RedemptionDateField]=None,
                               strikePriceField:Option[StrikePriceField]=None,
                               optAttributeField:Option[OptAttributeField]=None,
                               contractMultiplierField:Option[ContractMultiplierField]=None,
                               couponRateField:Option[CouponRateField]=None,
                               securityExchangeField:Option[SecurityExchangeField]=None,
                               issuerField:Option[IssuerField]=None,
                               encodedIssuerLenField:Option[EncodedIssuerLenField]=None,
                               encodedIssuerField:Option[EncodedIssuerField]=None,
                               securityDescField:Option[SecurityDescField]=None,
                               encodedSecurityDescLenField:Option[EncodedSecurityDescLenField]=None,
                               encodedSecurityDescField:Option[EncodedSecurityDescField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSecurityAltIDField.map(_.value).getOrElse(0) != securityAltIDGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoSecurityAltIDField.TagId,noSecurityAltIDField.map(_.value).getOrElse(0), securityAltIDGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,symbolField)
    symbolSfxField.foreach(fmt(b,_))
    securityIDField.foreach(fmt(b,_))
    securityIDSourceField.foreach(fmt(b,_))
    noSecurityAltIDField.foreach(fmt(b,_))
    securityAltIDGroups.getOrElse(List.empty).foreach(fmt(b,_))
    productField.foreach(fmt(b,_))
    cFICodeField.foreach(fmt(b,_))
    securityTypeField.foreach(fmt(b,_))
    maturityMonthYearField.foreach(fmt(b,_))
    maturityDateField.foreach(fmt(b,_))
    couponPaymentDateField.foreach(fmt(b,_))
    issueDateField.foreach(fmt(b,_))
    repoCollateralSecurityTypeField.foreach(fmt(b,_))
    repurchaseTermField.foreach(fmt(b,_))
    repurchaseRateField.foreach(fmt(b,_))
    factorField.foreach(fmt(b,_))
    creditRatingField.foreach(fmt(b,_))
    instrRegistryField.foreach(fmt(b,_))
    countryOfIssueField.foreach(fmt(b,_))
    stateOrProvinceOfIssueField.foreach(fmt(b,_))
    localeOfIssueField.foreach(fmt(b,_))
    redemptionDateField.foreach(fmt(b,_))
    strikePriceField.foreach(fmt(b,_))
    optAttributeField.foreach(fmt(b,_))
    contractMultiplierField.foreach(fmt(b,_))
    couponRateField.foreach(fmt(b,_))
    securityExchangeField.foreach(fmt(b,_))
    issuerField.foreach(fmt(b,_))
    encodedIssuerLenField.foreach(fmt(b,_))
    encodedIssuerField.foreach(fmt(b,_))
    securityDescField.foreach(fmt(b,_))
    encodedSecurityDescLenField.foreach(fmt(b,_))
    encodedSecurityDescField.foreach(fmt(b,_))
    b
  }

}
     
object InstrumentComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    SymbolField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SecurityAltIDGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SymbolSfxField.TagId, SecurityIDField.TagId, SecurityIDSourceField.TagId, NoSecurityAltIDField.TagId, ProductField.TagId, 
    CFICodeField.TagId, SecurityTypeField.TagId, MaturityMonthYearField.TagId, MaturityDateField.TagId, CouponPaymentDateField.TagId, 
    IssueDateField.TagId, RepoCollateralSecurityTypeField.TagId, RepurchaseTermField.TagId, RepurchaseRateField.TagId, FactorField.TagId, 
    CreditRatingField.TagId, InstrRegistryField.TagId, CountryOfIssueField.TagId, StateOrProvinceOfIssueField.TagId, LocaleOfIssueField.TagId, 
    RedemptionDateField.TagId, StrikePriceField.TagId, OptAttributeField.TagId, ContractMultiplierField.TagId, CouponRateField.TagId, 
    SecurityExchangeField.TagId, IssuerField.TagId, EncodedIssuerLenField.TagId, EncodedIssuerField.TagId, SecurityDescField.TagId, 
    EncodedSecurityDescLenField.TagId, EncodedSecurityDescField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SecurityAltIDGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SecurityAltIDGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSecurityAltIDField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SymbolField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[InstrumentComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(InstrumentComponent(SymbolField.decode(myFields.get(SymbolField.TagId)).get,
        myFields.get(SymbolSfxField.TagId).flatMap(f=>SymbolSfxField.decode(f)),
        myFields.get(SecurityIDField.TagId).flatMap(f=>SecurityIDField.decode(f)),
        myFields.get(SecurityIDSourceField.TagId).flatMap(f=>SecurityIDSourceField.decode(f)),
        myFields.get(NoSecurityAltIDField.TagId).flatMap(f=>NoSecurityAltIDField.decode(f)),
        if (nextTagPosLookup.contains(NoSecurityAltIDField.TagId)) SecurityAltIDGroup.decode(flds, nextTagPosLookup(NoSecurityAltIDField.TagId)) else None,
        myFields.get(ProductField.TagId).flatMap(f=>ProductField.decode(f)),
        myFields.get(CFICodeField.TagId).flatMap(f=>CFICodeField.decode(f)),
        myFields.get(SecurityTypeField.TagId).flatMap(f=>SecurityTypeField.decode(f)),
        myFields.get(MaturityMonthYearField.TagId).flatMap(f=>MaturityMonthYearField.decode(f)),
        myFields.get(MaturityDateField.TagId).flatMap(f=>MaturityDateField.decode(f)),
        myFields.get(CouponPaymentDateField.TagId).flatMap(f=>CouponPaymentDateField.decode(f)),
        myFields.get(IssueDateField.TagId).flatMap(f=>IssueDateField.decode(f)),
        myFields.get(RepoCollateralSecurityTypeField.TagId).flatMap(f=>RepoCollateralSecurityTypeField.decode(f)),
        myFields.get(RepurchaseTermField.TagId).flatMap(f=>RepurchaseTermField.decode(f)),
        myFields.get(RepurchaseRateField.TagId).flatMap(f=>RepurchaseRateField.decode(f)),
        myFields.get(FactorField.TagId).flatMap(f=>FactorField.decode(f)),
        myFields.get(CreditRatingField.TagId).flatMap(f=>CreditRatingField.decode(f)),
        myFields.get(InstrRegistryField.TagId).flatMap(f=>InstrRegistryField.decode(f)),
        myFields.get(CountryOfIssueField.TagId).flatMap(f=>CountryOfIssueField.decode(f)),
        myFields.get(StateOrProvinceOfIssueField.TagId).flatMap(f=>StateOrProvinceOfIssueField.decode(f)),
        myFields.get(LocaleOfIssueField.TagId).flatMap(f=>LocaleOfIssueField.decode(f)),
        myFields.get(RedemptionDateField.TagId).flatMap(f=>RedemptionDateField.decode(f)),
        myFields.get(StrikePriceField.TagId).flatMap(f=>StrikePriceField.decode(f)),
        myFields.get(OptAttributeField.TagId).flatMap(f=>OptAttributeField.decode(f)),
        myFields.get(ContractMultiplierField.TagId).flatMap(f=>ContractMultiplierField.decode(f)),
        myFields.get(CouponRateField.TagId).flatMap(f=>CouponRateField.decode(f)),
        myFields.get(SecurityExchangeField.TagId).flatMap(f=>SecurityExchangeField.decode(f)),
        myFields.get(IssuerField.TagId).flatMap(f=>IssuerField.decode(f)),
        myFields.get(EncodedIssuerLenField.TagId).flatMap(f=>EncodedIssuerLenField.decode(f)),
        myFields.get(EncodedIssuerField.TagId).flatMap(f=>EncodedIssuerField.decode(f)),
        myFields.get(SecurityDescField.TagId).flatMap(f=>SecurityDescField.decode(f)),
        myFields.get(EncodedSecurityDescLenField.TagId).flatMap(f=>EncodedSecurityDescLenField.decode(f)),
        myFields.get(EncodedSecurityDescField.TagId).flatMap(f=>EncodedSecurityDescField.decode(f))))
    } else None
  }

    
}
     