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
case class MarketDataRequestMessage(mDReqIDField:MDReqIDField,
                                    subscriptionRequestTypeField:SubscriptionRequestTypeField,
                                    marketDepthField:MarketDepthField,
                                    mDUpdateTypeField:Option[MDUpdateTypeField]=None,
                                    aggregatedBookField:Option[AggregatedBookField]=None,
                                    openCloseSettlFlagField:Option[OpenCloseSettlFlagField]=None,
                                    scopeField:Option[ScopeField]=None,
                                    mDImplicitDeleteField:Option[MDImplicitDeleteField]=None,
                                    noMDEntryTypesField:NoMDEntryTypesField,
                                    mDEntryTypesGroups: List[MDEntryTypesGroup],
                                    noRelatedSymField:NoRelatedSymField,
                                    relatedSymGroups: List[RelatedSymGroup],
                                    noTradingSessionsField:Option[NoTradingSessionsField]=None,
                                    tradingSessionsGroups: Option[List[TradingSessionsGroup]]=None,
                                    applQueueActionField:Option[ApplQueueActionField]=None,
                                    applQueueMaxField:Option[ApplQueueMaxField]=None) extends SfFixMessageBody("V")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noMDEntryTypesField.value != mDEntryTypesGroups.size)
    throw SfRepeatingGroupCountException(NoMDEntryTypesField.TagId,noMDEntryTypesField.value, mDEntryTypesGroups.size)
  if (noRelatedSymField.value != relatedSymGroups.size)
    throw SfRepeatingGroupCountException(NoRelatedSymField.TagId,noRelatedSymField.value, relatedSymGroups.size)
  if (noTradingSessionsField.map(_.value).getOrElse(0) != tradingSessionsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoTradingSessionsField.TagId,noTradingSessionsField.map(_.value).getOrElse(0), tradingSessionsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,mDReqIDField)
    fmt(b,subscriptionRequestTypeField)
    fmt(b,marketDepthField)
    mDUpdateTypeField.foreach(fmt(b,_))
    aggregatedBookField.foreach(fmt(b,_))
    openCloseSettlFlagField.foreach(fmt(b,_))
    scopeField.foreach(fmt(b,_))
    mDImplicitDeleteField.foreach(fmt(b,_))
    fmt(b,noMDEntryTypesField)
    fmt(b,noRelatedSymField)
    noTradingSessionsField.foreach(fmt(b,_))
    tradingSessionsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    applQueueActionField.foreach(fmt(b,_))
    applQueueMaxField.foreach(fmt(b,_))
    b
  }

}
     
object MarketDataRequestMessage extends SfFixMessageDecoder {
  val MsgType="V"
  val MsgName="MarketDataRequest"
             
  override val MandatoryFields = HashSet[Int](
    MDReqIDField.TagId, SubscriptionRequestTypeField.TagId, MarketDepthField.TagId, NoMDEntryTypesField.TagId, NoRelatedSymField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MDEntryTypesGroup.isMandatoryField(tagId) || RelatedSymGroup.isMandatoryField(tagId) || TradingSessionsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    MDUpdateTypeField.TagId, AggregatedBookField.TagId, OpenCloseSettlFlagField.TagId, ScopeField.TagId, MDImplicitDeleteField.TagId, 
    NoTradingSessionsField.TagId, ApplQueueActionField.TagId, ApplQueueMaxField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MDEntryTypesGroup.isOptionalField(tagId) || RelatedSymGroup.isOptionalField(tagId) || TradingSessionsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MDEntryTypesGroup.isFieldOf(tagId) || RelatedSymGroup.isFieldOf(tagId) || TradingSessionsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoMDEntryTypesField.TagId, NoRelatedSymField.TagId, NoTradingSessionsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==MDReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MarketDataRequestMessage(MDReqIDField.decode(myFields.get(MDReqIDField.TagId)).get,
        SubscriptionRequestTypeField.decode(myFields.get(SubscriptionRequestTypeField.TagId)).get,
        MarketDepthField.decode(myFields.get(MarketDepthField.TagId)).get,
        myFields.get(MDUpdateTypeField.TagId).flatMap(f=>MDUpdateTypeField.decode(f)),
        myFields.get(AggregatedBookField.TagId).flatMap(f=>AggregatedBookField.decode(f)),
        myFields.get(OpenCloseSettlFlagField.TagId).flatMap(f=>OpenCloseSettlFlagField.decode(f)),
        myFields.get(ScopeField.TagId).flatMap(f=>ScopeField.decode(f)),
        myFields.get(MDImplicitDeleteField.TagId).flatMap(f=>MDImplicitDeleteField.decode(f)),
        NoMDEntryTypesField.decode(myFields.get(NoMDEntryTypesField.TagId)).get,
        if (nextTagPosLookup.contains(NoMDEntryTypesField.TagId)) MDEntryTypesGroup.decode(flds, nextTagPosLookup(NoMDEntryTypesField.TagId)).get else List.empty,
        NoRelatedSymField.decode(myFields.get(NoRelatedSymField.TagId)).get,
        if (nextTagPosLookup.contains(NoRelatedSymField.TagId)) RelatedSymGroup.decode(flds, nextTagPosLookup(NoRelatedSymField.TagId)).get else List.empty,
        myFields.get(NoTradingSessionsField.TagId).flatMap(f=>NoTradingSessionsField.decode(f)),
        if (nextTagPosLookup.contains(NoTradingSessionsField.TagId)) TradingSessionsGroup.decode(flds, nextTagPosLookup(NoTradingSessionsField.TagId)) else None,
        myFields.get(ApplQueueActionField.TagId).flatMap(f=>ApplQueueActionField.decode(f)),
        myFields.get(ApplQueueMaxField.TagId).flatMap(f=>ApplQueueMaxField.decode(f))))
    } else None
  }

    
}
     