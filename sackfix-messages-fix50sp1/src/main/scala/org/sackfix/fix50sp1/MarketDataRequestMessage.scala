package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class MarketDataRequestMessage(mDReqIDField:MDReqIDField,
                                    subscriptionRequestTypeField:SubscriptionRequestTypeField,
                                    partiesComponent:Option[PartiesComponent]=None,
                                    marketDepthField:MarketDepthField,
                                    mDUpdateTypeField:Option[MDUpdateTypeField]=None,
                                    aggregatedBookField:Option[AggregatedBookField]=None,
                                    openCloseSettlFlagField:Option[OpenCloseSettlFlagField]=None,
                                    scopeField:Option[ScopeField]=None,
                                    mDImplicitDeleteField:Option[MDImplicitDeleteField]=None,
                                    mDReqGrpComponent:MDReqGrpComponent,
                                    instrmtMDReqGrpComponent:InstrmtMDReqGrpComponent,
                                    trdgSesGrpComponent:Option[TrdgSesGrpComponent]=None,
                                    applQueueActionField:Option[ApplQueueActionField]=None,
                                    applQueueMaxField:Option[ApplQueueMaxField]=None,
                                    mDQuoteTypeField:Option[MDQuoteTypeField]=None) extends SfFixMessageBody("V")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,mDReqIDField)
    fmt(b,subscriptionRequestTypeField)
    partiesComponent.foreach(fmt(b,_))
    fmt(b,marketDepthField)
    mDUpdateTypeField.foreach(fmt(b,_))
    aggregatedBookField.foreach(fmt(b,_))
    openCloseSettlFlagField.foreach(fmt(b,_))
    scopeField.foreach(fmt(b,_))
    mDImplicitDeleteField.foreach(fmt(b,_))
    fmt(b,mDReqGrpComponent)
    fmt(b,instrmtMDReqGrpComponent)
    trdgSesGrpComponent.foreach(fmt(b,_))
    applQueueActionField.foreach(fmt(b,_))
    applQueueMaxField.foreach(fmt(b,_))
    mDQuoteTypeField.foreach(fmt(b,_))
    b
  }

}
     
object MarketDataRequestMessage extends SfFixMessageDecoder {
  val MsgType="V"
  val MsgName="MarketDataRequest"
             
  override val MandatoryFields = HashSet[Int](
    MDReqIDField.TagId, SubscriptionRequestTypeField.TagId, MarketDepthField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || MDReqGrpComponent.isMandatoryField(tagId) || InstrmtMDReqGrpComponent.isMandatoryField(tagId) || TrdgSesGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    MDUpdateTypeField.TagId, AggregatedBookField.TagId, OpenCloseSettlFlagField.TagId, ScopeField.TagId, MDImplicitDeleteField.TagId, 
    ApplQueueActionField.TagId, ApplQueueMaxField.TagId, MDQuoteTypeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || MDReqGrpComponent.isOptionalField(tagId) || InstrmtMDReqGrpComponent.isOptionalField(tagId) || TrdgSesGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || MDReqGrpComponent.isFieldOf(tagId) || InstrmtMDReqGrpComponent.isFieldOf(tagId) || 
    TrdgSesGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==MDReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MarketDataRequestMessage(MDReqIDField.decode(myFields.get(MDReqIDField.TagId)).get,
        SubscriptionRequestTypeField.decode(myFields.get(SubscriptionRequestTypeField.TagId)).get,
        PartiesComponent.decode(flds, startPos),
        MarketDepthField.decode(myFields.get(MarketDepthField.TagId)).get,
        myFields.get(MDUpdateTypeField.TagId).flatMap(f=>MDUpdateTypeField.decode(f)),
        myFields.get(AggregatedBookField.TagId).flatMap(f=>AggregatedBookField.decode(f)),
        myFields.get(OpenCloseSettlFlagField.TagId).flatMap(f=>OpenCloseSettlFlagField.decode(f)),
        myFields.get(ScopeField.TagId).flatMap(f=>ScopeField.decode(f)),
        myFields.get(MDImplicitDeleteField.TagId).flatMap(f=>MDImplicitDeleteField.decode(f)),
        MDReqGrpComponent.decode(flds, startPos).get,
        InstrmtMDReqGrpComponent.decode(flds, startPos).get,
        TrdgSesGrpComponent.decode(flds, startPos),
        myFields.get(ApplQueueActionField.TagId).flatMap(f=>ApplQueueActionField.decode(f)),
        myFields.get(ApplQueueMaxField.TagId).flatMap(f=>ApplQueueMaxField.decode(f)),
        myFields.get(MDQuoteTypeField.TagId).flatMap(f=>MDQuoteTypeField.decode(f))))
    } else None
  }

    
}
     