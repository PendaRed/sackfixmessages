package org.sackfix.fix41

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX41.xml
  */
case class IndicationofInterestMessage(iOIIDField:IOIIDField,
                                       iOITransTypeField:IOITransTypeField,
                                       iOIRefIDField:Option[IOIRefIDField]=None,
                                       symbolField:SymbolField,
                                       symbolSfxField:Option[SymbolSfxField]=None,
                                       securityIDField:Option[SecurityIDField]=None,
                                       iDSourceField:Option[IDSourceField]=None,
                                       securityTypeField:Option[SecurityTypeField]=None,
                                       maturityMonthYearField:Option[MaturityMonthYearField]=None,
                                       maturityDayField:Option[MaturityDayField]=None,
                                       putOrCallField:Option[PutOrCallField]=None,
                                       strikePriceField:Option[StrikePriceField]=None,
                                       optAttributeField:Option[OptAttributeField]=None,
                                       securityExchangeField:Option[SecurityExchangeField]=None,
                                       issuerField:Option[IssuerField]=None,
                                       securityDescField:Option[SecurityDescField]=None,
                                       sideField:SideField,
                                       iOISharesField:IOISharesField,
                                       priceField:Option[PriceField]=None,
                                       currencyField:Option[CurrencyField]=None,
                                       validUntilTimeField:Option[ValidUntilTimeField]=None,
                                       iOIQltyIndField:Option[IOIQltyIndField]=None,
                                       iOIOthSvcField:Option[IOIOthSvcField]=None,
                                       iOINaturalFlagStringField:Option[IOINaturalFlagStringField]=None,
                                       noIOIQualifiersField:Option[NoIOIQualifiersField]=None,
                                       iOIQualifiersGroups: Option[List[IOIQualifiersGroup]]=None,
                                       textField:Option[TextField]=None,
                                       transactTimeField:Option[TransactTimeField]=None,
                                       uRLLinkField:Option[URLLinkField]=None) extends SfFixMessageBody("6")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noIOIQualifiersField.map(_.value).getOrElse(0) != iOIQualifiersGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoIOIQualifiersField.TagId,noIOIQualifiersField.map(_.value).getOrElse(0), iOIQualifiersGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,iOIIDField)
    fmt(b,iOITransTypeField)
    iOIRefIDField.foreach(fmt(b,_))
    fmt(b,symbolField)
    symbolSfxField.foreach(fmt(b,_))
    securityIDField.foreach(fmt(b,_))
    iDSourceField.foreach(fmt(b,_))
    securityTypeField.foreach(fmt(b,_))
    maturityMonthYearField.foreach(fmt(b,_))
    maturityDayField.foreach(fmt(b,_))
    putOrCallField.foreach(fmt(b,_))
    strikePriceField.foreach(fmt(b,_))
    optAttributeField.foreach(fmt(b,_))
    securityExchangeField.foreach(fmt(b,_))
    issuerField.foreach(fmt(b,_))
    securityDescField.foreach(fmt(b,_))
    fmt(b,sideField)
    fmt(b,iOISharesField)
    priceField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    validUntilTimeField.foreach(fmt(b,_))
    iOIQltyIndField.foreach(fmt(b,_))
    iOIOthSvcField.foreach(fmt(b,_))
    iOINaturalFlagStringField.foreach(fmt(b,_))
    noIOIQualifiersField.foreach(fmt(b,_))
    iOIQualifiersGroups.getOrElse(List.empty).foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    uRLLinkField.foreach(fmt(b,_))
    b
  }

}
     
object IndicationofInterestMessage extends SfFixMessageDecoder {
  val MsgType="6"
  val MsgName="IndicationofInterest"
             
  override val MandatoryFields = HashSet[Int](
    IOIIDField.TagId, IOITransTypeField.TagId, SymbolField.TagId, SideField.TagId, IOISharesField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    IOIQualifiersGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    IOIRefIDField.TagId, SymbolSfxField.TagId, SecurityIDField.TagId, IDSourceField.TagId, SecurityTypeField.TagId, 
    MaturityMonthYearField.TagId, MaturityDayField.TagId, PutOrCallField.TagId, StrikePriceField.TagId, OptAttributeField.TagId, 
    SecurityExchangeField.TagId, IssuerField.TagId, SecurityDescField.TagId, PriceField.TagId, CurrencyField.TagId, 
    ValidUntilTimeField.TagId, IOIQltyIndField.TagId, IOIOthSvcField.TagId, IOINaturalFlagStringField.TagId, NoIOIQualifiersField.TagId, 
    TextField.TagId, TransactTimeField.TagId, URLLinkField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    IOIQualifiersGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    IOIQualifiersGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoIOIQualifiersField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==IOIIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(IndicationofInterestMessage(IOIIDField.decode(myFields.get(IOIIDField.TagId)).get,
        IOITransTypeField.decode(myFields.get(IOITransTypeField.TagId)).get,
        myFields.get(IOIRefIDField.TagId).flatMap(f=>IOIRefIDField.decode(f)),
        SymbolField.decode(myFields.get(SymbolField.TagId)).get,
        myFields.get(SymbolSfxField.TagId).flatMap(f=>SymbolSfxField.decode(f)),
        myFields.get(SecurityIDField.TagId).flatMap(f=>SecurityIDField.decode(f)),
        myFields.get(IDSourceField.TagId).flatMap(f=>IDSourceField.decode(f)),
        myFields.get(SecurityTypeField.TagId).flatMap(f=>SecurityTypeField.decode(f)),
        myFields.get(MaturityMonthYearField.TagId).flatMap(f=>MaturityMonthYearField.decode(f)),
        myFields.get(MaturityDayField.TagId).flatMap(f=>MaturityDayField.decode(f)),
        myFields.get(PutOrCallField.TagId).flatMap(f=>PutOrCallField.decode(f)),
        myFields.get(StrikePriceField.TagId).flatMap(f=>StrikePriceField.decode(f)),
        myFields.get(OptAttributeField.TagId).flatMap(f=>OptAttributeField.decode(f)),
        myFields.get(SecurityExchangeField.TagId).flatMap(f=>SecurityExchangeField.decode(f)),
        myFields.get(IssuerField.TagId).flatMap(f=>IssuerField.decode(f)),
        myFields.get(SecurityDescField.TagId).flatMap(f=>SecurityDescField.decode(f)),
        SideField.decode(myFields.get(SideField.TagId)).get,
        IOISharesField.decode(myFields.get(IOISharesField.TagId)).get,
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(ValidUntilTimeField.TagId).flatMap(f=>ValidUntilTimeField.decode(f)),
        myFields.get(IOIQltyIndField.TagId).flatMap(f=>IOIQltyIndField.decode(f)),
        myFields.get(IOIOthSvcField.TagId).flatMap(f=>IOIOthSvcField.decode(f)),
        myFields.get(IOINaturalFlagStringField.TagId).flatMap(f=>IOINaturalFlagStringField.decode(f)),
        myFields.get(NoIOIQualifiersField.TagId).flatMap(f=>NoIOIQualifiersField.decode(f)),
        if (nextTagPosLookup.contains(NoIOIQualifiersField.TagId)) IOIQualifiersGroup.decode(flds, nextTagPosLookup(NoIOIQualifiersField.TagId)) else None,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(URLLinkField.TagId).flatMap(f=>URLLinkField.decode(f))))
    } else None
  }

    
}
     