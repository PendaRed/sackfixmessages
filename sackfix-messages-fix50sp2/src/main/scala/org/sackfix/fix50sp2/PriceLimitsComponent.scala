package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class PriceLimitsComponent(priceLimitTypeField:Option[PriceLimitTypeField]=None,
                                lowLimitPriceField:Option[LowLimitPriceField]=None,
                                highLimitPriceField:Option[HighLimitPriceField]=None,
                                tradingReferencePriceField:Option[TradingReferencePriceField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    priceLimitTypeField.foreach(fmt(b,_))
    lowLimitPriceField.foreach(fmt(b,_))
    highLimitPriceField.foreach(fmt(b,_))
    tradingReferencePriceField.foreach(fmt(b,_))
    b
  }

}
     
object PriceLimitsComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    PriceLimitTypeField.TagId, LowLimitPriceField.TagId, HighLimitPriceField.TagId, TradingReferencePriceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==PriceLimitTypeField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[PriceLimitsComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(PriceLimitsComponent(myFields.get(PriceLimitTypeField.TagId).flatMap(f=>PriceLimitTypeField.decode(f)),
        myFields.get(LowLimitPriceField.TagId).flatMap(f=>LowLimitPriceField.decode(f)),
        myFields.get(HighLimitPriceField.TagId).flatMap(f=>HighLimitPriceField.decode(f)),
        myFields.get(TradingReferencePriceField.TagId).flatMap(f=>TradingReferencePriceField.decode(f))))
    } else None
  }

    
}
     