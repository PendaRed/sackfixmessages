package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class MarketDataSnapshotFullRefreshMessage(mDReqIDField:Option[MDReqIDField]=None,
                                                instrumentComponent:InstrumentComponent,
                                                undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                                instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                                financialStatusField:Option[FinancialStatusField]=None,
                                                corporateActionField:Option[CorporateActionField]=None,
                                                netChgPrevDayField:Option[NetChgPrevDayField]=None,
                                                mDFullGrpComponent:MDFullGrpComponent,
                                                applQueueDepthField:Option[ApplQueueDepthField]=None,
                                                applQueueResolutionField:Option[ApplQueueResolutionField]=None,
                                                mDReportIDField:Option[MDReportIDField]=None,
                                                clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                                mDBookTypeField:Option[MDBookTypeField]=None,
                                                mDFeedTypeField:Option[MDFeedTypeField]=None,
                                                tradeDateField:Option[TradeDateField]=None,
                                                routingGrpComponent:Option[RoutingGrpComponent]=None) extends SfFixMessageBody("W")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    mDReqIDField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    financialStatusField.foreach(fmt(b,_))
    corporateActionField.foreach(fmt(b,_))
    netChgPrevDayField.foreach(fmt(b,_))
    fmt(b,mDFullGrpComponent)
    applQueueDepthField.foreach(fmt(b,_))
    applQueueResolutionField.foreach(fmt(b,_))
    mDReportIDField.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    mDBookTypeField.foreach(fmt(b,_))
    mDFeedTypeField.foreach(fmt(b,_))
    tradeDateField.foreach(fmt(b,_))
    routingGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object MarketDataSnapshotFullRefreshMessage extends SfFixMessageDecoder {
  val MsgType="W"
  val MsgName="MarketDataSnapshotFullRefresh"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || MDFullGrpComponent.isMandatoryField(tagId) || 
    RoutingGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    MDReqIDField.TagId, FinancialStatusField.TagId, CorporateActionField.TagId, NetChgPrevDayField.TagId, ApplQueueDepthField.TagId, 
    ApplQueueResolutionField.TagId, MDReportIDField.TagId, ClearingBusinessDateField.TagId, MDBookTypeField.TagId, MDFeedTypeField.TagId, 
    TradeDateField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || MDFullGrpComponent.isOptionalField(tagId) || 
    RoutingGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId) || 
    MDFullGrpComponent.isFieldOf(tagId) || RoutingGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==MDReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MarketDataSnapshotFullRefreshMessage(myFields.get(MDReqIDField.TagId).flatMap(f=>MDReqIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        UndInstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        myFields.get(FinancialStatusField.TagId).flatMap(f=>FinancialStatusField.decode(f)),
        myFields.get(CorporateActionField.TagId).flatMap(f=>CorporateActionField.decode(f)),
        myFields.get(NetChgPrevDayField.TagId).flatMap(f=>NetChgPrevDayField.decode(f)),
        MDFullGrpComponent.decode(flds, startPos).get,
        myFields.get(ApplQueueDepthField.TagId).flatMap(f=>ApplQueueDepthField.decode(f)),
        myFields.get(ApplQueueResolutionField.TagId).flatMap(f=>ApplQueueResolutionField.decode(f)),
        myFields.get(MDReportIDField.TagId).flatMap(f=>MDReportIDField.decode(f)),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(MDBookTypeField.TagId).flatMap(f=>MDBookTypeField.decode(f)),
        myFields.get(MDFeedTypeField.TagId).flatMap(f=>MDFeedTypeField.decode(f)),
        myFields.get(TradeDateField.TagId).flatMap(f=>TradeDateField.decode(f)),
        RoutingGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     