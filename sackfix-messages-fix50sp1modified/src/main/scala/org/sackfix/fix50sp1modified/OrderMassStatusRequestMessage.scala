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
case class OrderMassStatusRequestMessage(massStatusReqIDField:MassStatusReqIDField,
                                         massStatusReqTypeField:MassStatusReqTypeField,
                                         partiesComponent:Option[PartiesComponent]=None,
                                         accountField:Option[AccountField]=None,
                                         acctIDSourceField:Option[AcctIDSourceField]=None,
                                         tradingSessionIDField:Option[TradingSessionIDField]=None,
                                         tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                         instrumentComponent:Option[InstrumentComponent]=None,
                                         underlyingInstrumentComponent:Option[UnderlyingInstrumentComponent]=None,
                                         sideField:Option[SideField]=None) extends SfFixMessageBody("AF")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,massStatusReqIDField)
    fmt(b,massStatusReqTypeField)
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    underlyingInstrumentComponent.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    b
  }

}
     
object OrderMassStatusRequestMessage extends SfFixMessageDecoder {
  val MsgType="AF"
  val MsgName="OrderMassStatusRequest"
             
  override val MandatoryFields = HashSet[Int](
    MassStatusReqIDField.TagId, MassStatusReqTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || UnderlyingInstrumentComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    AccountField.TagId, AcctIDSourceField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, SideField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || UnderlyingInstrumentComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || UnderlyingInstrumentComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==MassStatusReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(OrderMassStatusRequestMessage(MassStatusReqIDField.decode(myFields.get(MassStatusReqIDField.TagId)).get,
        MassStatusReqTypeField.decode(myFields.get(MassStatusReqTypeField.TagId)).get,
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos),
        UnderlyingInstrumentComponent.decode(flds, startPos),
        myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f))))
    } else None
  }

    
}
     