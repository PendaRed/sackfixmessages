package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class MDEntriesGroup(mDUpdateActionField:MDUpdateActionField,
                          deleteReasonField:Option[DeleteReasonField]=None,
                          mDEntryTypeField:Option[MDEntryTypeField]=None,
                          mDEntryIDField:Option[MDEntryIDField]=None,
                          mDEntryRefIDField:Option[MDEntryRefIDField]=None,
                          instrumentComponent:Option[InstrumentComponent]=None,
                          noUnderlyingsField:Option[NoUnderlyingsField]=None,
                          underlyingsGroups: Option[List[UnderlyingsGroup]]=None,
                          noLegsField:Option[NoLegsField]=None,
                          legsGroups: Option[List[LegsGroup]]=None,
                          financialStatusField:Option[FinancialStatusField]=None,
                          corporateActionField:Option[CorporateActionField]=None,
                          mDEntryPxField:Option[MDEntryPxField]=None,
                          currencyField:Option[CurrencyField]=None,
                          mDEntrySizeField:Option[MDEntrySizeField]=None,
                          mDEntryDateField:Option[MDEntryDateField]=None,
                          mDEntryTimeField:Option[MDEntryTimeField]=None,
                          tickDirectionField:Option[TickDirectionField]=None,
                          mDMktField:Option[MDMktField]=None,
                          tradingSessionIDField:Option[TradingSessionIDField]=None,
                          tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                          quoteConditionField:Option[QuoteConditionField]=None,
                          tradeConditionField:Option[TradeConditionField]=None,
                          mDEntryOriginatorField:Option[MDEntryOriginatorField]=None,
                          locationIDField:Option[LocationIDField]=None,
                          deskIDField:Option[DeskIDField]=None,
                          openCloseSettlFlagField:Option[OpenCloseSettlFlagField]=None,
                          timeInForceField:Option[TimeInForceField]=None,
                          expireDateField:Option[ExpireDateField]=None,
                          expireTimeField:Option[ExpireTimeField]=None,
                          minQtyField:Option[MinQtyField]=None,
                          execInstField:Option[ExecInstField]=None,
                          sellerDaysField:Option[SellerDaysField]=None,
                          orderIDField:Option[OrderIDField]=None,
                          quoteEntryIDField:Option[QuoteEntryIDField]=None,
                          mDEntryBuyerField:Option[MDEntryBuyerField]=None,
                          mDEntrySellerField:Option[MDEntrySellerField]=None,
                          numberOfOrdersField:Option[NumberOfOrdersField]=None,
                          mDEntryPositionNoField:Option[MDEntryPositionNoField]=None,
                          scopeField:Option[ScopeField]=None,
                          priceDeltaField:Option[PriceDeltaField]=None,
                          netChgPrevDayField:Option[NetChgPrevDayField]=None,
                          textField:Option[TextField]=None,
                          encodedTextLenField:Option[EncodedTextLenField]=None,
                          encodedTextField:Option[EncodedTextField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,mDUpdateActionField)
    deleteReasonField.foreach(fmt(b,_))
    mDEntryTypeField.foreach(fmt(b,_))
    mDEntryIDField.foreach(fmt(b,_))
    mDEntryRefIDField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    financialStatusField.foreach(fmt(b,_))
    corporateActionField.foreach(fmt(b,_))
    mDEntryPxField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    mDEntrySizeField.foreach(fmt(b,_))
    mDEntryDateField.foreach(fmt(b,_))
    mDEntryTimeField.foreach(fmt(b,_))
    tickDirectionField.foreach(fmt(b,_))
    mDMktField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    quoteConditionField.foreach(fmt(b,_))
    tradeConditionField.foreach(fmt(b,_))
    mDEntryOriginatorField.foreach(fmt(b,_))
    locationIDField.foreach(fmt(b,_))
    deskIDField.foreach(fmt(b,_))
    openCloseSettlFlagField.foreach(fmt(b,_))
    timeInForceField.foreach(fmt(b,_))
    expireDateField.foreach(fmt(b,_))
    expireTimeField.foreach(fmt(b,_))
    minQtyField.foreach(fmt(b,_))
    execInstField.foreach(fmt(b,_))
    sellerDaysField.foreach(fmt(b,_))
    orderIDField.foreach(fmt(b,_))
    quoteEntryIDField.foreach(fmt(b,_))
    mDEntryBuyerField.foreach(fmt(b,_))
    mDEntrySellerField.foreach(fmt(b,_))
    numberOfOrdersField.foreach(fmt(b,_))
    mDEntryPositionNoField.foreach(fmt(b,_))
    scopeField.foreach(fmt(b,_))
    priceDeltaField.foreach(fmt(b,_))
    netChgPrevDayField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object MDEntriesGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int](
    MDUpdateActionField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || UnderlyingsGroup.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    DeleteReasonField.TagId, MDEntryTypeField.TagId, MDEntryIDField.TagId, MDEntryRefIDField.TagId, NoUnderlyingsField.TagId, 
    NoLegsField.TagId, FinancialStatusField.TagId, CorporateActionField.TagId, MDEntryPxField.TagId, CurrencyField.TagId, 
    MDEntrySizeField.TagId, MDEntryDateField.TagId, MDEntryTimeField.TagId, TickDirectionField.TagId, MDMktField.TagId, 
    TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, QuoteConditionField.TagId, TradeConditionField.TagId, MDEntryOriginatorField.TagId, 
    LocationIDField.TagId, DeskIDField.TagId, OpenCloseSettlFlagField.TagId, TimeInForceField.TagId, ExpireDateField.TagId, 
    ExpireTimeField.TagId, MinQtyField.TagId, ExecInstField.TagId, SellerDaysField.TagId, OrderIDField.TagId, 
    QuoteEntryIDField.TagId, MDEntryBuyerField.TagId, MDEntrySellerField.TagId, NumberOfOrdersField.TagId, MDEntryPositionNoField.TagId, 
    ScopeField.TagId, PriceDeltaField.TagId, NetChgPrevDayField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || UnderlyingsGroup.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || UnderlyingsGroup.isFieldOf(tagId) || LegsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoUnderlyingsField.TagId, NoLegsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==MDUpdateActionField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[MDEntriesGroup]=ArrayBuffer.empty[MDEntriesGroup]):Option[List[MDEntriesGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[MDEntriesGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[MDEntriesGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(MDEntriesGroup(MDUpdateActionField.decode(myFields.get(MDUpdateActionField.TagId)).get,
          myFields.get(DeleteReasonField.TagId).flatMap(f=>DeleteReasonField.decode(f)),
          myFields.get(MDEntryTypeField.TagId).flatMap(f=>MDEntryTypeField.decode(f)),
          myFields.get(MDEntryIDField.TagId).flatMap(f=>MDEntryIDField.decode(f)),
          myFields.get(MDEntryRefIDField.TagId).flatMap(f=>MDEntryRefIDField.decode(f)),
          InstrumentComponent.decode(flds, startPos),
          myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
          if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None,
          myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
          if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
          myFields.get(FinancialStatusField.TagId).flatMap(f=>FinancialStatusField.decode(f)),
          myFields.get(CorporateActionField.TagId).flatMap(f=>CorporateActionField.decode(f)),
          myFields.get(MDEntryPxField.TagId).flatMap(f=>MDEntryPxField.decode(f)),
          myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
          myFields.get(MDEntrySizeField.TagId).flatMap(f=>MDEntrySizeField.decode(f)),
          myFields.get(MDEntryDateField.TagId).flatMap(f=>MDEntryDateField.decode(f)),
          myFields.get(MDEntryTimeField.TagId).flatMap(f=>MDEntryTimeField.decode(f)),
          myFields.get(TickDirectionField.TagId).flatMap(f=>TickDirectionField.decode(f)),
          myFields.get(MDMktField.TagId).flatMap(f=>MDMktField.decode(f)),
          myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
          myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
          myFields.get(QuoteConditionField.TagId).flatMap(f=>QuoteConditionField.decode(f)),
          myFields.get(TradeConditionField.TagId).flatMap(f=>TradeConditionField.decode(f)),
          myFields.get(MDEntryOriginatorField.TagId).flatMap(f=>MDEntryOriginatorField.decode(f)),
          myFields.get(LocationIDField.TagId).flatMap(f=>LocationIDField.decode(f)),
          myFields.get(DeskIDField.TagId).flatMap(f=>DeskIDField.decode(f)),
          myFields.get(OpenCloseSettlFlagField.TagId).flatMap(f=>OpenCloseSettlFlagField.decode(f)),
          myFields.get(TimeInForceField.TagId).flatMap(f=>TimeInForceField.decode(f)),
          myFields.get(ExpireDateField.TagId).flatMap(f=>ExpireDateField.decode(f)),
          myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
          myFields.get(MinQtyField.TagId).flatMap(f=>MinQtyField.decode(f)),
          myFields.get(ExecInstField.TagId).flatMap(f=>ExecInstField.decode(f)),
          myFields.get(SellerDaysField.TagId).flatMap(f=>SellerDaysField.decode(f)),
          myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
          myFields.get(QuoteEntryIDField.TagId).flatMap(f=>QuoteEntryIDField.decode(f)),
          myFields.get(MDEntryBuyerField.TagId).flatMap(f=>MDEntryBuyerField.decode(f)),
          myFields.get(MDEntrySellerField.TagId).flatMap(f=>MDEntrySellerField.decode(f)),
          myFields.get(NumberOfOrdersField.TagId).flatMap(f=>NumberOfOrdersField.decode(f)),
          myFields.get(MDEntryPositionNoField.TagId).flatMap(f=>MDEntryPositionNoField.decode(f)),
          myFields.get(ScopeField.TagId).flatMap(f=>ScopeField.decode(f)),
          myFields.get(PriceDeltaField.TagId).flatMap(f=>PriceDeltaField.decode(f)),
          myFields.get(NetChgPrevDayField.TagId).flatMap(f=>NetChgPrevDayField.decode(f)),
          myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
          myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
          myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     