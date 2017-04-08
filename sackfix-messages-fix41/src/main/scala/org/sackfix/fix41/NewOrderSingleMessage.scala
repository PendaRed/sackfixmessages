package org.sackfix.fix41

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX41.xml
  */
case class NewOrderSingleMessage(clOrdIDField:ClOrdIDField,
                                 clientIDField:Option[ClientIDField]=None,
                                 execBrokerField:Option[ExecBrokerField]=None,
                                 accountField:Option[AccountField]=None,
                                 settlmntTypField:Option[SettlmntTypField]=None,
                                 futSettDateField:Option[FutSettDateField]=None,
                                 handlInstField:HandlInstField,
                                 execInstField:Option[ExecInstField]=None,
                                 minQtyIntField:Option[MinQtyIntField]=None,
                                 maxFloorIntField:Option[MaxFloorIntField]=None,
                                 exDestinationField:Option[ExDestinationField]=None,
                                 processCodeField:Option[ProcessCodeField]=None,
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
                                 prevClosePxField:Option[PrevClosePxField]=None,
                                 sideField:SideField,
                                 locateReqdStringField:Option[LocateReqdStringField]=None,
                                 orderQtyIntField:Option[OrderQtyIntField]=None,
                                 cashOrderQtyField:Option[CashOrderQtyField]=None,
                                 ordTypeField:OrdTypeField,
                                 priceField:Option[PriceField]=None,
                                 stopPxField:Option[StopPxField]=None,
                                 currencyField:Option[CurrencyField]=None,
                                 iOIIDField:Option[IOIIDField]=None,
                                 quoteIDField:Option[QuoteIDField]=None,
                                 timeInForceField:Option[TimeInForceField]=None,
                                 expireTimeField:Option[ExpireTimeField]=None,
                                 commissionField:Option[CommissionField]=None,
                                 commTypeField:Option[CommTypeField]=None,
                                 rule80AField:Option[Rule80AField]=None,
                                 forexReqStringField:Option[ForexReqStringField]=None,
                                 settlCurrencyField:Option[SettlCurrencyField]=None,
                                 textField:Option[TextField]=None,
                                 futSettDate2Field:Option[FutSettDate2Field]=None,
                                 orderQty2Field:Option[OrderQty2Field]=None,
                                 openCloseField:Option[OpenCloseField]=None,
                                 coveredOrUncoveredField:Option[CoveredOrUncoveredField]=None,
                                 customerOrFirmField:Option[CustomerOrFirmField]=None,
                                 maxShowIntField:Option[MaxShowIntField]=None,
                                 pegDifferenceField:Option[PegDifferenceField]=None) extends SfFixMessageBody("D")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,clOrdIDField)
    clientIDField.foreach(fmt(b,_))
    execBrokerField.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    settlmntTypField.foreach(fmt(b,_))
    futSettDateField.foreach(fmt(b,_))
    fmt(b,handlInstField)
    execInstField.foreach(fmt(b,_))
    minQtyIntField.foreach(fmt(b,_))
    maxFloorIntField.foreach(fmt(b,_))
    exDestinationField.foreach(fmt(b,_))
    processCodeField.foreach(fmt(b,_))
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
    prevClosePxField.foreach(fmt(b,_))
    fmt(b,sideField)
    locateReqdStringField.foreach(fmt(b,_))
    orderQtyIntField.foreach(fmt(b,_))
    cashOrderQtyField.foreach(fmt(b,_))
    fmt(b,ordTypeField)
    priceField.foreach(fmt(b,_))
    stopPxField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    iOIIDField.foreach(fmt(b,_))
    quoteIDField.foreach(fmt(b,_))
    timeInForceField.foreach(fmt(b,_))
    expireTimeField.foreach(fmt(b,_))
    commissionField.foreach(fmt(b,_))
    commTypeField.foreach(fmt(b,_))
    rule80AField.foreach(fmt(b,_))
    forexReqStringField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    futSettDate2Field.foreach(fmt(b,_))
    orderQty2Field.foreach(fmt(b,_))
    openCloseField.foreach(fmt(b,_))
    coveredOrUncoveredField.foreach(fmt(b,_))
    customerOrFirmField.foreach(fmt(b,_))
    maxShowIntField.foreach(fmt(b,_))
    pegDifferenceField.foreach(fmt(b,_))
    b
  }

}
     
object NewOrderSingleMessage extends SfFixMessageDecoder {
  val MsgType="D"
  val MsgName="NewOrderSingle"
             
