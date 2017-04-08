package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class CrossOrderCancelRequestMessage(orderIDField:Option[OrderIDField]=None,
                                          crossIDField:CrossIDField,
                                          origCrossIDField:OrigCrossIDField,
                                          crossTypeField:CrossTypeField,
                                          crossPrioritizationField:CrossPrioritizationField,
                                          noSidesField:NoSidesField,
                                          sidesGroups: List[SidesGroup],
                                          instrumentComponent:InstrumentComponent,
                                          noUnderlyingsField:Option[NoUnderlyingsField]=None,
                                          underlyingsGroups: Option[List[UnderlyingsGroup]]=None,
                                          noLegsField:Option[NoLegsField]=None,
                                          legsGroups: Option[List[LegsGroup]]=None,
                                          transactTimeField:TransactTimeField) extends SfFixMessageBody("u")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSidesField.value != sidesGroups.size)
    throw SfRepeatingGroupCountException(NoSidesField.TagId,noSidesField.value, sidesGroups.size)
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    orderIDField.foreach(fmt(b,_))
    fmt(b,crossIDField)
    fmt(b,origCrossIDField)
    fmt(b,crossTypeField)
    fmt(b,crossPrioritizationField)
    fmt(b,noSidesField)
    fmt(b,instrumentComponent)
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    fmt(b,transactTimeField)
    b
  }

}
     
object CrossOrderCancelRequestMessage extends SfFixMessageDecoder {
  val MsgType="u"
  val MsgName="CrossOrderCancelRequest"
             
  override val MandatoryFields = HashSet[Int](
    CrossIDField.TagId, OrigCrossIDField.TagId, CrossTypeField.TagId, CrossPrioritizationField.TagId, NoSidesField.TagId, 
    TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SidesGroup.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || UnderlyingsGroup.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrderIDField.TagId, NoUnderlyingsField.TagId, NoLegsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SidesGroup.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || UnderlyingsGroup.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SidesGroup.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || UnderlyingsGroup.isFieldOf(tagId) || 
    LegsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSidesField.TagId, NoUnderlyingsField.TagId, NoLegsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(CrossOrderCancelRequestMessage(myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        CrossIDField.decode(myFields.get(CrossIDField.TagId)).get,
        OrigCrossIDField.decode(myFields.get(OrigCrossIDField.TagId)).get,
        CrossTypeField.decode(myFields.get(CrossTypeField.TagId)).get,
        CrossPrioritizationField.decode(myFields.get(CrossPrioritizationField.TagId)).get,
        NoSidesField.decode(myFields.get(NoSidesField.TagId)).get,
        if (nextTagPosLookup.contains(NoSidesField.TagId)) SidesGroup.decode(flds, nextTagPosLookup(NoSidesField.TagId)).get else List.empty,
        InstrumentComponent.decode(flds, startPos).get,
        myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None,
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get))
    } else None
  }

    
}
     