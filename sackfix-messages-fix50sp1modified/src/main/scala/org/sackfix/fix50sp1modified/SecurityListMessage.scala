package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class SecurityListMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                               securityReportIDField:Option[SecurityReportIDField]=None,
                               clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                               securityReqIDField:Option[SecurityReqIDField]=None,
                               securityResponseIDField:Option[SecurityResponseIDField]=None,
                               securityRequestResultField:Option[SecurityRequestResultField]=None,
                               totNoRelatedSymField:Option[TotNoRelatedSymField]=None,
                               marketIDField:Option[MarketIDField]=None,
                               marketSegmentIDField:Option[MarketSegmentIDField]=None,
                               lastFragmentField:Option[LastFragmentField]=None,
                               secListGrpComponent:Option[SecListGrpComponent]=None) extends SfFixMessageBody("y")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    securityReportIDField.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    securityReqIDField.foreach(fmt(b,_))
    securityResponseIDField.foreach(fmt(b,_))
    securityRequestResultField.foreach(fmt(b,_))
    totNoRelatedSymField.foreach(fmt(b,_))
    marketIDField.foreach(fmt(b,_))
    marketSegmentIDField.foreach(fmt(b,_))
    lastFragmentField.foreach(fmt(b,_))
    secListGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object SecurityListMessage extends SfFixMessageDecoder {
  val MsgType="y"
  val MsgName="SecurityList"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || SecListGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecurityReportIDField.TagId, ClearingBusinessDateField.TagId, SecurityReqIDField.TagId, SecurityResponseIDField.TagId, SecurityRequestResultField.TagId, 
    TotNoRelatedSymField.TagId, MarketIDField.TagId, MarketSegmentIDField.TagId, LastFragmentField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || SecListGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || SecListGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SecurityListMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        myFields.get(SecurityReportIDField.TagId).flatMap(f=>SecurityReportIDField.decode(f)),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(SecurityReqIDField.TagId).flatMap(f=>SecurityReqIDField.decode(f)),
        myFields.get(SecurityResponseIDField.TagId).flatMap(f=>SecurityResponseIDField.decode(f)),
        myFields.get(SecurityRequestResultField.TagId).flatMap(f=>SecurityRequestResultField.decode(f)),
        myFields.get(TotNoRelatedSymField.TagId).flatMap(f=>TotNoRelatedSymField.decode(f)),
        myFields.get(MarketIDField.TagId).flatMap(f=>MarketIDField.decode(f)),
        myFields.get(MarketSegmentIDField.TagId).flatMap(f=>MarketSegmentIDField.decode(f)),
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        SecListGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     