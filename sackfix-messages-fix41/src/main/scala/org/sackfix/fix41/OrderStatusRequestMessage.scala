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
case class OrderStatusRequestMessage(orderIDField:Option[OrderIDField]=None,
                                     clOrdIDField:ClOrdIDField,
                                     clientIDField:Option[ClientIDField]=None,
                                     execBrokerField:Option[ExecBrokerField]=None,
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
                                     sideField:SideField) extends SfFixMessageBody("H")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    orderIDField.foreach(fmt(b,_))
    fmt(b,clOrdIDField)
    clientIDField.foreach(fmt(b,_))
    execBrokerField.foreach(fmt(b,_))
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
    b
  }

}
     
object OrderStatusRequestMessage extends SfFixMessageDecoder {
  val MsgType="H"
  val MsgName="OrderStatusRequest"
             
  override val MandatoryFields = HashSet[Int](
    ClOrdIDField.TagId, SymbolField.TagId, SideField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    OrderIDField.TagId, ClientIDField.TagId, ExecBrokerField.TagId, SymbolSfxField.TagId, SecurityIDField.TagId, 
    IDSourceField.TagId, SecurityTypeField.TagId, MaturityMonthYearField.TagId, MaturityDayField.TagId, PutOrCallField.TagId, 
    StrikePriceField.TagId, OptAttributeField.TagId, SecurityExchangeField.TagId, IssuerField.TagId, SecurityDescField.TagId)

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
      Some(OrderStatusRequestMessage(myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        ClOrdIDField.decode(myFields.get(ClOrdIDField.TagId)).get,
        myFields.get(ClientIDField.TagId).flatMap(f=>ClientIDField.decode(f)),
        myFields.get(ExecBrokerField.TagId).flatMap(f=>ExecBrokerField.decode(f)),
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
        SideField.decode(myFields.get(SideField.TagId)).get))
    } else None
  }

    
}
     