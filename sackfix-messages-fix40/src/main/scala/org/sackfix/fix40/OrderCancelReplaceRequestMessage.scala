package org.sackfix.fix40

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX40.xml
  */
case class OrderCancelReplaceRequestMessage(orderIDField:Option[OrderIDField]=None,
                                            clientIDField:Option[ClientIDField]=None,
                                            execBrokerField:Option[ExecBrokerField]=None,
                                            origClOrdIDField:OrigClOrdIDField,
                                            clOrdIDField:ClOrdIDField,
                                            listIDField:Option[ListIDField]=None,
                                            accountField:Option[AccountField]=None,
                                            settlmntTypField:Option[SettlmntTypField]=None,
                                            futSettDateField:Option[FutSettDateField]=None,
                                            handlInstField:HandlInstField,
                                            execInstField:Option[ExecInstField]=None,
                                            minQtyIntField:Option[MinQtyIntField]=None,
                                            maxFloorIntField:Option[MaxFloorIntField]=None,
                                            exDestinationField:Option[ExDestinationField]=None,
                                            symbolField:SymbolField,
                                            symbolSfxField:Option[SymbolSfxField]=None,
                                            securityIDField:Option[SecurityIDField]=None,
                                            iDSourceField:Option[IDSourceField]=None,
                                            issuerField:Option[IssuerField]=None,
                                            securityDescField:Option[SecurityDescField]=None,
                                            sideField:SideField,
                                            orderQtyIntField:OrderQtyIntField,
                                            ordTypeField:OrdTypeField,
                                            priceField:Option[PriceField]=None,
                                            stopPxField:Option[StopPxField]=None,
                                            currencyField:Option[CurrencyField]=None,
                                            timeInForceField:Option[TimeInForceField]=None,
                                            expireTimeField:Option[ExpireTimeField]=None,
                                            commissionField:Option[CommissionField]=None,
                                            commTypeField:Option[CommTypeField]=None,
                                            rule80AField:Option[Rule80AField]=None,
                                            forexReqStringField:Option[ForexReqStringField]=None,
                                            settlCurrencyField:Option[SettlCurrencyField]=None,
                                            textField:Option[TextField]=None) extends SfFixMessageBody("G")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    orderIDField.foreach(fmt(b,_))
    clientIDField.foreach(fmt(b,_))
    execBrokerField.foreach(fmt(b,_))
    fmt(b,origClOrdIDField)
    fmt(b,clOrdIDField)
    listIDField.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    settlmntTypField.foreach(fmt(b,_))
    futSettDateField.foreach(fmt(b,_))
    fmt(b,handlInstField)
    execInstField.foreach(fmt(b,_))
    minQtyIntField.foreach(fmt(b,_))
    maxFloorIntField.foreach(fmt(b,_))
    exDestinationField.foreach(fmt(b,_))
    fmt(b,symbolField)
    symbolSfxField.foreach(fmt(b,_))
    securityIDField.foreach(fmt(b,_))
    iDSourceField.foreach(fmt(b,_))
    issuerField.foreach(fmt(b,_))
    securityDescField.foreach(fmt(b,_))
    fmt(b,sideField)
    fmt(b,orderQtyIntField)
    fmt(b,ordTypeField)
    priceField.foreach(fmt(b,_))
    stopPxField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    timeInForceField.foreach(fmt(b,_))
    expireTimeField.foreach(fmt(b,_))
    commissionField.foreach(fmt(b,_))
    commTypeField.foreach(fmt(b,_))
    rule80AField.foreach(fmt(b,_))
    forexReqStringField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    b
  }

}
     
object OrderCancelReplaceRequestMessage extends SfFixMessageDecoder {
  val MsgType="G"
  val MsgName="OrderCancelReplaceRequest"
             
  override val MandatoryFields = HashSet[Int](
    OrigClOrdIDField.TagId, ClOrdIDField.TagId, HandlInstField.TagId, SymbolField.TagId, SideField.TagId, 
    OrderQtyIntField.TagId, OrdTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    OrderIDField.TagId, ClientIDField.TagId, ExecBrokerField.TagId, ListIDField.TagId, AccountField.TagId, 
    SettlmntTypField.TagId, FutSettDateField.TagId, ExecInstField.TagId, MinQtyIntField.TagId, MaxFloorIntField.TagId, 
    ExDestinationField.TagId, SymbolSfxField.TagId, SecurityIDField.TagId, IDSourceField.TagId, IssuerField.TagId, 
    SecurityDescField.TagId, PriceField.TagId, StopPxField.TagId, CurrencyField.TagId, TimeInForceField.TagId, 
    ExpireTimeField.TagId, CommissionField.TagId, CommTypeField.TagId, Rule80AField.TagId, ForexReqStringField.TagId, 
    SettlCurrencyField.TagId, TextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(OrderCancelReplaceRequestMessage(myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        myFields.get(ClientIDField.TagId).flatMap(f=>ClientIDField.decode(f)),
        myFields.get(ExecBrokerField.TagId).flatMap(f=>ExecBrokerField.decode(f)),
        OrigClOrdIDField.decode(myFields.get(OrigClOrdIDField.TagId)).get,
        ClOrdIDField.decode(myFields.get(ClOrdIDField.TagId)).get,
        myFields.get(ListIDField.TagId).flatMap(f=>ListIDField.decode(f)),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(SettlmntTypField.TagId).flatMap(f=>SettlmntTypField.decode(f)),
        myFields.get(FutSettDateField.TagId).flatMap(f=>FutSettDateField.decode(f)),
        HandlInstField.decode(myFields.get(HandlInstField.TagId)).get,
        myFields.get(ExecInstField.TagId).flatMap(f=>ExecInstField.decode(f)),
        myFields.get(MinQtyIntField.TagId).flatMap(f=>MinQtyIntField.decode(f)),
        myFields.get(MaxFloorIntField.TagId).flatMap(f=>MaxFloorIntField.decode(f)),
        myFields.get(ExDestinationField.TagId).flatMap(f=>ExDestinationField.decode(f)),
        SymbolField.decode(myFields.get(SymbolField.TagId)).get,
        myFields.get(SymbolSfxField.TagId).flatMap(f=>SymbolSfxField.decode(f)),
        myFields.get(SecurityIDField.TagId).flatMap(f=>SecurityIDField.decode(f)),
        myFields.get(IDSourceField.TagId).flatMap(f=>IDSourceField.decode(f)),
        myFields.get(IssuerField.TagId).flatMap(f=>IssuerField.decode(f)),
        myFields.get(SecurityDescField.TagId).flatMap(f=>SecurityDescField.decode(f)),
        SideField.decode(myFields.get(SideField.TagId)).get,
        OrderQtyIntField.decode(myFields.get(OrderQtyIntField.TagId)).get,
        OrdTypeField.decode(myFields.get(OrdTypeField.TagId)).get,
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(StopPxField.TagId).flatMap(f=>StopPxField.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(TimeInForceField.TagId).flatMap(f=>TimeInForceField.decode(f)),
        myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
        myFields.get(CommissionField.TagId).flatMap(f=>CommissionField.decode(f)),
        myFields.get(CommTypeField.TagId).flatMap(f=>CommTypeField.decode(f)),
        myFields.get(Rule80AField.TagId).flatMap(f=>Rule80AField.decode(f)),
        myFields.get(ForexReqStringField.TagId).flatMap(f=>ForexReqStringField.decode(f)),
        myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f))))
    } else None
  }

    
}
     