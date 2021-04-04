package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class OrderMassActionReportMessage(clOrdIDField:Option[ClOrdIDField]=None,
                                        secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                                        massActionReportIDField:MassActionReportIDField,
                                        massActionTypeField:MassActionTypeField,
                                        massActionScopeField:MassActionScopeField,
                                        massActionResponseField:MassActionResponseField,
                                        massActionRejectReasonField:Option[MassActionRejectReasonField]=None,
                                        totalAffectedOrdersField:Option[TotalAffectedOrdersField]=None,
                                        affectedOrdGrpComponent:Option[AffectedOrdGrpComponent]=None,
                                        notAffectedOrdersGrpComponent:Option[NotAffectedOrdersGrpComponent]=None,
                                        marketIDField:Option[MarketIDField]=None,
                                        marketSegmentIDField:Option[MarketSegmentIDField]=None,
                                        tradingSessionIDField:Option[TradingSessionIDField]=None,
                                        tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                        partiesComponent:Option[PartiesComponent]=None,
                                        instrumentComponent:Option[InstrumentComponent]=None,
                                        underlyingInstrumentComponent:Option[UnderlyingInstrumentComponent]=None,
                                        sideField:Option[SideField]=None,
                                        transactTimeField:Option[TransactTimeField]=None,
                                        textField:Option[TextField]=None,
                                        encodedTextLenField:Option[EncodedTextLenField]=None,
                                        encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("BZ")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    clOrdIDField.foreach(fmt(b,_))
    secondaryClOrdIDField.foreach(fmt(b,_))
    fmt(b,massActionReportIDField)
    fmt(b,massActionTypeField)
    fmt(b,massActionScopeField)
    fmt(b,massActionResponseField)
    massActionRejectReasonField.foreach(fmt(b,_))
    totalAffectedOrdersField.foreach(fmt(b,_))
    affectedOrdGrpComponent.foreach(fmt(b,_))
    notAffectedOrdersGrpComponent.foreach(fmt(b,_))
    marketIDField.foreach(fmt(b,_))
    marketSegmentIDField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    underlyingInstrumentComponent.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object OrderMassActionReportMessage extends SfFixMessageDecoder {
  val MsgType="BZ"
  val MsgName="OrderMassActionReport"
             
  override val MandatoryFields = HashSet[Int](
    MassActionReportIDField.TagId, MassActionTypeField.TagId, MassActionScopeField.TagId, MassActionResponseField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    AffectedOrdGrpComponent.isMandatoryField(tagId) || NotAffectedOrdersGrpComponent.isMandatoryField(tagId) || PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || 
    UnderlyingInstrumentComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ClOrdIDField.TagId, SecondaryClOrdIDField.TagId, MassActionRejectReasonField.TagId, TotalAffectedOrdersField.TagId, MarketIDField.TagId, 
    MarketSegmentIDField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, SideField.TagId, TransactTimeField.TagId, 
    TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    AffectedOrdGrpComponent.isOptionalField(tagId) || NotAffectedOrdersGrpComponent.isOptionalField(tagId) || PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || 
    UnderlyingInstrumentComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    AffectedOrdGrpComponent.isFieldOf(tagId) || NotAffectedOrdersGrpComponent.isFieldOf(tagId) || PartiesComponent.isFieldOf(tagId) || 
    InstrumentComponent.isFieldOf(tagId) || UnderlyingInstrumentComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ClOrdIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(OrderMassActionReportMessage(myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
        MassActionReportIDField.decode(myFields.get(MassActionReportIDField.TagId)).get,
        MassActionTypeField.decode(myFields.get(MassActionTypeField.TagId)).get,
        MassActionScopeField.decode(myFields.get(MassActionScopeField.TagId)).get,
        MassActionResponseField.decode(myFields.get(MassActionResponseField.TagId)).get,
        myFields.get(MassActionRejectReasonField.TagId).flatMap(f=>MassActionRejectReasonField.decode(f)),
        myFields.get(TotalAffectedOrdersField.TagId).flatMap(f=>TotalAffectedOrdersField.decode(f)),
        AffectedOrdGrpComponent.decode(flds, startPos),
        NotAffectedOrdersGrpComponent.decode(flds, startPos),
        myFields.get(MarketIDField.TagId).flatMap(f=>MarketIDField.decode(f)),
        myFields.get(MarketSegmentIDField.TagId).flatMap(f=>MarketSegmentIDField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        InstrumentComponent.decode(flds, startPos),
        UnderlyingInstrumentComponent.decode(flds, startPos),
        myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     