package org.sackfix.fix43

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX43.xml
  */
case class BidResponseMessage(bidIDField:Option[BidIDField]=None,
                              clientBidIDField:Option[ClientBidIDField]=None,
                              noBidComponentsField:NoBidComponentsField,
                              bidComponentsGroups: List[BidComponentsGroup]) extends SfFixMessageBody("l")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noBidComponentsField.value != bidComponentsGroups.size)
    throw SfRepeatingGroupCountException(NoBidComponentsField.TagId,noBidComponentsField.value, bidComponentsGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    bidIDField.foreach(fmt(b,_))
    clientBidIDField.foreach(fmt(b,_))
    fmt(b,noBidComponentsField)
    b
  }

}
     
object BidResponseMessage extends SfFixMessageDecoder {
  val MsgType="l"
  val MsgName="BidResponse"
             
  override val MandatoryFields = HashSet[Int](
    NoBidComponentsField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    BidComponentsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    BidIDField.TagId, ClientBidIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    BidComponentsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    BidComponentsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoBidComponentsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==BidIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(BidResponseMessage(myFields.get(BidIDField.TagId).flatMap(f=>BidIDField.decode(f)),
        myFields.get(ClientBidIDField.TagId).flatMap(f=>ClientBidIDField.decode(f)),
        NoBidComponentsField.decode(myFields.get(NoBidComponentsField.TagId)).get,
        if (nextTagPosLookup.contains(NoBidComponentsField.TagId)) BidComponentsGroup.decode(flds, nextTagPosLookup(NoBidComponentsField.TagId)).get else List.empty))
    } else None
  }

    
}
     