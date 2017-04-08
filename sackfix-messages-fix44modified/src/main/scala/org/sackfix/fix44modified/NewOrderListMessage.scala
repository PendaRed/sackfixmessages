package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class NewOrderListMessage(listIDField:ListIDField,
                               bidIDField:Option[BidIDField]=None,
                               clientBidIDField:Option[ClientBidIDField]=None,
                               progRptReqsField:Option[ProgRptReqsField]=None,
                               bidTypeField:BidTypeField,
                               progPeriodIntervalField:Option[ProgPeriodIntervalField]=None,
                               cancellationRightsField:Option[CancellationRightsField]=None,
                               moneyLaunderingStatusField:Option[MoneyLaunderingStatusField]=None,
                               registIDField:Option[RegistIDField]=None,
                               listExecInstTypeField:Option[ListExecInstTypeField]=None,
                               listExecInstField:Option[ListExecInstField]=None,
                               encodedListExecInstLenField:Option[EncodedListExecInstLenField]=None,
                               encodedListExecInstField:Option[EncodedListExecInstField]=None,
                               allowableOneSidednessPctField:Option[AllowableOneSidednessPctField]=None,
                               allowableOneSidednessValueField:Option[AllowableOneSidednessValueField]=None,
                               allowableOneSidednessCurrField:Option[AllowableOneSidednessCurrField]=None,
                               totNoOrdersField:TotNoOrdersField,
                               lastFragmentField:Option[LastFragmentField]=None,
                               noOrdersField:NoOrdersField,
                               ordersGroups: List[OrdersGroup]) extends SfFixMessageBody("E")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noOrdersField.value != ordersGroups.size)
    throw SfRepeatingGroupCountException(NoOrdersField.TagId,noOrdersField.value, ordersGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,listIDField)
    bidIDField.foreach(fmt(b,_))
    clientBidIDField.foreach(fmt(b,_))
    progRptReqsField.foreach(fmt(b,_))
    fmt(b,bidTypeField)
    progPeriodIntervalField.foreach(fmt(b,_))
    cancellationRightsField.foreach(fmt(b,_))
    moneyLaunderingStatusField.foreach(fmt(b,_))
    registIDField.foreach(fmt(b,_))
    listExecInstTypeField.foreach(fmt(b,_))
    listExecInstField.foreach(fmt(b,_))
    encodedListExecInstLenField.foreach(fmt(b,_))
    encodedListExecInstField.foreach(fmt(b,_))
    allowableOneSidednessPctField.foreach(fmt(b,_))
    allowableOneSidednessValueField.foreach(fmt(b,_))
    allowableOneSidednessCurrField.foreach(fmt(b,_))
    fmt(b,totNoOrdersField)
    lastFragmentField.foreach(fmt(b,_))
    fmt(b,noOrdersField)
    b
  }

}
     
object NewOrderListMessage extends SfFixMessageDecoder {
  val MsgType="E"
  val MsgName="NewOrderList"
             
  override val MandatoryFields = HashSet[Int](
    ListIDField.TagId, BidTypeField.TagId, TotNoOrdersField.TagId, NoOrdersField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OrdersGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    BidIDField.TagId, ClientBidIDField.TagId, ProgRptReqsField.TagId, ProgPeriodIntervalField.TagId, CancellationRightsField.TagId, 
    MoneyLaunderingStatusField.TagId, RegistIDField.TagId, ListExecInstTypeField.TagId, ListExecInstField.TagId, EncodedListExecInstLenField.TagId, 
    EncodedListExecInstField.TagId, AllowableOneSidednessPctField.TagId, AllowableOneSidednessValueField.TagId, AllowableOneSidednessCurrField.TagId, LastFragmentField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    OrdersGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    OrdersGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoOrdersField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ListIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(NewOrderListMessage(ListIDField.decode(myFields.get(ListIDField.TagId)).get,
        myFields.get(BidIDField.TagId).flatMap(f=>BidIDField.decode(f)),
        myFields.get(ClientBidIDField.TagId).flatMap(f=>ClientBidIDField.decode(f)),
        myFields.get(ProgRptReqsField.TagId).flatMap(f=>ProgRptReqsField.decode(f)),
        BidTypeField.decode(myFields.get(BidTypeField.TagId)).get,
        myFields.get(ProgPeriodIntervalField.TagId).flatMap(f=>ProgPeriodIntervalField.decode(f)),
        myFields.get(CancellationRightsField.TagId).flatMap(f=>CancellationRightsField.decode(f)),
        myFields.get(MoneyLaunderingStatusField.TagId).flatMap(f=>MoneyLaunderingStatusField.decode(f)),
        myFields.get(RegistIDField.TagId).flatMap(f=>RegistIDField.decode(f)),
        myFields.get(ListExecInstTypeField.TagId).flatMap(f=>ListExecInstTypeField.decode(f)),
        myFields.get(ListExecInstField.TagId).flatMap(f=>ListExecInstField.decode(f)),
        myFields.get(EncodedListExecInstLenField.TagId).flatMap(f=>EncodedListExecInstLenField.decode(f)),
        myFields.get(EncodedListExecInstField.TagId).flatMap(f=>EncodedListExecInstField.decode(f)),
        myFields.get(AllowableOneSidednessPctField.TagId).flatMap(f=>AllowableOneSidednessPctField.decode(f)),
        myFields.get(AllowableOneSidednessValueField.TagId).flatMap(f=>AllowableOneSidednessValueField.decode(f)),
        myFields.get(AllowableOneSidednessCurrField.TagId).flatMap(f=>AllowableOneSidednessCurrField.decode(f)),
        TotNoOrdersField.decode(myFields.get(TotNoOrdersField.TagId)).get,
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        NoOrdersField.decode(myFields.get(NoOrdersField.TagId)).get,
        if (nextTagPosLookup.contains(NoOrdersField.TagId)) OrdersGroup.decode(flds, nextTagPosLookup(NoOrdersField.TagId)).get else List.empty))
    } else None
  }

    
}
     