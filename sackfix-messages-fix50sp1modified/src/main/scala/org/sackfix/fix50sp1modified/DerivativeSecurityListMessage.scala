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
case class DerivativeSecurityListMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                                         securityReqIDField:Option[SecurityReqIDField]=None,
                                         securityResponseIDField:SecurityResponseIDField,
                                         securityRequestResultField:Option[SecurityRequestResultField]=None,
                                         underlyingInstrumentComponent:Option[UnderlyingInstrumentComponent]=None,
                                         derivativeSecurityDefinitionComponent:Option[DerivativeSecurityDefinitionComponent]=None,
                                         totNoRelatedSymField:Option[TotNoRelatedSymField]=None,
                                         lastFragmentField:Option[LastFragmentField]=None,
                                         relSymDerivSecGrpComponent:Option[RelSymDerivSecGrpComponent]=None) extends SfFixMessageBody("AA")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    securityReqIDField.foreach(fmt(b,_))
    fmt(b,securityResponseIDField)
    securityRequestResultField.foreach(fmt(b,_))
    underlyingInstrumentComponent.foreach(fmt(b,_))
    derivativeSecurityDefinitionComponent.foreach(fmt(b,_))
    totNoRelatedSymField.foreach(fmt(b,_))
    lastFragmentField.foreach(fmt(b,_))
    relSymDerivSecGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object DerivativeSecurityListMessage extends SfFixMessageDecoder {
  val MsgType="AA"
  val MsgName="DerivativeSecurityList"
             
  override val MandatoryFields = HashSet[Int](
    SecurityResponseIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || UnderlyingInstrumentComponent.isMandatoryField(tagId) || DerivativeSecurityDefinitionComponent.isMandatoryField(tagId) || RelSymDerivSecGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecurityReqIDField.TagId, SecurityRequestResultField.TagId, TotNoRelatedSymField.TagId, LastFragmentField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || UnderlyingInstrumentComponent.isOptionalField(tagId) || DerivativeSecurityDefinitionComponent.isOptionalField(tagId) || RelSymDerivSecGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || UnderlyingInstrumentComponent.isFieldOf(tagId) || DerivativeSecurityDefinitionComponent.isFieldOf(tagId) || 
    RelSymDerivSecGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(DerivativeSecurityListMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        myFields.get(SecurityReqIDField.TagId).flatMap(f=>SecurityReqIDField.decode(f)),
        SecurityResponseIDField.decode(myFields.get(SecurityResponseIDField.TagId)).get,
        myFields.get(SecurityRequestResultField.TagId).flatMap(f=>SecurityRequestResultField.decode(f)),
        UnderlyingInstrumentComponent.decode(flds, startPos),
        DerivativeSecurityDefinitionComponent.decode(flds, startPos),
        myFields.get(TotNoRelatedSymField.TagId).flatMap(f=>TotNoRelatedSymField.decode(f)),
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        RelSymDerivSecGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     