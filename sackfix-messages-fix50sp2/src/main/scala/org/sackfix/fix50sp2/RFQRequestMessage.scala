package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class RFQRequestMessage(rFQReqIDField:RFQReqIDField,
                             partiesComponent:Option[PartiesComponent]=None,
                             rFQReqGrpComponent:RFQReqGrpComponent,
                             subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None,
                             privateQuoteField:Option[PrivateQuoteField]=None) extends SfFixMessageBody("AH")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,rFQReqIDField)
    partiesComponent.foreach(fmt(b,_))
    fmt(b,rFQReqGrpComponent)
    subscriptionRequestTypeField.foreach(fmt(b,_))
    privateQuoteField.foreach(fmt(b,_))
    b
  }

}
     
object RFQRequestMessage extends SfFixMessageDecoder {
  val MsgType="AH"
  val MsgName="RFQRequest"
             
  override val MandatoryFields = HashSet[Int](
    RFQReqIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || RFQReqGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SubscriptionRequestTypeField.TagId, PrivateQuoteField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || RFQReqGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || RFQReqGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==RFQReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(RFQRequestMessage(RFQReqIDField.decode(myFields.get(RFQReqIDField.TagId)).get,
        PartiesComponent.decode(flds, startPos),
        RFQReqGrpComponent.decode(flds, startPos).get,
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f)),
        myFields.get(PrivateQuoteField.TagId).flatMap(f=>PrivateQuoteField.decode(f))))
    } else None
  }

    
}
     