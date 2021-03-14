package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class QuoteEntriesGroup(quoteEntryIDField:Option[QuoteEntryIDField]=None,
                             instrumentComponent:Option[InstrumentComponent]=None,
                             noLegsField:Option[NoLegsField]=None,
                             legsGroups: Option[List[LegsGroup]]=None,
                             bidPxField:Option[BidPxField]=None,
                             offerPxField:Option[OfferPxField]=None,
                             bidSizeField:Option[BidSizeField]=None,
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
                             tradingSessionIDField:Option[TradingSessionIDField]=None,
                             tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                             settlDateField:Option[SettlDateField]=None,
                             ordTypeField:Option[OrdTypeField]=None,
                             settlDate2Field:Option[SettlDate2Field]=None,
                             orderQty2Field:Option[OrderQty2Field]=None,
                             bidForwardPoints2Field:Option[BidForwardPoints2Field]=None,
                             offerForwardPoints2Field:Option[OfferForwardPoints2Field]=None,
                             currencyField:Option[CurrencyField]=None,
                             quoteEntryRejectReasonField:Option[QuoteEntryRejectReasonField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    quoteEntryIDField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    bidPxField.foreach(fmt(b,_))
    offerPxField.foreach(fmt(b,_))
    bidSizeField.foreach(fmt(b,_))
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
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    ordTypeField.foreach(fmt(b,_))
    settlDate2Field.foreach(fmt(b,_))
    orderQty2Field.foreach(fmt(b,_))
    bidForwardPoints2Field.foreach(fmt(b,_))
    offerForwardPoints2Field.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    quoteEntryRejectReasonField.foreach(fmt(b,_))
    b
  }

}
     
object QuoteEntriesGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    QuoteEntryIDField.TagId, NoLegsField.TagId, BidPxField.TagId, OfferPxField.TagId, BidSizeField.TagId, 
    OfferSizeField.TagId, ValidUntilTimeField.TagId, BidSpotRateField.TagId, OfferSpotRateField.TagId, BidForwardPointsField.TagId, 
    OfferForwardPointsField.TagId, MidPxField.TagId, BidYieldField.TagId, MidYieldField.TagId, OfferYieldField.TagId, 
    TransactTimeField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, SettlDateField.TagId, OrdTypeField.TagId, 
    SettlDate2Field.TagId, OrderQty2Field.TagId, BidForwardPoints2Field.TagId, OfferForwardPoints2Field.TagId, CurrencyField.TagId, 
    QuoteEntryRejectReasonField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || LegsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoLegsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteEntryIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[QuoteEntriesGroup]=ArrayBuffer.empty[QuoteEntriesGroup]):Option[List[QuoteEntriesGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[QuoteEntriesGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[QuoteEntriesGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(QuoteEntriesGroup(myFields.get(QuoteEntryIDField.TagId).flatMap(f=>QuoteEntryIDField.decode(f)),
          InstrumentComponent.decode(flds, startPos),
          myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
          if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
          myFields.get(BidPxField.TagId).flatMap(f=>BidPxField.decode(f)),
          myFields.get(OfferPxField.TagId).flatMap(f=>OfferPxField.decode(f)),
          myFields.get(BidSizeField.TagId).flatMap(f=>BidSizeField.decode(f)),
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
          myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
          myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
          myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
          myFields.get(OrdTypeField.TagId).flatMap(f=>OrdTypeField.decode(f)),
          myFields.get(SettlDate2Field.TagId).flatMap(f=>SettlDate2Field.decode(f)),
          myFields.get(OrderQty2Field.TagId).flatMap(f=>OrderQty2Field.decode(f)),
          myFields.get(BidForwardPoints2Field.TagId).flatMap(f=>BidForwardPoints2Field.decode(f)),
          myFields.get(OfferForwardPoints2Field.TagId).flatMap(f=>OfferForwardPoints2Field.decode(f)),
          myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
          myFields.get(QuoteEntryRejectReasonField.TagId).flatMap(f=>QuoteEntryRejectReasonField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     