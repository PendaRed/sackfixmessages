package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class QuoteSetsGroup(quoteSetIDField:Option[QuoteSetIDField]=None,
                          underlyingInstrumentComponent:Option[UnderlyingInstrumentComponent]=None,
                          totNoQuoteEntriesField:Option[TotNoQuoteEntriesField]=None,
                          lastFragmentField:Option[LastFragmentField]=None,
                          noQuoteEntriesField:Option[NoQuoteEntriesField]=None,
                          quoteEntriesGroups: Option[List[QuoteEntriesGroup]]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {
  if (noQuoteEntriesField.map(_.value).getOrElse(0) != quoteEntriesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoQuoteEntriesField.TagId,noQuoteEntriesField.map(_.value).getOrElse(0), quoteEntriesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    quoteSetIDField.foreach(fmt(b,_))
    underlyingInstrumentComponent.foreach(fmt(b,_))
    totNoQuoteEntriesField.foreach(fmt(b,_))
    lastFragmentField.foreach(fmt(b,_))
    noQuoteEntriesField.foreach(fmt(b,_))
    quoteEntriesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object QuoteSetsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    UnderlyingInstrumentComponent.isMandatoryField(tagId) || QuoteEntriesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    QuoteSetIDField.TagId, TotNoQuoteEntriesField.TagId, LastFragmentField.TagId, NoQuoteEntriesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    UnderlyingInstrumentComponent.isOptionalField(tagId) || QuoteEntriesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    UnderlyingInstrumentComponent.isFieldOf(tagId) || QuoteEntriesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoQuoteEntriesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteSetIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[QuoteSetsGroup]=ArrayBuffer.empty[QuoteSetsGroup]):Option[List[QuoteSetsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[QuoteSetsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[QuoteSetsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(QuoteSetsGroup(myFields.get(QuoteSetIDField.TagId).flatMap(f=>QuoteSetIDField.decode(f)),
          UnderlyingInstrumentComponent.decode(flds, startPos),
          myFields.get(TotNoQuoteEntriesField.TagId).flatMap(f=>TotNoQuoteEntriesField.decode(f)),
          myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
          myFields.get(NoQuoteEntriesField.TagId).flatMap(f=>NoQuoteEntriesField.decode(f)),
          if (nextTagPosLookup.contains(NoQuoteEntriesField.TagId)) QuoteEntriesGroup.decode(flds, nextTagPosLookup(NoQuoteEntriesField.TagId)) else None)))
      } else (startPos, None)
    }
  }
    
}
     