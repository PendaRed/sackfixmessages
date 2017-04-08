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
case class MarketDataIncrementalRefreshMessage(mDReqIDField:Option[MDReqIDField]=None,
                                               noMDEntriesField:NoMDEntriesField,
                                               mDEntriesGroups: List[MDEntriesGroup]) extends SfFixMessageBody("X")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noMDEntriesField.value != mDEntriesGroups.size)
    throw SfRepeatingGroupCountException(NoMDEntriesField.TagId,noMDEntriesField.value, mDEntriesGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    mDReqIDField.foreach(fmt(b,_))
    fmt(b,noMDEntriesField)
    b
  }

}
     
object MarketDataIncrementalRefreshMessage extends SfFixMessageDecoder {
  val MsgType="X"
  val MsgName="MarketDataIncrementalRefresh"
             
  override val MandatoryFields = HashSet[Int](
    NoMDEntriesField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MDEntriesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    MDReqIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MDEntriesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MDEntriesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoMDEntriesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==MDReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MarketDataIncrementalRefreshMessage(myFields.get(MDReqIDField.TagId).flatMap(f=>MDReqIDField.decode(f)),
        NoMDEntriesField.decode(myFields.get(NoMDEntriesField.TagId)).get,
        if (nextTagPosLookup.contains(NoMDEntriesField.TagId)) MDEntriesGroup.decode(flds, nextTagPosLookup(NoMDEntriesField.TagId)).get else List.empty))
    } else None
  }

    
}
     