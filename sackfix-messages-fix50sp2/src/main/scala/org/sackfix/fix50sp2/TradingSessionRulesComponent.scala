package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class TradingSessionRulesComponent(ordTypeRulesComponent:Option[OrdTypeRulesComponent]=None,
                                        timeInForceRulesComponent:Option[TimeInForceRulesComponent]=None,
                                        execInstRulesComponent:Option[ExecInstRulesComponent]=None,
                                        matchRulesComponent:Option[MatchRulesComponent]=None,
                                        marketDataFeedTypesComponent:Option[MarketDataFeedTypesComponent]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    ordTypeRulesComponent.foreach(fmt(b,_))
    timeInForceRulesComponent.foreach(fmt(b,_))
    execInstRulesComponent.foreach(fmt(b,_))
    matchRulesComponent.foreach(fmt(b,_))
    marketDataFeedTypesComponent.foreach(fmt(b,_))
    b
  }

}
     
object TradingSessionRulesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OrdTypeRulesComponent.isMandatoryField(tagId) || TimeInForceRulesComponent.isMandatoryField(tagId) || ExecInstRulesComponent.isMandatoryField(tagId) || MatchRulesComponent.isMandatoryField(tagId) || 
    MarketDataFeedTypesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    OrdTypeRulesComponent.isOptionalField(tagId) || TimeInForceRulesComponent.isOptionalField(tagId) || ExecInstRulesComponent.isOptionalField(tagId) || MatchRulesComponent.isOptionalField(tagId) || 
    MarketDataFeedTypesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    OrdTypeRulesComponent.isFieldOf(tagId) || TimeInForceRulesComponent.isFieldOf(tagId) || ExecInstRulesComponent.isFieldOf(tagId) || 
    MatchRulesComponent.isFieldOf(tagId) || MarketDataFeedTypesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = OrdTypeRulesComponent.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[TradingSessionRulesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(TradingSessionRulesComponent(OrdTypeRulesComponent.decode(flds, startPos),
        TimeInForceRulesComponent.decode(flds, startPos),
        ExecInstRulesComponent.decode(flds, startPos),
        MatchRulesComponent.decode(flds, startPos),
        MarketDataFeedTypesComponent.decode(flds, startPos)))
    } else None
  }

    
}
     