  override val MandatoryFields = HashSet[Int](
    ClOrdIDField.TagId, HandlInstField.TagId, SymbolField.TagId, SideField.TagId, OrdTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    ClientIDField.TagId, ExecBrokerField.TagId, AccountField.TagId, SettlmntTypField.TagId, FutSettDateField.TagId, 
    ExecInstField.TagId, MinQtyIntField.TagId, MaxFloorIntField.TagId, ExDestinationField.TagId, ProcessCodeField.TagId, 
    SymbolSfxField.TagId, SecurityIDField.TagId, IDSourceField.TagId, SecurityTypeField.TagId, MaturityMonthYearField.TagId, 
    MaturityDayField.TagId, PutOrCallField.TagId, StrikePriceField.TagId, OptAttributeField.TagId, SecurityExchangeField.TagId, 
    IssuerField.TagId, SecurityDescField.TagId, PrevClosePxField.TagId, LocateReqdStringField.TagId, OrderQtyIntField.TagId, 
    CashOrderQtyField.TagId, PriceField.TagId, StopPxField.TagId, CurrencyField.TagId, IOIIDField.TagId, 
    QuoteIDField.TagId, TimeInForceField.TagId, ExpireTimeField.TagId, CommissionField.TagId, CommTypeField.TagId, 
    Rule80AField.TagId, ForexReqStringField.TagId, SettlCurrencyField.TagId, TextField.TagId, FutSettDate2Field.TagId, 
    OrderQty2Field.TagId, OpenCloseField.TagId, CoveredOrUncoveredField.TagId, CustomerOrFirmField.TagId, MaxShowIntField.TagId, 
    PegDifferenceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ClOrdIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(NewOrderSingleMessage(ClOrdIDField.decode(myFields.get(ClOrdIDField.TagId)).get,
        myFields.get(ClientIDField.TagId).flatMap(f=>ClientIDField.decode(f)),
        myFields.get(ExecBrokerField.TagId).flatMap(f=>ExecBrokerField.decode(f)),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(SettlmntTypField.TagId).flatMap(f=>SettlmntTypField.decode(f)),
        myFields.get(FutSettDateField.TagId).flatMap(f=>FutSettDateField.decode(f)),
        HandlInstField.decode(myFields.get(HandlInstField.TagId)).get,
        myFields.get(ExecInstField.TagId).flatMap(f=>ExecInstField.decode(f)),
        myFields.get(MinQtyIntField.TagId).flatMap(f=>MinQtyIntField.decode(f)),
        myFields.get(MaxFloorIntField.TagId).flatMap(f=>MaxFloorIntField.decode(f)),
        myFields.get(ExDestinationField.TagId).flatMap(f=>ExDestinationField.decode(f)),
        myFields.get(ProcessCodeField.TagId).flatMap(f=>ProcessCodeField.decode(f)),
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
        myFields.get(PrevClosePxField.TagId).flatMap(f=>PrevClosePxField.decode(f)),
        SideField.decode(myFields.get(SideField.TagId)).get,
        myFields.get(LocateReqdStringField.TagId).flatMap(f=>LocateReqdStringField.decode(f)),
        myFields.get(OrderQtyIntField.TagId).flatMap(f=>OrderQtyIntField.decode(f)),
        myFields.get(CashOrderQtyField.TagId).flatMap(f=>CashOrderQtyField.decode(f)),
        OrdTypeField.decode(myFields.get(OrdTypeField.TagId)).get,
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(StopPxField.TagId).flatMap(f=>StopPxField.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(IOIIDField.TagId).flatMap(f=>IOIIDField.decode(f)),
        myFields.get(QuoteIDField.TagId).flatMap(f=>QuoteIDField.decode(f)),
        myFields.get(TimeInForceField.TagId).flatMap(f=>TimeInForceField.decode(f)),
        myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
        myFields.get(CommissionField.TagId).flatMap(f=>CommissionField.decode(f)),
        myFields.get(CommTypeField.TagId).flatMap(f=>CommTypeField.decode(f)),
        myFields.get(Rule80AField.TagId).flatMap(f=>Rule80AField.decode(f)),
        myFields.get(ForexReqStringField.TagId).flatMap(f=>ForexReqStringField.decode(f)),
        myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(FutSettDate2Field.TagId).flatMap(f=>FutSettDate2Field.decode(f)),
        myFields.get(OrderQty2Field.TagId).flatMap(f=>OrderQty2Field.decode(f)),
        myFields.get(OpenCloseField.TagId).flatMap(f=>OpenCloseField.decode(f)),
        myFields.get(CoveredOrUncoveredField.TagId).flatMap(f=>CoveredOrUncoveredField.decode(f)),
        myFields.get(CustomerOrFirmField.TagId).flatMap(f=>CustomerOrFirmField.decode(f)),
        myFields.get(MaxShowIntField.TagId).flatMap(f=>MaxShowIntField.decode(f)),
        myFields.get(PegDifferenceField.TagId).flatMap(f=>PegDifferenceField.decode(f))))
    } else None
  }

    
}
     